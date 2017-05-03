package application2;
	
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/*
 * Opprett JavaFX GUI program. Bruk FXMLLoader for å laste inn FXML
 * som beskriver GUI.
 */

public class Application2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
	       
		Scene scene = new Scene(root, 800, 600);
	    
		primaryStage.setTitle("FXML eksempel, med grafikk");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
