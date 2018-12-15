package application.controller;
/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import application.localisation.ResourceBundleUtils;
import application.localisation.ResourceBundleUtils.ResourceKeys;
import application.model.data.User;
import application.model.tasks.LoginProcess;
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

public class LoginController implements Initializable {

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="login_AnchorPane"
    private AnchorPane login_AnchorPane; // Value injected by FXMLLoader

    @FXML // fx:id="userName_Lable"
    private Label userName_Lable; // Value injected by FXMLLoader

    @FXML // fx:id="password_Lable"
    private Label password_Lable; // Value injected by FXMLLoader

    @FXML // fx:id="userName_TextField"
    private TextField userName_TextField; // Value injected by FXMLLoader

    @FXML // fx:id="password_PasswordField"
    private PasswordField password_PasswordField; // Value injected by FXMLLoader

    @FXML // fx:id="lblError"
    private Label lblError; // Value injected by FXMLLoader

    @FXML // fx:id="login_Button"
    private Button login_Button; // Value injected by FXMLLoader

    @FXML // fx:id="register_Button"
    private Button register_Button; // Value injected by FXMLLoader

    @FXML // fx:id="login_Lable"
    private Label login_Lable; // Value injected by FXMLLoader

	private MainController mainCon;
	
	

	final EventHandler<Event> registerHandler = new EventHandler<Event>() {
		@Override
		public void handle(Event event) {
			if (event.getEventType() != ActionEvent.ANY) {
				if (!((KeyEvent) event).getCode().equals(KeyCode.ENTER)) {
					return;
				}
			}
			if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(register_Button)) {
				LoginController.this.mainCon.gotoRegister();
			}

		}
	};

	final EventHandler<Event> loginHandler = new EventHandler<Event>() {
		@Override
		public void handle(Event event) {
			if (event.getEventType() != ActionEvent.ANY) {
				if (!((KeyEvent) event).getCode().equals(KeyCode.ENTER)) {
					return;
				}
			}

			if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(login_Button)
					|| mainCon.getStage().getScene().focusOwnerProperty().get().equals(password_PasswordField)) {
				User user = new User(LoginController.this.userName_TextField.getText(),
						LoginController.this.password_PasswordField.getText());
				LoginProcess lp = new LoginProcess(user, mainCon);
				lp.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler<WorkerStateEvent>() {
					@Override
					public void handle(WorkerStateEvent t) {
						Boolean result = lp.getValue();
						if (result) {
							LoginController.this.mainCon.gotoOptions();
						} else {
							LoginController.this.lblError.setVisible(true);
							LoginController.this.lblError
									.setText("An Error Ocured! Username or Password is incorrect!");
						}
					}
				});
				new Thread(lp).start();
			}
		}
	};

	public LoginController(MainController mainController) {
		this.mainCon = mainController;
	}

	public void changeLanguage(ResourceBundle resourceBundle) {
		this.login_Lable.setText(ResourceBundleUtils.getLangString(resourceBundle,
                ResourceKeys.txt_login_Lable)); 
		this.userName_Lable.setText(ResourceBundleUtils.getLangString(resourceBundle,
                ResourceKeys.txt_userName_Lable));
		this.password_Lable.setText(ResourceBundleUtils.getLangString(resourceBundle,
                ResourceKeys.txt_password_Lable));
		this.register_Button.setText(ResourceBundleUtils.getLangString(resourceBundle,
                ResourceKeys.txt_register_Button));
		this.login_Button.setText(ResourceBundleUtils.getLangString(resourceBundle,
                ResourceKeys.txt_login_Button));
		
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 assert login_AnchorPane != null : "fx:id=\"login_AnchorPane\" was not injected: check your FXML file 'Login.fxml'.";
	        assert userName_Lable != null : "fx:id=\"userName_Lable\" was not injected: check your FXML file 'Login.fxml'.";
	        assert password_Lable != null : "fx:id=\"password_Lable\" was not injected: check your FXML file 'Login.fxml'.";
	        assert userName_TextField != null : "fx:id=\"userName_TextField\" was not injected: check your FXML file 'Login.fxml'.";
	        assert password_PasswordField != null : "fx:id=\"password_PasswordField\" was not injected: check your FXML file 'Login.fxml'.";
	        assert lblError != null : "fx:id=\"lblError\" was not injected: check your FXML file 'Login.fxml'.";
	        assert login_Button != null : "fx:id=\"login_Button\" was not injected: check your FXML file 'Login.fxml'.";
	        assert register_Button != null : "fx:id=\"register_Button\" was not injected: check your FXML file 'Login.fxml'.";
	        assert login_Lable != null : "fx:id=\"login_Lable\" was not injected: check your FXML file 'Login.fxml'.";

		this.login_Button.addEventHandler(ActionEvent.ANY, this.loginHandler);
		this.register_Button.addEventHandler(ActionEvent.ANY, this.registerHandler);
		this.login_AnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, this.loginHandler);
		this.login_AnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, this.registerHandler);
	}
}
