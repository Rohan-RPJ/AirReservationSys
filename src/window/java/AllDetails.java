/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window.java;

import driver.DriverClass;
import driver.DriverFlight;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Rohan
 */
public class AllDetails extends Application{
    
    public Integer fare;
    public String trip, src, dest, depart_date, return_date, adults, childs, infants, flightNo1, flightNo2, 
            depart_time1, arrive_time1, depart_time2, arrive_time2, fare1, fare2;    
    public TextField f_m_name[], l_name[], f_name_tf, l_name_tf, email_tf, 
            add_tf, pin_tf, country_tf, mob_no_tf;
    public Button next_btn, back_btn, book_btn;
    public Scene allDetailsScene;
    public int i, j;
    public GridPane details_gp, travInfo_gp, preview_gp;
    public BorderPane borderPane;
    public ScrollPane rootPane1, rootPane2, rootPane3;
    public Alert confirm_book, booked;
    
    @Override
    public void start(Stage primaryStage)
    {
        Window w = new Window();
        Flights fs = new Flights();
        Login_scene ls = new Login_scene(); 
        Sign_Up_Window spw = new Sign_Up_Window();
        Forgot_Password fp = new Forgot_Password();
        
        Traveller t = new Traveller();
        User u = new User();
        DriverClass dc = new DriverClass();
        DriverFlight df = new DriverFlight();
        int adult = Integer.parseInt(adults); 
        int child = Integer.parseInt(childs);
        int infant = Integer.parseInt(infants); 
        f_m_name = new TextField[adult+child+infant];
        l_name = new TextField[adult+child+infant];
        
        TableView<Passenger> table = new TableView<>();
        ObservableList<Passenger> detail = FXCollections.observableArrayList();
        
        borderPane = new BorderPane();
        
        GridPane top_gp = new GridPane();
        
        borderPane.setTop(top_gp); 
        
        top_gp.setAlignment(Pos.CENTER); 
        
        //setting gaps between rows and columns of grid 
        top_gp.setHgap(80);
        top_gp.setVgap(10);
        
        //padding of gridpane in scene
        top_gp.setPadding(new Insets(20,20,20,20));
            
        //
        //top_gp.centerShapeProperty();
        //top_gp.setGridLinesVisible(true); 
        
        
        //****  Top of Border Pane  ****//
        
        
        Rectangle detail_bg = new Rectangle();
        //detail_bg.getStyleClass().add("");
        top_gp.add(detail_bg,0,0,4,2);
        detail_bg.setWidth(240); //setting the width of rectangle   
        detail_bg.setHeight(70);
        detail_bg.setStyle("-fx-fill: green");
        
        Rectangle trav_info_bg = new Rectangle();
        //trav_info_bg.getStyleClass().add("");
        top_gp.add(trav_info_bg,4,0,4,2);
        trav_info_bg.setWidth(240); //setting the width of rectangle   
        trav_info_bg.setHeight(70);
        trav_info_bg.setStyle("-fx-fill:white;");
        
        Rectangle preview_bg = new Rectangle();
        //preview_bg.getStyleClass().add("");
        top_gp.add(preview_bg,8,0,4,2);
        preview_bg.setWidth(240); //setting the width of rectangle   
        preview_bg.setHeight(70);
        preview_bg.setStyle("-fx-fill:white;");
        
        Label detail_lbl = new Label("Details");
        detail_lbl.setId("text"); 
        GridPane.setHalignment(detail_lbl, HPos.CENTER); 
        top_gp.add(detail_lbl,0,0,4,2);
        
        Label traveller_info_lbl = new Label("Traveller Info"); 
        traveller_info_lbl.setId("text"); 
        GridPane.setHalignment(traveller_info_lbl, HPos.CENTER); 
        top_gp.add(traveller_info_lbl,4,0,4,2);
        
        Label preview_lbl = new Label("Preview");
        preview_lbl.setId("text"); 
        GridPane.setHalignment(preview_lbl, HPos.CENTER); 
        top_gp.add(preview_lbl,8,0,4,2);
        
        top_gp.setStyle("-fx-background-color: #999999;-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        //End of Top of BorderPane
        
        //**Bottom of Border Pane**//
        HBox hb = new HBox();
        
        back_btn = new Button("Back");
        back_btn.setPrefSize(300, 40);
        //back button of alldetails
        back_btn.setOnAction(e->{
            
            if(borderPane.getCenter()==rootPane1)
            {
                primaryStage.close();
            }
            else if(borderPane.getCenter()==rootPane2)
            {
                trav_info_bg.setStyle("-fx-fill:white;");
                borderPane.setCenter(rootPane1);
            }
            else if(borderPane.getCenter()==rootPane3)
            {
                table.getItems().clear();
                next_btn.setDisable(false);
                next_btn.setVisible(true);
                book_btn.setDisable(true);
                book_btn.setVisible(false);
                preview_bg.setStyle("-fx-fill:white;");
                borderPane.setCenter(rootPane2);
            }
             
        });
                
        next_btn = new Button("Next");
        next_btn.setPrefSize(300, 40); 
        
        next_btn.setOnAction(new EventHandler<ActionEvent>(){
            
            final int n = j;
            private boolean allFilled()
             {                             
                for(int k=0; k<n; k++)
                {
                     if(f_m_name[k].getText().isEmpty() || l_name[k].getText().isEmpty())
                        return true;
                }
                if(f_name_tf.getText().isEmpty() || l_name_tf.getText().isEmpty() || email_tf.getText().isEmpty() || mob_no_tf.getText().isEmpty())
                {
                    return true;
                }
                else if(add_tf.getText().isEmpty() || pin_tf.getText().isEmpty() || country_tf.getText().isEmpty())
                {
                    return true;
                }
                else
                    return false;
            }
            
            @Override
            public void handle(ActionEvent e)
            {
            
                if(borderPane.getCenter()==rootPane1)
                {
                    System.out.println(borderPane.getCenter());
                    
                    Stage loginStage = new Stage();
                    ls.start(loginStage);
                    ls.signin_btn.setOnAction(m->{
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
                                        borderPane.setCenter(rootPane2);
                                        trav_info_bg.setStyle("-fx-fill:green;");
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
                }
                else if(borderPane.getCenter()==rootPane2)
                {
                    if(allFilled())
                    {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle("Incomplete Details"); 
                       alert.setContentText("All Fields are mandatory");
                       alert.show();
                    }   
                    else if(!(mob_no_tf.getText().length()==10) || !Pattern.matches("[0-9]{10}",mob_no_tf.getText()))
                    {   
                        Alert error =  new Alert(Alert.AlertType.ERROR);
                        error.setTitle("Invalid mobile number"); 
                        error.setContentText("Invalid mobile number");
                        error.show();
                    }
                    else if(!(pin_tf.getText().length()==6) || !Pattern.matches("[0-9]{6}",pin_tf.getText()))
                    {
                        Alert error =  new Alert(Alert.AlertType.ERROR);
                        error.setTitle("Invalid Pincode"); 
                        error.setContentText("Invalid Pincode");
                        error.show();
                    }    
                    else 
                    {
                        for(i=0;i<adult;i++)
                        {
                            detail.addAll(FXCollections.observableArrayList(new Passenger(i+1, f_m_name[i].getText()+" "+l_name[i].getText(), "Adult")));
                        }
                        for(j=0;j<child;j++,i++)
                        {
                            detail.addAll(FXCollections.observableArrayList(new Passenger(i+1, f_m_name[i].getText()+" "+l_name[i].getText(), "Child")));
                        }
                        for(j=0;j<infant;j++,i++)
                        {
                           detail.addAll(FXCollections.observableArrayList(new Passenger(i+1, f_m_name[i].getText()+" "+l_name[i].getText(), "Infant")));
                        }
                        preview_bg.setStyle("-fx-fill:green;");
                        borderPane.setCenter(rootPane3); 
                        next_btn.setDisable(true);
                        next_btn.setVisible(false);
                        book_btn.setDisable(false);
                        book_btn.setVisible(true);
                        hb.getChildren().add(book_btn);
                    } 
                }
                
            }
        });
        
        hb.getChildren().addAll(back_btn, next_btn);
        hb.setSpacing(100); 
        hb.setPadding(new Insets(20, 20, 20, 20)); 
        borderPane.setBottom(hb); 
        hb.setAlignment(Pos.CENTER); 
        hb.setStyle("-fx-background-color: #999999;-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        //End of Bottom of Border Pane
        
        
        
        //****  Center of Border Pane  ****//
        
        //** Details Scene **//
        
        details_gp = new GridPane();
        details_gp.setHgap(15);
        details_gp.setVgap(15);
        details_gp.setAlignment(Pos.CENTER); 
        details_gp.setPadding(new Insets(10, 10, 10, 10));
        
        //setting gridlines visible
        //details_gp.setGridLinesVisible(true);
        
        //
        Label flightDetail_lbl = new Label("Flight Detail");
        flightDetail_lbl.setStyle("-fx-font-size: 30px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n"+
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        details_gp.add(flightDetail_lbl, 0, 0, 4, 1); 
        
        Label srcDest_lbl = new Label(src+" to "+dest);
        srcDest_lbl.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        details_gp.add(srcDest_lbl, 0, 2, 2, 1); 
        
        Label departDate_lbl = new Label(depart_date);
        departDate_lbl.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        details_gp.add(departDate_lbl, 2, 2, 3, 1); 
        
        Image logo = new Image(Window.class.getResourceAsStream("air-logo.png"));
        ImageView logoView = new ImageView(logo);
                
        //setting size of image logo
        logoView.setFitHeight(80);
        logoView.setFitWidth(80);
        GridPane.setHalignment(logoView, HPos.CENTER);
        GridPane.setValignment(logoView, VPos.CENTER);
        //adding logo image 
        details_gp.add(logoView, 0, 3);
        
        //Adding flight name 
        Label flightName_lbl = new Label("AeroSwing");
        flightName_lbl.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");
        GridPane.setHalignment(flightName_lbl, HPos.CENTER); 
        GridPane.setValignment(flightName_lbl, VPos.TOP);
        details_gp.add(flightName_lbl, 0, 4);
            
        Label flightNo_lbl = new Label(flightNo1);
        flightNo_lbl.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");
        GridPane.setHalignment(flightNo_lbl, HPos.CENTER); 
        GridPane.setValignment(flightNo_lbl, VPos.TOP);
        details_gp.add(flightNo_lbl, 0, 5);
        
        Label depart_lbl = new Label("Depart");
        depart_lbl.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");
        GridPane.setHalignment(depart_lbl, HPos.CENTER); 
        GridPane.setValignment(depart_lbl, VPos.CENTER);
        details_gp.add(depart_lbl, 1, 3);
        
        Label arrive_lbl = new Label("Arrive");
        arrive_lbl.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");
        GridPane.setHalignment(arrive_lbl, HPos.CENTER); 
        GridPane.setValignment(arrive_lbl, VPos.CENTER);
        details_gp.add(arrive_lbl, 3, 3);
        
        Label src_lbl = new Label(src);
        src_lbl.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
        GridPane.setHalignment(src_lbl, HPos.CENTER); 
        GridPane.setValignment(src_lbl, VPos.CENTER);
        details_gp.add(src_lbl, 1, 4);
        
        Label dest_lbl = new Label(dest);
        dest_lbl.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
        GridPane.setHalignment(dest_lbl, HPos.CENTER); 
        GridPane.setValignment(dest_lbl, VPos.CENTER);
        details_gp.add(dest_lbl, 3, 4);
        
        Label deparTime1_lbl = new Label(depart_time1);
        deparTime1_lbl.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
        GridPane.setHalignment(deparTime1_lbl, HPos.CENTER); 
        GridPane.setValignment(deparTime1_lbl, VPos.CENTER);
        details_gp.add(deparTime1_lbl, 1, 5);
        
        Label arriveTime1_lbl = new Label(arrive_time1);
        arriveTime1_lbl.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
        GridPane.setHalignment(arriveTime1_lbl, HPos.CENTER); 
        GridPane.setValignment(arriveTime1_lbl, VPos.CENTER);
        details_gp.add(arriveTime1_lbl, 3, 5);
        
        Label passengers_lbl = new Label("Passengers");
        passengers_lbl.setId("text");
        details_gp.add(passengers_lbl, 0, 7);
        
        Label adl_lbl = new Label("Adult:");
        adl_lbl.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        details_gp.add(adl_lbl, 0, 8);
        
        Label chil_lbl = new Label("Child:");
        chil_lbl.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        details_gp.add(chil_lbl, 0, 9);
        
        Label inf_lbl = new Label("Infant:");
        inf_lbl.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        details_gp.add(inf_lbl, 0, 10);
        
        Label tot_adults = new Label(adults);
        tot_adults.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        details_gp.add(tot_adults, 1, 8);
        
        Label tot_childs = new Label(childs);
        tot_childs.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        details_gp.add(tot_childs, 1, 9);
        
        Label tot_infants = new Label(infants);
        tot_infants.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        details_gp.add(tot_infants, 1, 10);
        
        Label fare_lbl = new Label("Fare");
        fare_lbl.setId("text");
        details_gp.add(fare_lbl, 0, 12);
        
        Label tot_fare_lbl = new Label("Total Fare:");
        tot_fare_lbl.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        details_gp.add(tot_fare_lbl, 0, 13);
        
        if(trip.equals("One Way Trip"))
        {
            Label tot_fare = new Label("Rs. "+fare1);
            tot_fare.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                    "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
            details_gp.add(tot_fare, 1, 13);
        }
        else
        {
            fare = Integer.parseInt(fare1) + Integer.parseInt(fare2);
            Label tot_fare = new Label("Rs. "+fare.toString());
            tot_fare.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                    "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
            details_gp.add(tot_fare, 1, 13);
        }
        
        
        //if trip is round trip
        if(trip.equals("Round Trip"))
        {
            
            Label srcDest_lbl_r = new Label(dest+" to "+src);
            srcDest_lbl_r.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                    "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
            details_gp.add(srcDest_lbl_r, 7, 2, 2, 1); 
        
            Label returnDate_lbl = new Label(return_date);
            returnDate_lbl.setStyle("-fx-font-size: 23px;-fx-fill:#181818;-fx-font-weight: bold;\n" +
                    "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
            details_gp.add(returnDate_lbl, 9, 2, 2, 1); 
        
            Image logo_r = new Image(Window.class.getResourceAsStream("air-logo.png"));
            ImageView logoView_r = new ImageView(logo_r);
                
            //setting size of image logo
            logoView_r.setFitHeight(80);
            logoView_r.setFitWidth(80);
            GridPane.setHalignment(logoView_r, HPos.CENTER);
            GridPane.setValignment(logoView_r, VPos.CENTER);
            //adding logo image 
            details_gp.add(logoView_r, 7, 3);
        
            //Adding flight name 
            Label flightName_lbl_r = new Label("AeroSwing");
            flightName_lbl_r.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");
            GridPane.setHalignment(flightName_lbl_r, HPos.CENTER); 
            GridPane.setValignment(flightName_lbl_r, VPos.TOP);
            details_gp.add(flightName_lbl_r, 7, 4);
            
            Label flightNo_lbl_r = new Label(flightNo2);
            flightNo_lbl_r.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");
            GridPane.setHalignment(flightNo_lbl_r, HPos.CENTER); 
            GridPane.setValignment(flightNo_lbl_r, VPos.TOP);
            details_gp.add(flightNo_lbl_r, 7, 5);
        
            Label depart_lbl_r = new Label("Depart");
            depart_lbl_r.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");
            GridPane.setHalignment(depart_lbl_r, HPos.CENTER); 
            GridPane.setValignment(depart_lbl_r, VPos.CENTER);
            details_gp.add(depart_lbl_r, 8, 3);
        
            Label arrive_lbl_r = new Label("Arrive");
            arrive_lbl_r.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");
            GridPane.setHalignment(arrive_lbl_r, HPos.CENTER); 
            GridPane.setValignment(arrive_lbl_r, VPos.CENTER);
            details_gp.add(arrive_lbl_r, 10, 3);
        
            Label src_lbl_r = new Label(src);
            src_lbl_r.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
            GridPane.setHalignment(src_lbl_r, HPos.CENTER); 
            GridPane.setValignment(src_lbl_r, VPos.CENTER);
            details_gp.add(src_lbl_r, 8, 4);
        
            Label dest_lbl_r = new Label(dest);
            dest_lbl_r.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
            GridPane.setHalignment(dest_lbl_r, HPos.CENTER); 
            GridPane.setValignment(dest_lbl_r, VPos.CENTER);
            details_gp.add(dest_lbl_r, 10, 4);
        
            Label deparTime1_lbl_r = new Label(depart_time2);
            deparTime1_lbl_r.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
            GridPane.setHalignment(deparTime1_lbl_r, HPos.CENTER); 
            GridPane.setValignment(deparTime1_lbl_r, VPos.CENTER);
            details_gp.add(deparTime1_lbl_r, 8, 5);
        
            Label arriveTime1_lbl_r = new Label(arrive_time2);
            arriveTime1_lbl_r.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
            GridPane.setHalignment(arriveTime1_lbl_r, HPos.CENTER); 
            GridPane.setValignment(arriveTime1_lbl_r, VPos.CENTER);
            details_gp.add(arriveTime1_lbl_r, 10, 5);
        
        }
        
        rootPane1 = new ScrollPane();
        rootPane1.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        rootPane1.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); 
        rootPane1.setFitToHeight(true);
        rootPane1.setFitToWidth(true); 
        //rootPane.setVmax(2);
        //rootPane.setHmax(2);
        //rootPane.setVvalue(20);
        rootPane1.setContent(details_gp);  
        
        //End of Details Scene **//
        
        
        
        //** Traveller Info Scene **//
        
        travInfo_gp = new GridPane();
       
        travInfo_gp.setAlignment(Pos.TOP_LEFT); 
        
        //setting gaps between rows and columns of grid 
        travInfo_gp.setHgap(10);
        travInfo_gp.setVgap(10);
        
        //padding of gridpane in scene
        travInfo_gp.setPadding(new Insets(20,20,20,20));
        
        //gp.centerShapeProperty();
        //center_gp.setGridLinesVisible(true);
        
        Label pass_detail_lbl = new Label("Passenger Details");
        pass_detail_lbl.setStyle("-fx-font-size: 30px");
        travInfo_gp.add(pass_detail_lbl, 0, 0, 2, 1);
      
      //  Line line = new Line(0, 0, , startY);
            
        i=0;
        j=1;
        //Passenger Details of no. of adults selected 
        try{
        
        Label adult_lbl[] = new Label[adult];
        
        for(; j<=adult; i++,j++)
        {
            adult_lbl[j-1] = new Label(j+".Adult");
            adult_lbl[j-1].setId("text"); 
            travInfo_gp.add(adult_lbl[j-1],0, i+3);
            
            f_m_name[i] = new TextField();
            f_m_name[i].setPromptText("First & Middle Name"); 
            travInfo_gp.add(f_m_name[i], 1, i+3);
            
            l_name[i] = new TextField();
            l_name[i].setPromptText("Last Name"); 
            travInfo_gp.add(l_name[i], 2, i+3, 2, 1);
        }
        }catch(Exception ex) {
            System.out.println(ex);
        }
       
        //Passenger Details of no. of childs selected
        try{
        j=1;
         
        Label child_lbl[] = new Label[child];
        
        for(; j<=child; i++,j++)
        {
            child_lbl[j-1] = new Label(j+".Child");
            child_lbl[j-1].setId("text"); 
            travInfo_gp.add(child_lbl[j-1],0, i+3);
            
            f_m_name[i] = new TextField();
            f_m_name[i].setPromptText("First & Middle Name"); 
            travInfo_gp.add(f_m_name[i], 1, i+3);
            
            l_name[i] = new TextField();
            l_name[i].setPromptText("Last Name"); 
            travInfo_gp.add(l_name[i], 2, i+3, 2, 1);
            
        }
        }catch(NumberFormatException ex){
            System.out.println(ex);
        }
        
        //Passenger Details of no. of infants selected
        try{
        j=1;
        
        Label infant_lbl[] = new Label[infant];
        
        for(; j<=infant; i++,j++)
        {
            infant_lbl[j-1] = new Label(j+".Infant");
            infant_lbl[j-1].setId("text"); 
            travInfo_gp.add(infant_lbl[j-1],0, i+3);
            
            f_m_name[i] = new TextField();
            f_m_name[i].setPromptText("First & Middle Name"); 
            travInfo_gp.add(f_m_name[i], 1, i+3);
            
            l_name[i] = new TextField();
            l_name[i].setPromptText("Last Name"); 
            travInfo_gp.add(l_name[i], 2, i+3, 2, 1);
            
        }
        }catch(NumberFormatException ex){
            System.out.println(ex);
        }
        j=i-1;//j = no. of textfields 
        
        Label con_info_lbl = new Label("Contact Information");
        con_info_lbl.setStyle("-fx-font-size: 30px");
        travInfo_gp.add(con_info_lbl, 0, i+4, 2, 1);
        i++;
        
        Text f_name_txt = new Text("First Name:");
        f_name_txt.setId("text"); 
        travInfo_gp.add(f_name_txt, 0, i+6);
        
        f_name_tf = new TextField();
        f_name_tf.setPromptText("First Name"); 
        travInfo_gp.add(f_name_tf, 1, i+6);
        
        Text l_name_txt = new Text("Last Name:");
        l_name_txt.setId("text"); 
        travInfo_gp.add(l_name_txt, 2, i+6);
        
        l_name_tf = new TextField();
        l_name_tf.setPromptText("Last Name"); 
        travInfo_gp.add(l_name_tf, 3, i+6);
        i++;
        
        Text add_txt = new Text("Address:");
        add_txt.setId("text"); 
        travInfo_gp.add(add_txt, 0, i+6);
        
        add_tf = new TextField();
        add_tf.setPromptText("Address"); 
        travInfo_gp.add(add_tf, 1, i+6);
        
        Text email_txt = new Text("Email:");
        email_txt.setId("text"); 
        travInfo_gp.add(email_txt, 2, i+6);
        
        email_tf = new TextField();
        email_tf.setPromptText("Email"); 
        travInfo_gp.add(email_tf, 3, i+6);
        i++;
        
        Text country_txt = new Text("Country:");
        country_txt.setId("text"); 
        travInfo_gp.add(country_txt, 0, i+6);
        
        country_tf = new TextField();
        country_tf.setPromptText("Country"); 
        travInfo_gp.add(country_tf, 1, i+6);
        
        Text pin_txt = new Text("Pincode:");
        pin_txt.setId("text"); 
        travInfo_gp.add(pin_txt, 2, i+6);
        
        pin_tf = new TextField();
        pin_tf.setPromptText("Pincode"); 
        travInfo_gp.add(pin_tf, 3, i+6);
        i++;
              
        Text mob_no_txt = new Text("Mobile no:");
        mob_no_txt.setId("text"); 
        travInfo_gp.add(mob_no_txt, 0, i+6);
        
        mob_no_tf = new TextField();
        mob_no_tf.setPromptText("Mobile no"); 
        travInfo_gp.add(mob_no_tf, 1, i+6);
        i++;
        
        rootPane2 = new ScrollPane();
        rootPane2.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        rootPane2.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); 
        rootPane2.setFitToHeight(true);
        rootPane2.setFitToWidth(true); 
        //rootPane.setVmax(2);
        //rootPane.setHmax(2);
        //rootPane.setVvalue(20);
        rootPane2.setContent(travInfo_gp);  
        
         
        //End of Center of BorderPane
        
        
        //** End of Traveller Info Scene **//
        
        
        //** Preview Scene **//
        preview_gp = new GridPane();
        preview_gp.setHgap(15);
        preview_gp.setVgap(15);
        preview_gp.setAlignment(Pos.CENTER); 
        preview_gp.setPadding(new Insets(10, 10, 10, 10));
        
        //setting gridlines visible
        //preview_gp.setGridLinesVisible(true);
        
        //
        Label f_Detail_lbl = new Label("Flight Detail");
        f_Detail_lbl.setStyle("-fx-font-size: 30px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n"+
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        preview_gp.add(f_Detail_lbl, 0, 0, 4, 1); 
        
        Label src_Dest_lbl = new Label(src+" to "+dest);
        src_Dest_lbl.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        preview_gp.add(src_Dest_lbl, 0, 2, 2, 1); 
        
        Label depart_Date_lbl = new Label(depart_date);
        depart_Date_lbl.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        preview_gp.add(depart_Date_lbl, 2, 2, 3, 1); 
        
        //Image logo_img = new Image(Window.class.getResourceAsStream("air-logo.png"));
        ImageView logo_img = new ImageView(logo);
                
        //setting size of image logo
        logo_img.setFitHeight(80);
        logo_img.setFitWidth(80);
        GridPane.setHalignment(logo_img, HPos.CENTER);
        GridPane.setValignment(logo_img, VPos.CENTER);
        //adding logo image 
        preview_gp.add(logo_img, 0, 3);
        
        //Adding flight name 
        Label flight_Name_lbl = new Label("AeroSwing");
        flight_Name_lbl.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");
        GridPane.setHalignment(flight_Name_lbl, HPos.CENTER); 
        GridPane.setValignment(flight_Name_lbl, VPos.TOP);
        preview_gp.add(flight_Name_lbl, 0, 4);
            
        Label flight_No_lbl = new Label(flightNo1);
        flight_No_lbl.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");
        GridPane.setHalignment(flight_No_lbl, HPos.CENTER); 
        GridPane.setValignment(flight_No_lbl, VPos.TOP);
        preview_gp.add(flight_No_lbl, 0, 5);
        
        Label departlbl = new Label("Depart");
        departlbl.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");
        GridPane.setHalignment(departlbl, HPos.CENTER); 
        GridPane.setValignment(departlbl, VPos.CENTER);
        preview_gp.add(departlbl, 1, 3);
        
        Label arrivelbl = new Label("Arrive");
        arrivelbl.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");
        GridPane.setHalignment(arrivelbl, HPos.CENTER); 
        GridPane.setValignment(arrivelbl, VPos.CENTER);
        preview_gp.add(arrivelbl, 3, 3);
        
        Label srclbl = new Label(src);
        srclbl.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
        GridPane.setHalignment(srclbl, HPos.CENTER); 
        GridPane.setValignment(srclbl, VPos.CENTER);
        preview_gp.add(srclbl, 1, 4);
        
        Label destlbl = new Label(dest);
        destlbl.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
        GridPane.setHalignment(destlbl, HPos.CENTER); 
        GridPane.setValignment(destlbl, VPos.CENTER);
        preview_gp.add(destlbl, 3, 4);
        
        Label departTime1_lbl = new Label(depart_time1);
        deparTime1_lbl.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
        GridPane.setHalignment(departTime1_lbl, HPos.CENTER); 
        GridPane.setValignment(departTime1_lbl, VPos.CENTER);
        preview_gp.add(departTime1_lbl, 1, 5);
        
        Label arrive_Time1_lbl = new Label(arrive_time1);
        arrive_Time1_lbl.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
        GridPane.setHalignment(arrive_Time1_lbl, HPos.CENTER); 
        GridPane.setValignment(arrive_Time1_lbl, VPos.CENTER);
        preview_gp.add(arrive_Time1_lbl, 3, 5);
        
        Label passengerslbl = new Label("Passengers");
        passengerslbl.setId("text");
        preview_gp.add(passengerslbl, 0, 7);
        
        Label adlults_lbl = new Label("Adult:");
        adlults_lbl.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        preview_gp.add(adlults_lbl, 0, 8);
        
        Label childs_lbl = new Label("Child:");
        childs_lbl.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        preview_gp.add(childs_lbl, 0, 9);
        
        Label infants_lbl = new Label("Infant:");
        infants_lbl.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        preview_gp.add(infants_lbl, 0, 10);
        
        Label total_adults = new Label(adults);
        total_adults.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        preview_gp.add(total_adults, 1, 8);
        
        Label total_childs = new Label(childs);
        total_childs.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        preview_gp.add(total_childs, 1, 9);
        
        Label total_infants = new Label(infants);
        total_infants.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        preview_gp.add(total_infants, 1, 10);
        
        Label farelbl = new Label("Fare");
        farelbl.setId("text");
        preview_gp.add(farelbl, 0, 12);
        
        Label total_fare_lbl = new Label("Total Fare:");
        total_fare_lbl.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        preview_gp.add(total_fare_lbl, 0, 13);
        
        if(trip.equals("One Way Trip"))
        {
            int price= Integer.parseInt(fare1)*(adult+child);
            fare1=Integer.toString(price);
            Label tot_fare = new Label("Rs. "+fare1);
            tot_fare.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                    "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
            preview_gp.add(tot_fare, 1, 13);
        }
        else
        {
            fare = (Integer.parseInt(fare1) + Integer.parseInt(fare2))*(adult+child);
            Label tot_fare = new Label("Rs. "+fare.toString());
            tot_fare.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                    "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
            preview_gp.add(tot_fare, 1, 13);
        }
        
        
        //if trip is round trip
        if(trip.equals("Round Trip"))
        {
            
            Label srcDest_lbl_r = new Label(dest+" to "+src);
            srcDest_lbl_r.setStyle("-fx-font-size: 23px;\n" +"-fx-fill:#181818;-fx-font-weight: bold;\n" +
                    "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
            preview_gp.add(srcDest_lbl_r, 7, 2, 2, 1); 
        
            Label returnDate_lbl = new Label(return_date);
            returnDate_lbl.setStyle("-fx-font-size: 23px;-fx-fill:#181818;-fx-font-weight: bold;\n" +
                    "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
            preview_gp.add(returnDate_lbl, 9, 2, 2, 1); 
        
            Image logo_r = new Image(Window.class.getResourceAsStream("air-logo.png"));
            ImageView logoView_r = new ImageView(logo_r);
                
            //setting size of image logo
            logoView_r.setFitHeight(80);
            logoView_r.setFitWidth(80);
            GridPane.setHalignment(logoView_r, HPos.CENTER);
            GridPane.setValignment(logoView_r, VPos.CENTER);
            //adding logo image 
            preview_gp.add(logoView_r, 7, 3);
        
            //Adding flight name 
            Label flightName_lbl_r = new Label("AeroSwing");
            flightName_lbl_r.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");
            GridPane.setHalignment(flightName_lbl_r, HPos.CENTER); 
            GridPane.setValignment(flightName_lbl_r, VPos.TOP);
            preview_gp.add(flightName_lbl_r, 7, 4);
            
            Label flightNo_lbl_r = new Label(flightNo2);
            flightNo_lbl_r.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");
            GridPane.setHalignment(flightNo_lbl_r, HPos.CENTER); 
            GridPane.setValignment(flightNo_lbl_r, VPos.TOP);
            preview_gp.add(flightNo_lbl_r, 7, 5);
        
            Label depart_lbl_r = new Label("Depart");
            depart_lbl_r.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");
            GridPane.setHalignment(depart_lbl_r, HPos.CENTER); 
            GridPane.setValignment(depart_lbl_r, VPos.CENTER);
            preview_gp.add(depart_lbl_r, 8, 3);
        
            Label arrive_lbl_r = new Label("Arrive");
            arrive_lbl_r.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");
            GridPane.setHalignment(arrive_lbl_r, HPos.CENTER); 
            GridPane.setValignment(arrive_lbl_r, VPos.CENTER);
            preview_gp.add(arrive_lbl_r, 10, 3);
        
            Label src_lbl_r = new Label(src);
            src_lbl_r.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
            GridPane.setHalignment(src_lbl_r, HPos.CENTER); 
            GridPane.setValignment(src_lbl_r, VPos.CENTER);
            preview_gp.add(src_lbl_r, 8, 4);
        
            Label dest_lbl_r = new Label(dest);
            dest_lbl_r.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
            GridPane.setHalignment(dest_lbl_r, HPos.CENTER); 
            GridPane.setValignment(dest_lbl_r, VPos.CENTER);
            preview_gp.add(dest_lbl_r, 10, 4);
        
            Label deparTime1_lbl_r = new Label(depart_time2);
            deparTime1_lbl_r.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
            GridPane.setHalignment(deparTime1_lbl_r, HPos.CENTER); 
            GridPane.setValignment(deparTime1_lbl_r, VPos.CENTER);
            preview_gp.add(deparTime1_lbl_r, 8, 5);
        
            Label arriveTime1_lbl_r = new Label(arrive_time2);
            arriveTime1_lbl_r.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
            GridPane.setHalignment(arriveTime1_lbl_r, HPos.CENTER); 
            GridPane.setValignment(arriveTime1_lbl_r, VPos.CENTER);
            preview_gp.add(arriveTime1_lbl_r, 10, 5);
        
        }
        
        
        TableColumn srNoCol = new TableColumn("Sr.No");
        srNoCol.setMinWidth(100);
        srNoCol.setCellValueFactory(new PropertyValueFactory<>("srNo"));
 
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
 
        TableColumn typeCol = new TableColumn("Type");
        typeCol.setMinWidth(200);
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
 
        table.setItems(detail);
        table.getColumns().addAll(srNoCol, nameCol, typeCol);
 
        Label passengerDetail_lbl = new Label("Passenger Details");
        passengerDetail_lbl.setId("text");
        
        book_btn = new Button("Book");
        book_btn.setPrefSize(300, 40);
        
        /*book_btn.setOnAction(e->{
           
            confirm_book = new Alert(Alert.AlertType.CONFIRMATION, "Confirmation", ButtonType.YES, ButtonType.NO);
            confirm_book.setTitle("CONFIRMATION");
            confirm_book.setContentText("Confirm Booking ?");
            confirm_book.show();
            
            confirm_book.setOnCloseRequest(new EventHandler<DialogEvent>(){
                    @Override
                    public void handle(DialogEvent event) {
                        if(confirm_book.getResult()==ButtonType.YES)
                        {
                           
                            booked = new Alert(Alert.AlertType.INFORMATION, "INFORMATION");
                            booked.setTitle("INFORMATION");
                            booked.setContentText("Booked Flight Successfully");
                            booked.show();
                            
                            booked.setOnCloseRequest(new EventHandler<DialogEvent>(){
                            @Override
                            public void handle(DialogEvent event) {
                            if(booked.getResult()==ButtonType.OK)
                            {
                                Alert newSearch = new Alert(Alert.AlertType.INFORMATION, "INFORMATION", ButtonType.YES, ButtonType.NO);
                                newSearch.setTitle("INFORMATION");
                                newSearch.setContentText("Search for Flights ?");
                                newSearch.show();
                                
                                newSearch.setOnCloseRequest(new EventHandler<DialogEvent>(){
                                    @Override
                                    public void handle(DialogEvent event) {
                                    if(newSearch.getResult()==ButtonType.YES)
                                    {
                                        Stage stage = new Stage();
                                        w.start(stage);
                                    }   
                                    else
                                    {
                                        primaryStage.close();
                                    }
                                    }
                                });
                            }
                            }
                            });
                        }
                    }
            });
         
        });*/
        
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(passengerDetail_lbl, table);
        
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10, 0, 0, 10));
        hbox.getChildren().addAll(preview_gp, vbox, book_btn);
        
        rootPane3 = new ScrollPane();
        rootPane3.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        rootPane3.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); 
        rootPane3.setFitToHeight(true);
        rootPane3.setFitToWidth(true); 
        //rootPane.setVmax(2);
        //rootPane.setHmax(2);
        //rootPane.setVvalue(20);
        rootPane3.setContent(hbox);
        //rootPane3.setContent(preview_gp); 
        
        //** End of Preview Scene **//
        
        //****  End of Center Pane  ****//
        
        allDetailsScene = new Scene(borderPane, 1000, 600);
        allDetailsScene.getStylesheets().add(Window.class.getResource("LoginScene.css").toExternalForm());
        primaryStage.setScene(allDetailsScene);
        
        //setting primaryStage to the size of screen of pc
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        //MinX and MinY are upper left corner of primaryStage
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        //setting width of stage to width of screen
        primaryStage.setWidth(primaryScreenBounds.getWidth());
        //setting height of stage to height of screen
        primaryStage.setHeight(primaryScreenBounds.getHeight());
        primaryStage.show();
        
    }
    
    public static void main(String args[])
    {
        launch(args);
    }
    
    public static class Passenger {
 
        private final SimpleIntegerProperty srNo;
        private final SimpleStringProperty name;
        private final SimpleStringProperty type;
 
        private Passenger(int srNo, String name, String type) {
            this.srNo = new SimpleIntegerProperty(srNo);
            this.name = new SimpleStringProperty(name);
            this.type = new SimpleStringProperty(type);
        }
 
        public Integer getSrNo()
        {
            return srNo.get();
        }
        
        public void setSrNo(Integer Sr_no){
            srNo.set(Sr_no);
        }
        
        public String getName() {
            return name.get();
        }
 
        public void setFirstName(String Name) {
            name.set(Name);
        }
 
        public String getType() {
            return type.get();
        }
 
        public void setLastName(String Type) {
            type.set(Type);
        }
        
    }

}
