package application.model.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class WineEvaluation {

	private IntegerProperty wineEvaluationId;
	private ObjectProperty<Wine> wine;
	private ObjectProperty<User> user;
	private IntegerProperty sweet;
	private IntegerProperty salty;
	private IntegerProperty bitter;
	private IntegerProperty sour;

	public WineEvaluation(int id, Wine wine, User user, int sweet, int salty, int bitter, int sour) {
		this.wineEvaluationId = new SimpleIntegerProperty(id);
		this.wine = new SimpleObjectProperty<Wine>(wine);
		this.user = new SimpleObjectProperty<User>(user);
		this.sweet = new SimpleIntegerProperty(sweet);
		this.salty = new SimpleIntegerProperty(salty);
		this.bitter = new SimpleIntegerProperty(bitter);
		this.sour = new SimpleIntegerProperty(sour);
	}

	public WineEvaluation(Wine wine, User user, int sweet, int salty, int bitter, int sour) {
		this.wine = new SimpleObjectProperty<Wine>(wine);
		this.user = new SimpleObjectProperty<User>(user);
		this.sweet = new SimpleIntegerProperty(sweet);
		this.salty = new SimpleIntegerProperty(salty);
		this.bitter = new SimpleIntegerProperty(bitter);
		this.sour = new SimpleIntegerProperty(sour);
	}
	
	public IntegerProperty getWineEvaluationId() {
		return wineEvaluationId;
	}

	public ObjectProperty<Wine> getWine() {
		return wine;
	}

	public IntegerProperty getSweet() {
		return sweet;
	}

	public IntegerProperty getSalty() {
		return salty;
	}

	public IntegerProperty getBitter() {
		return bitter;
	}

	public IntegerProperty getSour() {
		return sour;
	}

	public ObjectProperty<User> getUser() {
		return user;
	}

	public void setUser(ObjectProperty<User> user) {
		this.user = user;
	}

	public void setWine(ObjectProperty<Wine> wine) {
		this.wine = wine;
	}

	public void setSweet(IntegerProperty sweet) {
		this.sweet = sweet;
	}

	public void setSalty(IntegerProperty salty) {
		this.salty = salty;
	}

	public void setBitter(IntegerProperty bitter) {
		this.bitter = bitter;
	}

	public void setSour(IntegerProperty sour) {
		this.sour = sour;
	}

}
