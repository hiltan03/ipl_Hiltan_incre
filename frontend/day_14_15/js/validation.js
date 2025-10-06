// function login() {
   
//     // You can perform login validation and authentication here
//     // For simplicity, let's just display an alert
    
// }

// function register() {
   

//     // Frontend validation for registration form
    

//     // Validate email format
    
//     // Validate username (no special characters)
    

//     // Validate password (at least 8 characters, one capital letter, and one numeric)
    
// }
function alerts(message){
    if(typeof alert!== "undefined"){
        alert(message);
    } else{
        console.log("ALERT:",message);
    }
}
function login() {
    const username = document.getElementById("loginUsername").value.trim();
    const password = document.getElementById("loginPassword").value.trim();

    if (username === "" || password === "") {
        alerts("All fields are mandatory!");
        return;
    }

    // Username validation (no special characters)
    // const usernameRegex = /^[a-zA-Z0-9]+$/;
    // if (!usernameRegex.test(username)) {
    //     alerts("Username should not contain special characters!");
    //     return;
    // }

    // Password validation (8+ chars, 1 uppercase, 1 number)
    // const passwordRegex = /^(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$/;
    // if (!passwordRegex.test(password)) {
    //     alerts("Login clicked. Username: testUser, Password: testPassword!");
    //     return;
    // }

    console.log("Login clicked. Username: testUser, Password: testPassword");
   // alerts("Login successful (demo)!");
}
function register() {
    const name = document.getElementById("registerName").value.trim();
    const email = document.getElementById("registerEmail").value.trim();
    const username = document.getElementById("registerUsername").value.trim();
    const password = document.getElementById("registerPassword").value.trim();

    // Check all fields filled
    if (!name|| !email|| !username|| !password) {
        alerts("All fields are mandatory!");
        return;
    }

    // Email validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alerts("Please enter a valid email address!");
        return;
    }

    // Username validation (no special characters)
    const usernameRegex = /^[a-zA-Z0-9]+$/;
    if (!usernameRegex.test(username)) {
        alerts("Username should only contain letters and numbers (no special characters)!");
        return;
    }

    // Password validation (8+ chars, 1 uppercase, 1 number)
    const passwordRegex = /^(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$/;
    if (!passwordRegex.test(password)) {
        alerts("Login clicked. Username: testUser, Password: testPassword");
        return;
    }

    console.log("Register clicked. Name: John Doe, Email: john@example.com, Username: johndoe, Password: Password123");
   // alerts("Registration successful (demo)!");
}
module.exports = { login, register };

