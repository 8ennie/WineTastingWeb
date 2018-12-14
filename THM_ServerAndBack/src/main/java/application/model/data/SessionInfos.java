/**
 * 
 */
package application.model.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author student
 *
 */
public class SessionInfos {

	private final User currentUser;

	private ObservableList<Stand> standList = FXCollections.observableArrayList();
	private ObservableList<Wine> wineList = FXCollections.observableArrayList();

	
	/**
	 * 
	 */
	public SessionInfos(User currentUser) {
		this.currentUser = currentUser;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public ObservableList<Stand> getStandList() {
		return standList;
	}

	public ObservableList<Wine> getWineList() {
		return wineList;
	}

	public void setWineList(ObservableList<Wine> wineList) {
		this.wineList = wineList;
	}

	public void setStandList(ObservableList<Stand> standList) {
		this.standList = standList;
	}
	
	public void addStand(Stand stand) {
		this.standList.add(stand);
	}

	public void addWine(Wine newWine) {
		this.wineList.add(newWine);	
	}
}
