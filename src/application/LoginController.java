package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class LoginController {
	@FXML
	private TextField username;
	
    @FXML
    private TextField email;

    @FXML
    private TextField password;
    
	 @FXML
	  private Button loginBtn;
	 @FXML
	  private Button Rbtn;
	 @FXML
	    private Button RBtn;
	 @FXML
	    private Button Mitarbeiter;
	 
	 public final String HOME="resources/Home.fxml";
	 public final String MITARBEITER="resources/Mitarbeiter.fxml";
	 public final String REGISTRATION="resources/Register.fxml";
	 public final String ADD="resources/AddUser.fxml";
	 public final String LOGIN="resources/Login.fxml";
	 
	    
	@FXML
	void login() throws SQLException {
		String sql="select email,password from users where email=? and password=?";
		try(Connection conn= SqlConnection.conn();
			PreparedStatement pst= conn.prepareStatement(sql)) {
			pst.setString(1,email.getText());
			pst.setString(2,password.getText());
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Sie haben Erfolreich eigngeloggt ");
				System.out.println(rs);
				mainScene();}
			else {
				
				JOptionPane.showMessageDialog(null, "entweder Ihre email oder Ihre Passwort ist Falsch");
			}
		}
		
		
	}
	@FXML
	public void register() throws SQLException {
		String sql ="insert into users(username,email,password) values(?,?,?)";
		try(Connection connection =SqlConnection.conn();
			PreparedStatement pst= connection.prepareStatement(sql)) {
			pst.setString(1,username.getText());
			pst.setString(2,email.getText());
			pst.setString(3,password.getText());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Sie haben Erfolreich ein neues Account erstellt!!! ");
			loginForm();
		}
		
	}
	
	 
	 public void SceneControl(Button b,String str) {
			
				
				Stage primaryStage = null;
				primaryStage =(Stage) b.getScene().getWindow();
				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource(str));
				    primaryStage.setScene(new Scene(root));
			        primaryStage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
	 @FXML
	 public void mainScene() {
		
		 SceneControl(loginBtn,HOME);
		 }
	 
	 @FXML
	 public void mitarbeiter() {
			
				
		 SceneControl(Mitarbeiter,MITARBEITER);
		 
		 }
		 
	 
	 @FXML
	 public void registerForm() {
			
		 SceneControl(Rbtn,REGISTRATION);
		 }
	 
	 @FXML
	 public void loginForm() {
			
	
		 SceneControl(RBtn,LOGIN);
		 }

}
