function handleLogin (event){
    event.preventDefault();
    const email= document.getElementById ("email").value;
    const password= document.getElementById ("password").value;

    const user ={
        email:email,
        password:password
    };

    fetch("http://localhost:8000/api/users/login",{
        method: 'POST',
        headers :{
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(user)

    }).then(response=>{
        if(!response.ok){
            alert('login and/ password is incorrect');
        }
        return response.json();
    }).then ((response)=>{
        localStorage.setItem('connectedUser', JSON.stringify());
        window.location.href ='index.html'

    }).catch(error =>{
    console.erro('POST REQUEST ERR', error)
})
}






const loginForm = document.getElementById("loginForm")
loginForm.addEventListener ("submit", handleLogin);