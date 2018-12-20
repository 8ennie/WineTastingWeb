/**
 * 
 */
package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.data.Stand;
import application.model.tasks.AddStand;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * @author bcwie
 *
 */
public class AddStandController implements Initializable {

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="addStand_AnchorPane"
    private AnchorPane addStand_AnchorPane; // Value injected by FXMLLoader

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

    @FXML // fx:id="addStandTitel_Lable"
    private Label addStandTitel_Lable; // Value injected by FXMLLoader

    @FXML // fx:id="back_Button"
    private Button back_Button; // Value injected by FXMLLoader

    @FXML // fx:id="standName_Lable"
    private Label standName_Lable; // Value injected by FXMLLoader

    @FXML // fx:id="standOwner_Lable"
    private Label standOwner_Lable; // Value injected by FXMLLoader

    @FXML // fx:id="standName_TextField"
    private TextField standName_TextField; // Value injected by FXMLLoader

    @FXML // fx:id="standLocation_TextField"
    private TextField standLocation_TextField; // Value injected by FXMLLoader

    @FXML // fx:id="standOwner_TextField"
    private TextField standOwner_TextField; // Value injected by FXMLLoader

    @FXML // fx:id="standLocation_Lable"
    private Label standLocation_Lable; // Value injected by FXMLLoader

    @FXML // fx:id="addStand_Button"
    private Button addStand_Button; // Value injected by FXMLLoader

	private MainController mainCon;

	public AddStandController(MainController mainController) {
		// TODO Auto-generated constructor stub
		this.mainCon = mainController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert addStand_AnchorPane != null : "fx:id=\"addStand_AnchorPane\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert options_MenuBar != null : "fx:id=\"options_MenuBar\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert settings_Menu != null : "fx:id=\"settings_Menu\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert language_Menu != null : "fx:id=\"language_Menu\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert german_MenuItem != null : "fx:id=\"german_MenuItem\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert english_MenuItem != null : "fx:id=\"english_MenuItem\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert user_Menu != null : "fx:id=\"user_Menu\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert logOut_MenuItem != null : "fx:id=\"logOut_MenuItem\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert addStandTitel_Lable != null : "fx:id=\"addStandTitel_Lable\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert back_Button != null : "fx:id=\"back_Button\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert standName_Lable != null : "fx:id=\"standName_Lable\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert standOwner_Lable != null : "fx:id=\"standOwner_Lable\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert standName_TextField != null : "fx:id=\"standName_TextField\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert standLocation_TextField != null : "fx:id=\"standLocation_TextField\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert standOwner_TextField != null : "fx:id=\"standOwner_TextField\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert standLocation_Lable != null : "fx:id=\"standLocation_Lable\" was not injected: check your FXML file 'AddStand.fxml'.";
        assert addStand_Button != null : "fx:id=\"addStand_Button\" was not injected: check your FXML file 'AddStand.fxml'.";
		this.addStand_AnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, this.addStandHandler);
		this.addStand_Button.addEventHandler(ActionEvent.ANY, this.addStandHandler);
		back_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.gotoStands();
			}
		});
	}

	final EventHandler<Event> addStandHandler = new EventHandler<Event>() {
		@Override
		public void handle(Event event) {
			if (event.getEventType() != ActionEvent.ANY) {
				if (!((KeyEvent) event).getCode().equals(KeyCode.ENTER)) {
					return;
				}
			}
			if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(addStand_Button)
				|| mainCon.getStage().getScene().focusOwnerProperty().get().equals(standOwner_TextField)) {
				try {
					Stand newStand = new Stand(standName_TextField.getText(), standLocation_TextField.getText(), standOwner_TextField.getText());
					AddStand addStand = new AddStand(newStand,mainCon);
					new Thread(addStand).start();
					mainCon.gotoStands();
					mainCon.getSession().addStand(newStand);;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	};
	
	
	

}
