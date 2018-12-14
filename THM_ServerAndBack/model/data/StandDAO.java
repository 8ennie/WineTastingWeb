/**
 * 
 */
package application.model.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ncwie
 *
 */
public class StandDAO extends BaseDAO implements IStandDAO {

	public StandDAO() {
		super();
	}

	@Override
	public Stand getStandByID(int id) throws SQLException {
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"Select ID,standName, standLocation, standOwner  from wine_test_db.STAND WHERE ID = ?");
		prepareStatement.setInt(1, id);
		ResultSet rs = prepareStatement.executeQuery();
		rs.next();
		return new Stand(rs.getInt("ID"), rs.getString("standName"), rs.getString("standLocation"),
				rs.getString("standOwner"));
	}

	@Override
	public List<Stand> getStandByName(String name) throws SQLException {
		List<Stand> stands = new ArrayList<>();
		PreparedStatement prepareStatement = this.conn.prepareStatement(
				"Select ID,standName, standLocation, standOwner  from wine_test_db.STAND WHERE standName = ?");
		prepareStatement.setString(1, name);
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			stands.add(new Stand(rs.getInt("ID"), rs.getString("standName"), rs.getString("standLocation"),
					rs.getString("standOwner")));
		}
		return stands;
	}

	@Override
	public boolean persistStand(Stand stand) throws SQLException {
		PreparedStatement prepareStatement = this.conn
				.prepareStatement("INSERT INTO STAND (standName, standLocation, standOwner) VALUES (?, ?, ?)");
		prepareStatement.setString(1, stand.getStandName().get());
		prepareStatement.setString(2, stand.getStandLocation().get());
		prepareStatement.setString(3, stand.getStandOwner().get());
		return prepareStatement.execute();
	}

	@Override
	public List<Stand> getAllStands() throws SQLException {
		List<Stand> stands = new ArrayList<>();
		PreparedStatement prepareStatement = this.conn
				.prepareStatement("Select ID,standName, standLocation, standOwner  from wine_test_db.STAND");
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			stands.add(new Stand(rs.getInt("ID"), rs.getString("standName"), rs.getString("standLocation"),
					rs.getString("standOwner")));
		}
		return stands;
	}

	@Override
	public boolean deleteStand(Stand stand) throws SQLException {
		PreparedStatement prepareStatement = this.conn.prepareStatement("DELETE from wine_test_db.STAND  WHERE ID = ?");
		prepareStatement.setInt(1, stand.getStandId().get());
		return prepareStatement.execute();
	}

}
