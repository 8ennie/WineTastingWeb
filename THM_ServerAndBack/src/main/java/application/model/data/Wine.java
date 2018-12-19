package application.model.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Wine {

	private IntegerProperty wineId;
	private StringProperty name;
	private StringProperty description;
	private ObjectProperty<Stand> stand;

	public Wine(int wineId, String name, String description, Stand stand) {
		this.wineId = new SimpleIntegerProperty(wineId);
		this.name = new SimpleStringProperty(name);
		this.description = new SimpleStringProperty(description);
		this.stand = new SimpleObjectProperty<Stand>(stand);
	}

	@Override
	public String toString() {
		
	    return this.getName().get();
	}
	
	public IntegerProperty getWineId() {
		return wineId;
	}

	public StringProperty getName() {
		return name;
	}

	public StringProperty getDescription() {
		return description;
	}

	public ObjectProperty<Stand> getStand() {
		return stand;
	}

	public void setWineId(IntegerProperty wineId) {
		this.wineId = wineId;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}

	public void setDescription(StringProperty description) {
		this.description = description;
	}

	public void setStand(ObjectProperty<Stand> stand) {
		this.stand = stand;
	}

}
