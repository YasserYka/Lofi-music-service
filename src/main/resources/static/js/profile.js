const baseUrl = "http://localhost:8080";

window.onload = getInformation;

function getInformation(){
    const token = localStorage.getItem('token');
    console.log(token);
    if(token){
        fetch(baseUrl+"/user", {
            method: "GET",
            headers: {Authorization: token}
        })
        .then(response => response.json())
        .then(data => {
            /*if(!data.message)
                //Something went wrong probably
                localStorage.removeItem("token");
            else*/
                console.log(data);
        })
    }
}