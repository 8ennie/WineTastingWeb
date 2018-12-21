package application.controller;

/**
 * Sample Skeleton for 'Options.fxml' Controller Class
 */

import java.net.URL;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import application.localisation.OptionResourceBundleUtils;
import application.localisation.OptionResourceBundleUtils.OptionResourceKeys;
import application.model.data.SearchStatus;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

	    @FXML // fx:id="edit_Button"
	    private Button edit_Button; // Value injected by FXMLLoader

	    @FXML // fx:id="edit_ImageView"
	    private ImageView edit_ImageView; // Value injected by FXMLLoader

	    @FXML // fx:id="evaluation_Button"
	    private Button evaluation_Button; // Value injected by FXMLLoader

	    @FXML // fx:id="evaluate_ImageView"
	    private ImageView evaluate_ImageView; // Value injected by FXMLLoader

	    @FXML // fx:id="viewEvaluation_Button"
	    private Button viewEvaluation_Button; // Value injected by FXMLLoader

	    @FXML // fx:id="viewEvaluation_ImageView"
	    private ImageView viewEvaluation_ImageView; // Value injected by FXMLLoader

	    @FXML // fx:id="options_MenuBar"
	    private MenuBar options_MenuBar; // Value injected by FXMLLoader

	    @FXML // fx:id="settings_Menu"
	    private Menu settings_Menu; // Value injected by FXMLLoader

	    @FXML // fx:id="user_Menu"
	    private Menu user_Menu; // Value injected by FXMLLoader
	    
	    @FXML // fx:id="logOut_MenuItem"
	    private MenuItem logOut_MenuItem; // Value injected by FXMLLoader 	 	

	    @FXML // fx:id="options_Lable"
	    private Label options_Lable; // Value injected by FXMLLoader
	    
	    @FXML // fx:id="language_Menu"
	    private Menu language_Menu; // Value injected by FXMLLoader

	    @FXML // fx:id="german_MenuItem"
	    private MenuItem german_MenuItem; // Value injected by FXMLLoader

	    @FXML // fx:id="english_MenuItem"
	    private MenuItem english_MenuItem; // Value injected by FXMLLoader


	private final MainController mainCon;

	public OptionsController(MainController mainController) {
		this.mainCon = mainController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 assert options_AnchorPane != null : "fx:id=\"options_AnchorPane\" was not injected: check your FXML file 'Options.fxml'.";
		 assert options_AnchorPane != null : "fx:id=\"options_AnchorPane\" was not injected: check your FXML file 'Options.fxml'.";
	        assert edit_Button != null : "fx:id=\"edit_Button\" was not injected: check your FXML file 'Options.fxml'.";
	        assert edit_ImageView != null : "fx:id=\"edit_ImageView\" was not injected: check your FXML file 'Options.fxml'.";
	        assert evaluation_Button != null : "fx:id=\"evaluation_Button\" was not injected: check your FXML file 'Options.fxml'.";
	        assert evaluate_ImageView != null : "fx:id=\"evaluate_ImageView\" was not injected: check your FXML file 'Options.fxml'.";
	        assert viewEvaluation_Button != null : "fx:id=\"viewEvaluation_Button\" was not injected: check your FXML file 'Options.fxml'.";
	        assert viewEvaluation_ImageView != null : "fx:id=\"viewEvaluation_ImageView\" was not injected: check your FXML file 'Options.fxml'.";
	        assert options_MenuBar != null : "fx:id=\"options_MenuBar\" was not injected: check your FXML file 'Options.fxml'.";
	        assert settings_Menu != null : "fx:id=\"settings_Menu\" was not injected: check your FXML file 'Options.fxml'.";
	        assert language_Menu != null : "fx:id=\"language_Menu\" was not injected: check your FXML file 'Options.fxml'.";
	        assert german_MenuItem != null : "fx:id=\"german_MenuItem\" was not injected: check your FXML file 'Options.fxml'.";
	        assert english_MenuItem != null : "fx:id=\"english_MenuItem\" was not injected: check your FXML file 'Options.fxml'.";
	        assert user_Menu != null : "fx:id=\"user_Menu\" was not injected: check your FXML file 'Options.fxml'.";
	        assert logOut_MenuItem != null : "fx:id=\"logOut_MenuItem\" was not injected: check your FXML file 'Options.fxml'.";
	        assert options_Lable != null : "fx:id=\"options_Lable\" was not injected: check your FXML file 'Options.fxml'.";
		options_AnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, enterHandler);
		logOut_MenuItem.addEventHandler(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.logOut();
			}
		});
		german_MenuItem.addEventHandler(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.language = Locale.GERMANY;
				changeLanguage(PropertyResourceBundle.getBundle("Option",mainCon.language));
			}
		});
		english_MenuItem.addEventHandler(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.language = Locale.UK;
				changeLanguage(PropertyResourceBundle.getBundle("Option",mainCon.language));
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
		edit_ImageView.setImage(new Image("/pictures/edit2.png"));
		evaluate_ImageView.setImage(new Image("/pictures/evaluate.png"));
		viewEvaluation_ImageView.setImage(new Image("/pictures/chart2.png"));
		
	}

	final EventHandler<KeyEvent> enterHandler = new EventHandler<KeyEvent>() {
		@Override
		public void handle(KeyEvent event) {
			if (event.getCode().equals(KeyCode.ENTER)) {
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

	
	public void changeLanguage(ResourceBundle resourceBundle) {
		this.settings_Menu
				.setText(OptionResourceBundleUtils.getLangString(resourceBundle, OptionResourceKeys.txt_settings_Menu));
		this.language_Menu
		.setText(OptionResourceBundleUtils.getLangString(resourceBundle, OptionResourceKeys.txt_language_Menu));
		this.german_MenuItem
		.setText(OptionResourceBundleUtils.getLangString(resourceBundle, OptionResourceKeys.txt_german_MenuItem));
		this.english_MenuItem
		.setText(OptionResourceBundleUtils.getLangString(resourceBundle, OptionResourceKeys.txt_english_MenuItem));
		this.user_Menu
		.setText(OptionResourceBundleUtils.getLangString(resourceBundle, OptionResourceKeys.txt_user_Menu) + mainCon.getSession().getCurrentUser().getUsername());
		this.logOut_MenuItem
		.setText(OptionResourceBundleUtils.getLangString(resourceBundle, OptionResourceKeys.txt_logOut_MenuItem));
		this.options_Lable
		.setText(OptionResourceBundleUtils.getLangString(resourceBundle, OptionResourceKeys.txt_options_Lable));
		this.edit_Button
		.setText(OptionResourceBundleUtils.getLangString(resourceBundle, OptionResourceKeys.txt_edit_Button));
		this.evaluation_Button
		.setText(OptionResourceBundleUtils.getLangString(resourceBundle, OptionResourceKeys.txt_evaluation_Button));
		this.viewEvaluation_Button
		.setText(OptionResourceBundleUtils.getLangString(resourceBundle, OptionResourceKeys.txt_viewEvaluation_Button));
		
	}
}
