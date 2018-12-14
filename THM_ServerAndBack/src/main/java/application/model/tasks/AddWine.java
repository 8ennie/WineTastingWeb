package application.model.tasks;

import java.sql.SQLException;

import application.controller.MainController;
import application.model.data.Wine;
import application.model.data.WineDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class AddWine extends Task<Boolean> {

	private final Wine wine;
	private final MainController mainCon;

	public AddWine(Wine wine,MainController mainCon) {
		this.wine = wine;
		this.mainCon = mainCon;
	}

	private boolean updateWineList() {
		ObservableList<Wine> wineList = FXCollections.observableArrayList();
		try {
			wineList.addAll(new WineDAO().getAllWines());
			mainCon.getSession().setWineList(wineList);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean writeToDatabase() {
		try {
			new WineDAO().persistWine(this.wine);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	protected Boolean call() throws Exception {
		return this.writeToDatabase() && this.updateWineList();
	}

}
