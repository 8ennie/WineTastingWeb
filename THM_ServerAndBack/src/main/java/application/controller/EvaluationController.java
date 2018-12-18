/**
 * 
 */
package application.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import application.model.data.SearchStatus;
import application.model.data.StandEvaluation;
import application.model.data.StandEvaluationDAO;
import application.model.data.Wine;
import application.model.data.WineDAO;
import application.model.data.WineEvaluation;
import application.model.data.WineEvaluationDAO;
import application.model.tasks.AddStandEvaluation;
import application.model.tasks.AddWineEvaluation;
import application.model.tasks.ChangeStandEvaluation;
import application.model.tasks.ChangeWineEvaluation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * @author student
 *
 */
public class EvaluationController implements Initializable {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="evaluate_AnchorPane"
	private AnchorPane evaluate_AnchorPane; // Value injected by FXMLLoader

	@FXML // fx:id="userName_Lable"
	private Label userName_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="logOut_Button"
	private Button logOut_Button; // Value injected by FXMLLoader

	@FXML // fx:id="goBack_Button"
	private Button goBack_Button; // Value injected by FXMLLoader

	@FXML // fx:id="standName_Lable"
	private Label standName_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="wines_ChoiceBox"
	private ChoiceBox<Wine> wines_ChoiceBox; // Value injected by FXMLLoader

	@FXML // fx:id="sweet_Slider"
	private Slider sweet_Slider; // Value injected by FXMLLoader

	@FXML // fx:id="salty_Slider"
	private Slider salty_Slider; // Value injected by FXMLLoader

	@FXML // fx:id="bitter_Slider"
	private Slider bitter_Slider; // Value injected by FXMLLoader

	@FXML // fx:id="sour_Slider"
	private Slider sour_Slider; // Value injected by FXMLLoader

	@FXML // fx:id="review_TextArea"
	private TextArea review_TextArea; // Value injected by FXMLLoader

	@FXML // fx:id="evaluateWine_Button"
	private Button evaluateWine_Button; // Value injected by FXMLLoader

	private MainController mainCon;

	private Wine wine;

	private WineEvaluation wineEvaluation;

	private StandEvaluation standEvaluation;

	public EvaluationController(MainController mainController, Wine wine) {
		// TODO Auto-generated constructor stub
		this.mainCon = mainController;
		this.wine = wine;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert evaluate_AnchorPane != null : "fx:id=\"evaluate_AnchorPane\" was not injected: check your FXML file 'Evaluate.fxml'.";
		assert userName_Lable != null : "fx:id=\"userName_Lable\" was not injected: check your FXML file 'Evaluate.fxml'.";
		assert logOut_Button != null : "fx:id=\"logOut_Button\" was not injected: check your FXML file 'Evaluate.fxml'.";
		assert goBack_Button != null : "fx:id=\"goBack_Button\" was not injected: check your FXML file 'Evaluate.fxml'.";
		assert standName_Lable != null : "fx:id=\"standName_Lable\" was not injected: check your FXML file 'Evaluate.fxml'.";
		assert wines_ChoiceBox != null : "fx:id=\"wines_ChoiceBox\" was not injected: check your FXML file 'Evaluate.fxml'.";
		assert sweet_Slider != null : "fx:id=\"sweet_Slider\" was not injected: check your FXML file 'Evaluate.fxml'.";
		assert salty_Slider != null : "fx:id=\"salty_Slider\" was not injected: check your FXML file 'Evaluate.fxml'.";
		assert bitter_Slider != null : "fx:id=\"bitter_Slider\" was not injected: check your FXML file 'Evaluate.fxml'.";
		assert sour_Slider != null : "fx:id=\"sour_Slider\" was not injected: check your FXML file 'Evaluate.fxml'.";
		assert review_TextArea != null : "fx:id=\"review_TextArea\" was not injected: check your FXML file 'Evaluate.fxml'.";
		assert evaluateWine_Button != null : "fx:id=\"evaluateWine_Button\" was not injected: check your FXML file 'Evaluate.fxml'.";

		userName_Lable.setText(mainCon.getSession().getCurrentUser().getUsername());

		logOut_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.logOut();
			}
		});

		goBack_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.gotoSearch(SearchStatus.Evaluation);
			}
		});

		standName_Lable.setText("Stand Name: " + wine.getStand().get().getStandName().get());

		ObservableList<Wine> standWineList = FXCollections.observableArrayList();
		try {
			standWineList.addAll(new WineDAO().getWineByStand(wine.getStand().get()));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		wines_ChoiceBox.setItems(standWineList);
		wines_ChoiceBox.getSelectionModel().select(wine);
		wines_ChoiceBox.setValue(wine);
		wines_ChoiceBox.getSelectionModel().selectedItemProperty().addListener(changeWineListener);
		evaluateWine_Button.addEventHandler(ActionEvent.ANY, evaluateWineHandler);
		evaluateWine_Button.addEventHandler(ActionEvent.ANY, evaluateStandHandler);
		update();

		if (chechIfStandEvaluated()) {
			review_TextArea.setText(standEvaluation.getReview().get());
		}
	}

	ChangeListener<Wine> changeWineListener = new ChangeListener<Wine>() {
		@Override
		public void changed(ObservableValue<? extends Wine> observable, Wine oldValue, Wine newValue) {
			update();
		}
	};

	private void update() {
		if (chechIfWineEvaluated()) {
			loadWineEvaluation();
			// this.wine = wines_ChoiceBox.getValue();
		} else {
			sweet_Slider.setValue(0);
			salty_Slider.setValue(0);
			bitter_Slider.setValue(0);
			sour_Slider.setValue(0);
		}
	}

	final EventHandler<Event> evaluateStandHandler = new EventHandler<Event>() {
		@Override
		public void handle(Event event) {
			if (event.getEventType() != ActionEvent.ANY) {
				if (!((KeyEvent) event).getCode().equals(KeyCode.ENTER)) {
					return;
				}
			}

			if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(evaluateWine_Button)) {
				if (standEvaluation != null) {
					if (!review_TextArea.getText().equals(standEvaluation.getReview().get())) {
						standEvaluation.setReview(review_TextArea.getText());
						ChangeStandEvaluation changeStandEvaluation = new ChangeStandEvaluation(standEvaluation);
						new Thread(changeStandEvaluation).start();
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Success");
						alert.setHeaderText(null);
						alert.setContentText("The Evaluation was Changed");

						alert.showAndWait();
					}
				}else{
					standEvaluation = new StandEvaluation(wine.getStand().get(), mainCon.getSession().getCurrentUser(), review_TextArea.getText());
					AddStandEvaluation addStandEvaluation = new AddStandEvaluation(standEvaluation);
					new Thread(addStandEvaluation).start();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Success");
					alert.setHeaderText(null);
					alert.setContentText("The Stand was Added");

					alert.showAndWait();
				}
				
			}
		}
	};

	final EventHandler<Event> evaluateWineHandler = new EventHandler<Event>() {
		@Override
		public void handle(Event event) {
			if (event.getEventType() != ActionEvent.ANY) {
				if (!((KeyEvent) event).getCode().equals(KeyCode.ENTER)) {
					return;
				}
			}

			if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(evaluateWine_Button)) {
				if (wineEvaluation == null) {
					WineEvaluation newWineEvaluation = new WineEvaluation(wines_ChoiceBox.getValue(),
							mainCon.getSession().getCurrentUser(), (int) sweet_Slider.getValue(),
							(int) salty_Slider.getValue(), (int) bitter_Slider.getValue(),
							(int) sour_Slider.getValue());
					AddWineEvaluation addWineEvaluation = new AddWineEvaluation(newWineEvaluation);
					new Thread(addWineEvaluation).start();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Success");
					alert.setHeaderText(null);
					alert.setContentText("The Wine Was Evaluated");

					alert.showAndWait();
					update();
				} else {
					WineEvaluation changedWineEvaluation = new WineEvaluation(
							wineEvaluation.getWineEvaluationId().get(), wines_ChoiceBox.getValue(),
							mainCon.getSession().getCurrentUser(), (int) sweet_Slider.getValue(),
							(int) salty_Slider.getValue(), (int) bitter_Slider.getValue(),
							(int) sour_Slider.getValue());
					ChangeWineEvaluation changeWineEvaluation = new ChangeWineEvaluation(changedWineEvaluation);
					new Thread(changeWineEvaluation).start();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Success");
					alert.setHeaderText(null);
					alert.setContentText("The Evaluation was Updated");

					alert.showAndWait();
					update();
				}
			}
		}
	};

	private boolean chechIfWineEvaluated() {
		WineEvaluationDAO wineEvaluationDAO = new WineEvaluationDAO();
		List<WineEvaluation> listWineEvaluation;
		try {
			listWineEvaluation = wineEvaluationDAO.getWineEvaluationByWine(wines_ChoiceBox.getValue());
		} catch (SQLException e) {
			listWineEvaluation = null;
			e.printStackTrace();
		}
		if (!listWineEvaluation.isEmpty()) {
			for (WineEvaluation wineEvaluation : listWineEvaluation) {
				if (wineEvaluation.getUser().get().getUserID() == mainCon.getSession().getCurrentUser().getUserID()) {
					this.wineEvaluation = wineEvaluation;
					return true;
				}
			}
		}
		return false;
	}

	private boolean chechIfStandEvaluated() {
		StandEvaluationDAO standEvaluationDAO = new StandEvaluationDAO();
		List<StandEvaluation> listStandEvaluation;
		try {
			listStandEvaluation = standEvaluationDAO
					.getStandEvaluationByStand(wines_ChoiceBox.getValue().getStand().get());
			
		} catch (SQLException e) {
			listStandEvaluation = null;
			e.printStackTrace();
		}
		if (!listStandEvaluation.isEmpty()) {
			for (StandEvaluation standEvaluation : listStandEvaluation) {
				if (standEvaluation.getUser().get().getUserID() == mainCon.getSession().getCurrentUser().getUserID()) {
					this.standEvaluation = standEvaluation;
					return true;
				}
			}
		}
		return false;
	}

	private void loadWineEvaluation() {
		sweet_Slider.setValue(this.wineEvaluation.getSweet().get());
		salty_Slider.setValue(this.wineEvaluation.getSalty().get());
		bitter_Slider.setValue(this.wineEvaluation.getBitter().get());
		sour_Slider.setValue(this.wineEvaluation.getSour().get());
	}

}
