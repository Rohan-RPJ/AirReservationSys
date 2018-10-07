/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package driver;

import java.sql.*;

/**
 *
 * @author akgy2
 */
public class DriverClass {
    private int flag;
    
    public setFlag(int status)
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
