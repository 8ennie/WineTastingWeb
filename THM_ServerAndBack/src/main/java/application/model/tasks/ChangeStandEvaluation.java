package application.model.tasks;

import java.sql.SQLException;

import application.model.data.StandEvaluation;
import application.model.data.StandEvaluationDAO;
import javafx.concurrent.Task;

public class ChangeStandEvaluation extends Task<Boolean> {

	private final StandEvaluation standEvaluation;

	public ChangeStandEvaluation(StandEvaluation standEvaluation) {
		this.standEvaluation = standEvaluation;
	}

	private boolean changeDatebase(){
		try{
			new StandEvaluationDAO().changeStandEvaluation(standEvaluation);
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
