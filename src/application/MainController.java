package application;
import  javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



public class MainController extends Router  implements Initializable {
	
 
    @FXML
    private TextField txtMember;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtAge;

    @FXML
    private Button BtnAdd;

    @FXML
    private TableView<Person> table;

    @FXML
    private TableColumn<Person, String> vorname;

    @FXML
    private TableColumn<Person, String> name;

    @FXML
    private TableColumn<Person, String> alt;

    @FXML
    private TableColumn<Person, String> addresse;

    @FXML
    private TableColumn<Person, String> email;

    @FXML
    private TableColumn<Person, String> telefon;
    
    @FXML
    private Button Mitarbeiter;
    
    @FXML
	  private Button loginBtn;
    @FXML
    private TextField txtemail;

    @FXML
    private TextField txttelefon;
  
    @FXML
    private TextField txtname;

    @FXML
    private Button sc;
    
    @FXML
    private Button edit;
    
  
    int index;
    Connection connection =null;
	Statement stmt = null;

		 void table() throws SQLException {
			Connection connection = SqlConnection.conn();
	    	stmt = connection.createStatement();
    		ResultSet ergebnis = stmt.executeQuery("select * from info");
    		ObservableList<Person> Oblist = FXCollections.observableArrayList();
    		 
    		 while (ergebnis.next())
 	        {
 	            Person p = new Person();
 	            p.setVorname(ergebnis.getString("vorname"));
 	            p.setName(ergebnis.getString("name"));
 	            p.setEmail(ergebnis.getString("email"));
 	            p.setAlt(ergebnis.getString("alt"));
 	            p.setAddresse(ergebnis.getString("addresse"));
 	            p.setTelefon(ergebnis.getString("telefon"));
 	            Oblist.add(p);
 	       }
    		
    		 table.setItems(Oblist);
    		 vorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
    		 name.setCellValueFactory(new PropertyValueFactory<>("name"));
    		 alt.setCellValueFactory(new PropertyValueFactory<>("alt"));
    		 addresse.setCellValueFactory(new PropertyValueFactory<>("addresse"));
    		 email.setCellValueFactory(new PropertyValueFactory<>("email"));
    		 telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
		 }
		 @FXML
		 public void home() {

			 toScene(loginBtn,"resources/Home.fxml");
			 }
		 
		 @FXML
		 void addPerson() {
		
			 toScene(sc,"resources/AddUser.fxml");
		 }
		 
		@FXML
		void onEditChanged(TableColumn.CellEditEvent<Person,String> e){
			Person p = table.getSelectionModel().getSelectedItem();
			
			p.setTelefon(e.getNewValue());
			
		}
		
	    @FXML
	    void getSelected (MouseEvent event){
	    index =table.getSelectionModel().getSelectedIndex();
	   txtMember.setText(vorname.getCellData(index).toString());
	    }
	    
	    @FXML
	    void edit() throws SQLException {
	    	
	    	toScene(edit,"resources/EditUser.fxml");
	    	
	    }
	    
	    @FXML
	    void delete() {
	    	 try {
	    		Connection connection = SqlConnection.conn();
	    		PreparedStatement pst;
	             pst = connection.prepareStatement("delete from info where vorname=?");
	             pst.setString(1, txtMember.getText());
	             pst.execute();
	             JOptionPane.showMessageDialog(null, "Delete");
	             table();
	         
	         } catch (Exception e) {
	             JOptionPane.showMessageDialog(null, e);
	         }
	    	
	    }
	   
		    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			table();
			table.setEditable(true);
			vorname.setCellFactory(TextFieldTableCell.forTableColumn());
			name.setCellFactory(TextFieldTableCell.forTableColumn());
			email.setCellFactory(TextFieldTableCell.forTableColumn());
			alt.setCellFactory(TextFieldTableCell.forTableColumn());
			telefon.setCellFactory(TextFieldTableCell.forTableColumn());
			addresse.setCellFactory(TextFieldTableCell.forTableColumn());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
      
	  
	
}
