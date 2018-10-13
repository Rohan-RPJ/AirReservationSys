/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window.java;

import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Rohan
 */
public class AllDetails extends Application{
    
    
    public String adults, childs, infants;    
    public TextField f_m_name[], l_name[], f_name_tf, l_name_tf, email_tf, 
            add_tf, pin_tf, country_tf, mob_no_tf;
    public Scene s;

    @Override
    public void start(Stage primaryStage)
    {
        Window w = new Window();
        Traveller t = new Traveller();
        
        BorderPane borderPane = new BorderPane();
        
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
        
        Rectangle trav_info_bg = new Rectangle();
        //trav_info_bg.getStyleClass().add("");
        top_gp.add(trav_info_bg,4,0,4,2);
        trav_info_bg.setWidth(240); //setting the width of rectangle   
        trav_info_bg.setHeight(70);
        
        Rectangle preview_bg = new Rectangle();
        //preview_bg.getStyleClass().add("");
        top_gp.add(preview_bg,8,0,4,2);
        preview_bg.setWidth(240); //setting the width of rectangle   
        preview_bg.setHeight(70);
        
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
        
        Button back_btn = new Button("Back");
        back_btn.setPrefSize(300, 40);
        
         
        
        Button next_btn = new Button("Next");
        next_btn.setPrefSize(300, 40); 
        next_btn.setStyle("-fx-background-radius: 50em;"); 
        
        hb.getChildren().addAll(back_btn, next_btn);
        hb.setSpacing(100); 
        hb.setPadding(new Insets(20, 20, 20, 20)); 
        borderPane.setBottom(hb); 
        hb.setAlignment(Pos.CENTER); 
        hb.setStyle("-fx-background-color: #999999;-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        //End of Bottom of Border Pane
        
        
        
        //****  Center of Border Pane  ****//
        
        //** Details Scene **//
        
        GridPane details_gp = new GridPane();
        details_gp.setGridLinesVisible(true);
        details_gp.setHgap(15);
        details_gp.setVgap(15);
        details_gp.setAlignment(Pos.TOP_LEFT); 
        details_gp.setPadding(new Insets(10, 10, 10, 10));
        
        //
        Label flightDetail_lbl = new Label("Flight Detail");
        flightDetail_lbl.setId("text"); 
        details_gp.add(flightDetail_lbl, 0, 0); 
        
        
        
        //End of Details Scene **//
        
        //** Traveller Info Scene **//
        
        GridPane travInfo_gp = new GridPane();
       
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
            
        int i=0,j=1;
        //Passenger Details of no. of adults selected 
        try{
        int adult = Integer.parseInt(adults); 
        Label adult_lbl[] = new Label[adult];
        
        f_m_name = new TextField[adult];
        l_name = new TextField[adult];
        for(; j<=adult; i++,j++)
        {
            adult_lbl[j-1] = new Label(j+".Adult");
            adult_lbl[j-1].setId("text"); 
            travInfo_gp.add(adult_lbl[j-1],0, i+3);
            
            f_m_name[j-1] = new TextField();
            f_m_name[j-1].setPromptText("First & Middle Name"); 
            travInfo_gp.add(f_m_name[j-1], 1, i+3);
            
            l_name[j-1] = new TextField();
            l_name[j-1].setPromptText("Last Name"); 
            travInfo_gp.add(l_name[j-1], 2, i+3, 2, 1);
        }
        }catch(Exception ex) {
            System.out.println(ex);
        }
       
        //Passenger Details of no. of childs selected
        try{
        j=1;
        int child = Integer.parseInt(childs); 
        Label child_lbl[] = new Label[child];
        f_m_name = new TextField[child];
        l_name = new TextField[child];
        for(; j<=child; i++,j++)
        {
            child_lbl[j-1] = new Label(j+".Child");
            child_lbl[j-1].setId("text"); 
            travInfo_gp.add(child_lbl[j-1],0, i+3);
            
            f_m_name[j-1] = new TextField();
            f_m_name[j-1].setPromptText("First & Middle Name"); 
            travInfo_gp.add(f_m_name[j-1], 1, i+3);
            
            l_name[j-1] = new TextField();
            l_name[j-1].setPromptText("Last Name"); 
            travInfo_gp.add(l_name[j-1], 2, i+3, 2, 1);
            
        }
        }catch(NumberFormatException ex){
            System.out.println(ex);
        }
        
        //Passenger Details of no. of infants selected
        try{
        j=1;
        int infant = Integer.parseInt(infants); 
        Label infant_lbl[] = new Label[infant];
        f_m_name = new TextField[infant];
        l_name = new TextField[infant];
        for(; j<=infant; i++,j++)
        {
            infant_lbl[j-1] = new Label(j+".Infant");
            infant_lbl[j-1].setId("text"); 
            travInfo_gp.add(infant_lbl[j-1],0, i+3);
            
            f_m_name[j-1] = new TextField();
            f_m_name[j-1].setPromptText("First & Middle Name"); 
            travInfo_gp.add(f_m_name[j-1], 1, i+3);
            
            l_name[j-1] = new TextField();
            l_name[j-1].setPromptText("Last Name"); 
            travInfo_gp.add(l_name[j-1], 2, i+3, 2, 1);
            
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
        
        final int n = j;
        //
        next_btn.setOnAction(new EventHandler<ActionEvent>(){
            
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
               
                }        
            }

        });//end of actionevent of next button
        
        
        ScrollPane rootPane = new ScrollPane();
        rootPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        rootPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); 
        rootPane.setFitToHeight(true);
        rootPane.setFitToWidth(true); 
        //rootPane.setVmax(2);
        //rootPane.setHmax(2);
        //rootPane.setVvalue(20);
        rootPane.setContent(travInfo_gp);  
        
        borderPane.setCenter(rootPane); 
        //End of Center of BorderPane
        
        s = new Scene(borderPane, 1000, 600);
        s.getStylesheets().add(Window.class.getResource("LoginScene.css").toExternalForm());
        
        //** End of Traveller Info Scene **//
        
        
        //** Preview Scene **//
        
        //** End of Preview Scene **//
        
        //****  End of Center Pane  ****//
    }
    
    public static void main(String args[])
    {
        launch(args);
    }
    
}
