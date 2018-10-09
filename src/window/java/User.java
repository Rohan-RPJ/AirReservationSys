/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window.java;

/**
 *
 * @author akgy2
 */
public class User{
    //all the fields
    private String userId, password, firstName, lastName , middleName, gender, pin;
    private String occupation, country, email, mobileNo, nationality , resAddress;
    private String dob;
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
    
    public void setGender(String gender)
    {
        this.gender=gender;
    }
    public void setPin(String pin)
    {
        this.pin=pin;
    }
    //NOtE: date setter() and date field not added yet
    
    public void setDob(String dob)
    {
        this.dob=dob;
    }
    
    
    //getter functions 
    public String getUserId()
    {
         return userId;
    }
    public String getPin()
    {
        return pin;
    }
    public String getPassword()
    {
        return password;
    }

    public String getGender()
    {
        return gender;
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
    public String getDob()
    {
        return dob;
    }
} 

