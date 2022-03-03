function main(){
  console.info("Sakura")
  recipe();
}

function recipe(){
  var main = document.getElementById("main");
  var recipe;
  recipe = create_recipe();
  main.appendChild(recipe);
}

function create_recipe(){
  var section = create_section();
  var image = create_img();
  var paragraf  = create_paragaf();
  var header2 = create_h2();
  var h3 = create_h3();
  var list = create_list(10);

  section.appendChild(header2);
  section.appendChild(image);
  section.appendChild(h3);
  section.appendChild(list);
  section.appendChild(paragraf);
  return section;
}

function create_section(){
  var section = document.createElement("section");
  return section;
}

function create_img(){
  var img = document.createElement("img");
  img.src = "img/anime_kitsune.jpg";
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

function create_h3(){
    var h3 = document.createElement("h3");
    var h3_text = document.createTextNode("Meat");
    h3.appendChild(h3_text);
    return h3;
}

function create_list(nr_of_li){
  var ul = document.createElement("ul");
  var li = [];
  var li_text = [];

  for (var i = 0; i < nr_of_li; i++) {
    li[i] = document.createElement("li");
    li_text[i] = document.createTextNode("x lorem");
  }

  for (var i = 0; i < li.length; i++) {
    li[i].appendChild(li_text[i]);
  }

  for (var i = 0; i < li.length; i++) {
    ul.appendChild(li[i]);
  }

  return ul;
}
// currently unused function
function create_button(){
  var button = document.createElement("button");
  var button_text = document.createTextNode("Like");
  button.appendChild(button_text);
  return button;
}
// currently unused function
function create_comment_box(){
  var comment_box = document.createElement("div");
  var user_input = create_input();
  var user_comments = create_comments();
  comment_box.id = "comment_container"
  comment_box.appendChild(user_input);
  comment_box.appendChild(user_comments);
  return comment_box;
}

function create_input(){
  var input = document.createElement("input");
  input.type = "text";
  input.placeholder = "Comments";
  return input;
}

function create_comments(){
  var comments = document.createElement("p");
  var comment_text = document.createTextNode("Sakuya");
  comments.appendChild(comment_text);
  return comments;
}

window.onload = main()
