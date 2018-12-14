package application.model.data;

import java.sql.SQLException;
import java.util.List;

public interface IWineDAO {
	public Wine getWineByID(int id) throws SQLException;
	
	public List<Wine> getWineByName(String name)throws SQLException;
	
	public boolean persistWine(Wine wine) throws SQLException;
	
	public List<Wine> getAllWines() throws SQLException;
	
	public boolean deleteWine(Wine wine) throws SQLException;
	
	public List<Wine> getWineByStand(Stand stand) throws SQLException;
	
}
