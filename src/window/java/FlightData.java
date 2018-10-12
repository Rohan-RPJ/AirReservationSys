
package window.java;

/**
 *
 * @author HP
 */
public class FlightData
{
    public String Flight_Number,Airlines,Source,Destination,Departure_Time,Arrival_Time,Fare;
    
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
}    