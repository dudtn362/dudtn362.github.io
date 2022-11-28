package org.vision.popol.homework;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.vision.popol.fxhomebook.ConnectionFactory;
import org.vision.popol.fxhomebook.Homebook;
import org.vision.popol.fxhomebook.HomebookDao;
import org.vision.popol.fxhomebook.TableViewFactory;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Controll implements Initializable {

	@FXML
	private BorderPane borderPane;

	@FXML
	private TableView<Map<String,String>> tableView;

	@FXML
	private TextField txtSerialno;

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtPassword;

	@FXML
	private TextField txtGender;

	@FXML
	private TextField txtTel;

	@FXML
	private TextField txtEmail;

	@FXML
	private Button btnInsert;

	@FXML
	private Button btnUpdate;

	@FXML
	private Button btnDelete;

	@FXML
	private Button btnFind;

	@FXML
	private Button btnSelectAll;

	@FXML
	void onInsert(ActionEvent event) throws SQLException,ClassNotFoundException  {
		// 자료 입력 부분
		// dao를 사용할 수 있게 준비작업을 먼저
		MemberDao dao = new MemberDao();
		Member vo = new Member();
		vo.setSerialno(Long.parseLong(txtSerialno.getText()));
		vo.setName(txtName.getText());
		vo.setId(txtId.getText());
		vo.setPwd(txtPassword.getText());
		vo.setGender(txtGender.getText());
		vo.setTel(txtTel.getText());
		vo.setEmail(txtEmail.getText());
		try {
			dao.insert(ConnectionFactory.getConnection(), vo);
			refreshTableview();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@FXML
	void onUpdate(ActionEvent event) {
		// TODO - 입력 텍스트필드들의 정보로 Homebook vo를 만든 다음 dao의 update()메소드를 호출하고
		// 화면을 갱신한다.
		Member vo = new Member();
		vo.setSerialno(Long.parseLong(txtSerialno.getText()));
		vo.setName(txtName.getText());
		vo.setId(txtId.getText());
		vo.setPwd(txtPassword.getText());
		vo.setGender(txtGender.getText());
		vo.setTel(txtTel.getText());
		vo.setEmail(txtEmail.getText());
		MemberDao dao = new MemberDao();
		try {
			dao.update(ConnectionFactory.getConnection(), vo);
			refreshTableview();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	void onDelete(ActionEvent event) {
		// TODO - 선택한 행을 인지하고 그 행의 시리얼번호를 읽어 DAO의 delete메소드를 호출하고
		// 반영된 내용을 화면에 출력한다. //소프트웨어개발격언 - divide & conquer !
		// int selectRow = tableView.getSelectionModel().getSelectedIndex();
		Map<String, String> map =  tableView.getSelectionModel().getSelectedItem();
		System.out.println(map);
		MemberDao dao = new MemberDao();
		try {
			// db삭제 삭제작업
			dao.delete(ConnectionFactory.getConnection(), Long.parseLong(map.get("SERIALNO")));
			refreshTableview();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	void onFind(ActionEvent event) {
		String condition = JOptionPane.showInputDialog("WHERE 포함한 조건");
		MemberDao dao = new MemberDao();
    	try {  		
    		List<Member> data = dao.selectByCondition(ConnectionFactory.getConnection(),condition);
			//tableView = TableViewFactory.getTable("SELECT * FROM MEMBER ",ConnectionFactory.getConnection());		
    		tableView.getItems().clear();
    		for(Member x:data) {
				Map<String,String> rowMap = new HashMap<>();
				rowMap.put("SERIALNO",x.getSerialno()+"");
//				rowMap.put("SERIALNO",x.GET);
//				rowMap.put("SERIALNO",x.getSerialno()+"");
				rowMap.put("NAME",x.getName()+"");
				rowMap.put("ID",x.getId()+"");
				rowMap.put("PASSWORD",x.getPwd()+"");
				rowMap.put("GENDER",x.getGender()+"");
				rowMap.put("TEL",x.getTel()+"");
				rowMap.put("EMAIL",x.getEmail()+"");
				System.out.println(rowMap);
    			tableView.getItems().add(rowMap);
    		
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	void onSelectAll(ActionEvent event) {
		refreshTableview();
	}
	public void refreshTableview() {
		try {
			tableView = TableViewFactory.getTable("SELECT * FROM MEMBER", ConnectionFactory.getConnection());
			// 이벤트 처리 기능을 새로이 생성될때 마다 부
			tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
				@Override
				public void changed(ObservableValue observable, Object oldValue, Object newValue) {
					// TODO 현재 선택된 행의 정보를 텍스트필드들에게 뿌려줌
					Map<String, String> rowData = (Map<String, String>) tableView.getSelectionModel().getSelectedItem();
					txtSerialno.setText(rowData.get("SERIALNO"));
					txtName.setText(rowData.get("NAME"));
					txtId.setText(rowData.get("ID"));
					txtPassword.setText(rowData.get("PASSWORD"));
					txtGender.setText(rowData.get("GENDER"));
					txtTel.setText(rowData.get("TEL"));
					txtEmail.setText(rowData.get("EMAIL"));
				}
			});
			borderPane.setCenter(tableView);
			// 집계 작업
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		refreshTableview();
	}
}
