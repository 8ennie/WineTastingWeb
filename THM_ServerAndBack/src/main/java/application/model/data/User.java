/**
 * 
 */
package application.model.data;

/**
 * @author Noah Ruben
 *
 */
public class User {
	
	private int userID;
	private final String USERNAME;
	private final String PW;
	
	public String getUsername() {
		return this.USERNAME;
	}
	public String getPassword() {
		return this.PW;
	}
	
	public int getUserID() {
		return this.userID;
	}
	
	/**
	 * @param name of the user
	 * @param password of the user
	 */
	public User(String name, String password) {
		USERNAME = name;
		PW = password;
	}
	
	public User(int userID, String name, String password) {
		this.userID = userID;
		USERNAME = name;
		PW = password;
	}
	
	
	public boolean isEqualTo(User userToCompare) {
		if (this.USERNAME.equals(userToCompare.getUsername()) && this.PW.equals(userToCompare.getPassword())) {
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User ");
		if (USERNAME != null) {
			builder.append("USERNAME=");
			builder.append(USERNAME);
			builder.append(", ");
		}
		if (PW != null) {
			builder.append("PW=");
			builder.append(PW);
		}
		return builder.toString();
	}
}
