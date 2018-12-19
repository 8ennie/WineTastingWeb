package application.controller;

import java.net.URL;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import application.localisation.OptionResourceBundleUtils;
import application.localisation.OptionResourceBundleUtils.OptionResourceKeys;
import application.localisation.SearchResourceBundleUtils;
import application.localisation.SearchResourceBundleUtils.SearchResourceKeys;
import application.model.data.SearchStatus;
import application.model.data.Wine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class SearchController implements Initializable {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="search_AnchorPane"
	private AnchorPane search_AnchorPane; // Value injected by FXMLLoader

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

	@FXML // fx:id="searchTitle_Lable"
	private Label searchTitle_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="back_Button"
	private Button back_Button; // Value injected by FXMLLoader

	@FXML // fx:id="result_TableView"
	private TableView<Wine> result_TableView; // Value injected by FXMLLoader

	@FXML // fx:id="standNr_TableColumn"
	private TableColumn<Wine, Integer> standNr_TableColumn; // Value injected by FXMLLoader

	@FXML // fx:id="standName_TableColumn"
	private TableColumn<Wine, String> standName_TableColumn; // Value injected by FXMLLoader

	@FXML // fx:id="standLocation_TableColumn"
	private TableColumn<Wine, String> standLocation_TableColumn; // Value injected by FXMLLoader

	@FXML // fx:id="standOwner_TableColumn"
	private TableColumn<Wine, String> standOwner_TableColumn; // Value injected by FXMLLoader

	@FXML // fx:id="wineName_TableColumn"
	private TableColumn<Wine, String> wineName_TableColumn; // Value injected by FXMLLoader

	@FXML // fx:id="search_Lable"
	private Label search_Lable; // Value injected by FXMLLoader

	@FXML // fx:id="search_TextField"
	private TextField search_TextField; // Value injected by FXMLLoader

	@FXML // fx:id="chooseStand_Button"
	private Button chooseStand_Button; // Value injected by FXMLLoader

	@FXML // fx:id="editStand_Button"
	private Button editStand_Button; // Value injected by FXMLLoader

	@FXML // fx:id="search_ImageView"
	private ImageView search_ImageView; // Value injected by FXMLLoader

	private MainController mainCon;

	private SearchStatus searchStatus;

	private ObservableList<Wine> wineList = FXCollections.observableArrayList();

	public SearchController(MainController mainController) {
		this.mainCon = mainController;
		this.wineList = mainCon.getSession().getWineList();
	}

	public SearchController(MainController mainController, SearchStatus searchStatus) {
		this.mainCon = mainController;
		this.wineList = mainCon.getSession().getWineList();
		this.searchStatus = searchStatus;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert search_AnchorPane != null : "fx:id=\"search_AnchorPane\" was not injected: check your FXML file 'Search.fxml'.";
		assert options_MenuBar != null : "fx:id=\"options_MenuBar\" was not injected: check your FXML file 'Search.fxml'.";
		assert settings_Menu != null : "fx:id=\"settings_Menu\" was not injected: check your FXML file 'Search.fxml'.";
		assert language_Menu != null : "fx:id=\"language_Menu\" was not injected: check your FXML file 'Search.fxml'.";
		assert german_MenuItem != null : "fx:id=\"german_MenuItem\" was not injected: check your FXML file 'Search.fxml'.";
		assert english_MenuItem != null : "fx:id=\"english_MenuItem\" was not injected: check your FXML file 'Search.fxml'.";
		assert user_Menu != null : "fx:id=\"user_Menu\" was not injected: check your FXML file 'Search.fxml'.";
		assert logOut_MenuItem != null : "fx:id=\"logOut_MenuItem\" was not injected: check your FXML file 'Search.fxml'.";
		assert search_ImageView != null : "fx:id=\"search_ImageView\" was not injected: check your FXML file 'Search.fxml'.";
		assert searchTitle_Lable != null : "fx:id=\"searchTitle_Lable\" was not injected: check your FXML file 'Search.fxml'.";
		assert back_Button != null : "fx:id=\"back_Button\" was not injected: check your FXML file 'Search.fxml'.";
		assert result_TableView != null : "fx:id=\"result_TableView\" was not injected: check your FXML file 'Search.fxml'.";
		assert standNr_TableColumn != null : "fx:id=\"standNr_TableColumn\" was not injected: check your FXML file 'Search.fxml'.";
		assert standName_TableColumn != null : "fx:id=\"standName_TableColumn\" was not injected: check your FXML file 'Search.fxml'.";
		assert standLocation_TableColumn != null : "fx:id=\"standLocation_TableColumn\" was not injected: check your FXML file 'Search.fxml'.";
		assert standOwner_TableColumn != null : "fx:id=\"standOwner_TableColumn\" was not injected: check your FXML file 'Search.fxml'.";
		assert wineName_TableColumn != null : "fx:id=\"wineName_TableColumn\" was not injected: check your FXML file 'Search.fxml'.";
		assert search_Lable != null : "fx:id=\"search_Lable\" was not injected: check your FXML file 'Search.fxml'.";
		assert search_TextField != null : "fx:id=\"search_TextField\" was not injected: check your FXML file 'Search.fxml'.";
		assert chooseStand_Button != null : "fx:id=\"chooseStand_Button\" was not injected: check your FXML file 'Search.fxml'.";
		assert editStand_Button != null : "fx:id=\"editStand_Button\" was not injected: check your FXML file 'Search.fxml'.";

		standName_TableColumn.setCellValueFactory(cellData -> cellData.getValue().getStand().get().getStandName());
		standNr_TableColumn
				.setCellValueFactory(cellData -> cellData.getValue().getStand().get().getStandId().asObject());
		standLocation_TableColumn
				.setCellValueFactory(cellData -> cellData.getValue().getStand().get().getStandLocation());
		standOwner_TableColumn.setCellValueFactory(cellData -> cellData.getValue().getStand().get().getStandOwner());
		wineName_TableColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
		
		FilteredList<Wine> filteredData = new FilteredList<>(wineList, p -> true);

		search_TextField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(wine -> {
				// If filter text is empty, display all Wines.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (wine.getStand().get().getStandName().get().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches Stand name.
				} else if (wine.getName().get().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches Wine name.
				} else if (wine.getStand().get().getStandLocation().get().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches Stand location.
				}
				return false; // Does not match.
			});
		});

		SortedList<Wine> sortedWineList = new SortedList<>(filteredData);

		sortedWineList.comparatorProperty().bind(result_TableView.comparatorProperty());

		result_TableView.setItems(sortedWineList);

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
				changeLanguage(PropertyResourceBundle.getBundle("Search",mainCon.language));
			}
		});
		english_MenuItem.addEventHandler(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.language = Locale.UK;
				changeLanguage(PropertyResourceBundle.getBundle("Search",mainCon.language));
			}
		});
		back_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.gotoOptions();
			}
		});

		editStand_Button.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainCon.gotoStands();
			}
		});

		search_AnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, chooseStandHandler);
		chooseStand_Button.addEventHandler(ActionEvent.ANY, chooseStandHandler);

		search_ImageView.setImage(new Image("/pictures/search.png"));
	}

	final EventHandler<Event> chooseStandHandler = new EventHandler<Event>() {
		@Override
		public void handle(Event event) {
			if (event.getEventType() != ActionEvent.ANY) {
				if (!((KeyEvent) event).getCode().equals(KeyCode.ENTER)) {
					return;
				}
			}

			if (mainCon.getStage().getScene().focusOwnerProperty().get().equals(chooseStand_Button)
					&& !result_TableView.getSelectionModel().isEmpty()) {
				if (searchStatus.equals(SearchStatus.Evaluation)) {
					mainCon.gotoEvaluation(result_TableView.getSelectionModel().getSelectedItem());
				} else if (searchStatus.equals(SearchStatus.ViewEvaluation)) {
					mainCon.gotoViewEvaluation(result_TableView.getSelectionModel().getSelectedItem());
				}

			}
		}
	};

	public void changeLanguage(ResourceBundle resourceBundle) {
		this.settings_Menu
				.setText(SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_settings_Menu));
		this.language_Menu
				.setText(SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_language_Menu));
		this.german_MenuItem.setText(
				SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_german_MenuItem));
		this.english_MenuItem.setText(
				SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_english_MenuItem));
		this.user_Menu
				.setText(SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_user_Menu)+ mainCon.getSession().getCurrentUser().getUsername());
		this.logOut_MenuItem.setText(
				SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_logOut_MenuItem));
		this.searchTitle_Lable.setText(
				SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_searchTitle_Lable));
		this.back_Button
				.setText(SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_back_Button));
		this.standNr_TableColumn.setText(
				SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_standNr_TableColumn));
		this.standName_TableColumn.setText(
				SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_standName_TableColumn));
		this.standLocation_TableColumn.setText(SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_standLocation_TableColumn));
		this.standOwner_TableColumn.setText(
				SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_standOwner_TableColumn));
		this.wineName_TableColumn.setText(
				SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_wineName_TableColumn));
		this.search_Lable
				.setText(SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_search_Lable));
		this.search_TextField.setPromptText(
				SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_search_TextField));
		this.chooseStand_Button.setText(
				SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_chooseStand_Button));
		this.editStand_Button.setText(
				SearchResourceBundleUtils.getLangString(resourceBundle, SearchResourceKeys.txt_editStand_Button));

	}

}
