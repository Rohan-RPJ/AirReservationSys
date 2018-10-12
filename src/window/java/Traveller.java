/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window.java;

/**
 *
 * @author HP
 */
public class Traveller{
    //all the fields
    private String trip, fromCity, toCity, classType, departDate, returnDate;
    private String adults, childs, infants;
    public int adult, child, infant;
    //Setter methods for all the fields

    public void setTrip(String trip)
    {
        this.trip=trip;
    }
    public void setFromCity(String fromCity)
    {
        this.fromCity=fromCity;
    }
    public void setToCity(String toCity)
    {
        this.toCity=toCity;
    }
    public void setClassType(String classType)
    {
        this.classType=classType;
    }
    public void setDepartDate(String departDate)
    {
        this.departDate=departDate;
    }
    public void setReturnDate(String returnDate)
    {
        this.returnDate=returnDate;
    }
    public void setAdults(String adults)
    {
        this.adults=adults;
    }
    public void setChilds(String childs)
    {
        this.childs=childs;
    }
    public void setInfants(String infants)
    {
        this.infants=infants;
    }
    
    //getter functions 
    public String getTrip()
    {
         return trip;
    }
    public String getFromCity()
    {
        return fromCity;
    }
    public String getToCity()
    {
        return toCity;
    }

    public String getClassType()
    {
        return classType;
    }

    public String getDepartDate()
    {
        return departDate;
    }
    public String getReturnDate()
    {
        return returnDate;
    }
    public String getAdults()
    {
        return adults;
    }
    public String getChilds()
    {
        return childs;
    }
    public String getInfants()
    {
        return infants;
    }
} 

