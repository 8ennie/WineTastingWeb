package application.model.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends BaseDAO implements IUserDAO{

	public UserDAO() {
		super();
	}
	
	public static void main(String[] args) {
		IUserDAO userDAO = new UserDAO();
		try {
			userDAO.persistUser(new User("NOAH", "test"));
			List<User> userByName = userDAO.getUserByName("NOAH");
			for (User user : userByName) {
				System.out.println(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public User getUserByID(int id) throws SQLException {
		PreparedStatement prepareStatement = this.conn.prepareStatement("Select ID, USERNAME, PW from wine_test_db.USER WHERE ID = ?");
		prepareStatement.setInt(1, id);
		ResultSet rs = prepareStatement.executeQuery();
		rs.next();
		return new User(rs.getInt("ID"),rs.getString("USERNAME"), rs.getString("PW"));
	}

	@Override
	public List<User> getUserByName(String name) throws SQLException {
		List<User> users = new ArrayList<>();
		PreparedStatement prepareStatement = this.conn.prepareStatement("Select ID, USERNAME, PW from wine_test_db.USER WHERE USERNAME = ?");
		prepareStatement.setString(1, name);
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			users.add(new User(rs.getInt("ID"),rs.getString("USERNAME"), rs.getString("PW")));
		}
		return users;
	}
	
	@Override
	public boolean persistUser(User user) throws SQLException{
		PreparedStatement prepareStatement = this.conn.prepareStatement("INSERT INTO USER (USERNAME, PW) VALUES (?, ?)");
		prepareStatement.setString(1,user.getUsername());
		prepareStatement.setString(2,user.getPassword());
		return prepareStatement.execute();
	}
	
	

}
