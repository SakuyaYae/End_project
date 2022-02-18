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
public class Recipe_Builder {
    private String title;
    private String description;
    private String category;
    private String guide;
    private String ingrediens;
    private String username;
    private String image;
    
    public String getTitle() {
        return title;
    }

    public Recipe_Builder Title(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Recipe_Builder Description(String description) {
        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Recipe_Builder Category(String category) {
        this.category = category;
        return this;
    }

    public String getGuide() {
        return guide;
    }

    public Recipe_Builder Guide(String guide) {
        this.guide = guide;
        return this;
    }

    public String getIngrediens() {
        return ingrediens;
    }

    public Recipe_Builder Ingrediens(String ingrediens) {
        this.ingrediens = ingrediens;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Recipe_Builder Username(String username) {
        this.username = username;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Recipe_Builder Image(String image) {
        this.image = image;
        return this;
    }
    public Recipe Build(){
        return new Recipe(this);
    }
}
