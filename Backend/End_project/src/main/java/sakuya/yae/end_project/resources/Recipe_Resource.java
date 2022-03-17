/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakuya.yae.end_project.resources;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sakuya.yae.end_project.beans.Recipe_Bean;
import sakuya.yae.end_project.entities.Recipe;

/**
 *
 * @author SakuyaYae
 */
 @Produces(MediaType.APPLICATION_JSON)
 @Path("recipe")
 @Consumes(MediaType.APPLICATION_JSON)
public class Recipe_Resource {
    
    @EJB
    Recipe_Bean recipe_bean;

    /**
     * Function for GET method that sends data from the database if there is any
     * @return A response status code 200 or 204
     */
    @GET
    public Response getRecipe(){
        List<Recipe> recipe = recipe_bean.getRecipe();
        if(recipe.size() > 0){
            return Response.status(Response.Status.OK).entity(recipe).build();
    }
        else{
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
    
    /**
     * Function for POST method
     * @param recipe
     * @return A response status code 201 or 400
     */
    @POST
    public Response postRecipe(Recipe recipe){
        if(recipe_bean.postRecipe(recipe)){
            return Response.status(Response.Status.CREATED).build();
        }
        else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
