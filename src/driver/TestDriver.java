/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;
/**
 *
 * @author akgy2
 */
import window.java.User;
public class TestDriver {
    public static void main(String args[])
    {
        DriverClass dc=new DriverClass();
        User u =new User();
        u.setFirstName("abhi");
        u.setMiddleName("s");
        u.setUserId("akg");
        u.setPassword("lol12345");
        u.setLastName("Hola");
        u.setMobileNo("1234567890");
        u.setResAddress("bhayander");
        u.setEmail("ab@ab.com");
        u.setDob("2017-07-07");
        u.setPin("123456");
        dc.setUserData(u);
        dc.checkRecord();
        System.out.println("Status: "+dc.getStatus());
        if(dc.getStatus()==1)
        {dc.insertRecord();
        System.out.println("Record inserted");}
        
        System.out.println("Driver object created");
    }
}
