package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public abstract class Router {

	 public void toScene(Button Btn, String str) {
			
			
			Stage primaryStage = null;
			primaryStage =(Stage) Btn.getScene().getWindow();
			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource(str));
			    primaryStage.setScene(new Scene(root));
		        primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
}
