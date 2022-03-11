const recipe_data = new Request("http://localhost:8080/End_project/api/recipe", {method:"GET", body: null});
const user_data = new Request("http://localhost:8080/End_project/api/user", {method:"GET", mode:"no-cors"});

function sakura_recipe_retrival(){
    var data;
    fetch(recipe_data).then((Response) => {
        if(Response.ok){
            return Response.text();
        }
        else{
            console.info("");
            console.info("Yuki");
            throw new Error(`HTTP error! Status: ${Response.status}`);
        }
    }).then((Response) => {
        console.info(Response);
        data = Response;
     });
     return data;
}

function sakura_user_retrival(){
    fetch(user_data).then((Response) => {if(Response.ok){
         return Response.text()
    }
    else{
        console.info("");
        console.info("yagyuu");
        throw new Error(`HTTP error! Status: ${Response.status}`);
    }
    })
}

function sakura_main(){
   // var user = sakura_user_retrival();
    var recipe = sakura_recipe_retrival();

    //console.info(user);
    console.info("====");
    console.info("====");
    console.info(recipe);
}

window.onload = sakura_main();