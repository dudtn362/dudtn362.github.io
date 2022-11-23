package org.vision.popol.fxmycar;

import java.awt.Paint;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyFxCar경기장 extends Application {

	MyCar[] raceCars;// Runnable객체들 
	VBox root = new VBox();
	VBox lanes = new VBox();
	HBox menuBox = new HBox();
	Button btnStart = new Button("Start");
	Button btnStop = new Button("Stop");
	Button btnSuspend = new Button("Suspend");
	Button btnResume = new Button("Resume");
	Button btnRank = new Button("Rank");
	TextArea resultArea = new TextArea();
	//Thread backThread;
	public static void main(String[] args) {
		launch(args);
	}

	public void startLine() {
		MyCar.rank = 0;
		raceCars = new MyCar[] { new MyCar("상등신"), new MyCar("뼈다귀"),
				new MyCar("가마솟"), new MyCar("관순누"), new MyCar("병아리"),
				new MyCar("낙숫물"), new MyCar("바가지"), new MyCar("뉴산슬"),
				new MyCar("합정역"), new MyCar("오마이갓") };
		
		lanes.getChildren().clear();
		for (int i = 0; i < raceCars.length; i++) {
			lanes.getChildren().addAll(raceCars[i].lane);
		}
		btnStart.setDisable(false);
		btnStop.setDisable(true);
		btnSuspend.setDisable(false);
		btnResume.setDisable(false);
		btnRank.setDisable(false);
	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		menuBox.setPadding(new Insets(10, 10, 10, 10));
		menuBox.setSpacing(20);
		startLine();
		menuBox.setAlignment(Pos.CENTER);
		menuBox.getChildren().addAll(btnStart, btnStop, btnSuspend, btnResume,
				btnRank);
		root.getChildren().addAll(lanes, menuBox, resultArea);
		Scene scene = new Scene(root, 1100, 600);
		scene.getStylesheets().add(
				getClass().getResource("newFile.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show();
		// ------------------------------------

		btnStart.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						startLine();
						//
						for (int i = 0; i < 10; i++) {
							raceCars[i].start();
						}
						
					}
				});
		btnStop.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {

						for (int i = 0; i < 10; i++) {
							raceCars[i].stop();
						}

					}
				});
		btnSuspend.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {

						for (int i = 0; i < 10; i++) {

							raceCars[i].suspend();
						}

					}
				});
		btnResume.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {

						for (int i = 0; i < 10; i++) {
							raceCars[i].resume();
						}

					}
				});
		btnRank.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {

						for (Integer key : MyCar.rankMap.keySet()) {
							resultArea.appendText(key + "등: "
									+ MyCar.rankMap.get(key) + "\n");
						}

						btnStart.setDisable(false);
						btnStop.setDisable(true);
						btnSuspend.setDisable(true);
						btnResume.setDisable(true);
						btnRank.setDisable(true);
					}
				});
	}

}