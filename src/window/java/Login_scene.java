/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window.java;

import driver.DriverClass;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Rohan
 */
public class Login_scene extends Application{
        
    public GridPane sign_in_pane;
    public Scene login_scene;
    public StackPane stackpane;
    public Button signup_btn,signin_btn,close_btn;
    public TextField username_tf;
    public PasswordField passwd_pf;
    
    private User u =new User();
    private DriverClass dc = new DriverClass();
    
    private Forgot_Password fp = new Forgot_Password();
    @Override
    public void start(Stage loginStage)
    {
        //Window class Object
        Window w = new Window();
        
        stackpane = new StackPane();
        login_scene = new Scene(stackpane, 1000, 600);
        sign_in_pane = new GridPane();
        
        //setting gaps between rows and columns of grid 
        sign_in_pane.setHgap(10);
        sign_in_pane.setVgap(10);
        sign_in_pane.setStyle("-fx-background-color: rgba(0,0,0,0.9);-fx-background-radius: 10;-fx-opacity: 0.9"); 
        sign_in_pane.setMaxHeight(Screen.getPrimary().getVisualBounds().getHeight());
        sign_in_pane.setMaxWidth(Screen.getPrimary().getVisualBounds().getWidth());
        //padding of gridpane in scene
        sign_in_pane.setPadding(new Insets(50,50,50,50));
        sign_in_pane.setAlignment(Pos.CENTER); 
        //
        //sign_in_pane.setGridLinesVisible(true); 
        
        Text login_txt = new Text("Login");
        sign_in_pane.add(login_txt, 0, 0); 
        login_txt.setId("text");
        login_txt.setStyle("-fx-underline: true; -fx-fill: white;"); 
        //
        Image logo = new Image(Window.class.getResourceAsStream("air-logo.png"));
        ImageView logo_img_view = new ImageView(logo);
        
        //adding logo image to sign_in_pane
        sign_in_pane.add(logo_img_view,2,3,3,3);
        
        //setting size of image logo
        logo_img_view.setFitHeight(150);
        logo_img_view.setFitWidth(200);
        GridPane.setHalignment(logo_img_view, HPos.CENTER); 
        
        //Text for account details 
        Text account_txt = new Text("Enter Your Account Details");
        account_txt.setStyle("-fx-fill: white;-fx-font-size: 40px;-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 )"); 
        sign_in_pane.add(account_txt,2,7,3,1);
        
        //
        Text username_txt = new Text("Username :");
        sign_in_pane.add(username_txt, 2, 10, 2, 1); 
        username_txt.setId("text"); 
        username_txt.setStyle("-fx-fill: white"); 
        //
        username_tf = new TextField();
        username_tf.setPromptText("Enter Username"); 
        username_tf.setPrefHeight(30);
        sign_in_pane.add(username_tf,4, 10, 2, 1);
        
        //T
        Text passwd_txt = new Text("Password :");
        sign_in_pane.add(passwd_txt,2,12,2,1);      
        passwd_txt.setId("text"); 
        passwd_txt.setStyle("-fx-fill: white"); 
        //
        passwd_pf = new PasswordField();
        passwd_pf.setPromptText("Enter Password");
        passwd_pf.setPrefHeight(30);
        sign_in_pane.add(passwd_pf,4,12,2,1);
        
        //
        signin_btn = new Button("Sign in");
        signin_btn.setMaxWidth(350); 
        GridPane.setHalignment(signin_btn, HPos.CENTER); 
        sign_in_pane.add(signin_btn, 4, 17, 2, 2); 
        
        /*//SignIn button of login scene 
            signin_btn.setOnAction(f -> {
              
                if(username_tf.getText().isEmpty() || passwd_pf.getText().isEmpty())
                {
                    Alert warning = new Alert(Alert.AlertType.WARNING);
                    warning.setTitle("Warning"); 
                    warning.setContentText("Both fields are mandatory"); 
                    warning.show();
                }
                else{
                    try {
                        u.setUserId(username_tf.getText());
                        u.setPassword(passwd_pf.getText());
                        dc.setUserData(u);
                        int flag=dc.checkCredentials();
                        switch (flag) {
                            case 0:
                                {
                                    Alert warning = new Alert(Alert.AlertType.WARNING);
                                    warning.setTitle("Warning");
                                    warning.setContentText("Username or Password is Incorrect");
                                    warning.show();
                                    break;
                                }
                            case -1:
                                {
                                    Alert warning = new Alert(Alert.AlertType.WARNING);
                                    warning.setTitle("Warning");
                                    warning.setContentText("Account does not exists");
                                    warning.show();
                                    break;
                                }
                            case 1:
                            {
                                Stage primaryStage = new Stage();
                                w.start(primaryStage);
                                w.page_1.setVisible(true);
                                w.sign_in_btn.setVisible(false);
                                w.sign_in_btn.setDisable(true);
                                w.sign_out_btn.setVisible(true);
                                w.sign_out_btn.setDisable(false);
                                w.hello_user_lbl.setText("Hello "+dc.getUserData().getFirstName()+"!");
                                w.hello_user_lbl.setVisible(true);
                                w.hello_user_lbl.setDisable(false);
                                
                                loginStage.close();
                                break;  
                            }
                            default:
                                break;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            });*/
        
        //forgot_password? 
        Hyperlink forgot_pw = new Hyperlink("(forgot password ?)");
        sign_in_pane.add(forgot_pw,6,22,3,1);
        GridPane.setHalignment(forgot_pw, HPos.RIGHT); 
        forgot_pw.setId("forgot-pw");
        
        //forgotpassword actionEvent
        forgot_pw.setOnAction(new EventHandler<ActionEvent>(){
 
            @Override
            public void handle(ActionEvent e)
            {       
                Stage new_passwd_page = new Stage();
                Forgot_Password fp = new Forgot_Password();
                fp.start(new_passwd_page); 
                fp.exit_btn.setOnMousePressed(m->{
                
                    if(!username_tf.getText().isEmpty())
                        username_tf.clear();
                    if(!passwd_pf.getText().isEmpty())
                        passwd_pf.clear();
                });
                fp.change_pw_btn.setOnMousePressed(m->{
                    
                    if(!username_tf.getText().isEmpty())
                        username_tf.clear();
                    if(!passwd_pf.getText().isEmpty())
                        passwd_pf.clear();
                });
            }      
        }); 
        
        //
        signup_btn = new Button("Sign Up");
        signup_btn.setMaxWidth(150); 
        GridPane.setHalignment(signup_btn, HPos.CENTER);
        sign_in_pane.add(signup_btn, 2, 22, 2, 1);
        
        //SignUp button ActionEvent
        signup_btn.setOnAction(e->{
           Stage sign_up_page = new Stage();
           Sign_Up_Window spw = new Sign_Up_Window();
           spw.start(sign_up_page); 
            spw.exit_btn.setOnMousePressed(m->{
                
                if(!username_tf.getText().isEmpty())
                    username_tf.clear();
                if(!passwd_pf.getText().isEmpty())
                    passwd_pf.clear();
            });
            spw.submit_btn.setOnMousePressed(m->{
                
                if(!username_tf.getText().isEmpty())
                    username_tf.clear();
                if(!passwd_pf.getText().isEmpty())
                    passwd_pf.clear();
                
            });
            
        });
        
        close_btn = new Button("Close");
        close_btn.setMaxWidth(150);
        GridPane.setHalignment(close_btn, HPos.RIGHT);
        sign_in_pane.add(close_btn, 8, 0);
        
        //Close button ActionEvent
        close_btn.setOnAction((ActionEvent e) -> {
            
            loginStage.close();
            
        });
        
        //background for login scene
        Image bg = new Image(Window.class.getResourceAsStream("plane.jpg")); 
        ImageView bg_view = new ImageView(bg);
        stackpane.getChildren().addAll(bg_view,sign_in_pane);
             
        username_tf.clear();
        passwd_pf.clear();
        //
        login_scene.getStylesheets().add(Window.class.getResource("LoginScene.css").toExternalForm());
        loginStage.setScene(login_scene);
        
        //setting primaryStage to the size of screen of pc
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        //MinX and MinY are upper left corner of primaryStage
        loginStage.setX(primaryScreenBounds.getMinX());
        loginStage.setY(primaryScreenBounds.getMinY());
        //setting width of stage to width of screen
        loginStage.setWidth(primaryScreenBounds.getWidth());
        //setting height of stage to height of screen
        loginStage.setHeight(primaryScreenBounds.getHeight());
        
        loginStage.show();
        
    }
    
    public static void main(String args[])
    {
        launch(args);
    }
}
