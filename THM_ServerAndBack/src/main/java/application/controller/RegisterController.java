package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.localisation.LoginResourceBundleUtils;
import application.localisation.LoginResourceBundleUtils.LoginResourceKeys;
import application.localisation.RegisterResourceBundleUtils;
import application.localisation.RegisterResourceBundleUtils.RegisterResourceKeys;
import application.model.data.User;
import application.model.tasks.RegisterUser;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class RegisterController implements Initializable {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="register_AnchorPane"
	private AnchorPane register_AnchorPane; // Value injected by FXMLLoader

	@FXML // fx:id="userName_Lable"
	private Label userName_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="password1_Lable"
	private Label password1_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="userName_TextField"
	private TextField userName_TextField; // Value injected by FXMLLoader

	@FXML // fx:id="password1_PasswordField"
	private PasswordField password1_PasswordField; // Value injected by FXMLLoader

	@FXML // fx:id="password2_PasswordField"
	private PasswordField password2_PasswordField; // Value injected by FXMLLoader

	@FXML // fx:id="password2_Lable"
	private Label password2_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="register_Lable"
	private Label register_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="back_Button"
	private Button back_Button; // Value injected by FXMLLoader

	@FXML // fx:id="register_Button"
	private Button register_Button; // Value injected by FXMLLoader

	private MainController mainCon;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		assert register_AnchorPane != null : "fx:id=\"register_AnchorPane\" was not injected: check your FXML file 'Register.fxml'.";
		assert userName_Lable != null : "fx:id=\"userName_Lable\" was not injected: check your FXML file 'Register.fxml'.";
		assert password1_Lable != null : "fx:id=\"password1_Lable\" was not injected: check your FXML file 'Register.fxml'.";
		assert userName_TextField != null : "fx:id=\"userName_TextField\" was not injected: check your FXML file 'Register.fxml'.";
		assert password1_PasswordField != null : "fx:id=\"password1_PasswordField\" was not injected: check your FXML file 'Register.fxml'.";
		assert password2_PasswordField != null : "fx:id=\"password2_PasswordField\" was not injected: check your FXML file 'Register.fxml'.";
		assert password2_Lable != null : "fx:id=\"password2_Lable\" was not injected: check your FXML file 'Register.fxml'.";
		assert register_Lable != null : "fx:id=\"register_Lable\" was not injected: check your FXML file 'Register.fxml'.";
		assert back_Button != null : "fx:id=\"back_Button\" was not injected: check your FXML file 'Register.fxml'.";
		assert register_Button != null : "fx:id=\"register_Button\" was not injected: check your FXML file 'Register.fxml'.";
		register_AnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, this.registerHandler);
		register_Button.addEventHandler(ActionEvent.ANY, this.registerHandler);
		back_Button.addEventFilter(ActionEvent.ANY, backHandler);
		register_AnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, this.backHandler);
	}

	final EventHandler<Event> backHandler = new EventHandler<Event>() {
		@Override
		public void handle(Event event) {
			if (event.getEventType() != ActionEvent.ANY) {
				if (!((KeyEvent) event).getCode().equals(KeyCode.ENTER)) {
					return;
				}
			}
			if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(back_Button)) {
				mainCon.gotoLogin();
			}

		}
	};

	public RegisterController(MainController mainController) {
		this.mainCon = mainController;
	}

	public void changeLanguage(ResourceBundle resourceBundle) {
		this.register_Lable.setText(
				RegisterResourceBundleUtils.getLangString(resourceBundle, RegisterResourceKeys.txt_register_Lable));
		this.userName_Lable.setText(
				RegisterResourceBundleUtils.getLangString(resourceBundle, RegisterResourceKeys.txt_userName_Lable));
		this.password1_Lable.setText(
				RegisterResourceBundleUtils.getLangString(resourceBundle, RegisterResourceKeys.txt_password1_Lable));
		this.password2_Lable.setText(
				RegisterResourceBundleUtils.getLangString(resourceBundle, RegisterResourceKeys.txt_password2_Lable));
		this.userName_TextField.setPromptText(
				RegisterResourceBundleUtils.getLangString(resourceBundle, RegisterResourceKeys.txt_userName_TextField));
		this.password1_PasswordField.setPromptText(
				RegisterResourceBundleUtils.getLangString(resourceBundle, RegisterResourceKeys.txt_password1_PasswordField));
		this.password2_PasswordField.setPromptText(
				RegisterResourceBundleUtils.getLangString(resourceBundle, RegisterResourceKeys.txt_password2_PasswordField));
		this.back_Button.setText(
				RegisterResourceBundleUtils.getLangString(resourceBundle, RegisterResourceKeys.txt_back_Button));
		this.register_Button.setText(
				RegisterResourceBundleUtils.getLangString(resourceBundle, RegisterResourceKeys.txt_register_Button));
	}

	final EventHandler<Event> registerHandler = new EventHandler<Event>() {
		@Override
		public void handle(Event event) {
			if (event.getEventType() != ActionEvent.ANY) {
				if (!((KeyEvent) event).getCode().equals(KeyCode.ENTER)) {
					return;
				}
			}

			if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(register_Button)
					|| mainCon.getStage().getScene().focusOwnerProperty().get().equals(password2_PasswordField)) {
				if (password1_PasswordField.getText().equals(password2_PasswordField.getText())) {
					User newUser = new User(userName_TextField.getText(), password1_PasswordField.getText());
					RegisterUser rU = new RegisterUser(newUser);
					rU.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler<WorkerStateEvent>() {
						@Override
						public void handle(WorkerStateEvent t) {
							Boolean result = (Boolean) rU.getValue();
							if (result) {
								mainCon.gotoLogin();
							} else {
							}
						}
					});
					new Thread(rU).start();
				} else {
					System.out.println("PW's nicht gleich");

				}
			}
		}
	};
}
