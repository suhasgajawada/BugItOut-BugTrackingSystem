function submitBugReport() {
    console.log("Function called");
    // Get form inputs
    const projectTitle = document.getElementById("project-title").value;
    const bugTitle = document.getElementById("bug-title").value;
    const description = document.getElementById("description").value;
    const severity = document.getElementById("severity-level").value;

    // Check if all fields are filled out
    if (projectTitle && bugTitle && description && severity) {
        // Generate a unique ID (for demonstration purposes, you can use a library like UUID for production)
        const uniqueId = "BUG-" + Math.random().toString(36).substr(2, 9);

        // Get the current date and time
        const currentDate = new Date();
        const formattedDate = currentDate.toISOString();

        // Prepare bug report data
        const bugReport = {
            id: uniqueId,
            createdBy: "Tester",
            createdOn: formattedDate,
            projectTitle: projectTitle,
            bugTitle: bugTitle,
            description: description,
            severity: severity
        };

        // Display a success message
        alert("Bug created successfully!");

        // You can also send the bug report data to the server or perform further actions here

        // Reset the form (if needed)
        document.getElementById("bug-report-form").reset();
    } else {
        // If any required field is empty, show an error message
        alert("Please fill out all required fields.");
    }
}