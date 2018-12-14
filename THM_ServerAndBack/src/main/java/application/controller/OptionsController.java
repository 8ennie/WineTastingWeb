package application.controller;

/**
 * Sample Skeleton for 'Options.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import application.model.data.SearchStatus;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class OptionsController implements Initializable {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="options_AnchorPane"
	private AnchorPane options_AnchorPane; // Value injected by FXMLLoader

	@FXML // fx:id="userName_Lable"
	private Label userName_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="logOut_Button"
	private Button logOut_Button; // Value injected by FXMLLoader

	@FXML // fx:id="edit_Button"
	private Button edit_Button; // Value injected by FXMLLoader

	@FXML // fx:id="evaluation_Button"
	private Button evaluation_Button; // Value injected by FXMLLoader

	@FXML // fx:id="viewEvaluation_Button"
	private Button viewEvaluation_Button; // Value injected by FXMLLoader

	private final MainController mainCon;

	public OptionsController(MainController mainController) {
		this.mainCon = mainController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert options_AnchorPane != null : "fx:id=\"options_AnchorPane\" was not injected: check your FXML file 'Options.fxml'.";
		assert userName_Lable != null : "fx:id=\"userName_Lable\" was not injected: check your FXML file 'Options.fxml'.";
		assert logOut_Button != null : "fx:id=\"logOut_Button\" was not injected: check your FXML file 'Options.fxml'.";
		assert edit_Button != null : "fx:id=\"edit_Button\" was not injected: check your FXML file 'Options.fxml'.";
		assert evaluation_Button != null : "fx:id=\"evaluation_Button\" was not injected: check your FXML file 'Options.fxml'.";
		assert viewEvaluation_Button != null : "fx:id=\"viewEvaluation_Button\" was not injected: check your FXML file 'Options.fxml'.";
		userName_Lable.setText(mainCon.getSession().getCurrentUser().getUsername());
		options_AnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, enterHandler);
		logOut_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.logOut();
			}
		});
		edit_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.gotoStands();
			}
		});
		evaluation_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.gotoSearch(SearchStatus.Evaluation);
			}
		});
		viewEvaluation_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.gotoSearch(SearchStatus.ViewEvaluation);
			}
		});
	}

	final EventHandler<KeyEvent> enterHandler = new EventHandler<KeyEvent>() {
		@Override
		public void handle(KeyEvent event) {
			if (event.getCode().equals(KeyCode.ENTER)) {
				if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(logOut_Button)) {
					mainCon.logOut();
				}
				if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(edit_Button)) {
					mainCon.gotoStands();
				}
				if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(evaluation_Button)) {
					mainCon.gotoSearch(SearchStatus.Evaluation);
				}
				if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(viewEvaluation_Button)) {
					mainCon.gotoSearch(SearchStatus.ViewEvaluation);
				}
			}

		}
	};

}
