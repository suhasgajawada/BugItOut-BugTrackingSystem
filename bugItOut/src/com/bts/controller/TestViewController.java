package com.bts.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.bts.beans.Bug;
import com.bts.beans.Project;
import com.bts.beans.User;
import com.bts.beans.enums.BugStatus;
import com.bts.beans.enums.ProjectStatus;
import com.bts.beans.enums.UserType;
import com.bts.exceptions.AuthenticationException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;
import com.bts.exceptions.ProjectManagerLimitExceededException;
import com.bts.exceptions.UserAlreadyExistsException;
import com.bts.exceptions.UserAlreadyRegisteredException;
import com.bts.exceptions.UserNotFoundException;
import com.bts.service.BugService;
import com.bts.service.ProjectService;
import com.bts.service.TeamService;
import com.bts.service.UserService;
import com.bts.util.ObjectFactory;

public class TestViewController {
//    static UserService userService = ObjectFactory.getUserInstance();
//    static ProjectService projectService = ObjectFactory.getProjectServiceInstace();
//    static BugService bugService = ObjectFactory.getBugServiceInstance();
//    static TeamService teamService = ObjectFactory.getTeamServiceInstance();
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//        	System.out.println("Enter a value:");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline character
//
//            try {
//                switch (choice) {
//                    // need to handle exceptions
//                    case 1:
//                        onboardUser(scanner);
//                        break;
//                    case 2:
//                        registerUser(scanner);
//                        break;
//                    case 3:
//                        loginUser(scanner);
//                        break;
//                    case 9:
//                        System.out.println("Exiting the program.");
//                        System.exit(0);
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
//            } catch (Exception e) {
//                System.err.println("An error occurred: " + e.getMessage());
//            }
//        }
//    }
//
//    private static void onboardUser(Scanner scanner)
//    {
//        System.out.println("Enter no of users you want to onboard: ");
//        int n = scanner.nextInt();
//        scanner.nextLine();
//        String name;
//        int role;
//        String email;
//        
//        try {
//        	for(int i = 0; i<n; i++)
//            {
//                System.out.println("Enter name: ");
//                name = scanner.next();
//                System.out.println("Enter role: ");
//                role = scanner.nextInt();
//                System.out.println("Enter email: ");
//                email = scanner.next();
//                User user = new User(name, (role == 1)?UserType.projectManager:(role == 2)?UserType.tester:UserType.developer, email);
//                userService.createUser(user);
//            }
//		} catch (DataAccessException| InvalidDataException| UserAlreadyExistsException e) {
//			System.err.println(e.getMessage());
//		}
//        System.out.println("Users onboarded");
//    }
//    
//    private static void registerUser(Scanner scanner)
//    {
//        String email;
//        String password;
//
//        System.out.println("Enter email: ");
//        email = scanner.next();
//        System.out.println("Enter password: ");
//        password = scanner.next();
//        try {
//			userService.registerUser(email, password);
//		} catch (UserAlreadyRegisteredException | DataAccessException | UserNotFoundException e) {
//			e.printStackTrace();
//		}
//    }
//    
//    private static void loginUser(Scanner scanner)
//    {
//        String email;
//        String password;
//        System.out.println("Enter email: ");
//        email = scanner.next();
//        System.out.println("Enter password: ");
//        password = scanner.next();
//        try {
//			userService.loginUser(email, password);
//		} catch (AuthenticationException | DataAccessException e) {
//			e.printStackTrace();
//		}
//        User user = null;
//		try {
//			user = userService.getUserByEmail(email);
//			if(user.getUserType() == UserType.projectManager)
//	        	handleProjectManagerMenu(scanner);
//	        if(user.getUserType() == UserType.tester)
//	        	handleTesterMenu(scanner);
//	        if(user.getUserType() == UserType.developer)
//	        	handleDeveloperMenu(scanner);
//		} catch (UserNotFoundException | DataAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//    }
//
//    private static void handleProjectManagerMenu(Scanner scanner) {
//        System.out.println("Project Manager Menu");
//        System.out.println("1. Create Project");
//        System.out.println("2. View Projects");
//        System.out.print("Enter your choice: ");
//
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // Consume the newline character
//
//        switch (choice) {
//            case 1:
//                createProject(scanner);
//                break;
//            case 2:
//                viewProjects(scanner);
//                break;
//            case 9:
//                // Return to the main menu
//                break;
//            default:
//                System.out.println("Invalid choice. Please try again.");
//        }
//    }
//
//    private static void viewBugs(int projectId) {
//		try {
//			Set<Bug> bugs = bugService.getBugsByProjectID(projectId);
//			System.out.println("Here are all the bugs!!");
//			List<Integer> unassigned = new ArrayList<Integer>();
//			List<Integer> markedForClose = new ArrayList<Integer>();
//			List<Integer> inProgress = new ArrayList<Integer>();
//			for(Bug b : bugs)
//			{
//				System.out.println("Bug Name : " + b.getTitle());
//				System.out.println("Bug ID :" + b.getBugId());
//				if(b.getAssignedTo() == 0)
//				{
//					System.out.println("Bug needs to be assigned");
//					unassigned.add(b.getBugId());
//				}
//				else if(b.isMarkedForClosing())
//				{
//					System.out.println("Bug is Marked for closing");
//					markedForClose.add(b.getBugId());
//				}
//				else
//				{
//					System.out.println("Bug is being resolved!!");
//					inProgress.add(b.getBugId());
//				}
//				System.out.println("Enter Bug ID: ");
//			}
//			
//			
//		} catch (DataAccessException e) {
//			System.err.println(e.getMessage());
//		}
//	}
//
//    private static void viewProjects(Scanner scanner) {
//		try {
//			Set<Project> projects =  projectService.getAllProjects();
//			System.out.println("Here are all the projects!!");
//			for( Project p : projects)
//			{
//				System.out.print(p.getProjectName() + " ");
//				System.out.println(p.getProjectId());
//			}
//			System.out.println("Enter Project ID to view bugs: ");
//			viewBugs(scanner.nextInt());
//			
//		} catch (DataAccessException e) {
//			System.err.println(e.getMessage());
//		}
//	}
//
//	private static void createProject(Scanner scanner) {
//		System.out.println("Enter your UserID:");
//		int userId = scanner.nextInt()
//		System.out.println("Enter Project Name :");
//		String projectName = scanner.next();
//		System.out.println("Enter Project Descrtiption :");
//		String description = scanner.next();
//		System.out.println("Enter Start Date (yyyy-mm-dd) :");
//		String startDate = scanner.next();
//		try {
//			projectService.createProject(new Project(userId,projectName, description, LocalDate.parse(startDate), ProjectStatus.inProgress));
//		} catch (DataAccessException | InvalidDataException | ProjectManagerLimitExceededException e) {
//			System.err.println(e.getMessage());
//		}
//		
//	}
//
//		// Implement the tester menu similar to the project manager menu
//    private static void handleTesterMenu(Scanner scanner) {
//    	
//    }
//
//
//    private static void handleDeveloperMenu(Scanner scanner) {
//        // Implement the developer menu similar to the project manager menu
//    }
//
//    // ...

}
