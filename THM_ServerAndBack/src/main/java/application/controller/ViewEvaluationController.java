package application.controller;

import java.net.URL;
import java.sql.SQLException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.model.data.SearchStatus;
import application.model.data.Stand;
import application.model.data.StandEvaluation;
import application.model.data.StandEvaluationDAO;
import application.model.data.Wine;
import application.model.data.WineDAO;
import application.model.data.WineEvaluation;
import application.model.data.WineEvaluationDAO;
import javafx.fxml.Initializable;

public class ViewEvaluationController implements Initializable {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="viewEvaluation_AnchorPane"
	private AnchorPane viewEvaluation_AnchorPane; // Value injected by FXMLLoader

	@FXML // fx:id="options_MenuBar"
	private MenuBar options_MenuBar; // Value injected by FXMLLoader

	@FXML // fx:id="settings_Menu"
	private Menu settings_Menu; // Value injected by FXMLLoader

	@FXML // fx:id="language_Menu"
	private Menu language_Menu; // Value injected by FXMLLoader

	@FXML // fx:id="german_MenuItem"
	private MenuItem german_MenuItem; // Value injected by FXMLLoader

	@FXML // fx:id="english_MenuItem"
	private MenuItem english_MenuItem; // Value injected by FXMLLoader

	@FXML // fx:id="user_Menu"
	private Menu user_Menu; // Value injected by FXMLLoader

	@FXML // fx:id="logOut_MenuItem"
	private MenuItem logOut_MenuItem; // Value injected by FXMLLoader

	@FXML // fx:id="viewEvaluationTitle_Lable"
	private Label viewEvaluationTitle_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="wines_ChoiceBox"
	private ChoiceBox<Wine> wines_ChoiceBox; // Value injected by FXMLLoader

	@FXML // fx:id="wine_Lable"
	private Label wine_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="sweet_Lable"
	private Label sweet_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="salty_Lable"
	private Label salty_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="bitter_Lable"
	private Label bitter_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="sour_Lable"
	private Label sour_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="sweetAVG_Lable"
	private Label sweetAVG_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="saltyAVG_Lable"
	private Label saltyAVG_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="bitterAVG_Lable"
	private Label bitterAVG_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="sourAVG_Lable"
	private Label sourAVG_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="sweetOWN_Lable"
	private Label sweetOWN_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="saltyOWN_Lable"
	private Label saltyOWN_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="bitterOWN_Lable"
	private Label bitterOWN_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="sourOWN_Lable"
	private Label sourOWN_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="standName_Lable"
	private Label standName_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="standReview_Lable"
	private Label standReview_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="standReview_TextArea"
	private TextArea standReview_TextArea; // Value injected by FXMLLoader

	@FXML // fx:id="finished_Button"
	private Button finished_Button; // Value injected by FXMLLoader

	private MainController mainCon;

	private Wine wine;

	private final Stand stand;

	private List<WineEvaluation> wineEvaluations;

	public ViewEvaluationController(MainController mainController, Wine wine) {
		// TODO Auto-generated constructor stub
		this.mainCon = mainController;
		this.wine = wine;
		this.stand = wine.getStand().get();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert viewEvaluation_AnchorPane != null : "fx:id=\"viewEvaluation_AnchorPane\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert options_MenuBar != null : "fx:id=\"options_MenuBar\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert settings_Menu != null : "fx:id=\"settings_Menu\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert language_Menu != null : "fx:id=\"language_Menu\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert german_MenuItem != null : "fx:id=\"german_MenuItem\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert english_MenuItem != null : "fx:id=\"english_MenuItem\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert user_Menu != null : "fx:id=\"user_Menu\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert logOut_MenuItem != null : "fx:id=\"logOut_MenuItem\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert viewEvaluationTitle_Lable != null : "fx:id=\"viewEvaluationTitle_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert wines_ChoiceBox != null : "fx:id=\"wines_ChoiceBox\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert wine_Lable != null : "fx:id=\"wine_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert sweet_Lable != null : "fx:id=\"sweet_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert salty_Lable != null : "fx:id=\"salty_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert bitter_Lable != null : "fx:id=\"bitter_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert sour_Lable != null : "fx:id=\"sour_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert sweetAVG_Lable != null : "fx:id=\"sweetAVG_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert saltyAVG_Lable != null : "fx:id=\"saltyAVG_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert bitterAVG_Lable != null : "fx:id=\"bitterAVG_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert sourAVG_Lable != null : "fx:id=\"sourAVG_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert sweetOWN_Lable != null : "fx:id=\"sweetOWN_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert saltyOWN_Lable != null : "fx:id=\"saltyOWN_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert bitterOWN_Lable != null : "fx:id=\"bitterOWN_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert sourOWN_Lable != null : "fx:id=\"sourOWN_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert standName_Lable != null : "fx:id=\"standName_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert standReview_Lable != null : "fx:id=\"standReview_Lable\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert standReview_TextArea != null : "fx:id=\"standReview_TextArea\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
		assert finished_Button != null : "fx:id=\"finished_Button\" was not injected: check your FXML file 'ViewEvaluation.fxml'.";
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

		finished_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.gotoSearch(SearchStatus.ViewEvaluation);
			}
		});

		update();

		loadStandReview();

		wines_ChoiceBox.getSelectionModel().selectedItemProperty().addListener(changeWineListener);
	}

	ChangeListener<Wine> changeWineListener = new ChangeListener<Wine>() {
		@Override
		public void changed(ObservableValue<? extends Wine> observable, Wine oldValue, Wine newValue) {
			update();
		}
	};

	private void loadStandReview() {
		List<StandEvaluation> standEvaluationsList = null;
		try {
			standEvaluationsList = new StandEvaluationDAO().getStandEvaluationByStand(stand);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (standEvaluationsList != null) {
			for (StandEvaluation standEvaluation : standEvaluationsList) {
				if (standReview_TextArea.getText().isEmpty()) {
					standReview_TextArea.setText(standEvaluation.getUser().get().getUsername() + ": \t\t"
							+ standEvaluation.getReview().get());
				} else {
					standReview_TextArea.setText(
							standReview_TextArea.getText() + "\n" + standEvaluation.getUser().get().getUsername()
									+ ": \t\t" + standEvaluation.getReview().get());
				}
			}

		}

	}

	private void update() {
		this.wine = wines_ChoiceBox.getValue();
		try {
			wineEvaluations = new WineEvaluationDAO().getWineEvaluationByWine(wine);
		} catch (SQLException e) {
			wineEvaluations = null;
			e.printStackTrace();
		}
		if (!wineEvaluations.isEmpty()) {
			WineEvaluation ownWineEvaluation = getOwnEvaluated();
			if (!ownWineEvaluation.equals(null)) {
				sweetOWN_Lable.setText(String.valueOf(ownWineEvaluation.getSweet().get()));
				saltyOWN_Lable.setText(String.valueOf(ownWineEvaluation.getSalty().get()));
				bitterOWN_Lable.setText(String.valueOf(ownWineEvaluation.getBitter().get()));
				sourOWN_Lable.setText(String.valueOf(ownWineEvaluation.getSour().get()));
			} else {
				sweetOWN_Lable.setText("Not Evaluated");
				saltyOWN_Lable.setText("Not Evaluated");
				bitterOWN_Lable.setText("Not Evaluated");
				sourOWN_Lable.setText("Not Evaluated");
			}
			List<Integer> sweetAVG = new ArrayList<>();
			List<Integer> saltyAVG = new ArrayList<>();
			List<Integer> bitterAVG = new ArrayList<>();
			List<Integer> sourAVG = new ArrayList<>();
			for (WineEvaluation wineEvaluation : wineEvaluations) {
				sweetAVG.add(wineEvaluation.getSweet().get());
				saltyAVG.add(wineEvaluation.getSalty().get());
				bitterAVG.add(wineEvaluation.getBitter().get());
				sourAVG.add(wineEvaluation.getSour().get());
			}
			sweetAVG_Lable.setText(String.valueOf(getAVG(sweetAVG)));
			saltyAVG_Lable.setText(String.valueOf(getAVG(saltyAVG)));
			bitterAVG_Lable.setText(String.valueOf(getAVG(bitterAVG)));
			sourAVG_Lable.setText(String.valueOf(getAVG(sourAVG)));
		} else {
			sweetOWN_Lable.setText("Not Evaluated");
			saltyOWN_Lable.setText("Not Evaluated");
			bitterOWN_Lable.setText("Not Evaluated");
			sourOWN_Lable.setText("Not Evaluated");
			sweetAVG_Lable.setText("Not Evaluated");
			saltyAVG_Lable.setText("Not Evaluated");
			bitterAVG_Lable.setText("Not Evaluated");
			sourAVG_Lable.setText("Not Evaluated");
		}
	}

	private double getAVG(List<Integer> list) {
		double avg = 0;
		for (Integer integer : list) {
			avg = avg + (double) integer;
		}
		avg = avg / (double) list.size();
		return avg;
	}

	private WineEvaluation getOwnEvaluated() {
		for (WineEvaluation wineEvaluation : wineEvaluations) {
			if (wineEvaluation.getUser().get().getUserID() == mainCon.getSession().getCurrentUser().getUserID()) {
				return wineEvaluation;
			}
		}
		return null;
	}
}
