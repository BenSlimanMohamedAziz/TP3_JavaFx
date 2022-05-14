package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddBookControlor implements Initializable {
	 @FXML
	 private TextField tfLastName;
	 @FXML
	 private TextField tfFirstName;
	 @FXML
	 private TextField tfEmail;
	 @FXML
	 private Button addBtn;
	 @FXML
	 private Button exportBtn;
	 @FXML
	 private Button importBtn;
	 @FXML
	 private Button removeBtn;
	 @FXML
	 private Button quitBtn;
	 @FXML
	 private TableView<Person> table;
	 @FXML
	 private TableColumn<Person, String> emailCol;
	 @FXML
	 private TableColumn<Person, String> firstNameCol;
	 @FXML
	 private TableColumn<Person, String> lastNameCol;
	 private DataClass data;
	//A Completer
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.data= new DataClass();
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		emailCol.setCellValueFactory(new PropertyValueFactory<>("mail"));
				
	}
	@FXML
	protected void handleExitButtonAction(ActionEvent event)
	{ 
	 Platform.exit();
	}
	@FXML
	protected void handleImportbuttonAction(ActionEvent event) {
		table.getItems().addAll(data.getImportList());
		/*System.out.println(table.getItems());*/
	}
	
	@FXML
	public void add(ActionEvent event){
		Person p=new Person(tfLastName.getText(),tfFirstName.getText(),tfEmail.getText());
		data.getImportList().add(p);
		}
	
	@FXML
	public void supprimer(ActionEvent event){
		table.getItems().remove(table.getSelectionModel().getSelectedItem());
		
		}
	
	@FXML
	public void exporter(ActionEvent event){
		data.setExportList(table.getItems());
		}
	}
