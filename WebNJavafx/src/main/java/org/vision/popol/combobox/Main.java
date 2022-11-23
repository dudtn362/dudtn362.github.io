package org.vision.popol.combobox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
// mvc(model view controll) 패턴 ==> 파이썬 장고 (mvt(model viewer template)패턴)
public class Main extends Application {

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("콤보박스연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
