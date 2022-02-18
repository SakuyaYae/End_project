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
public class Recipe_Resource {
    @EJB
    Recipe_Bean recipe_bean;
    
        @GET
    public Response getManga(){
        
        if(.size() > 0){
            return Response
                .ok()
                .build();
    }
        else{
            return Response
                .noContent()
                .build();
        }
    }
    @POST
    public Response postManga(Recipe recipe){
        if(recipe_bean.postRecipe(recipe)){
            return Response.status(Response.Status.CREATED).build();
        }
        else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
