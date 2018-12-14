package application.model.data;

import java.sql.SQLException;
import java.util.List;

public interface IStandDAO {
	public Stand getStandByID(int id) throws SQLException;
	public List<Stand> getStandByName(String name)throws SQLException;
	
	public boolean persistStand(Stand stand) throws SQLException;
	
	public List<Stand> getAllStands() throws SQLException;
	
	public boolean deleteStand(Stand stand) throws SQLException;
}
