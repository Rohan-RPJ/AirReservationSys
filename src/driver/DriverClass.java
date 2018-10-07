/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package driver;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import window.java.User;
/**
 *
 * @author akgy2
 */
public class DriverClass {
    //stores the status of the operation
    private int flag;
    //stores the User object returned by getFormDetails()
    private User u=new User();
    private Connection con;
    private Statement st;
    
    DriverClass(){
        con =null;
        st= null;
        try{
            
            //registering the driver
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch(ClassNotFoundException e)
                {
            System.out.println("Driver registration error!");
            System.exit(1);
        }
        try{
            //loading the properties file
            Properties prop = new Properties();
            prop.load(new FileInputStream("userdb.properites"));
            
            String user = prop.getProperty("user");
            String password= prop.getProperty("password");
            String dburl= prop.getProperty("dburl");
            
            con= DriverManager.getConnection(dburl, user, password);
        
                }
        catch(Exception e){
        
        }
    }
    public void setUserData(User u)
    {
        this.u=u;
    }
    
    public void setFlag(int status)
    {
        flag =  status;
    }
    /**
     *returns the flag for success of entry of data into the db. Flag represents:
     *  1 - successful
     *  0 - email exists 
     * -1 - username exists
     * -2 - mobile number already exits
     **/
    public int getStatus()
    {
        return flag
    }
}
