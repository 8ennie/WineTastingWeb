/**
 * 
 */
package application.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.model.data.Stand;
import application.model.data.Wine;
import application.model.data.WineDAO;
import application.model.tasks.AddWine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * @author student
 *
 */
public class EditWineController implements Initializable {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="editWine_AnchorPane"
	private AnchorPane editWine_AnchorPane; // Value injected by FXMLLoader

	@FXML // fx:id="userName_Lable"
	private Label userName_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="logOut_Button"
	private Button logOut_Button; // Value injected by FXMLLoader

	@FXML // fx:id="standName_Lable"
	private Label standName_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="wines_ChoiceBox"
	private ChoiceBox<Wine> wines_ChoiceBox; // Value injected by FXMLLoader

	@FXML // fx:id="removeWine_Button"
	private Button removeWine_Button; // Value injected by FXMLLoader

	@FXML // fx:id="wineName_TextField"
	private TextField wineName_TextField; // Value injected by FXMLLoader

	@FXML // fx:id="addWine_Button"
	private Button addWine_Button; // Value injected by FXMLLoader

	@FXML // fx:id="finished_Button"
	private Button finished_Button; // Value injected by FXMLLoader

	private MainController mainCon;

	private Stand stand;

	public EditWineController(MainController mainController, Stand stand) {
		this.mainCon = mainController;
		this.stand = stand;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert editWine_AnchorPane != null : "fx:id=\"editWine_AnchorPane\" was not injected: check your FXML file 'EditWine.fxml'.";
		assert userName_Lable != null : "fx:id=\"userName_Lable\" was not injected: check your FXML file 'EditWine.fxml'.";
		assert logOut_Button != null : "fx:id=\"logOut_Button\" was not injected: check your FXML file 'EditWine.fxml'.";
		assert standName_Lable != null : "fx:id=\"standName_Lable\" was not injected: check your FXML file 'EditWine.fxml'.";
		assert wines_ChoiceBox != null : "fx:id=\"wines_ChoiceBox\" was not injected: check your FXML file 'EditWine.fxml'.";
		assert removeWine_Button != null : "fx:id=\"removeWine_Button\" was not injected: check your FXML file 'EditWine.fxml'.";
		assert wineName_TextField != null : "fx:id=\"wineName_TextField\" was not injected: check your FXML file 'EditWine.fxml'.";
		assert addWine_Button != null : "fx:id=\"addWine_Button\" was not injected: check your FXML file 'EditWine.fxml'.";
		assert finished_Button != null : "fx:id=\"finished_Button\" was not injected: check your FXML file 'EditWine.fxml'.";
		userName_Lable.setText(mainCon.getSession().getCurrentUser().getUsername());
		standName_Lable.setText(stand.getStandName().get());
		
		ObservableList<Wine> standWineList = FXCollections.observableArrayList();
		try {
			standWineList.addAll(new WineDAO().getWineByStand(stand));
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		wines_ChoiceBox.setItems(standWineList);
		logOut_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.logOut();
			}
		});
		finished_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.gotoStands();
			}
		});
		this.editWine_AnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, this.addWineHandler);
		this.addWine_Button.addEventHandler(ActionEvent.ANY, this.addWineHandler);
		this.removeWine_Button.addEventHandler(ActionEvent.ANY, this.deleteWineHandler);
		this.editWine_AnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, this.deleteWineHandler);
	}

	final EventHandler<Event> addWineHandler = new EventHandler<Event>() {
		@Override
		public void handle(Event event) {
			if (event.getEventType() != ActionEvent.ANY) {
				if (!((KeyEvent) event).getCode().equals(KeyCode.ENTER)) {
					return;
				}
			}
			if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(addWine_Button)
				|| mainCon.getStage().getScene().focusOwnerProperty().get().equals(wineName_TextField)) {
				try {
					Wine newWine = new Wine((mainCon.getSession().getWineList().get(mainCon.getSession().getWineList().size()-1).getWineId().get())+1,wineName_TextField.getText(),"",stand);
					AddWine addWine = new AddWine(newWine,mainCon);
					new Thread(addWine).start();
					System.out.println(mainCon.getSession().getWineList().size());
					wines_ChoiceBox.getItems().add(newWine);
					wineName_TextField.clear();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	};
	
	final EventHandler<Event> deleteWineHandler = new EventHandler<Event>() {
		@Override
		public void handle(Event event) {
			if (event.getEventType() != ActionEvent.ANY) {
				if (!((KeyEvent) event).getCode().equals(KeyCode.ENTER)) {
					return;
				}
			}
			if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(removeWine_Button)) {
				try {
					Wine delWine = wines_ChoiceBox.getSelectionModel().getSelectedItem();
					mainCon.getSession().getWineList().remove(delWine);
					wines_ChoiceBox.getItems().remove(delWine);
					new WineDAO().deleteWine(delWine);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	};

}
