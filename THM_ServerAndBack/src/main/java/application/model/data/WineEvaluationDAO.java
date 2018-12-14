package application.model.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WineEvaluationDAO extends BaseDAO implements IWineEvaluationDAO {

	@Override
	public WineEvaluation getWineEvaluationByID(int id) throws SQLException {
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"Select ID, wineID, userID, sweet, salty, bitter, sour   from wine_test_db.WINEEVALUATION WHERE ID = ?");
		prepareStatement.setInt(1, id);
		ResultSet rs = prepareStatement.executeQuery();
		rs.next();
		return new WineEvaluation(rs.getInt("ID"), new WineDAO().getWineByID(rs.getInt("wineID")),
				new UserDAO().getUserByID(rs.getInt("userID")), rs.getInt("sweet"), rs.getInt("salty"),
				rs.getInt("bitter"), rs.getInt("sour"));
	}

	@Override
	public List<WineEvaluation> getWineEvaluationByWine(Wine wine) throws SQLException {
		List<WineEvaluation> winesEvaluation = new ArrayList<>();
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"Select ID, wineID, userID, sweet, salty, bitter, sour   from wine_test_db.WINEEVALUATION WHERE wineID = ?");
		prepareStatement.setInt(1, wine.getWineId().get());
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			winesEvaluation.add(new WineEvaluation(rs.getInt("ID"), new WineDAO().getWineByID(rs.getInt("wineID")),
					new UserDAO().getUserByID(rs.getInt("userID")), rs.getInt("sweet"), rs.getInt("salty"),
					rs.getInt("bitter"), rs.getInt("sour")));
		}
		return winesEvaluation;
	}

	@Override
	public List<WineEvaluation> getWineEvaluationByStand(Stand stand) throws SQLException {
		List<WineEvaluation> winesEvaluation = new ArrayList<>();
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"Select ID, wineID, userID, sweet, salty, bitter, sour   from wine_test_db.WINEEVALUATION WHERE standID = ?");
		prepareStatement.setInt(1, stand.getStandId().get());
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			winesEvaluation.add(new WineEvaluation(rs.getInt("ID"), new WineDAO().getWineByID(rs.getInt("wineID")),
					new UserDAO().getUserByID(rs.getInt("userID")), rs.getInt("sweet"), rs.getInt("salty"),
					rs.getInt("bitter"), rs.getInt("sour")));
		}
		return winesEvaluation;
	}

	@Override
	public boolean persistWineEvaluation(WineEvaluation wineEvaluation) throws SQLException {
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"INSERT INTO WINEEVALUATION (wineID, userID, sweet, salty, bitter, sour) VALUES (?, ?, ?, ?, ?, ?)");
		prepareStatement.setInt(1, wineEvaluation.getWine().get().getWineId().get());
		prepareStatement.setInt(2, wineEvaluation.getUser().get().getUserID());
		prepareStatement.setInt(3, wineEvaluation.getSweet().get());
		prepareStatement.setInt(4, wineEvaluation.getSalty().get());
		prepareStatement.setInt(5, wineEvaluation.getBitter().get());
		prepareStatement.setInt(6, wineEvaluation.getSour().get());
		return prepareStatement.execute();
	}

	@Override
	public boolean deleteWineEvaluation(WineEvaluation wineEvaluation) throws SQLException {
		PreparedStatement prepareStatement = this.conn
				.prepareStatement("DELETE from wine_test_db.WINEEVALUATION WHERE ID = ?");
		prepareStatement.setInt(1, wineEvaluation.getWineEvaluationId().get());
		return prepareStatement.execute();
	}

	@Override
	public boolean changeWineEvaluation(WineEvaluation wineEvaluation) throws SQLException {
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"UPDATE wine_test_db.WINEEVALUATION SET sweet = ?,salty = ?,bitter = ?,sour = ? WHERE ID = ?");
		prepareStatement.setInt(1, wineEvaluation.getSweet().get());
		prepareStatement.setInt(2, wineEvaluation.getSalty().get());
		prepareStatement.setInt(3, wineEvaluation.getBitter().get());
		prepareStatement.setInt(4, wineEvaluation.getSour().get());
		prepareStatement.setInt(5, wineEvaluation.getWineEvaluationId().get());
		return prepareStatement.execute();
	}

}
