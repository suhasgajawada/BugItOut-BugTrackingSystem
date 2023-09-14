document.addEventListener("DOMContentLoaded", function () {
    // Sample project details (you can replace with actual data)
    const projectData = {
        projectName: "Strategic Growth Accelerator",
        startDate: "2023-01-01",
        endDate: "2023-12-31",
        bugCount: 7,
    };

    // Populate project details
    document.getElementById("project-name").textContent = projectData.projectName;
    document.getElementById("start-date").textContent = projectData.startDate;
    document.getElementById("end-date").textContent = projectData.endDate;
    document.getElementById("bug-count").textContent = projectData.bugCount;

    // Sample bug list (you can replace with actual data)
    const bugList = [
        "Memory Leaks",
        "Concurrency Issues",
        "Compatibility Bugs",
        "Regression Bugs",
        "Localization Bugs",
        "Data Corruption",
        "Input Validation Bugs"
        // Add more bug names here
    ];

    // Populate bug list
    const bugListElement = document.getElementById("bug-list");
    bugList.forEach((bugName) => {
        const bugItem = document.createElement("li");
        bugItem.textContent = bugName;
        bugItem.classList.add("list-group-item");
        bugItem.addEventListener("click", () => {
            openBugPopup(bugName);
        });
        bugListElement.appendChild(bugItem);
    });

    // Bug popup functionality
    function openBugPopup(bugName) {
        const bugPopup = document.getElementById("bug-popup");
        const bugNameElement = document.getElementById("bug-name");
        bugNameElement.textContent = bugName;
        bugPopup.style.display = "block";

        const assignButton = document.getElementById("assign-button");
        const closeButton = document.getElementById("close-button");

        assignButton.addEventListener("click", () => {
            // Add logic to assign the bug to a developer here
            alert(`Assigned ${bugName} to a developer.`);
            closeBugPopup();
        });

        closeButton.addEventListener("click", () => {
            // Add logic to close the bug here
            alert(`Closed ${bugName}.`);
            closeBugPopup();
        });
    }

    function closeBugPopup() {
        const bugPopup = document.getElementById("bug-popup");
        bugPopup.style.display = "none";
    }
});
