function main(){
    nav()
}
function nav(){
  var header;
  var nav;
  var h1;
  h1 = create_h1();
  nav = nav_bar();
  header.appendChild(h1);
  header.appendChild(nav);
}

function create_h1(){
  var h1 = document.createElement("h1");
  var h1_text = document.createTextNode("Sakura");
  h1.appendChild(h1_text);
  return h1;
}

function nav_bar(){
    var nav = create_nav();
    var list = create_list(1);
    nav.appendChild(list);
    return nav;
}

function create_list(nr_of_li){
    var ul = document.createElement("ul");
    var li = [];
    var li_text = [create_a()];
  
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
  var option = ["Sign up","Login"];
  var a_text = document.createTextNode(option[option_num]);
  a.appendChild(a_text);
  return a;
}



window.onload = main();
