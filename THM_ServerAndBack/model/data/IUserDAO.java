/**
 * 
 */
package application.model.data;

import java.sql.SQLException;
import java.util.List;

interface IUserDAO {
	public User getUserByID(int id) throws SQLException;
	public List<User> getUserByName(String name)throws SQLException;
	
	public boolean persistUser(User user) throws SQLException;
}