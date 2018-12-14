/**
 * 
 */
package application.model.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import application.model.data.Stand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Noah Ruben
 * @see <a href="https://github.com/8ennie/WineTasting">Github</a>
 */
public class StandFileHandler{
	private static final String PATH = new File("").getAbsolutePath() + "\\WineTasting\\src\\application\\model\\data\\Stand.csv";

	private static ObservableList<Stand> standFromFile = FXCollections.observableArrayList();

	public static ObservableList<Stand> getStand(){
		readStands();
		return standFromFile;

	}

	public static void persistStand(Stand stand) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true));
		writer.write(stand.getStandId().get() + ";" + stand.getStandName().get() + ";" + stand.getStandLocation().get() + ";" + stand.getStandOwner().get());
		writer.newLine();
		writer.flush();
		writer.close();
	}

	public static void deleteStand(Stand delStand) throws IOException {
		standFromFile.remove(delStand);
		BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, false));
		for (Stand stand : standFromFile) {
			try {
				writer.write(stand.getStandId().get() + ";" + stand.getStandName().get() + ";" + stand.getStandLocation().get() + ";" + stand.getStandOwner().get());
				writer.newLine();
				writer.flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		writer.close();
	}
	
	
	private static void readStands(){
		try{
			standFromFile.clear();
			FileInputStream fstream = new FileInputStream(PATH);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
			String line = null;
			while ((line = reader.readLine()) != null){
				String[] linesSplit = line.trim().split(";");
				Stand tempStand = new Stand(Integer.parseInt(linesSplit[0]), linesSplit[1],linesSplit[2],linesSplit[3]);
				if(!standFromFile.contains(tempStand)){
					standFromFile.add(tempStand);
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
