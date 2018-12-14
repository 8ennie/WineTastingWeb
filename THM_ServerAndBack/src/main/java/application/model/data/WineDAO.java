package application.model.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WineDAO extends BaseDAO implements IWineDAO {

	@Override
	public Wine getWineByID(int id) throws SQLException {
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"Select ID,wineName, wineDescription, standID  from wine_test_db.WINE WHERE ID = ?");
		prepareStatement.setInt(1, id);
		ResultSet rs = prepareStatement.executeQuery();
		rs.next();
		return new Wine(rs.getInt("ID"), rs.getString("wineName"), rs.getString("wineDescription"),new StandDAO().getStandByID(rs.getInt("standID"))
				);
	}

	@Override
	public List<Wine> getWineByName(String name) throws SQLException {
		List<Wine> wines = new ArrayList<>();
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"Select ID,wineName, wineDescription, standID  from wine_test_db.WINE WHERE wineName = ?");
		prepareStatement.setString(1, name);
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			wines.add(new Wine(rs.getInt("ID"), rs.getString("wineName"), rs.getString("wineDescription"),new StandDAO().getStandByID(rs.getInt("standID"))));
		}
		return wines;
	}

	@Override
	public boolean persistWine(Wine wine) throws SQLException {
		PreparedStatement prepareStatement = this.conn.prepareStatement("INSERT INTO WINE (wineName, wineDescription, standID) VALUES (?, ?, ?)");
		prepareStatement.setString(1,wine.getName().get());
		prepareStatement.setString(2,wine.getDescription().get());
		prepareStatement.setInt(3,wine.getStand().get().getStandId().get());
		return prepareStatement.execute();
	}

	@Override
	public List<Wine> getAllWines() throws SQLException {
		List<Wine> wines = new ArrayList<>();
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"Select ID,wineName , wineDescription ,standID  from wine_test_db.WINE");
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			wines.add(new Wine(rs.getInt("ID"), rs.getString("wineName"), rs.getString("wineDescription"),new StandDAO().getStandByID(rs.getInt("standID"))));
		}
		return wines;
	}

	@Override
	public boolean deleteWine(Wine wine) throws SQLException {
		PreparedStatement prepareStatement = this.conn.prepareStatement("DELETE from wine_test_db.WINE  WHERE ID = ?");
		prepareStatement.setInt(1, wine.getWineId().get());
		return prepareStatement.execute();
	}

	@Override
	public List<Wine> getWineByStand(Stand stand) throws SQLException {
		List<Wine> wines = new ArrayList<>();
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"Select ID,wineName, wineDescription, standID  from wine_test_db.WINE WHERE standID = ?");
		prepareStatement.setInt(1, stand.getStandId().get());
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			wines.add(new Wine(rs.getInt("ID"), rs.getString("wineName"), rs.getString("wineDescription"),new StandDAO().getStandByID(rs.getInt("standID"))));
		}
		return wines;
	}

}
