package application.model.data;

import java.sql.SQLException;
import java.util.List;

public interface IStandEvaluationDAO {

	public StandEvaluation getStandEvaluationByID(int id) throws SQLException;
	
	public List<StandEvaluation> getStandEvaluationByStand(Stand stand) throws SQLException;
	
	public boolean persistStandEvaluation(StandEvaluation standEvaluation) throws SQLException;
	
	public boolean deleteStandEvaluation(StandEvaluation standEvaluation) throws SQLException;

	public boolean changeStandEvaluation(StandEvaluation standEvaluation) throws SQLException;
}
