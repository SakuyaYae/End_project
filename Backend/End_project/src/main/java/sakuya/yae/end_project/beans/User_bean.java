/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakuya.yae.end_project.beans;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import javax.ejb.Stateless;
import sakuya.yae.end_project.Connection_Factory;
import sakuya.yae.end_project.entities.Users;

/**
 *
 * @author SakuyaYae
 */
@Stateless
public class User_bean {

    /**
     * Function for createing User objects from a basic auth String
     * @param user_data
     * @return A User object whit a username and password
     */
    public Users createUser(String user_data){
        user_data = user_data.substring(6).trim();
        
        byte bytes[] = Base64.getDecoder().decode(user_data);
        user_data = new String(bytes);
        int data_separetor = user_data.indexOf(":");
        String username = user_data.substring(0, data_separetor);
        String password = user_data.substring(data_separetor + 1);
        return new Users(username, password);
    }
    
    /**
     * Function for verifying users
     * @param user
     * @return true if user exists in the database or false otherwise
     */
    public boolean checkUser(Users user){
          try(Connection con = Connection_Factory.getconnection()){
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1, user.getUser());
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                String bcryped_hash_str = res.getString("pass");
                BCrypt.Result data = BCrypt.verifyer().verify(user.getPassword().toCharArray(), bcryped_hash_str);
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println("failed to veryfi user" + e.getMessage());
            return false;
        }
    }
    
    /**
     * Function for saving users in the database
     * @param user
     * @return number of row affected in the database
     */
    public int saveUser(Users user){
        try(Connection con = Connection_Factory.getconnection()){
            String Hashed_password = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
            PreparedStatement stmt = con.prepareStatement("INSERT INTO users(username, pass) VALUES(?, ?)");
            stmt.setString(1, user.getUser());
            stmt.setString(2, user.getPassword());
            return stmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println("error in saveing user" + e.getMessage());
            return 0;
        }
    }
}
