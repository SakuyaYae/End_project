function main(){
  var upload = document.getElementById("upload");
  upload.onclick = post_recipe;
  console.info("Sakura")
}

function post_recipe(){
  var recipe_input = user_input();
  send_data(recipe_input);
  console.info("====")
}

function user_input(){
  var title = document.getElementById("title");
  var description = document.getElementById("description");
  var ingrediens = document.getElementById("ingrediens");
  var categories = document.getElementById("categories");
  var step_by_setp_guide = document.getElementById("step_by_setp_guide");
  var img = document.getElementById("img");
  var recipe_data = [title, description, ingrediens, categories, step_by_setp_guide, img];

  for(var i = 0; i < recipe_data.length; i++){
    recipe_data[i] = String(recipe_data[i].value)
  }

  return recipe_data;
}

function send_data(recipe){
  for(var i = 0; i < recipe.length; i++){
    console.info(recipe[i])
  }
}

window.onload = main()
