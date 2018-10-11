/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window.java;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
    
    @Override
    public void start(Stage primaryStage)
    {
      
        Traveller t = new Traveller();
        
        bp = new BorderPane();
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
        top_gp.add(child_lbl, 4, 3);
        top_gp.add(infant_lbl, 5, 3);
        //
        
        //
        tot_adult = new Label(adults);
        GridPane.setHalignment(tot_adult, HPos.CENTER);
        
        tot_child = new Label(childs);
        GridPane.setHalignment(tot_child, HPos.CENTER);
        
        tot_infant = new Label(infants);
        GridPane.setHalignment(tot_infant, HPos.CENTER);
        
        top_gp.add(tot_adult, 3, 4);
        top_gp.add(tot_child, 4, 4);
        top_gp.add(tot_infant, 5, 4);
        //
        
        
        fSearchScene = new Scene(bp, 1000, 600);
    }
}
