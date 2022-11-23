package org.vision.popol.fxhello;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GugudanControll {

    @FXML
    private TextField txtDan;

    @FXML
    private Button btnDispGugudan;

    @FXML
    private TextArea textArea;

    @FXML
    void displayGugudan(ActionEvent event) {
    	// TODO ~ 구구단을 출력하는 소스 
    	int 단 = Integer.parseInt(txtDan.getText());
    	for(int i=1;i<=9;i++) {
    		textArea.appendText(단+"*"+i+" = "+(단*i)+"\n");
    		
    	}
    	
    }

}
