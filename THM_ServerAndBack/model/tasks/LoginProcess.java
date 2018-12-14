package application.model.tasks;

import java.sql.SQLException;
import java.util.List;

import application.controller.MainController;
import application.model.data.SessionInfos;
import application.model.data.Stand;
import application.model.data.StandDAO;
import application.model.data.User;
import application.model.data.UserDAO;
import application.model.data.Wine;
import application.model.data.WineDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class LoginProcess extends Task<Boolean> {

	private User user;
	private final MainController mainCon;

	@Override
	protected Boolean call() throws Exception {
		if (verifyLogin()) {
			login();
			return true;
		} else {
			return false;
		}
	}

	public LoginProcess(User user, MainController mainCon) {
		this.user = user;
		this.mainCon = mainCon;
	}

	public boolean verifyLogin() {
		UserDAO userDAO = new UserDAO();
		List<User> users = null;
		try {
			users = userDAO.getUserByName(this.user.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (User user : users) {
			if (this.user.isEqualTo(user)) {
				this.user = user;
				return true;
			}
		}
		return false;
	}

	private void login() {
		try {
			SessionInfos sessionInfos = new SessionInfos(this.user);
			this.mainCon.setSession(sessionInfos);
			ObservableList<Stand> standList = FXCollections.observableArrayList();
			standList.addAll(new StandDAO().getAllStands());
			sessionInfos.setStandList(standList);
			ObservableList<Wine> wineList = FXCollections.observableArrayList();
			wineList.addAll(new WineDAO().getAllWines());
			sessionInfos.setWineList(wineList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
