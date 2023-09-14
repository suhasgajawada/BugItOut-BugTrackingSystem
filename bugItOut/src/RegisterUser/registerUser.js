
document.addEventListener("DOMContentLoaded", function () {
    // Simulate some loading time (you can replace this with actual loading logic)
    setTimeout(function () {
        // Hide the preloader
        document.querySelector(".preloader").style.display = "none";

        // Show the login page
        document.querySelector(".register-page").style.display = "block";
    }, 2000); // 2000 milliseconds (2 seconds) delay for the demo
});


function checkPasswords() {
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;

    // Define a regular expression to check for a strong password
    var strongPasswordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    if (strongPasswordRegex.test(password)) {
        if (password == confirmPassword) {
            alert('Passwords match!');
            window.location.href="../login/login.html";
        } else {
            alert('Passwords do not match. Please try again.');
        }
    } else {
        alert('Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character.');
    }
}