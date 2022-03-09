const recipe_data = new Request("http://localhost:8080/End_project/api/recipe");
const user_data = new Request("http://localhost:8080/End_project/api/user");

function sakura_recipe_retrival(){
    fetch(recipe_data).then((Response) => {if(Response.ok){
        return Response.json();
    }
    else{
        throw new Error(`HTTP error! Status: ${Response.status}`);
    }
    })
    console.info("sakura")
    return "recipe Error";
}

function sakura_user_retrival(){
    fetch(user_data).then((Response) => {if(Response.ok){
        return Response.json();
    }
    else{
        throw new Error(`HTTP error! Status: ${Response.status}`);
    }
    })
    console.info("sakura")
    return " user error";
}

function sakura_main(){
    var user = sakura_user_retrival();
    var recipe = sakura_recipe_retrival();

    console.info(user);
    console.info("====");
    console.info("====");
    console.info(recipe);
}

window.onload = sakura_main();