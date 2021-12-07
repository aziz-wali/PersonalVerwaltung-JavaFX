package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneController {
	 @FXML
	 private Button start;
	 private Stage primaryStage;
	 	@FXML
	    private TextField txtMember;

	    @FXML
	    private TextField txtAddress;

	    @FXML
	    private TextField txtAge;

	    @FXML
	    private Button BtnAdd;
	    @FXML
	    private TextField txtemail;

	    @FXML
	    private TextField txttelefon;
	  
	    @FXML
	    private TextField txtname;
	
	    @FXML
	    void Add() throws SQLException {
	    
			
			 String sql="insert into info(vorname,name,email,alt,addresse,telefon)values(?,?,?,?,?,?)";
			
			try(Connection connection = SqlConnection.conn();
					PreparedStatement pst = connection.prepareStatement(sql)) {
				
				  pst.setString(1,txtMember.getText());
				  pst.setString(2,txtname.getText());
				  pst.setString(3,txtemail.getText());
				  pst.setString(4,txtAge.getText());
				  pst.setString(5,txtAddress.getText());
				  pst.setString(6,txttelefon.getText());
				  //pst.setString(4,tel.getText());
				  pst.execute();
			      JOptionPane.showMessageDialog(null, "Users Add succes");
			}
			
	    }
	 
	    @FXML
	    void toscene1() {
    	
	    	Parent root;
			primaryStage =(Stage) start.getScene().getWindow();
			try {
				root = FXMLLoader.load(getClass().getResource("resources/Mitarbeiter.fxml"));
				 primaryStage.setScene(new Scene(root, 1000, 400));
			        primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
       
}
