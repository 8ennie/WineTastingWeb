package application.model.tasks;

import java.sql.SQLException;

import application.model.data.User;
import application.model.data.UserDAO;
import javafx.concurrent.Task;

public class RegisterUser extends Task<Boolean>{

	private final User user;

	public RegisterUser(User user){
		this.user = user;
	}

	private boolean writeToDatabse(){
		try{
			new UserDAO().persistUser(this.user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	protected Boolean call() throws Exception{
		return this.writeToDatabse();
	}
}
