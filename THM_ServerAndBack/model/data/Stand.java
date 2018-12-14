package application.model.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Stand {

	
	private IntegerProperty standId;
	private StringProperty standName;
	private StringProperty standLocation;
	private StringProperty standOwner;
	
	
	public Stand(String standName, String standLocation, String standOwner) {
		this.standName = new SimpleStringProperty(standName);
		this.standLocation = new SimpleStringProperty(standLocation);
		this.standOwner = new SimpleStringProperty(standOwner);
	}
	
	public Stand(int standId,String standName, String standLocation, String standOwner) {
		this.standId = new SimpleIntegerProperty(standId);
		this.standName = new SimpleStringProperty(standName);
		this.standLocation = new SimpleStringProperty(standLocation);
		this.standOwner = new SimpleStringProperty(standOwner);
	}
	
	public IntegerProperty getStandId() {
		return standId;
	}
	public StringProperty getStandName() {
		return standName;
	}
	public StringProperty getStandLocation() {
		return standLocation;
	}
	public StringProperty getStandOwner() {
		return standOwner;
	}
	public void setStandOwner(StringProperty standOwner) {
		this.standOwner = standOwner;
	}
	public void setStandId(IntegerProperty standId) {
		this.standId = standId;
	}
	public void setStandName(StringProperty standName) {
		this.standName = standName;
	}
	public void setStandLocation(StringProperty standLocation) {
		this.standLocation = standLocation;
	}
	
	
}
