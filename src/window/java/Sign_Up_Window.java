/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window.java;


import java.time.LocalDate;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage; 


/**
 *
 * @author Rohan
 */


/*class User{
    //all the fields
    private String userId, password, firstName, lastName , middleName, gender;
    private String occupation, country, email, mobileNo, nationality , resAddress;
    
    //Setter methods for all the fields
    public void setUserId(String userId)
    {
        this.userId=userId;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }
    public void setMiddleName(String middleName)
    {
        this.middleName=middleName;
    }
    public void setMobileNo(String mobileNo)
    {
        this.mobileNo=mobileNo;
    }
    public void setOccupation(String occupation)
    {
        this.occupation=occupation;
    }
    public void setNationality(String nationality)
    {
        this.nationality=nationality;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public void setResAddress(String resAddress)
    {
        this.resAddress=resAddress;
    }
    public void setCountry(String country)
    {
        this.country=country;
    }
    */
    //NOtE: date setter() and date field not added yet
    /*
    public void setDob(String dob)
    {
        this.dob=dob;
    }
    */
    /*
    //getter functions 
    public String getUserId()
    {
         return userId;
    }
    public String getPassword()
    {
        return password;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getMiddleName()
    {
        return middleName;
    }
    public String getMobileNo()
    {
        return mobileNo;
    }
    public String getOccupation()
    {
        return occupation;
    }
    public String getNationality()
    {
        return nationality;
    }
    public String getEmail()
    {
        return email;
    }
    public String getResAddress()
    {
        return resAddress;
    }
    public String getCountry()
    {
        return country;
    }
    
} */

public class Sign_Up_Window extends Application{
    
    public TextField user_id_tf,mobile_no_tf,f_name_tf,m_name_tf,l_name_tf,email_tf;
    public TextField flat_tf,street_tf,area_tf,pin_tf;
    public PasswordField passwd_pf,confirm_passwd_pf;
    public RadioButton male_rbtn,female_rbtn,transgender_rbtn;
    public ToggleGroup gender_tg;
    public DatePicker dob_dp;
    public ComboBox occ_cb,country_cb,nationality_cb,city_cb;
    //private User u = new User();
    
    @Override
    public void start(Stage sign_up_page) {
    
    sign_up_page.setTitle("Sign Up");
    //sign_up_page.setFullScreen(true); 

            
    //GridPane Layout 
    GridPane sign_up_pane = new GridPane();
             
    //
    sign_up_pane.setId("sign-up");
    
    //making gridlines visible
    //sign_up_pane.setGridLinesVisible(true); 
                
    //
    sign_up_pane.setAlignment(Pos.CENTER_LEFT);          
            
    //scenetitle
    Label sign_up_scene_title = new Label();
    sign_up_scene_title.setText("Individual Registration"); 
    sign_up_pane.add(sign_up_scene_title,0,0,4,2);
    
    //css effects for label
    sign_up_scene_title.setId("text");
    
     
       
    //setting gaps between rows and columns of grid 
    sign_up_pane.setHgap(10);
    sign_up_pane.setVgap(10);
        
    //padding of gridpane in scene
    sign_up_pane.setPadding(new Insets(50,50,50,50));
            
    //
    sign_up_pane.centerShapeProperty();
            
    //rectangle as background for acc_details label
    Rectangle acc_detail_text_bg = new Rectangle();
    //acc_detail_text_bg.setFill(Color.LIGHTBLUE);
    
    acc_detail_text_bg.getStyleClass().add("my-label_bg");
    sign_up_pane.add(acc_detail_text_bg,0,4,4,1);
    acc_detail_text_bg.setWidth(Screen.getPrimary().getVisualBounds().getWidth()); //setting the width of rectangle   
    acc_detail_text_bg.setHeight(20);
    
    Label acc_details_lbl = new Label("Account Details");
    sign_up_pane.add(acc_details_lbl,0,4,2,1);

    
    //
    Text user_id = new Text("User Id :");
    sign_up_pane.add(user_id,0,6);
    //css effects same as that for text on 1st page 
    user_id.setId("sign-up");  
    
    //
    user_id_tf = new TextField();
    user_id_tf.setPromptText("Enter your user id");
    sign_up_pane.add(user_id_tf,1,6,3,1);
    user_id_tf.setId("required");  
    //
    Label user_id_alert = new Label("Between 3 to 10 characters.Only letter, number and underscores are allowed");
    sign_up_pane.add(user_id_alert,1,7,5,1);
            
    //
    Text passwd_txt = new Text("New Password :");
    sign_up_pane.add(passwd_txt,0,9);
    
    //css effects same as that for text on 1st page 
    passwd_txt.setId("sign-up");
             
    //
    passwd_pf = new PasswordField();
    passwd_pf.setPromptText("Enter Password");
    sign_up_pane.add(passwd_pf,1,9,3,1);
    //new_passwd_pf.setDisable(true);
    
        
    //
    Label passwd_alert = new Label();
    passwd_alert.setText("Password should contain alphabets,numbers and special characters(@,#,$) and"
            + " should be atleast 8 characters long");
    sign_up_pane.add(passwd_alert,1,10,7,1);
    
    //
    Text confirm_passwd_txt = new Text("Confirm Password :");
    sign_up_pane.add(confirm_passwd_txt,0,12);
    
    //css effects same as that for text on 1st page 
    confirm_passwd_txt.setId("sign-up");
             
    //
    confirm_passwd_pf = new PasswordField();
    confirm_passwd_pf.setPromptText("Confirm Password");
    sign_up_pane.add(confirm_passwd_pf,1,12,3,1);
    
    //rectangle as background for acc_details label
    Rectangle per_detail_txt_bg = new Rectangle();
    //per_detail_txt_bg.setFill(Color.LIGHTBLUE);
    
    per_detail_txt_bg.getStyleClass().add("my-label_bg");
    sign_up_pane.add(per_detail_txt_bg,0,14,4,1);
    per_detail_txt_bg.setWidth(Screen.getPrimary().getVisualBounds().getWidth()); //setting the width of rectangle   
    per_detail_txt_bg.setHeight(20);
    
    //
    Label personal_details_lbl = new Label("Personal Details");
    sign_up_pane.add(personal_details_lbl,0,14,2,1);
    
    //
    Text f_name_txt = new Text("First Name :");
    sign_up_pane.add(f_name_txt,0,16);
    
    //
    f_name_tf = new TextField();
    f_name_tf.setPromptText("Enter first name");
    sign_up_pane.add(f_name_tf,1,16,3,1);
    
    //
    Text m_name_txt = new Text("Middle Name :");
    sign_up_pane.add(m_name_txt,0,18);
    
    //
    m_name_tf = new TextField();
    m_name_tf.setPromptText("Enter middle name");
    sign_up_pane.add(m_name_tf,1,18,3,1);
    
    //
    Text l_name_txt = new Text("Last Name :");
    sign_up_pane.add(l_name_txt,0,20);
    
    //
    l_name_tf = new TextField();
    l_name_tf.setPromptText("Enter last name");
    sign_up_pane.add(l_name_tf,1,20,3,1);
    
    //
    Text gender_txt = new Text("Gender :");
    sign_up_pane.add(gender_txt,0,22);
    
    //RadioButton for male,female,transgender
    male_rbtn = new RadioButton("Male");
    sign_up_pane.add(male_rbtn,1,22);
    
    female_rbtn = new RadioButton("Female");
    sign_up_pane.add(female_rbtn,2,22);
    
    transgender_rbtn = new RadioButton("Transgender");
    sign_up_pane.add(transgender_rbtn,3,22);
    
    //Toggling Gender RadioButtons
    gender_tg = new ToggleGroup();
    male_rbtn.setToggleGroup(gender_tg);
    female_rbtn.setToggleGroup(gender_tg);
    transgender_rbtn.setToggleGroup(gender_tg);
    
    //
    Text dob_txt = new Text("Date of Birth :");
    sign_up_pane.add(dob_txt,0,24);
    
    //
    dob_dp = new DatePicker();
    dob_dp.setPromptText("Date of Birth"); 
    sign_up_pane.add(dob_dp,1,24,3,1);
    dob_dp.setEditable(false); 
    
    dob_dp.setDayCellFactory(picker -> new DateCell(){
        @Override
        public void updateItem(LocalDate date, boolean empty){
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                //dates disabled beyond current date
                setDisable(empty || date.compareTo(today)>0);
            }
    }); 
    //
    Text occupation_txt = new Text("Occupation :"); 
    sign_up_pane.add(occupation_txt,0,26);
    
    //
    occ_cb = new ComboBox();
    occ_cb.setPromptText("----select occupation----");
    occ_cb.getItems().addAll("Government","Public","Private","Professional","SelfEmployed","Student","Others"); 
    sign_up_pane.add(occ_cb,1,26,3,1);
    
    //
    Text country_txt = new Text("Country :");
    sign_up_pane.add(country_txt,0,28);
    
    //
    country_cb = new ComboBox();
    country_cb.setPromptText("----select country----");
    country_cb.getItems().addAll("India","Antarcta","Australia","Brazil"); 
    sign_up_pane.add(country_cb,1,28,3,1);
    
    //
    Label star = new Label("*");
    star.setId("i");
    star.applyCss();
    //
    Text email_txt = new Text("Email ");
    email_txt.setText(email_txt.getText().concat(star.getText()+" :")); 
    sign_up_pane.add(email_txt,0,30);
    
    
    //
    email_tf = new TextField();
    email_tf.setPromptText("Enter email id");
    sign_up_pane.add(email_tf,1,30,3,1);
    
    //
    Text mobile_no_txt = new Text("Mobile no. :");
    sign_up_pane.add(mobile_no_txt,0,32);
    
    //
    mobile_no_tf = new TextField();
    mobile_no_tf.setPromptText("Enter mobile no.");
    sign_up_pane.add(mobile_no_tf,1,32,3,1);
    
    //
    Text nationality_txt = new Text("Nationality :");
    sign_up_pane.add(nationality_txt,0,34);
    
    //
    nationality_cb = new ComboBox();
    nationality_cb.setPromptText("----select nationality----");
    nationality_cb.getItems().addAll("India","Antarctica","Australia","Brazil"); 
    sign_up_pane.add(nationality_cb,1,34,3,1);
    
    //rectangle as background for acc_details label
    Rectangle res_add_txt_bg = new Rectangle();
    //res_add_txt_bg.setFill(Color.LIGHTBLUE);
    
    res_add_txt_bg.getStyleClass().add("my-label_bg");
    sign_up_pane.add(res_add_txt_bg,0,36,4,1);
    res_add_txt_bg.setWidth(Screen.getPrimary().getVisualBounds().getWidth()); //setting the width of rectangle   
    res_add_txt_bg.setHeight(20);
    
    //Residential address label
    Label res_add_lbl = new Label("Residential Address");
    sign_up_pane.add(res_add_lbl,0,36,3,1);
    
    //flat/door/block no text
    Text flat_txt = new Text("Flat/Door/Block :");
    sign_up_pane.add(flat_txt,0,38);
    
    //
    flat_tf = new TextField();
    flat_tf.setPromptText("flat/door/block");
    sign_up_pane.add(flat_tf,1,38,3,1);
    
    //street/lane text
    Text street_txt = new Text("Street/Lane :");
    sign_up_pane.add(street_txt,0,40);
    
    //
    street_tf = new TextField();
    street_tf.setPromptText("street/lane");
    sign_up_pane.add(street_tf,1,40,3,1);
    
    //area/locality text
    Text area_txt = new Text("Area/Locality :");
    sign_up_pane.add(area_txt,0,42);
    
    //
    area_tf = new TextField();
    area_tf.setPromptText("area/locality");
    sign_up_pane.add(area_tf,1,42,3,1);
    
    //pincode text
    Text pin_txt = new Text("Pincode :");
    sign_up_pane.add(pin_txt,0,44);
    
    //
    pin_tf = new TextField();
    pin_tf.setPromptText("enter pincode");
    sign_up_pane.add(pin_tf,1,44,3,1);
    
    //city/town
    Text city_txt = new Text("City/Town :");
    sign_up_pane.add(city_txt,0,46);
    
    //
    city_cb = new ComboBox();
    city_cb.setPromptText("----select city/town----");
    city_cb.getItems().addAll("Mumbai","New Delhi","Bengaluru","Chennai");
    sign_up_pane.add(city_cb,1,46,3,1);
    
    //getValue of selected RadioButton
    /*gender_tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                @Override
                public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1)
                {
                    RadioButton chk = (RadioButton)t1.getToggleGroup().getSelectedToggle();
                    System.out.println(chk.getText());
                }
            });*/
    
    //
    Button submit_btn = new Button("Submit Registration");
    sign_up_pane.add(submit_btn,0,50);
    submit_btn.setOnAction(new EventHandler<ActionEvent>(){
        
        private boolean allFilled(TextField... textFields)
        {
            for(TextField textField : textFields)
            {
                if(textField.getText().trim().isEmpty())
                {
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public void handle(ActionEvent e)
        {
            
            if(allFilled())
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Incomplete Details"); 
                alert.setContentText("Please fill all mandatory details");
                alert.show();
            }
            else if(gender_tg.getSelectedToggle()==null || dob_dp.getValue()==null || occ_cb.getValue()==null || country_cb.getValue()==null 
                    || city_cb.getValue()==null || nationality_cb.getValue()==null)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Incomplete Details"); 
                alert.setContentText("Please fill all mandatory details");
                alert.show();
            }
            else if(!(user_id_tf.getText().length()>2 && user_id_tf.getText().length()<11 && Pattern.matches("[a-zA-Z0-9_]+", user_id_tf.getText())))
            {
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Re-Enter User-Id"); 
                warning.setContentText("User Id should contain 3 to 10 characters and only letter, number and underscores are allowed");
                warning.show();
            }
            else if(passwd_pf.getText().length()<8 && confirm_passwd_pf.getText().length()<8)
            {
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Re-enter Password"); 
                warning.setContentText("Length of Password should be atleast 8 characters long");
                warning.show();
            }
            else if(!confirm_passwd_pf.getText().equals(passwd_pf.getText()))
            {
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Re-enter Password"); 
                warning.setContentText("Passwords don't match");
                warning.show();
            }   
            else if(!(Pattern.matches("[a-zA-Z0-9@#$]+", passwd_pf.getText())))
            {
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Re-enter Password"); 
                warning.setContentText("Password should contain only alphabets,numbers and"
                        + " special characters(@,#,$)");
                warning.show();
            }
            else if(!(Pattern.matches("[a-zA-Z]+", f_name_tf.getText()) && Pattern.matches("[a-zA-Z]+", m_name_tf.getText())
                    && Pattern.matches("[a-zA-Z]+", l_name_tf.getText())))
            {
                Alert warning = new Alert(Alert.AlertType.WARNING,"Re-Enter Name");
                warning.setTitle("Re-enter Name"); 
                warning.setContentText("Name field should contain only characters");
                warning.show();
            }
            /*else if(!(email_tf.getText().length()>2 && user_id_tf.getText().length()<11 && Pattern.matches("[a-zA-Z0-9_]+", user_id_tf.getText())))
            {
                Alert warning = new Alert(Alert.AlertType.WARNING,"Re-Enter User-Id");
                warning.setContentText("User Id should contain 3 to 10 characters and only letter, number and underscores are allowed");
                warning.show();
            }*/
            else if(!(mobile_no_tf.getText().length()==10) || Pattern.matches("[0-9]",mobile_no_tf.getText()))
            {
                Alert error =  new Alert(Alert.AlertType.ERROR);
                error.setTitle("Invalid mobile number"); 
                error.setContentText("Invalid mobile number");
                error.show();
            }
            else if(!(pin_tf.getText().length()==6) || Pattern.matches("[0-9]",pin_tf.getText()))
            {
                Alert error =  new Alert(Alert.AlertType.ERROR);
                error.setTitle("Invalid Pincode"); 
                error.setContentText("Invalid Pincode");
                error.show();
            }
            
            else 
            {
                Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION,"Confirmation",ButtonType.YES,ButtonType.NO);
                confirmation.setTitle("Confirmation"); 
                confirmation.setContentText("Confirm Register ?"); 
                confirmation.show();
  
                confirmation.setOnCloseRequest(new EventHandler<DialogEvent>(){
                    @Override
                    public void handle(DialogEvent event) {
                        if(confirmation.getResult()==ButtonType.YES)
                        {   
                            /*Label registered = new Label("Registered Successfully"); 
                            registered.setId("register"); 
                            sign_up_pane.add(registered,0,53,1,2);*/
                            
                            //return all field values to database
                            
                            // sud = new SignUpData();
                            //System.out.println("User ID:"+getFormDetails().getUserId());
                            //System.out.println("Mobile no received is:"+sud.return_mob_no());
                            /*DriverClass dc = new DriverClass();
                            if(dc.getStatus()==-1)
                            {
                                Alert mob_no_exist = new Alert(Alert.AlertType.ERROR);
                                mob_no_exist.setTitle("Error"); 
                                mob_no_exist.setContentText("Mobile number already exists\n"
                                        + "Please add a new number");
                            }
                            if(dc.getStatus==1)*/
                            
                            
                            sign_up_page.close();
                            Alert registered = new Alert(Alert.AlertType.INFORMATION);
                            registered.setTitle("Registered Successfully");
                            registered.setContentText("Thankyou for Registration"); 
                            registered.show();
                            
                      
                        }
                        /*else if(confirmation.getResult()==ButtonType.NO)
                        {
                            passwd_pf.setText("");    
                            confirm_passwd_pf.setText(""); 
                        }*/ 
                    }       
                }); 
                }
               
            }

    });
    
    /*//clear all fields
    Button reset_btn = new Button("Reset");
    sign_up_pane.add(reset_btn,1,50);
    
    reset_btn.setOnAction(new EventHandler<ActionEvent>() {
        
        private void allFilled(TextField... textFields)
        {
            for(TextField textField : textFields)
            {
                textField.clear(); 
            }
        }
        @Override
        public void handle(ActionEvent e) {
            allFilled();
        }
    });*/
    
    //exit forgot password page
    Button exit_btn = new Button("Exit");
    sign_up_pane.add(exit_btn, 1, 50);
    exit_btn.setOnAction(e -> {
        sign_up_page.close();
    });
    
    //
    
    
    //
    ScrollPane rootPane = new ScrollPane();
    rootPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    rootPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); 
    rootPane.setFitToHeight(true);
    rootPane.setFitToWidth(true); 
    rootPane.setContent(sign_up_pane);   
    
    //
    Scene sign_up_scene = new Scene(rootPane,1000,600);
            
    sign_up_scene.getStylesheets().add(Sign_Up_Window.class.getResource("Sign_Up.css").toExternalForm());
    sign_up_page.setScene(sign_up_scene);
    
    //setting primaryStage to the size of screen of pc
    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    //MinX and MinY are upper left corner of primaryStage
    sign_up_page.setX(primaryScreenBounds.getMinX());
    sign_up_page.setY(primaryScreenBounds.getMinY());
    //setting width of stage to width of screen
    sign_up_page.setWidth(primaryScreenBounds.getWidth());
    //setting height of stage to height of screen
    sign_up_page.setHeight(primaryScreenBounds.getHeight());
        
    sign_up_page.show();
    }
    
    /*public User getFormDetails()
    {
        u.setUserId(user_id_tf.getText());
        return  u;
    }*/
}

