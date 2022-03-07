const data = new Request("localhost8080://sakuya/yae/end_project/api/recipe");

function sakura_data_retrival(){
    fetch(data).then((Response) => {if (Response.ok) {
        return Response.json();
    }
    else{
        throw new Error(`HTTP error! Status: ${ Response.status }`);
    }})
    console.info("sakura")
}