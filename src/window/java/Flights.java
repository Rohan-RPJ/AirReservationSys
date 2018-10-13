/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window.java;

import java.text.ParseException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class Flights extends Application{
    
    public Scene fSearchScene;
    public BorderPane bp;
    public GridPane top_gp;
    public Label trip_lbl,src_dest_lbl,adult_lbl,child_lbl,infant_lbl,
            tot_adult,tot_child,tot_infant;
    public String trip, src, dest,adults,childs,infants;
    public ArrayList<FlightData> al = new ArrayList<>();
    public ArrayList<FlightData> alr = new ArrayList<>();
    
    public Button next_btn;
    public int i;
    public void setFlightData(ArrayList<FlightData> al)
    {
        this.al=al;
    }
    
    public void setRoundFlightData(ArrayList<FlightData> alr)
    {
        this.alr=alr;
    }
    @Override
    public void start(Stage primaryStage) throws ParseException
    {
      
        Window w = new Window();
        Traveller t = new Traveller();
        
        bp = new BorderPane();
        
        //**** Top of Border Pane ****//
        top_gp = new GridPane();
        
        top_gp.setGridLinesVisible(true); 
        bp.setTop(top_gp); 
        top_gp.setAlignment(Pos.CENTER); 
        
        //setting gaps between rows and columns of grid 
        top_gp.setHgap(10);
        top_gp.setVgap(10);
        
        //padding of gridpane in scene
        top_gp.setPadding(new Insets(20,20,20,20));
        
        trip_lbl = new Label(trip);
        trip_lbl.setStyle("-fx-font_weight:bold;-fx-font-size:30px"); 
        top_gp.add(trip_lbl, 0, 0, 6, 1);
        
        src_dest_lbl = new Label(src+" to "+dest);
        src_dest_lbl.setStyle("-fx-font-size:15px"); 
        top_gp.add(src_dest_lbl, 0, 2, 6, 1);
        
        //
        adult_lbl = new Label("Adult");
        child_lbl = new Label("Child");
        infant_lbl =new Label("Infant");
        
        top_gp.add(adult_lbl, 3, 3);
        top_gp.add(child_lbl, 5, 3);
        top_gp.add(infant_lbl, 7, 3);
        //
        
        //
        tot_adult = new Label(adults);
        GridPane.setHalignment(tot_adult, HPos.CENTER);
        
        tot_child = new Label(childs);
        GridPane.setHalignment(tot_child, HPos.CENTER);
        
        tot_infant = new Label(infants);
        GridPane.setHalignment(tot_infant, HPos.CENTER);
        
        top_gp.add(tot_adult, 4, 3);
        top_gp.add(tot_child, 6, 3);
        top_gp.add(tot_infant, 8, 3);
        
        top_gp.setStyle("-fx-background-color: #999999;");
        //End of top of  borderPane 
        
        //**** Center Of bottom Pane ****//
        
        HBox hb = new HBox(20);
        
        GridPane[] center_gp1 = new GridPane[4];
        VBox v1 = new VBox(30);
        StackPane[] sp1 = new StackPane[4];
        Rectangle[] r1 = new Rectangle[4];
        Image[] logo1 = new Image[4];
        ImageView[] logo_img_view1 = new ImageView[4];
        Label[] flight_name1 = new Label[4];
        Label[] flightNo1 = new Label[4];
        Label[] time_src1 = new Label[4];
        Label[] time_dest1 = new Label[4];
        Label[] source1 = new Label[4];
        Label[] destination1 = new Label[4];
        Label[] tot_time_req1 = new Label[4];
        Label[] fare1 = new Label[4];
        RadioButton[] book_btn1 = new RadioButton[4];
        ToggleGroup oneWayTrip_tg = new ToggleGroup();
       
        GridPane[] center_gp2 = new GridPane[4];
        VBox v2 = new VBox(30);
        StackPane[] sp2 = new StackPane[4];
        Rectangle[] r2 = new Rectangle[4];
        Image[] logo2 = new Image[4];
        ImageView[] logo_img_view2 = new ImageView[4];
        Label[] flight_name2 = new Label[4];
        Label[] flightNo2 = new Label[4];
        Label[] time_src2 = new Label[4];
        Label[] time_dest2 = new Label[4];
        Label[] source2 = new Label[4];
        Label[] destination2 = new Label[4];
        Label[] tot_time_req2 = new Label[4];
        Label[] fare2 = new Label[4];
        RadioButton[] book_btn2 = new RadioButton[4];
        ToggleGroup roundTrip_tg = new ToggleGroup();    
        
        i=0;
        //Passenger Details of no. of adults selected 
        //try{
        //int tot_fligts = Integer.parseInt(); 
        
        for(; i<al.size(); i++)
        {System.out.println("one way trip size"+al.size());
            
            //setting primary properties required for gridPane
            center_gp1[i] = new GridPane();
            center_gp1[i].setAlignment(Pos.CENTER); 
            
            //background of gridPane
            r1[i] = new Rectangle();
            r1[i].setWidth(530); 
            r1[i].setHeight(230);
            r1[i].setStyle("-fx-fill:white;-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 ); ");
            
            
            //center_gp[i].setStyle("-fx-background-color: white");
            //setting gaps between rows and columns of grid 
            center_gp1[i].setHgap(10);
            center_gp1[i].setVgap(10);
            
            //padding of gridpane in scene
            center_gp1[i].setPadding(new Insets(5,5,5,5));
        
            //Visibility of gridPanes
            //center_gp1[i].setGridLinesVisible(true);
            
            //end of setting primary properties required for gridPane
            
            //contents inside gridPane
            
            logo1[i] = new Image(Window.class.getResourceAsStream("air-logo.png"));
            logo_img_view1[i] = new ImageView(logo1[i]);
        
           
            //setting size of image logo
            logo_img_view1[i].setFitHeight(65);
            logo_img_view1[i].setFitWidth(65);
            GridPane.setHalignment(logo_img_view1[i], HPos.CENTER);
            GridPane.setValignment(logo_img_view1[i], VPos.CENTER);
            //adding logo image 
            center_gp1[i].add(logo_img_view1[i],0,0);
            
            //Adding flight name 
            flight_name1[i] = new Label("AeroSwing");
            flight_name1[i].setStyle("-fx-font-size: 15px;");
            GridPane.setHalignment(flight_name1[i], HPos.LEFT); 
            GridPane.setValignment(flight_name1[i], VPos.CENTER);
            center_gp1[i].add(flight_name1[i], 1, 0);
            
            flightNo1[i] = new Label(al.get(i).getFlight_Number()); 
            flightNo1[i].setStyle("-fx-font-size: 15px;");
            GridPane.setHalignment(flightNo1[i], HPos.LEFT); 
            GridPane.setValignment(flightNo1[i], VPos.BOTTOM);
            center_gp1[i].add(flightNo1[i], 1, 0);
            
            time_src1[i] = new Label(al.get(i).getDeparture_Time());
            time_src1[i].setStyle("-fx-font-size: 30px;-fx-font-weight: bold;");
            GridPane.setHalignment(time_src1[i], HPos.CENTER); 
            center_gp1[i].add(time_src1[i], 4, 0);
            
            time_dest1[i] = new Label(al.get(i).getArrival_Time());
            time_dest1[i].setStyle("-fx-font-size: 30px;-fx-font-weight: bold;");
            GridPane.setHalignment(time_dest1[i], HPos.CENTER); 
            center_gp1[i].add(time_dest1[i], 7, 0);
            
            source1[i] = new Label(al.get(i).getSourceCity());
            source1[i].setStyle("-fx-font-size: 20px;"); 
            GridPane.setHalignment(source1[i], HPos.CENTER); 
            center_gp1[i].add(source1[i], 4, 1);
            
            destination1[i] = new Label(al.get(i).getDestinationCity());
            destination1[i].setStyle("-fx-font-size: 20px;"); 
            GridPane.setHalignment(destination1[i], HPos.CENTER); 
            center_gp1[i].add(destination1[i], 7, 1);
            
            //total time required
            tot_time_req1[i] = new Label(al.get(i).getDuration());
            tot_time_req1[i].setStyle("-fx-font-size: 30px;-fx-font-weight: bold;");
            GridPane.setHalignment(tot_time_req1[i], HPos.CENTER); 
            center_gp1[i].add(tot_time_req1[i], 1, 5, 3, 1);
            
            //fare
            fare1[i] = new Label("Rs."+al.get(i).getFare());
            fare1[i].setStyle("-fx-font-size: 30px;-fx-font-weight: bold;-fx-text-fill:red"); 
            GridPane.setHalignment(fare1[i], HPos.CENTER); 
            center_gp1[i].add(fare1[i], 6, 5, 2, 1);
            
            book_btn1[i] =new RadioButton("Book");
            book_btn1[i].setToggleGroup(oneWayTrip_tg);
            //book_btn1[i].setStyle("-fx-font-size: 15px; -fx-background-color: #cccccc"); 
            center_gp1[i].add(book_btn1[i], 8, 7, 2, 1);            
            
            book_btn1[i].setOnAction(e->{
                System.out.println(oneWayTrip_tg.getToggles().indexOf(oneWayTrip_tg.getSelectedToggle()));  
            });
            sp1[i] = new StackPane();
            sp1[i].getChildren().addAll(r1[i], center_gp1[i]); 
            v1.getChildren().add(sp1[i]); 
            
        }
        if(trip.equals("Round Trip"))
        {System.out.println("Round trip size"+alr.size());
            for(i=0;i<alr.size();i++)
            {
                //setting primary properties required for gridPane
                center_gp2[i] = new GridPane();
                center_gp2[i].setAlignment(Pos.CENTER); 
                
                //background of gridPane
                r2[i] = new Rectangle();
                r2[i].setWidth(530); 
                r2[i].setHeight(230);
                   r2[i].setStyle("-fx-fill:white;-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 ); ");
            
                   
                //center_gp[i].setStyle("-fx-background-color: white");
                //setting gaps between rows and columns of grid 
                center_gp2[i].setHgap(10);
                center_gp2[i].setVgap(10);
                
                //padding of gridpane in scene
                center_gp2[i].setPadding(new Insets(5,5,5,5));
            
                //center_gp2[i].setGridLinesVisible(true);
            
                //end of setting primary properties required for gridPane
            
                //contents inside gridPane
            
                logo2[i] = new Image(Window.class.getResourceAsStream("air-logo.png"));
                logo_img_view2[i] = new ImageView(logo2[i]);
                
           
                //setting size of image logo
                logo_img_view2[i].setFitHeight(65);
                logo_img_view2[i].setFitWidth(65);
                GridPane.setHalignment(logo_img_view2[i], HPos.CENTER);
                GridPane.setValignment(logo_img_view2[i], VPos.CENTER);
                //adding logo image 
                center_gp2[i].add(logo_img_view2[i],0,0);
            
                //Adding flight name 
                flight_name2[i] = new Label("AeroSwing");
                flight_name2[i].setStyle("-fx-font-size: 15px;");
                GridPane.setHalignment(flight_name2[i], HPos.LEFT); 
                GridPane.setValignment(flight_name2[i], VPos.CENTER);
                center_gp2[i].add(flight_name2[i], 1, 0);
            
                flightNo2[i] = new Label(alr.get(i).getFlight_Number());
                flightNo2[i].setStyle("-fx-font-size: 15px;");
                GridPane.setHalignment(flightNo2[i], HPos.LEFT); 
                GridPane.setValignment(flightNo2[i], VPos.BOTTOM);
                center_gp2[i].add(flightNo2[i], 1, 0);
                
                time_src2[i] = new Label(alr.get(i).getDeparture_Time());
                time_src2[i].setStyle("-fx-font-size: 30px;-fx-font-weight: bold;");
                GridPane.setHalignment(time_src2[i], HPos.CENTER); 
                center_gp2[i].add(time_src2[i], 4, 0);
                
                time_dest2[i] = new Label(alr.get(i).getArrival_Time());
                time_dest2[i].setStyle("-fx-font-size: 30px;-fx-font-weight: bold;");
                GridPane.setHalignment(time_dest2[i], HPos.CENTER); 
                center_gp2[i].add(time_dest2[i], 7, 0);
            
                source2[i] = new Label(alr.get(i).getSourceCity());
                source2[i].setStyle("-fx-font-size: 20px;"); 
                GridPane.setHalignment(source2[i], HPos.CENTER); 
                center_gp2[i].add(source2[i], 4, 1);
                
                destination2[i] = new Label(alr.get(i).getDestinationCity());
                destination2[i].setStyle("-fx-font-size: 20px;"); 
                GridPane.setHalignment(destination2[i], HPos.CENTER); 
                center_gp2[i].add(destination2[i], 7, 1);
                
                //total time requworjired
                tot_time_req2[i] = new Label(alr.get(i).getDuration());
                tot_time_req2[i].setStyle("-fx-font-size: 30px;-fx-font-weight: bold;");
                GridPane.setHalignment(tot_time_req2[i], HPos.CENTER); 
                center_gp2[i].add(tot_time_req2[i], 1, 5, 3, 1);
            
                //fare
                fare2[i] = new Label("Rs."+alr.get(i).getFare());
                fare2[i].setStyle("-fx-font-size: 30px;-fx-font-weight: bold;-fx-text-fill:red"); 
                GridPane.setHalignment(fare2[i], HPos.CENTER); 
                center_gp2[i].add(fare2[i], 6, 5, 2, 1);
            
                book_btn2[i] =new RadioButton("Book");
                book_btn2[i].setToggleGroup(roundTrip_tg);
                //book_btn2[i].setStyle("-fx-font-size: 15px; -fx-background-color: #cccccc"); 
                center_gp2[i].add(book_btn2[i], 8, 7, 2, 1);            
            
                book_btn2[i].setOnAction(e->{
                    System.out.println(roundTrip_tg.getToggles().indexOf(roundTrip_tg.getSelectedToggle()));  
                });
                
                sp2[i] = new StackPane();
                sp2[i].getChildren().addAll(r2[i], center_gp2[i]); 
                v2.getChildren().add(sp2[i]);
            
            }
        }
        /*}catch(Exception ex) {
            System.out.println(ex);
        }
        */
        v1.setStyle("-fx-background-color: #cccccc"); 
        v2.setStyle("-fx-background-color: #cccccc"); 
        
        ScrollPane rootPane1 = new ScrollPane();
        rootPane1.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        rootPane1.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); 
        rootPane1.setFitToHeight(true);
        rootPane1.setFitToWidth(true); 
        //rootPane1.setVmax(2);
        //rootPane1.setHmax(2);
        //rootPane1.setVvalue(20);
        rootPane1.setContent(v1);  
        
        if(trip.equals("Round Trip"))
        {
            ScrollPane rootPane2 = new ScrollPane();
            rootPane2.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            rootPane2.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); 
            rootPane2.setFitToHeight(true);
            rootPane2.setFitToWidth(true); 
            //rootPane2.setVmax(2);
            //rootPane2.setHmax(2);
            //rootPane2.setVvalue(20);
            rootPane2.setContent(v2);
        
            hb.getChildren().addAll(rootPane1, rootPane2);
        }
        else
        {
            hb.getChildren().add(rootPane1); 
        }
        
        hb.setAlignment(Pos.CENTER); 
        hb.setStyle("-fx-background-color: #999999");
        
        bp.setCenter(hb);
        
        //End of center of Bottom Pane
        
        
        //****  Bottom of Border Pane  ****//
        HBox hbox = new HBox();
        
        Button back_btn = new Button("Back");
        back_btn.setPrefSize(300, 40);
        back_btn.setId("btn"); 
        
        back_btn.setOnAction(e->{
            
           w.start(primaryStage); 
           primaryStage.setScene(w.scene); 
           bp.setVisible(false);
           bp.setDisable(true); 
           w.page_1.setVisible(true);
           w.page_1.setDisable(false); 
           
        });
        
        next_btn = new Button("Next");
        next_btn.setPrefSize(300, 40); 
        next_btn.setId("btn");
        
        //setOnAction for next_btn 
        next_btn.setOnAction(e->{
            
            AllDetails db = new AllDetails();
            db.adults = adults;
            db.childs = childs;
            db.infants = infants;
            db.start(primaryStage); 
            primaryStage.setScene(db.s);
            bp.setVisible(false);
            bp.setDisable(true);
            
        });
       
        hbox.getChildren().addAll(back_btn, next_btn);
        hbox.setSpacing(100); 
        hbox.setPadding(new Insets(20, 20, 20, 20)); 
        hbox.setAlignment(Pos.CENTER); 
        hbox.setStyle("-fx-background-color: #999999;");
        bp.setBottom(hbox); 
        
        //End of Bottom of Border Pane
        
        fSearchScene = new Scene(bp, 1000, 600);
        fSearchScene.getStylesheets().add(Flights.class.getResource("Flights.css").toExternalForm());
    }
}
