package application.model.tasks;

import java.sql.SQLException;

import application.model.data.WineEvaluation;
import application.model.data.WineEvaluationDAO;
import javafx.concurrent.Task;

public class AddWineEvaluation extends Task<Boolean> {

	private final WineEvaluation wineEvaluation;

	public AddWineEvaluation(WineEvaluation wineEvaluation) {
		this.wineEvaluation = wineEvaluation;
	}

	private boolean writeToDatebase(){
		try{
			new WineEvaluationDAO().persistWineEvaluation(wineEvaluation);
			} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	protected Boolean call() throws Exception {
		return writeToDatebase();
	}

}
