/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window.java;

import driver.DriverClass;
import driver.DriverFlight;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene; 
import javafx.scene.control.Alert;
import javafx.scene.control.Button; 
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Rohan
 */

public class Window extends Application {
    
    //Decalration of fields
    public RadioButton one_trip_btn,round_trip_btn;
    public ToggleGroup trip_tg;
    public ComboBox from_city_list,to_city_list,class_list;
    public DatePicker depart_date,return_date;
    public Spinner<Integer> adult_no,child_no,infant_no;
    public Button search_btn, sign_in_btn, sign_up_btn, sign_out_btn;
    public Scene scene;
    public Image logo;
    public GridPane page_1;
    public Label hello_user_lbl;
    private DriverFlight df = new DriverFlight();
    private Traveller t = new Traveller();
    private Flights fs = new Flights();
    private User u =new User();
    private AllDetails ad = new AllDetails();
    
    @Override
    public void start(Stage primaryStage) {
        
        
        DriverClass dc = new DriverClass();
        
        Login_scene ls = new Login_scene();
        
        //setting full screen 
        //primaryStage.setFullScreen(true); 
        
        //Setting gridPane as layout for the page
        page_1 = new GridPane();
        
        //making gridlines visible
        //page_1.setGridLinesVisible(true);
        
        //css effects for page_1 i.e. gridpane
        page_1.setId("page");
       
        //setting gaps between rows and columns of grid 
        page_1.setHgap(10);
        page_1.setVgap(10);
        
        //padding of gridpane in scene
        page_1.setPadding(new Insets(50,50,50,50));
        
        //Logo Image
        logo = new Image(Window.class.getResourceAsStream("air-logo.png")); 
        ImageView logo_view = new ImageView(logo);
        
        //adding logo image to gridpane
        page_1.add(logo_view,0,0);
        
        //setting size of image logo
        logo_view.setFitHeight(150);
        logo_view.setFitWidth(200);
        
        
        //scenetitle
        Label scenetitle = new Label("Welcome To AeroSwing Flights...");
       
        //adding css effects to label welcome-label
        scenetitle.setId("welcome-label");
        page_1.add(scenetitle, 1,0,4,2);
        
        //Radio Buttons 
        one_trip_btn = new RadioButton("One Way Trip");
        round_trip_btn = new RadioButton("Round Trip");
        
        //ToggleGroup to select any one option for RadioButtons
        trip_tg = new ToggleGroup();
        one_trip_btn.setToggleGroup(trip_tg);
        round_trip_btn.setToggleGroup(trip_tg);
        
        //Setting Title for radioButtons
        Text select_trip_text = new Text("Select Your Trip");
        select_trip_text.setId("text");
        
        //adding trip text and radio buttons to page
        page_1.add(select_trip_text, 0,3,2,1);
        page_1.add(one_trip_btn,0,4);
        page_1.add(round_trip_btn,0,5);
        
        //Journeydetails-text
        Text jour_detail_text = new Text("Enter Your Journey Details");
        jour_detail_text.setId("text");
        page_1.add(jour_detail_text,0,7,2,1);
        
        //Text for From:
        Text from_state_text = new Text("Journey From :");
        page_1.add(from_state_text,0,9);
        
        //ComboBox for Source States
        from_city_list = new ComboBox();
        from_city_list.getItems().addAll("Mumbai","New Delhi","Bengaluru","Chennai");
        from_city_list.setPromptText("---------select city---------");
        from_city_list.setMaxSize(300,50);
        page_1.add(from_city_list,1,9);
 
        
        //css effects for combobox from_state_list
        from_city_list.setId("combobox");
        
        //departure date
        depart_date = new DatePicker();
        depart_date.setPromptText("Departure Date");        
        depart_date.setEditable(false); 
        page_1.add(depart_date,2,9);
        
        //return date
        return_date = new DatePicker();
        return_date.setPromptText("Return Date");
        return_date.setEditable(false);
        page_1.add(return_date,2,11);
        
        //disabling dates before toady's date and dates after 1 year  
        depart_date.setDayCellFactory(picker -> new DateCell(){
            @Override
            public void updateItem(LocalDate date, boolean empty){
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                if(return_date.getValue()==null)
                    setDisable(empty || date.compareTo(today)<0 || date.isAfter(today.plusYears(1)));   
                else if(return_date.getValue()!=null)
                    setDisable(empty || date.compareTo(return_date.getValue())>0 || date.compareTo(today)<0 || date.isAfter(return_date.getValue().plusYears(1)));
            }
        });
    
        //text for To:
        Text to_state_text = new Text("To Destination:");
        page_1.add(to_state_text,0,11);
 
        //ComboBox for Destination Cities
        to_city_list = new ComboBox();
        to_city_list.getItems().addAll("Mumbai","New Delhi","Bengaluru","Chennai");
        to_city_list.setPromptText("---------select city---------");
        to_city_list.setMaxSize(300,50);
        page_1.add(to_city_list,1,11);
        
        //css effects for comobox to_state_list
        to_city_list.setId("combobox");

        
        //disabling dates before departure date and dates after 1 year  
        return_date.setDayCellFactory(picker -> new DateCell(){
            @Override
            public void updateItem(LocalDate date, boolean empty){
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                if(depart_date.getValue()!=null)
                    setDisable(empty || date.compareTo(depart_date.getValue())<0 || date.isAfter(depart_date.getValue().plusYears(1)));
                else if(depart_date.getValue()==null)
                    setDisable(empty || date.compareTo(today)<0 || date.isAfter(today.plusYears(1)));
            }
        });
        
        //enabling return date if only round trip is selected
        return_date.setDisable(true); 
 
        //if one way trip selected then disabling return date
        one_trip_btn.setOnAction(e -> {
            return_date.setDisable(true); 
        });
        
        //if round trip selected then enabling return date
        round_trip_btn.setOnAction(e -> {
            
            return_date.setDisable(false); 
        });   
        
        //Text for Class
        Text select_class = new Text("Select Class :");
        page_1.add(select_class,0,14);
        
        //ComboBox for selecting Class
        class_list = new ComboBox();
        class_list.getItems().addAll("Economy","Business","First");
        class_list.setMaxSize(300,50);
        page_1.add(class_list,1,14,1,1);
        
        //css effects for comobox class_list
        class_list.setId("combobox");
        
        class_list.setPromptText("--------select class--------"); 
//        class_list.setMinSize(to_city_list.getWidth(),to_city_list.getHeight());
        
        //Text for travellers
        Text travellers_txt = new Text("Traveller(s) :");
        travellers_txt.setId("text");
        page_1.add(travellers_txt,0,15,2,1);
        
        //css effects for comobox travellers
        //travellers_txt.setId("combobox");
        
        //
        Text adult_txt = new Text("Adult(above 15 yrs) :");
        page_1.add(adult_txt,0,16);
        
        adult_no = new Spinner<>();
        //value_factory for adult i.e. setting range of values for no. of adults
        adult_no.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,4,0));
        page_1.add(adult_no, 0, 17);
        
        Text child_txt = new Text("Child(2-15 yrs) :");
        page_1.add(child_txt,1,16);
        
        child_no = new Spinner<>();
        //value_factory for child i.e. setting range of values for no. of child
        child_no.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,4,0));
        page_1.add(child_no, 1, 17);
        
        Text infant_txt = new Text("Infant(Under 2 yrs) :");
        page_1.add(infant_txt,2,16);
        
        infant_no = new Spinner<>();
        //value_factory for infant i.e. setting range of values for no. of infants
        infant_no.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,4,0));
        page_1.add(infant_no, 2, 17);

            
        //signIn button actionevent
        sign_in_btn = new Button("Sign in");
        page_1.add(sign_in_btn, 0,26);
        
        sign_in_btn.setOnAction(e ->{
            
            Stage loginStage = new Stage();
            ls.start(loginStage);
            //primaryStage.close();
            //SignIn button of login scene 
            ls.signin_btn.setOnAction(f -> {
              
                if(ls.username_tf.getText().isEmpty() || ls.passwd_pf.getText().isEmpty())
                {
                    Alert warning = new Alert(Alert.AlertType.WARNING);
                    warning.setTitle("Warning"); 
                    warning.setContentText("Both fields are mandatory"); 
                    warning.show();
                }
                else{
                    try {
                        u.setUserId(ls.username_tf.getText());
                        u.setPassword(ls.passwd_pf.getText());
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
                                
                                primaryStage.show();
                                page_1.setVisible(true);
                                sign_in_btn.setVisible(false);
                                sign_in_btn.setDisable(true);
                                sign_out_btn.setVisible(true);
                                sign_out_btn.setDisable(false);
                                hello_user_lbl.setText("Hello "+dc.getUserData().getFirstName()+"!");
                                hello_user_lbl.setVisible(true);
                                hello_user_lbl.setDisable(false);
                                
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
                
            });
        });
        
        //
        RadioButton trip = (RadioButton)trip_tg.getSelectedToggle();
        sign_up_btn = new Button("Sign up");
        page_1.add(sign_up_btn, 2, 26);
        GridPane.setHalignment(sign_up_btn, HPos.RIGHT); 
        
        //signUp btn actionEvent
        sign_up_btn.setOnAction(e->{
           Stage sign_up_page = new Stage();
           Sign_Up_Window spw = new Sign_Up_Window();
           spw.start(sign_up_page); 
        });
    
        
        search_btn = new Button("Search");
        search_btn.setMaxSize(250, 50);
        page_1.add(search_btn,1,23,2,1); 
        
        //search button ActionEvent
        search_btn.setOnAction(e->{
            
            if(trip_tg.getSelectedToggle()==null || from_city_list.getValue()==null || to_city_list.getValue()==null || class_list.getValue()==null)
            {System.out.println("toogle");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Incomplete Details"); 
                alert.setContentText("Please fill all the required  Fields");
                alert.show();
            }
            else if(adult_no.getValue()==0 && child_no.getValue()==0 && infant_no.getValue()==0)
            {System.out.println("no. of trav");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Incomplete Details"); 
                alert.setContentText("Please fill all the required Fields");
                alert.show();
            }
            else if(((RadioButton)trip_tg.getSelectedToggle()).getText().equals("One Way Trip") && depart_date.getValue()==null) 
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Incomplete Details"); 
                alert.setContentText("Please fill all the required Fields");
                alert.show();
            }
            else if(((RadioButton)trip_tg.getSelectedToggle()).getText().equals("Round Trip") && (depart_date.getValue()==null || return_date.getValue()==null))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Incomplete Details"); 
                alert.setContentText("Please fill all the required Fields");
                alert.show();
            }
            else if(from_city_list.getValue().equals(to_city_list.getValue()))
            {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error"); 
                error.setContentText("Choose a different Source or Destination");
                error.show();
            }
            else
            {
                fs.trip = getFlightDetails().getTrip();
                fs.src = getFlightDetails().getFromCity();
                fs.dest = getFlightDetails().getToCity();
                fs.adults = getFlightDetails().getAdults();
                fs.childs = getFlightDetails().getChilds();
                fs.infants = getFlightDetails().getInfants();
                fs.depart_date = getFlightDetails().getDepartDate();
                fs.return_date = getFlightDetails().getReturnDate();
                df.setTravellerData(getFlightDetails());
                
                try {
                    fs.setFlightData(df.getFlightRecords());
                } catch (SQLException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                }                
                
                if(((RadioButton)trip_tg.getSelectedToggle()).getText().equals("Round Trip"))
                {
                    try {
                        fs.setRoundFlightData(df.getRoundFlightRecord());
                    } catch (SQLException ex) {
                        Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                Stage flightSearchStage = new Stage();
                try {
                    fs.start(flightSearchStage);
                } catch (ParseException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        sign_out_btn = new Button("Sign Out");
        //sign_out btn actionEvent
        sign_out_btn.setOnAction(e->{
            
            hello_user_lbl.setVisible(false); 
            sign_out_btn.setVisible(false);
            sign_out_btn.setDisable(true);
            sign_in_btn.setDisable(false); 
            sign_in_btn.setVisible(true); 
            
        });
        
        page_1.add(sign_out_btn, 0, 26);
        sign_out_btn.setVisible(false); 
        sign_out_btn.setDisable(true); 
        
        hello_user_lbl = new Label();
        hello_user_lbl.setStyle("-fx-font-size: 25px; -fx-text-fill: green");
        page_1.add(hello_user_lbl, 0, 27);
        hello_user_lbl.setVisible(false); 
        hello_user_lbl.setDisable(true); 

        
        ScrollPane rootPane = new ScrollPane();
        rootPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        rootPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); 
        rootPane.setFitToHeight(true);
        rootPane.setFitToWidth(true); 
        //rootPane.setVmax(2);
        //rootPane.setHmax(2);
        //rootPane.setVvalue(20);
        rootPane.setContent(page_1);  
       
        
        //instantiating scene
        scene = new Scene(rootPane, 1000, 600);
        
        scene.getStylesheets().add(Window.class.getResource("Window.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("AeroSwing National Flights");
        //primaryStage.setResizable(false);  
        
        //setting primaryStage to the size of screen of pc
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
          //MinX and MinY are upper left corner of primaryStage
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
          //setting width of stage to width of screen
        primaryStage.setWidth(primaryScreenBounds.getWidth());
          //setting height of stage to height of screen
        primaryStage.setHeight(primaryScreenBounds.getHeight());
        
        //primaryStage.initStyle(StageStyle.TRANSPARENT); 
        
        //show Stage
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public Traveller getFlightDetails()
    {
        
        RadioButton trip = (RadioButton)trip_tg.getSelectedToggle();
        t.setTrip(trip.getText());
    
        t.setFromCity(from_city_list.getValue().toString());
    
        t.setToCity(to_city_list.getValue().toString());
    
        t.setClassType(class_list.getValue().toString());

        t.setDepartDate(depart_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    
        if(((RadioButton)trip_tg.getSelectedToggle()).getText().equals("Round Trip")) 
        {
            t.setReturnDate(return_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        
        t.setAdults(adult_no.getValue().toString());
    
        t.setChilds(child_no.getValue().toString());
    
        t.setInfants(infant_no.getValue().toString());
        
        return t;
    }
}
