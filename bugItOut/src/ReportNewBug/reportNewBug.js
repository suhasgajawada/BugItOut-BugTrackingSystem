function submitBugReport() {
    // Get form inputs
    const projectTitle = document.getElementById("project-title").value;
    const bugTitle = document.getElementById("bug-title").value;
    const description = document.getElementById("description").value;
    const severity = document.getElementById("severity").value;

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

    // Send the bug report data to the server (you can replace this with your actual server endpoint)
    // For demonstration purposes, we'll log the data to the console
    console.log("Bug Report Submitted:", bugReport);


}