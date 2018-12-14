package application.model.tasks;

import java.sql.SQLException;

import application.model.data.WineEvaluation;
import application.model.data.WineEvaluationDAO;
import javafx.concurrent.Task;

public class ChangeWineEvaluation extends Task<Boolean> {

	private final WineEvaluation wineEvaluation;

	public ChangeWineEvaluation(WineEvaluation wineEvaluation) {
		this.wineEvaluation = wineEvaluation;
	}

	private boolean changeDatebase(){
		try{
			new WineEvaluationDAO().changeWineEvaluation(wineEvaluation);
			} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	protected Boolean call() throws Exception {
		return changeDatebase();
	}

}
