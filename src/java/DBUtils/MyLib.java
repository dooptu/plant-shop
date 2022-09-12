/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LENOVO
 */
public class MyLib {
    //ham nay de tao connection tu ung dung toi SQL
    public static Connection makeConnection() throws Exception{
        // su dung neu co static va co throws Exception thi phai try catch
        // try
        // Connection conn = Mylib.makeConnection
        //catch
        Connection cn=null;
        String IP="localhost";
        String instanceName="TUNGUYEN\\TUNGUYEN";
        String port="1433";
        String uid="sa";
        String pwd="12345";
        String db="PlantShop";
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://" +IP+"\\"+ instanceName+":"+port
                 +";databasename="+db+";user="+uid+";password="+pwd;
        Class.forName(driver);
        cn=DriverManager.getConnection(url);
        return cn;
        
    }
}
