/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import java.sql.SQLException;
import java.util.ArrayList;
import window.java.FlightData;
import window.java.Traveller;

/**
 *
 * @author garga
 */
public class TestFlight {
  public static void main(String args[]) throws SQLException
    {
        DriverFlight df=new DriverFlight();
        Traveller u =new Traveller();
        u.setToCity("Mumbai");
        u.setFromCity("New Delhi");
        u.setTrip("One Way Trip");
        u.setClassType("Economy");
        
        df.setTravellerData(u);
        ArrayList<FlightData> al=new ArrayList();
        al=df.getFlightRecords();
        for(int i=0;i<al.size();i++)
        {
            System.out.println("Record "+i);
            System.out.println("Flight Number"+al.get(i).getFlight_Number());
        }
        
        System.out.println("Driver object created");
        df.close();
    }  
}
