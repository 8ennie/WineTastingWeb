package application.model.tasks;

import java.sql.SQLException;

import application.controller.MainController;
import application.model.data.Stand;
import application.model.data.StandDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class AddStand extends Task<Boolean>{	
	private final Stand stand;
	private final MainController mainCon;
	
	public AddStand(Stand stand,MainController mainCon) {
		this.stand = stand;
		this.mainCon = mainCon;
	}
	
	private boolean updateStandsList() {
		ObservableList<Stand> standList = FXCollections.observableArrayList();
		try {
			standList.addAll(new StandDAO().getAllStands());
			mainCon.getSession().setStandList(standList);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean writeToDatebase(){
		try{
			new StandDAO().persistStand(this.stand);
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	protected Boolean call() throws Exception{
		return (this.writeToDatebase() && this.updateStandsList());
	}

}
