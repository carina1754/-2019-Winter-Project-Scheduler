package application;
 
import java.io.IOException;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
 
public class MainController {
 
    @FXML
    private Label Login;
    
    @FXML
    private TextField txtUserName;
    
    @FXML
    private TextField txtPassword;
    
    @FXML
    private Button login;
    
    @FXML
    private Button join;
    
    public void Login(ActionEvent event) throws Exception{
        if(txtUserName.getText().equals("name") && txtPassword.getText().equals("pass")){
            Login.setText("Login Success");
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/application/january.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            Stage main = (Stage) Login.getScene().getWindow();
            main.close();
        }else{
            Login.setText("Login Failed");
        }
    }
    
    public void JoinPop(ActionEvent event) {
   	 Parent root;
   	try {
   		root = FXMLLoader.load(getClass().getResource("/application/join.fxml"));
   	    Scene scene = new Scene(root);
   	    Stage stage = new Stage();
   	    stage.setScene(scene);
   	    stage.show();
   	    

   	
   	
   	} catch (IOException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	} 

   	}
    
}