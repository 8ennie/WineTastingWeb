package application.model.data;

import java.sql.SQLException;
import java.util.List;

public interface IWineEvaluationDAO {

	public WineEvaluation getWineEvaluationByID(int id) throws SQLException;
	
	public List<WineEvaluation> getWineEvaluationByWine(Wine wine) throws SQLException;
		
	public List<WineEvaluation> getWineEvaluationByStand(Stand stand) throws SQLException;
	
	public boolean persistWineEvaluation(WineEvaluation wineEvaluation) throws SQLException;
	
	public boolean deleteWineEvaluation(WineEvaluation wineEvaluation) throws SQLException;

	public boolean changeWineEvaluation(WineEvaluation wineEvaluation) throws SQLException;
}
