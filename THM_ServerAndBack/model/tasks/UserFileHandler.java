package application.model.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import application.model.data.User;

public class UserFileHandler{
	private static final String PATH = new File("").getAbsolutePath() + "\\WineTasting\\src\\application\\model\\data\\UserList.csv";
	private static List<User> usersFromFile = new ArrayList<User>();

	public static List<User> getUsers(){
		readUsers();
		return usersFromFile;

	}

	public static void deleteUser(User delUser) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, false));
		for (User user : usersFromFile) {
			if(user != delUser) {
				try {
					writer.write(user.getUsername() + ";" + user.getPassword());
					writer.newLine();
					writer.flush();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		writer.close();
	}
	
	
	public static void persistUser(User user) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true));
		writer.write(user.getUsername() + ";" + user.getPassword());
		writer.newLine();
		writer.flush();
		writer.close();
	}

	private static void readUsers(){
		try{

			FileInputStream fstream = new FileInputStream(PATH);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));

			String line = null;
			while ((line = reader.readLine()) != null){
				String[] linesSplit = line.trim().split(";");
				User tempUser = new User(linesSplit[0], linesSplit[1]);
				if(!usersFromFile.contains(tempUser)){
					usersFromFile.add(tempUser);
				}
			}
			// Close the input stream
			reader.close();
		} catch (FileNotFoundException exception){
			System.out.println(exception.getMessage());

		} catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
