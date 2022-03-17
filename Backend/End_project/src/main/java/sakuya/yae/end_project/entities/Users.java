/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakuya.yae.end_project.entities;

/**
 *
 * @author SakuyaYae
 */
public class Users {
    private String user;
    private String password;

    /**
     *
     * @param user
     * @param password
     */
    public Users(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    /**
     *
     * @return
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
