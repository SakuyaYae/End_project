function main(){
  console.info("Sakura")
  recipe(2);
}

function recipe(number_of_recipes){
  var main = document.getElementById("main");
  var recipe;
  for (var i = 0; i < number_of_recipes; i++) {
    recipe = create_recipe(i);
    main.appendChild(recipe);
  }
}

function create_recipe(img_num){
  var header2;
  var paragraf;
  var section;
  var image;
  section = create_section();
  image = create_img(img_num);
  paragraf  = create_paragaf();
  header2 = create_h2();

  section.appendChild(header2);
  section.appendChild(image);
  section.appendChild(paragraf);
  return section;
}

function create_section(){
  var section = document.createElement("section");
  return section;
}

function create_img(img_num){
  var img_list = img_list = ["img/anime_kitsune.jpg", "img/anime.jpg"];
  var img = document.createElement("img");
  img.src = img_list[img_num];
  return img;
}

function create_paragaf(){
  var p = document.createElement("p");
  var p_text = document.createTextNode("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
  p.appendChild(p_text);
  return p;
}

function create_h2(){
    var h2 = document.createElement("h2");
    var h2_text = document.createTextNode("Temp Food");
    h2.appendChild(h2_text);
    return h2;
}
window.onload = main()
