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
import application.model.data.Wine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author bcwie
 *
 */
public class WineFileHander {
	private static final String PATH = new File("").getAbsolutePath()
			+ "\\WineTasting\\src\\application\\model\\data\\Wine.csv";

	private static ObservableList<Wine> wineFromFile = FXCollections.observableArrayList();

	public static ObservableList<Wine> getWine() {
		readWine();
		return wineFromFile;

	}

	public static void persistWine(Wine wine) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true));
		writer.write(wine.getWineId().get() + ";" + wine.getName().get() + ";" + wine.getDescription().get() + ";"
				+ wine.getStand().get().getStandId().get());
		writer.newLine();
		writer.flush();
		writer.close();
	}

	public static void deleteWine(Wine delWine) throws IOException {
		wineFromFile.remove(delWine);
		BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, false));
		for (Wine wine : wineFromFile) {
			try {
				writer.write(wine.getWineId().get() + ";" + wine.getName().get() + ";" + wine.getDescription().get()
						+ ";" + wine.getStand().get().getStandId().get());
				writer.newLine();
				writer.flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		writer.close();
	}

	private static void readWine() {
		try {

			FileInputStream fstream = new FileInputStream(PATH);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] linesSplit = line.trim().split(";");
				ObservableList<Stand> standList = StandFileHandler.getStand();
				Stand wineStand = standList.get(0);
				for (Stand stand : standList) {
					if (stand.getStandId().get() == Integer.parseInt(linesSplit[3])) {
						wineStand = stand;
					}
				}
				Wine tempStand = new Wine(Integer.parseInt(linesSplit[0]), linesSplit[1], linesSplit[2], wineStand);
				if (!wineFromFile.contains(tempStand)) {
					wineFromFile.add(tempStand);
				}
			}
			// Close the input stream
			reader.close();
		} catch (FileNotFoundException exception) {
			System.out.println(exception.getMessage());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
