package application.model.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StandEvaluationDAO extends BaseDAO implements IStandEvaluationDAO {

	@Override
	public StandEvaluation getStandEvaluationByID(int id) throws SQLException {
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"Select ID, standID, userID, review   from wine_test_db.STANDEVALUATION WHERE ID = ?");
		prepareStatement.setInt(1, id);
		ResultSet rs = prepareStatement.executeQuery();
		rs.next();
		return new StandEvaluation(rs.getInt("ID"), new StandDAO().getStandByID(rs.getInt("standID")),
				new UserDAO().getUserByID(rs.getInt("userID")), rs.getString("review"));
	}

	@Override
	public List<StandEvaluation> getStandEvaluationByStand(Stand stand) throws SQLException {
		List<StandEvaluation> standEvaluations = new ArrayList<>();
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"Select ID, standID, userID, review   from wine_test_db.STANDEVALUATION WHERE standID = ?" );
		prepareStatement.setInt(1, stand.getStandId().get());
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			standEvaluations.add(new StandEvaluation(rs.getInt("ID"), new StandDAO().getStandByID(rs.getInt("standID")),
					new UserDAO().getUserByID(rs.getInt("userID")), rs.getString("review")));
		}
		return standEvaluations;
	}

	@Override
	public boolean persistStandEvaluation(StandEvaluation standEvaluation) throws SQLException {
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"INSERT INTO wine_test_db.STANDEVALUATION (standID, userID, review) VALUES (?, ?, ?)");
		prepareStatement.setInt(1, standEvaluation.getStand().get().getStandId().get());
		prepareStatement.setInt(2, standEvaluation.getUser().get().getUserID());
		prepareStatement.setString(3, standEvaluation.getReview().get());
		return prepareStatement.execute();
	}

	@Override
	public boolean deleteStandEvaluation(StandEvaluation standEvaluation) throws SQLException {
		PreparedStatement prepareStatement = this.conn
				.prepareStatement("DELETE from wine_test_db.STANDEVALUATION WHERE ID = ?");
		prepareStatement.setInt(1, standEvaluation.getStandEvaluationId().get());
		return prepareStatement.execute();
	}

	@Override
	public boolean changeStandEvaluation(StandEvaluation standEvaluation) throws SQLException {
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"UPDATE wine_test_db.STANDEVALUATION SET review = ? WHERE ID = ?");
		prepareStatement.setString(1, standEvaluation.getReview().get());
		prepareStatement.setInt(2, standEvaluation.getStandEvaluationId().get());
		return prepareStatement.execute();
	}

	

}
