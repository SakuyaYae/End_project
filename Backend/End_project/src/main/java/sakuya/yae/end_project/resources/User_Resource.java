/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakuya.yae.end_project.resources;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import sakuya.yae.end_project.beans.User_bean;
import sakuya.yae.end_project.entities.Users;

/**
 *
 * @author SakuyaYae
 */
@Path("user")
public class User_Resource {
    @EJB
    User_bean user_bean;
    
    /**
     * GET method function for validating a user
     * @param authorization
     * @return  Response status 201 if user is is a valid user otherwise Response status 401
     */
    @GET
    public Response check_user(@HeaderParam("Authorization") String authorization){
        Users user = user_bean.createUser(authorization);
        if(user_bean.checkUser(user)){
            return Response.status(Response.Status.CREATED).build();
        }
        else{
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
    
    /**
     *  POST method function for creating user
     * @param authorization
     * @return Response status 201 if user was craated succsefuly otherwise Response status 400
     */
    @POST
    public Response create_user(@HeaderParam("Authorization") String authorization){
        Users user = user_bean.createUser(authorization);
        if(user_bean.saveUser(user) == 1){
            return Response.status(Response.Status.CREATED).build();
        }
        else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
