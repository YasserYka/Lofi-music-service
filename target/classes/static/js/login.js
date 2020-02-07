const baseUrl = "http://localhost:8080"
document.getElementById('submit').addEventListener('click', handleLogin);

function handleLogin(){
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    fetch(baseUrl+"/authenticate", {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        credentials: 'same-origin',
        body: JSON.stringify({"username":username ,"password" : password})
    }).then(response => {

        if(response.status !== 200){
            throw new Error(response.status);
        }
        else
            return response;

    }).then(response => {

            response.json().then(data => {
                localStorage.setItem('token', data.jwt);
                window.location.replace("http://localhost:8080/home");
            })
            .catch(error => {
                console.log(error);
            })

    }).catch(error => {
        showErrorMessage(error);
    })
};
function showErrorMessage(error){
    alert("Something went wrong please make sure to enter the right username and password");
    console.log(error);
}