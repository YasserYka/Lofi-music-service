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
            console.log("WORNG USERNAME OR PASSWORD");
        }

        response.json().then(data => {
            console.log("RECEIVED: ", data);
            localStorage.setItem('token', data.jwt);
        })
        .catch(error => {
            console.log("SOMETHING WENT WRONG: ", error);
        })
    })
};
