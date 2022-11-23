package org.vision.popol.fxcalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CalcControll {

    @FXML
    private TextField txtCalc1;

    @FXML
    private TextField txtCalc2;

    @FXML
    private Button btndispPlus;

    @FXML
    private Button btndispSubtract;

    @FXML
    private Button btndispMultiply;

    @FXML
    private Button btndispDivide;

    @FXML
    private TextArea textArea;

    @FXML
    private Label labelAnswer;

    @FXML
    private Label labelName;

    @FXML
    void displayDivide(ActionEvent event) {
    	try {
			double A = Double.parseDouble(txtCalc1.getText());
			double B = Double.parseDouble(txtCalc2.getText());
			String result = String.format("%.2f",(A/B));
			textArea.appendText(A+"÷"+B+"="+result+"\n");
		} catch (NumberFormatException e) {
			textArea.appendText("변수를 입력해주세요!\n");
		}
    }

    @FXML
    void displayMultiply(ActionEvent event) {
    	try {
			double A = Double.parseDouble(txtCalc1.getText());
			double B = Double.parseDouble(txtCalc2.getText());
			String result = String.format("%.2f",(A*B));
			textArea.appendText(A+"X"+B+"="+result+"\n");
		} catch (NumberFormatException e) {
			textArea.appendText("변수를 입력해주세요!\n");
		}
    }

    @FXML
    void displayPlus(ActionEvent event) {
    	try {
			double A = Double.parseDouble(txtCalc1.getText());
			double B = Double.parseDouble(txtCalc2.getText());
			String result = String.format("%.2f",(A+B));
			textArea.appendText(A+"+"+B+"="+result+"\n");
		} catch (NumberFormatException e) {
			textArea.appendText("변수를 입력해주세요!\n");
		}
    }

    @FXML
    void displaySubtract(ActionEvent event) {
    	try {
			double A = Double.parseDouble(txtCalc1.getText());
			double B = Double.parseDouble(txtCalc2.getText());	
			String result = String.format("%.2f",(A-B));
			textArea.appendText( A+"-"+B+"="+result+"\n");
		} catch (NumberFormatException e) {
			textArea.appendText("변수를 입력해주세요!\n");
		}
    }

}
