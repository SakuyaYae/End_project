/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakuya.yae.end_project.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
    
    
    
        public List<Recipe> getRecipe(){
            List<Recipe> Recipe_list = new ArrayList<>();
            try(Connection con = Connection_Factory.getconnection()){
            
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM `recipe`");
                ResultSet result = stmt.executeQuery();
            
                while(result.next()){
                    String title = result.getString("title");
                    String description = result.getString("descriptions");
                    String category = result.getString("category");
                    String guide = result.getString("guide");
                    String ingrediens = result.getString("ingrediens");
                    String username= result.getString("username");
                    String image = result.getString("image");
                    
                    Recipe recipe = new Recipe_Builder()
                                    .Title(title)
                                    .Description(description)
                                    .Category(category)
                                    .Guide(guide)
                                    .Ingrediens(ingrediens)
                                    .Username(username)
                                    .Image(image)
                                    .Build();
                    
                    Recipe_list.add(recipe);
                }
            }
            catch(Exception e){
                System.out.println("Recipe_Bean.getRecipe: " + e.getMessage());
            }
            return Recipe_list;
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
