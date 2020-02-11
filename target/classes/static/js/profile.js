const baseUrl = "http://localhost:8080";
const defaultImage = "images/users/default.jpg"

window.onload = getInformation;
document.getElementById("logout").addEventListener("click", deleteToken);

function getInformation(){
    const token = localStorage.getItem('token');
        fetch(baseUrl+"/user", {
            method: "GET",
            headers: {Authorization: token}
        })
        .then(response => response.json())
        .then(data => {
            /*if(!data.message)
                //Something went wrong probably jwt expired?
                localStorage.removeItem("token");
            else
            console.log(data);*/
            constructProfile(data)
        })
}

function constructProfile(data){
    document.getElementById("name").innerHTML = data.name;
    document.getElementById("username").innerHTML = data.username;
    document.getElementById("signupDate").innerHTML = data.signupDate;
    let imageContainer = document.getElementById("image-container");

    let image = document.createElement("img");
    image.id = "image";

    if(data.imageUrl)
        image.src = data.imageUrl;
    else
        image.src = defaultImage;
        
    imageContainer.appendChild(image);
}

function deleteToken(){
    const token = localStorage.getItem('token');
    if(token){
        localStorage.removeItem("token")
        window.location.replace("http://localhost:8080/home");
    }
}
