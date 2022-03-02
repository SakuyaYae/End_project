function main(){
  console.info("Sakura")
  header_menu()
}

function header_menu(){
  var header = document.getElementById("header");
  var nav_menu;
  var h1;
  h1 = create_h1();
  nav_menu = nav_bar();
  header.appendChild(h1);
  header.appendChild(nav_menu);
}

function create_h1(){
  var h1 = document.createElement("h1");
  var h1_text = document.createTextNode("Sakura");
  var h1_link = create_h1_a();
  h1.appendChild(h1_text);
  h1_link.appendChild(h1);
  return h1_link;
}

function create_h1_a(){
  var h1_a = document.createElement("a");
  h1_a.href = "home.html";
  return h1_a;
}

function nav_bar(){
  var nav_bar = create_nav();
  var list = create_list(2);
  nav_bar.appendChild(list);
  return nav_bar;
}

function create_nav(){
  var nav  = document.createElement("nav");
  return nav;
}

function create_list(nr_of_li){
  var ul = document.createElement("ul");
  var li = [];
  var li_text = [];
  
  for (var i = 0; i < nr_of_li; i++) {
    li[i] = document.createElement("li");
    li_text[i] = create_a(i);
  }
  
  for (var i = 0; i < li.length; i++) {
    li[i].appendChild(li_text[i]);
  }
  
  for (var i = 0; i < li.length; i++) {
    ul.appendChild(li[i]);
  }
  
  return ul;
}

function create_a(option_num){
  var a = document.createElement("a");
  var option = ["Sign up","Login", ""];

  if(option_num == 0){
    a.href = "Sign_up.html";
  }

  if (option_num == 1) {
    a.href = "login.html";
  }

  if(option_num > 2){
    option_num = 2;
  }

  var a_text = document.createTextNode(option[option_num]);
  a.appendChild(a_text);
  return a;
}

window.onload = main();
