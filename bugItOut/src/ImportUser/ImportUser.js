

document.addEventListener('DOMContentLoaded', function () {
    const dataForm = document.getElementById('dataForm');
    const submitButton = document.getElementById('submitButton');
    const jsonData = [];

    submitButton.addEventListener('click', function () {
        const name = document.getElementById('name').value;
        const role = document.getElementById('role').value;
        const email = document.getElementById('email').value;

        // Create a data object
        const dataObject = {
            name: name,
            role: role,
            email: email
        };


        // Add the data object to the JSON array
        jsonData.push(dataObject);

        // Clear the form fields
        document.getElementById('name').value = '';
        document.getElementById('role').value = '';
        document.getElementById('email').value = '';

        // Display a success message (you can modify this as needed)
        alert('Data added successfully!');

        // Optionally, you can save the JSON data to a file
        saveToJsonFile();
    });

    function saveToJsonFile() {
        // Convert the JSON data to a string
        const jsonString = JSON.stringify(jsonData);

        // Create a Blob object containing the JSON data
        const blob = new Blob([jsonString], { type: 'application/json' });

        // Create a download link and trigger a click event to download the JSON file
        const a = document.createElement('a');
        a.href = URL.createObjectURL(blob);
        a.download = 'data.json';
        a.style.display = 'none';
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
    }
}
);






