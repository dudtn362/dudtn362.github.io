package org.vision.popol.sqlex;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class SqlControll {
	
	@FXML
	private BorderPane rootPane;

    @FXML
    private TableView<?> tableSqlResult;

    @FXML
    private TextArea sqlEditor;

    @FXML
    private Button btnCommit;

    @FXML //이벤트 핸들러 
    void commit(ActionEvent event) throws ClassNotFoundException, SQLException {
    	//질의창의 질의를 수행시켜 그 결과 TableView를 rootPane의 center에 붙이는 작업
    	String sql = sqlEditor.getText();
    	sql = sql.replace(";", "");
    	Connection conn = ConnectionFactory.getConnection();
    	tableSqlResult = TableViewFactory.getTable(sql,conn);
    	rootPane.setCenter(tableSqlResult);
    }

}
