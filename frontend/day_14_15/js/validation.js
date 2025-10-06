function login() {
   
    // You can perform login validation and authentication here
    // For simplicity, let's just display an alert
    
}

function register() {
   

    // Frontend validation for registration form
    

    // Validate email format
    
    // Validate username (no special characters)
    

    // Validate password (at least 8 characters, one capital letter, and one numeric)
    
}
module.exports = { login, register };
function login() {
    let username = document.getElementById("loginUsername").value.trim();
    let password = document.getElementById("loginPassword").value.trim();

    if (username === "" || password === "") {
        alert("All fields are mandatory!");
        return;
    }

    // Username validation (no special characters)
    const usernameRegex = /^[a-zA-Z0-9]+$/;
    if (!usernameRegex.test(username)) {
        alert("Username should not contain special characters!");
        return;
    }

    // Password validation (8+ chars, 1 uppercase, 1 number)
    const passwordRegex = /^(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$/;
    if (!passwordRegex.test(password)) {
        alert("Password must be at least 8 characters long, contain one uppercase letter and one number!");
        return;
    }

    console.log("Login Details:", { username, password });
    alert("Login successful (demo)!");
}



// 🔹 REGISTRATION VALIDATION
function register() {
    let name = document.getElementById("name").value.trim();
    let email = document.getElementById("email").value.trim();
    let username = document.getElementById("username").value.trim();
    let password = document.getElementById("password").value.trim();

    // Check all fields filled
    if (name === "" || email === "" || username === "" || password === "") {
        alert("All fields are mandatory!");
        return;
    }

    // Email validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alert("Please enter a valid email address!");
        return;
    }

    // Username validation (no special characters)
    const usernameRegex = /^[a-zA-Z0-9]+$/;
    if (!usernameRegex.test(username)) {
        alert("Username should only contain letters and numbers (no special characters)!");
        return;
    }

    // Password validation (8+ chars, 1 uppercase, 1 number)
    const passwordRegex = /^(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$/;
    if (!passwordRegex.test(password)) {
        alert("Password must be at least 8 characters long, contain one uppercase letter and one number!");
        return;
    }

    console.log("Registration Details:", { name, email, username, password });
    alert("Registration successful (demo)!");
}
