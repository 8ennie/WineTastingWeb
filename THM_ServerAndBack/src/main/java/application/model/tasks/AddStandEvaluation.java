package application.model.tasks;

import java.sql.SQLException;

import application.model.data.StandEvaluation;
import application.model.data.StandEvaluationDAO;
import javafx.concurrent.Task;

public class AddStandEvaluation extends Task<Boolean>{

	private final StandEvaluation standEvaluation;

	public AddStandEvaluation(StandEvaluation standEvaluation) {
		this.standEvaluation = standEvaluation;
	}

	private boolean writeToDatebase(){
		try{
			new StandEvaluationDAO().persistStandEvaluation(standEvaluation);
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
