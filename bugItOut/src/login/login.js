
const users =[{
  "email": " ajay@gmail.com",
  "password": "password1",
  "role": "Manager"
},
{
  "email": "arjunrampaul@gmail.com",
  "password": "password2",
  "role": "Developer"
},
{
  "email": "Sathyapathy@gmail.com",
  "password": "password3",
  "role": "Tester"
},
{
  "email": "krishnakumar@gmail.com",
  "password": "password4",
  "role": "FreeDeveloper"
}

]
document.getElementById('login_form').addEventListener('submit', function (e) {
  e.preventDefault(); // Prevent form submission
  
  const email = document.getElementById('email').value;
  const password = document.getElementById('pass').value;
  
  
  
 
  const user = users.find(u => u.email === email && u.password===password);
  if (user) {
    
    // Redirect to main page based on user's role
    switch (user.role) {
      case 'Tester':
        window.location.href = '/BugItOut-BugTrackingSystem/bugItOut/src/TesterMainPage/index.html'; // Replace with the actual admin page URL
        break;
      case 'Developer':
        window.location.href = '/BugItOut-BugTrackingSystem/bugItOut/src/DeveloperMainPage/developersMainPage.html';
        // Replace with the actual user page URL
        break;
      case 'Manager':
        window.location.href = '/BugItOut-BugTrackingSystem/bugItOut/src/ProjectManagerPage/Index.html';// Replace with the actual user page URL
        break;
      case 'FreeDeveloper':
        window.location.href = '/BugItOut-BugTrackingSystem/bugItOut/src/DeveloperMainPage/freeDevlopersMainPage.html';
        break;



    }
  } else {
    document.getElementById('status').textContent = 'Invalid email or password';
  }
});
