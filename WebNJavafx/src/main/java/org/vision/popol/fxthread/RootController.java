package org.vision.popol.fxthread;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RootController implements Initializable {
	@FXML
	private Label lblTime;
	@FXML
	private Button btnStart;
	@FXML
	private Button btnStop;
	boolean isStop;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 디자인시 이벤트 처리 명기않고 컨트롤러에서 처리하는 방법
		btnStart.setOnAction(event -> handleBtnStart(event));
		btnStop.setOnAction(event -> handleBtnStop(event));
	}
	public void handleBtnStart(ActionEvent e) {
		isStop = false;// 중요
		Thread clock = new Thread() {
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				while (!isStop) {
					String strTime = sdf.format(new Date());
					Platform.runLater(() -> {
						//////////////////////////
						lblTime.setText(strTime);
						//////////////////////////
					});

					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		clock.setDaemon(true);// main 쓰레드와 생명주기를 맞춘다. 
		clock.start();
	}

	public void handleBtnStop(ActionEvent e) {
		isStop = true;
	}

}
