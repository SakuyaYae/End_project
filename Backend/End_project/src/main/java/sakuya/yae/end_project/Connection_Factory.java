/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakuya.yae.end_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SakuyaYae
 */
public class Connection_Factory {
    
    /**
     *
     * @return a conection to a local database
     * @throws ClassNotFoundException can not find classes that is needed
     * @throws SQLException sql errors
     */
    public static Connection getconnection() throws ClassNotFoundException, SQLException{
        String user = "samuel";
        String pssword = "6.z(D5$=FQPN";
        String url = "jdbc:mysql://localhost/saumel";
        Class.forName("com.mysql.jdbc.Driver");
        return (Connection)DriverManager.getConnection(url, user, pssword);
    }
}
