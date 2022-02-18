/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakuya.yae.end_project.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ejb.Stateless;
import sakuya.yae.end_project.Connection_Factory;
import sakuya.yae.end_project.entities.Recipe;
import sakuya.yae.end_project.entities.Recipe_Builder;

/**
 *
 * @author SakuyaYae
 */
@Stateless
public class Recipe_Bean {
    
    
    
        public Recipe getManga(){
        
        try(Connection con = Connection_Factory.getconnection()){
            
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `recipe` ");
            ResultSet result = stmt.executeQuery();
            
            while(result.next()){
                String title = result.getString("title");
                String description = result.getString("description");
                String category = result.getString("category");
                String guide = result.getString("guide");
                String ingrediens = result.getString("ingrediens");
                String username= result.getString("username");
                String image = result.getString("image");
                Recipe recipe = new Recipe_Builder().Title(title)
                        .Description(description)
                        .Category(category)
                        .Guide(guide)
                        .Ingrediens(ingrediens)
                        .Username(username)
                        .Image(image)
                        .Build();
            }
        }catch(Exception e){
        System.out.println("MangaBean.getmanga: " + e.getMessage());
        }
        return MangaList;
    }

        public boolean postRecipe(Recipe recipe){
            boolean success = false;
            try(Connection con = Connection_Factory.getconnection()){
            
                PreparedStatement stmt = con.prepareStatement("INSERT INTO recipe(description, title, guide, username, category, image, ingrediens) VALUES(?, ?, ?, ?, ?, ?, ?)");
                stmt.setString(1, recipe.getDescription());
                stmt.setString(2, recipe.getTitle());
                stmt.setString(3, recipe.getGuide());
                stmt.setString(4, recipe.getUsername());
                stmt.setString(5, recipe.getCategory());
                stmt.setString(6, recipe.getImage());
                stmt.setString(7, recipe.getIngrediens());
                success = stmt.executeUpdate() > 0;
            
           
            }
            catch(Exception e){
                System.out.println("Recipe_Bean.postRecipe: " + e.getMessage());
            }
        return success;
    }
}
