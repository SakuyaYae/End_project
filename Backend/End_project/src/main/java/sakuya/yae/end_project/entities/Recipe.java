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
public class Recipe {
    private String title;
    private String description;
    private String category;
    private String guide;
    private String ingrediens;
    private String username;
    private String image;

    public Recipe(String title, String description, String category, String guide, String ingrediens, String username, String image) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.guide = guide;
        this.ingrediens = ingrediens;
        this.username = username;
        this.image = image;
    }

    public Recipe() {
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getIngrediens() {
        return ingrediens;
    }

    public void setIngrediens(String ingrediens) {
        this.ingrediens = ingrediens;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
    
}
