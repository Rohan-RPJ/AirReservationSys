/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package driver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import window.java.User;
/**
 *
 * @author akgy2
 */
public class DriverClass {
    //stores the status of the operation
    private int flag;
    //stores the User object returned by getFormDetails()
    private User u;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
   public DriverClass(){
        con =null;
        st= null;
        try{
            
            //registering the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        }
        catch(ClassNotFoundException e)
                {
            System.out.println("Driver registration error!");
            System.exit(1);
        }
        try{
            //loading the properties file
            InputStream is ;
            is= DriverClass.class.getResourceAsStream("/driver/userdb.properties");
            Properties prop = new Properties();
            if(is!=null)
            {//prop.load(new FileInputStream("userdb.properties"));
            prop.load(is);
                System.out.println("User id"+prop.getProperty("user"));
                System.out.println("Password "+prop.getProperty("password"));
                System.out.println("url "+prop.getProperty("dburl"));
            }
            else{System.out.println("Properties file error");}
            
            String user = prop.getProperty("user");
            String password= prop.getProperty("password");
            String dburl= prop.getProperty("dburl");
            
            con= DriverManager.getConnection(dburl, user, password);
            
             System.out.println("Creating statement...");
                st = con.createStatement();
                String sql;
                //sample query
                sql = "SELECT * FROM userData";
                rs = st.executeQuery(sql);
                
                while(rs.next())
                    {
                        String uid= rs.getString("userId");
                        System.out.println("User id:"+uid);
                    }
                
                
           // rs.close();
           // st.close();
           // con.close();
                }
        catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Unknown error");
            e.printStackTrace();
        }
        
        finally{
      //finally block used to close resources
            /*try{
            if(st!=null)
              st.close();
         }
           catch(SQLException se2){
            }// nothing we can do
      try{
         if(con!=null)
            con.close();
      }catch(SQLException se){
         se.printStackTrace();
      
      }*///end finally try
   }//end try
    
    }//end of constructor
    
    public void setUserData(User u)
    {
        this.u=u;
    }
    
    public void setFlag(int status)
    {
        flag =  status;
    }
    public void checkRecord()
    {
        String sql= "SELECT userId, mobileno, email FROM userData WHERE "+
                        "userId='"+u.getUserId()+"' OR "+
                        "email='"+u.getEmail()+"' OR "+
                        "mobileno='"+u.getMobileNo()+"'";
        System.out.println("Sent check record sql is: "+sql);
        try {
            rs = st.executeQuery(sql);
            
            
        if(!rs.next()) //no previous record exists
        {
            setFlag(1);
            
        }
        else
        {
            while(rs.next())
            {
                String uid,mobileno,email;
                uid= rs.getString("userId");
                mobileno= rs.getString("mobileno");
                email=rs.getString("email");
                
                if(u.getUserId().equals(uid)){
                    setFlag(-1);
                }
                else if(u.getEmail().equals(email)){
                    setFlag(0);
                }
                else if(u.getMobileNo().equals(mobileno)){
                    setFlag(-2);
                }
            }
        }
        
       } catch (SQLException ex) {
        ex.printStackTrace();
        }
        
    }
    
    public void insertRecord()
    {
        try {
            String sql= "INSERT INTO userData VALUES('"+
                    u.getUserId()+"', "+
                    "SHA1('"+u.getPassword()+"'), '"+
                    u.getFirstName()+"','"+
                    u.getMiddleName()+"','"+
                    u.getLastName()+"','"+
                    u.getMobileNo()+"','"+
                    u.getEmail()+"','"+
                    u.getResAddress()+"','"+
                    u.getDob()+"',"+
                    u.getPin()
                    +")";
            System.out.println("Sent sql is: "+sql);
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();}
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
        return flag;
    }
    
    public void close()
    {
       try{
           if(con!=null)
            con.close();} catch(SQLException e){}
        try {
                if(st!=null)
            st.close();} catch(SQLException e){}
        try {   if(st!=null)
                rs.close();}catch(SQLException e){}
    }
   
}
