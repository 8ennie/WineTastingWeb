package application.model.data;



import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StandEvaluation {

	
	private IntegerProperty standEvaluationId;
	private ObjectProperty<Stand> stand;
	private ObjectProperty<User> user;
	private StringProperty review;
	
	public StandEvaluation(int id, Stand stand, User user, String review) {
		this.standEvaluationId = new SimpleIntegerProperty(id);
		this.stand = new SimpleObjectProperty<Stand>(stand);
		this.user = new SimpleObjectProperty<User>(user);
		this.review = new SimpleStringProperty(review);
	}

	public StandEvaluation(Stand stand, User user, String review) {
		this.stand = new SimpleObjectProperty<Stand>(stand);
		this.user = new SimpleObjectProperty<User>(user);
		this.review = new SimpleStringProperty(review);
	}
	
	public ObjectProperty<Stand> getStand() {
		return stand;
	}

	public void setStand(ObjectProperty<Stand> stand) {
		this.stand = stand;
	}

	public ObjectProperty<User> getUser() {
		return user;
	}

	public void setUser(ObjectProperty<User> user) {
		this.user = user;
	}

	public StringProperty getReview() {
		return review;
	}

	public void setReview(SimpleStringProperty review) {
		this.review = review;
	}

	public IntegerProperty getStandEvaluationId() {
		return standEvaluationId;
	}
	
	
}
