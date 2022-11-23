package org.vision.popol.combobox;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
// 컨트롤러가 초기화 될 때 준비해야할 작업이 있다면
// Initializable을 구현해야 합니다.
public class Controll implements Initializable{

    @FXML
    private ComboBox<String> comboDan;

    @FXML
    private TextArea textArea;

    @FXML
    void dispGugudan(ActionEvent event) {
    	String x = comboDan.getSelectionModel().getSelectedItem();
    	System.out.println(x+"를(을) 불렀니?");
    	int dan = Integer.parseInt(x.substring(0,1));
    	textArea.setText(null);
    	for(int i=1;i<=9;i++) {
    		textArea.appendText(dan+"*"+i+"="+(dan*i)+"\n");
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 컨트롤들의 초기화 작업
		comboDan.getItems().addAll("5단","6단","7단","8단","9단");
	}

}
