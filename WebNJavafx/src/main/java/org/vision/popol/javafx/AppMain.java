package org.vision.popol.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 주요한 멍석(최상위에 깔려 있는 멍석)
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		// GUI 장면
		Scene scene = new Scene(root); 
		primaryStage.setScene(scene);
		primaryStage.setTitle("내가 처음 만드는 GUI프로그램");
		primaryStage.show();
	}

}
