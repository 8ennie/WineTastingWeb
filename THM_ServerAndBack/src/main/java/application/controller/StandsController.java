package application.controller;

import java.net.URL;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import application.localisation.SearchResourceBundleUtils;
import application.localisation.SearchResourceBundleUtils.SearchResourceKeys;
import application.localisation.StandsResourceBundleUtils;
import application.localisation.StandsResourceBundleUtils.StandsResourceKeys;
import application.model.data.Stand;
import application.model.data.StandDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class StandsController implements Initializable {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="stands_AnchorPane"
	private AnchorPane stands_AnchorPane; // Value injected by FXMLLoader

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

	@FXML // fx:id="standTitle_Lable"
	private Label standTitle_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="back_Button"
	private Button back_Button; // Value injected by FXMLLoader

	@FXML // fx:id="search_Lable"
	private Label search_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="editWines_Button"
	private Button editWines_Button; // Value injected by FXMLLoader

	@FXML // fx:id="addStand_Button"
	private Button addStand_Button; // Value injected by FXMLLoader

	@FXML // fx:id="removeStand_Button"
	private Button removeStand_Button; // Value injected by FXMLLoader

	@FXML // fx:id="search_TextField"
	private TextField search_TextField; // Value injected by FXMLLoader

	@FXML // fx:id="stands_TableView"
	private TableView<Stand> stands_TableView; // Value injected by FXMLLoader

	@FXML // fx:id="standNr_TableColumn"
	private TableColumn<Stand, Integer> standNr_TableColumn; // Value injected by FXMLLoader

	@FXML // fx:id="standName_TableColumn"
	private TableColumn<Stand, String> standName_TableColumn; // Value injected by FXMLLoader

	@FXML // fx:id="standLocation_TableColumn"
	private TableColumn<Stand, String> standLocation_TableColumn; // Value injected by FXMLLoader

	@FXML // fx:id="standOwner_TableColumn"
	private TableColumn<Stand, String> standOwner_TableColumn; // Value injected by FXMLLoader

	private MainController mainCon;

	private ObservableList<Stand> standList = FXCollections.observableArrayList();

	public StandsController(MainController mainController) {
		// TODO Auto-generated constructor stub
		this.mainCon = mainController;
		standList = mainCon.getSession().getStandList();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert stands_AnchorPane != null : "fx:id=\"stands_AnchorPane\" was not injected: check your FXML file 'Stands.fxml'.";
		assert options_MenuBar != null : "fx:id=\"options_MenuBar\" was not injected: check your FXML file 'Stands.fxml'.";
		assert settings_Menu != null : "fx:id=\"settings_Menu\" was not injected: check your FXML file 'Stands.fxml'.";
		assert language_Menu != null : "fx:id=\"language_Menu\" was not injected: check your FXML file 'Stands.fxml'.";
		assert german_MenuItem != null : "fx:id=\"german_MenuItem\" was not injected: check your FXML file 'Stands.fxml'.";
		assert english_MenuItem != null : "fx:id=\"english_MenuItem\" was not injected: check your FXML file 'Stands.fxml'.";
		assert user_Menu != null : "fx:id=\"user_Menu\" was not injected: check your FXML file 'Stands.fxml'.";
		assert logOut_MenuItem != null : "fx:id=\"logOut_MenuItem\" was not injected: check your FXML file 'Stands.fxml'.";
		assert standTitle_Lable != null : "fx:id=\"standTitle_Lable\" was not injected: check your FXML file 'Stands.fxml'.";
		assert back_Button != null : "fx:id=\"back_Button\" was not injected: check your FXML file 'Stands.fxml'.";
		assert search_Lable != null : "fx:id=\"search_Lable\" was not injected: check your FXML file 'Stands.fxml'.";
		assert editWines_Button != null : "fx:id=\"editWines_Button\" was not injected: check your FXML file 'Stands.fxml'.";
		assert addStand_Button != null : "fx:id=\"addStand_Button\" was not injected: check your FXML file 'Stands.fxml'.";
		assert removeStand_Button != null : "fx:id=\"removeStand_Button\" was not injected: check your FXML file 'Stands.fxml'.";
		assert search_TextField != null : "fx:id=\"search_TextField\" was not injected: check your FXML file 'Stands.fxml'.";
		assert stands_TableView != null : "fx:id=\"stands_TableView\" was not injected: check your FXML file 'Stands.fxml'.";
		assert standNr_TableColumn != null : "fx:id=\"standNr_TableColumn\" was not injected: check your FXML file 'Stands.fxml'.";
		assert standName_TableColumn != null : "fx:id=\"standName_TableColumn\" was not injected: check your FXML file 'Stands.fxml'.";
		assert standLocation_TableColumn != null : "fx:id=\"standLocation_TableColumn\" was not injected: check your FXML file 'Stands.fxml'.";
		assert standOwner_TableColumn != null : "fx:id=\"standOwner_TableColumn\" was not injected: check your FXML file 'Stands.fxml'.";
		standName_TableColumn.setCellValueFactory(cellData -> cellData.getValue().getStandName());
		standNr_TableColumn.setCellValueFactory(cellData -> cellData.getValue().getStandId().asObject());
		standLocation_TableColumn.setCellValueFactory(cellData -> cellData.getValue().getStandLocation());
		standOwner_TableColumn.setCellValueFactory(cellData -> cellData.getValue().getStandOwner());
		editWines_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (stands_TableView.getSelectionModel().getSelectedItem() != null) {
					mainCon.gotoEditWine(stands_TableView.getSelectionModel().getSelectedItem());
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning! No Stand Selected");
					alert.setHeaderText(null);
					alert.setContentText("Please Select a Stand");

					alert.showAndWait();
				}

			}
		});
		addStand_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.gotoAddStand();
			}
		});
		back_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.gotoOptions();
			}
		});
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
				changeLanguage(PropertyResourceBundle.getBundle("Stands", mainCon.language));
			}
		});
		english_MenuItem.addEventHandler(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.language = Locale.UK;
				changeLanguage(PropertyResourceBundle.getBundle("Stands", mainCon.language));
			}
		});

		setUpTable();
		this.removeStand_Button.addEventHandler(ActionEvent.ANY, this.deleteStandHandler);
		this.stands_AnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, this.deleteStandHandler);
	}

	final EventHandler<Event> deleteStandHandler = new EventHandler<Event>() {
		@Override
		public void handle(Event event) {
			if (event.getEventType() != ActionEvent.ANY) {
				if (!((KeyEvent) event).getCode().equals(KeyCode.ENTER)) {
					return;
				}
			}
			if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(removeStand_Button)) {

				if (stands_TableView.getSelectionModel().getSelectedItem() != null) {
					try {
						Stand delStand = stands_TableView.getSelectionModel().getSelectedItem();
						standList.remove(delStand);
						new StandDAO().deleteStand(delStand);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning! No Stand Selected");
					alert.setHeaderText(null);
					alert.setContentText("Please Select a Stand");

					alert.showAndWait();
				}
			}
		}
	};

	private void setUpTable() {
		FilteredList<Stand> filteredData = new FilteredList<>(standList, p -> true);

		search_TextField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(stand -> {
				// If filter text is empty, display all Stands.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (stand.getStandName().get().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches Stand name.
				} else if (stand.getStandLocation().get().contains(lowerCaseFilter)) {
					return true; // Filter matches Stand Location.
				} else if (stand.getStandOwner().get().contains(lowerCaseFilter)) {
					return true; // Filter matches Stand Owner.
				}
				return false; // Does not match.
			});
		});

		SortedList<Stand> sortedStandList = new SortedList<>(filteredData);

		sortedStandList.comparatorProperty().bind(stands_TableView.comparatorProperty());

		stands_TableView.setItems(sortedStandList);
	}

	public void changeLanguage(ResourceBundle resourceBundle) {
		this.settings_Menu
				.setText(StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_settings_Menu));
		this.language_Menu
				.setText(StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_language_Menu));
		this.german_MenuItem.setText(
				StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_german_MenuItem));
		this.english_MenuItem.setText(
				StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_english_MenuItem));
		this.user_Menu.setText(StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_user_Menu)
				+ mainCon.getSession().getCurrentUser().getUsername());
		this.logOut_MenuItem.setText(
				StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_logOut_MenuItem));
		this.standTitle_Lable.setText(
				StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_standTitle_Lable));
		this.back_Button
				.setText(StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_back_Button));
		this.search_Lable
				.setText(StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_search_Lable));
		this.editWines_Button.setText(
				StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_editWines_Button));
		this.addStand_Button.setText(
				StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_addStand_Button));
		this.removeStand_Button.setText(
				StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_removeStand_Button));
		this.search_TextField.setPromptText(
				StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_search_TextField));
		this.standNr_TableColumn.setText(
				StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_standNr_TableColumn));
		this.standName_TableColumn.setText(
				StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_standName_TableColumn));
		this.standLocation_TableColumn.setText(StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_standLocation_TableColumn));
		this.standOwner_TableColumn.setText(
				StandsResourceBundleUtils.getLangString(resourceBundle, StandsResourceKeys.txt_standOwner_TableColumn));
	}

}
