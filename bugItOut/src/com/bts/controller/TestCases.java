package com.bts.controller;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bts.beans.Project;
import com.bts.beans.User;
import com.bts.beans.enums.ProjectStatus;
import com.bts.beans.enums.UserType;
import com.bts.exceptions.AuthorizationException;
import com.bts.exceptions.BugAssignmentException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;
import com.bts.exceptions.InvalidDateException;
import com.bts.exceptions.ProjectManagerLimitExceededException;
import com.bts.exceptions.UserAlreadyExistsException;
import com.bts.service.BugService;
import com.bts.service.ProjectService;
import com.bts.service.TeamService;
import com.bts.service.UserService;
import com.bts.util.ObjectFactory;

public class TestCases {
	static UserService userService = ObjectFactory.getUserInstance();
    static ProjectService projectService = ObjectFactory.getProjectServiceInstace();
    static BugService bugService = ObjectFactory.getBugServiceInstance();
    static TeamService teamService = ObjectFactory.getTeamServiceInstance();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    testUserRegistration();
                    break;
                case 2:
                    testCreateNewProject();
                    break;
                case 9:
                    System.out.println("Exiting the test program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Test Menu");
        System.out.println("1. Test User Registration");
        System.out.println("2. Test Create New Project");
        // Add more test options here
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void testUserRegistration() {
        System.out.println("Testing User Registration...");


        // Test case a: All fields are mandatory
        try{
        	userService.registerUser("alex@alex.com", null, null);
        	System.err.println("Test case 1a (All fields mandatory): Failed");
        }
        catch (Exception e) {System.out.println("Test case 1a (All fields mandatory): Passed");
		}
        
        // Test case b: Email should exist and match with the role
        try{
        	userService.registerUser("alex@alex.com", "Alex@123", UserType.developer);
        	System.err.println("Test case 1b (Email validation): Failed");
        }
        catch(Exception e) {
        	System.out.println("Test case 1b (Email validation): Passed");
        }

        // Test case c: User should not have already been registered
        try{
        	userService.registerUser("max@champ.com", "Max@123", UserType.projectManager);
        	System.err.println("Test case 1c (User already registered): Failed");
        }
        catch(Exception e) {
        	System.out.println("Test case 1c (User already registered): Passed");
        }
    }

    private static void testCreateNewProject() {
    	int projectManagerId;
    	String projectName;
    	String description;
    	LocalDate startDate;
    	ProjectStatus status;
    	int testerId;
    	int developerId;
    	// Test case 2a: Start date should be at least 2 days later than the current date
    	projectManagerId = 1;
    	projectName = "Something";
    	description = "Something";
    	startDate = LocalDate.parse("2023-09-15");
    	status = ProjectStatus.inProgress;
    	testerId = 2;
    	try {
			projectService.createProject(new Project(projectManagerId, projectName, description,startDate, status), projectManagerId, testerId);
			System.err.println("Test case 2a: Failed");
		} catch (DataAccessException | ProjectManagerLimitExceededException | InvalidDateException
				| InvalidDataException e) {
			System.out.println("Test case 2a: Passed");
		}
        // Test case 2b: Project status should be set to "in progress"
    	startDate = LocalDate.parse("2023-09-25");
    	status = ProjectStatus.Completed;
    	try {
			projectService.createProject(new Project(projectManagerId, projectName, description,startDate, status), projectManagerId, testerId);
			System.err.println("Test case 2b: Failed");
		} catch (DataAccessException | ProjectManagerLimitExceededException | InvalidDateException
				| InvalidDataException e) {
			System.out.println("Test case 2b: Passed");
		}
    	// Test case 2c: Developers can be assigned to only one project
    	developerId = 3;
    	try {
			bugService.assignBugToDeveloper(projectManagerId, developerId);
			System.err.println("Test case 2c: Failed");
		} catch (BugAssignmentException | DataAccessException | AuthorizationException e) {
			System.out.println("Test case 2c: Passed");
		}
    	
    	// Test case 2d: Testers can be assigned to a maximum of 2 projects
    	testerId = 4;
    	try {
			projectService.createProject(new Project(projectManagerId, projectName, description,startDate, status), projectManagerId, testerId);
			System.err.println("Test case 2d: Failed");
		} catch (DataAccessException | ProjectManagerLimitExceededException | InvalidDateException
				| InvalidDataException e) {
			System.out.println("Test case 2d: Passed");
		}
    	
    	// Test case 2e: Testers can be assigned to projects only under same project manager
    	testerId = 5;
    	try {
			projectService.createProject(new Project(projectManagerId, projectName, description,startDate, status), projectManagerId, testerId);
			System.err.println("Test case 2e: Failed");
		} catch (DataAccessException | ProjectManagerLimitExceededException | InvalidDateException
				| InvalidDataException e) {
			System.out.println("Test case 2e: Passed");
		}
    	
    }
}
