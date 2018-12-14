/**
 * 
 */
package application.controller;

import application.model.data.SearchStatus;
import application.model.data.SessionInfos;
import application.model.data.Stand;
import application.model.data.Wine;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author student
 *
 */
public class MainController {

	private Stage stage;
	private SessionInfos session;

	public MainController(Stage stage) {
		this.stage = stage;
	}

	public void gotoLogin() {
		try {
			this.replaceSceneContent("/application/view/Login.fxml", new LoginController(this));

		} catch (Exception ex) {
			System.out.println("Login: " + ex.getMessage());
		}
	}

	public void gotoAddStand() {
		try {
			this.replaceSceneContent("/application/view/AddStand.fxml", new AddStandController(this));

		} catch (Exception ex) {
			System.out.println("AddStand: " + ex.getMessage());
		}
	}
	
	public void gotoEvaluation(Wine wine) {
		try {
			this.replaceSceneContent("/application/view/Evaluate.fxml", new EvaluationController(this,wine));

		} catch (Exception ex) {
			System.out.println("Evaluate: " + ex.getMessage());
		}
	}
	
	public void gotoRegister() {
		try {
			this.replaceSceneContent("/application/view/Register.fxml", new RegisterController(this));

		} catch (Exception ex) {
			System.out.println("Register: " + ex.getMessage());
		}
	}
	
	public void gotoSearch(SearchStatus searchStatus) {
		try {
			this.replaceSceneContent("/application/view/Search.fxml", new SearchController(this,searchStatus));

		} catch (Exception ex) {
			System.out.println("Search: " + ex.getMessage());
		}
	}
	
	public void gotoStands() {
		try {
			this.replaceSceneContent("/application/view/Stands.fxml", new StandsController(this));

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Stands: " + ex.getMessage());
		}
	}
	
	public void gotoViewEvaluation(Wine wine) {
		try {
			this.replaceSceneContent("/application/view/ViewEvaluation.fxml", new ViewEvaluationController(this,wine));

		} catch (Exception ex) {
			System.out.println("ViewEvaluation: " + ex.getMessage());
		}
	}
	
	public void gotoEditWine(Stand stand) {
		try {
			this.replaceSceneContent("/application/view/EditWine.fxml", new EditWineController(this, stand));

		} catch (Exception ex) {
			System.out.println("EditWine: " + ex.getMessage());
		}
	}
	
	public void gotoOptions() {
		try {
			this.replaceSceneContent("/application/view/Options.fxml", new OptionsController(this));

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Options: " + ex.getMessage());
		}
	}

	private void replaceSceneContent(String fxmlPath, Initializable controller) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(fxmlPath));
		loader.setController(controller);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		// Show the GUI
		stage.show();
	}

	public void gotoNextScene(String fxmlPath, Initializable controller) {
		try {
			this.replaceSceneContent(fxmlPath, controller);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void logOut() {
		// TODO Auto-generated method stub
		gotoLogin();
	}

	/**
	 * @return the session
	 */
	public SessionInfos getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(SessionInfos session) {
		this.session = session;
	}

	public Stage getStage() {
		return stage;
	}
}
