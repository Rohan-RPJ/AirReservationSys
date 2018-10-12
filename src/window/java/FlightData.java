
package window.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HP
 */
public class FlightData
{
    public String Flight_Number,Airlines,Source,Destination,Departure_Time,Arrival_Time,Fare, duration;
    
      public void setFlight_Number(String Flight_Number)
    {
        this.Flight_Number=Flight_Number;
    }
    public void setSourceCity(String Source)
    {
        this.Source=Source;
    }
    public void setDestinationCity(String Destination)
    {
        this.Destination=Destination;
    }
    public void setAirlines(String Airlines)
    {
        this.Airlines=Airlines;
    }
    public void setDeparture_Time(String Departure_Time)
    {
        this.Departure_Time=Departure_Time;
    }
    public void setArrival_Time(String Arrival_Time)
    {
        this.Arrival_Time=Arrival_Time;
    }
    public void setFare(String Fare)
    {
        this.Fare=Fare;
    }
     
    //getter functions 
    public String getFlight_Number()
    {
         return Flight_Number;
    }
    public String getAirlines()
    {
        return Airlines;
    }
    public String getSourceCity()
    {
        return Source;
    }

    public String getDestinationCity()
    {
        return Destination;
    }

    public String getDeparture_Time()
    {
        return Departure_Time;
    }
    public String getArrival_Time()
    {
        return Arrival_Time;
    }
    public String getFare()
    {
        return Fare;
    }
    
    public String getDuration() throws ParseException
    {
        String time1 =getArrival_Time();
        String time2 =getDeparture_Time();

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime();
    
    
        String hours= Long.toString(difference/(1000*60*60));
        String mins=Long.toString((difference/(1000*60))%60);
    
        return(hours+"h "+mins+"m");
    
    }
}    