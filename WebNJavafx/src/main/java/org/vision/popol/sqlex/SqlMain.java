package org.vision.popol.sqlex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SqlMain extends Application {

	public static void main(String[] args) {
		launch(); // 조상이 가지고 있는 메소드 (Application)
	}

	@Override // launch()메소드에서 호출 : primaryStage만들어서 전달해줌
	// 프로그래머는 전달받은 스테이지에 장면 셋팅시키는 작업을 하여야 함
	public void start(Stage primaryStage) throws Exception {
		// 주요한 멍석(최상위에 깔려 있는 멍석)
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		// GUI 장면
		Scene scene = new Scene(root); 
		primaryStage.setScene(scene);
		primaryStage.setTitle("질의연습기");
		primaryStage.show(); //gui가 동작
		
	}

}
