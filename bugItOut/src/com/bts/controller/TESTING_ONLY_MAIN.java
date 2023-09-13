package com.bts.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.bts.beans.Project;
import com.bts.beans.User;
import com.bts.beans.enums.ProjectStatus;
import com.bts.beans.enums.UserType;
import com.bts.dao.ProjectDao;
import com.bts.dao.ProjectDaoImpl;
import com.bts.exceptions.AuthenticationException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;
import com.bts.exceptions.UserAlreadyExistsException;
import com.bts.exceptions.UserAlreadyRegisteredException;
import com.bts.service.BugService;
import com.bts.service.ProjectService;
import com.bts.service.TeamService;
import com.bts.service.UserService;
import com.bts.util.ObjectFactory;

public class TESTING_ONLY_MAIN {
	
	static UserService userService = ObjectFactory.getUserInstance();
    static ProjectService projectService = ObjectFactory.getProjectServiceInstace();
    static BugService bugService = ObjectFactory.getBugServiceInstance();
    static TeamService teamService = ObjectFactory.getTeamServiceInstance();
    static ProjectDao projectDao = new ProjectDaoImpl();
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        while (true) {
        	
        	System.out.println("Enter a value:");
        	
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            try {
                switch (choice) {
                    // need to handle exceptions
                    case 1:
                    	 System.out.println("Enter no of users you want to onboard: ");
                         int n = scanner.nextInt();
                         scanner.nextLine();
                         String name;
                         int role;
                         String email;
                         
                         try {
                         	for(int i = 0; i<n; i++)
                             {
                                 System.out.println("Enter name: ");
                                 name = scanner.next();
                                 System.out.println("Enter role: ");
                                 role = scanner.nextInt();
                                 System.out.println("Enter email: ");
                                 email = scanner.next();
                                 User user = new User(name, (role == 1)?UserType.projectManager:(role == 2)?UserType.tester:UserType.developer, email);
                                 userService.createUser(user);
                             }
                 		} catch (DataAccessException| InvalidDataException| UserAlreadyExistsException e) {
                 			System.err.println(e.getMessage());
                 		}
                         System.out.println("Users onboarded");
                     
                        break;
                    case 2:
                    		System.out.println("Enter userId to get details:");
                        	User userById= userService.getUserById(scanner.nextInt());
                        	System.out.println(userById);
                        break;
                    case 3:
                        System.out.println("Enter email to get details:");
                    	User userByEmail= userService.getUserByEmail(scanner.next());
                    	System.out.println(userByEmail);
                    	break;
                    case 4:
                    	System.out.println("To Register User:");
                    	System.out.println("Enter email:");
                    	String email1= scanner.next();
                    	System.out.println("Enter password:");
                    	String password = scanner.next();
                    	try{
                    		userService.registerUser(email1, password);
                    	}catch(UserAlreadyRegisteredException e) {
                    		 System.err.println( e.getMessage());
                    	}
                    	break;
                    case 5:
                    	System.out.println("To Login User:");
                    	System.out.println("Enter email:");
                    	String email2= scanner.next();
                    	System.out.println("Enter password:");
                    	String password2 = scanner.next();
                    	try {
                    		User user=userService.loginUser(email2, password2);
                    	
                    		System.out.println("Logged In");
                    	}catch(AuthenticationException |DataAccessException e) {
                    		System.err.println( e.getMessage());
                    	}
                    	break;
                    case 6:
                    	System.out.println("to logout user:");
                    	System.out.println("Enter the UserId");
                    	try {
                    	userService.logoutUser(scanner.nextInt());
                    	System.out.println("user logged out");
                    	}catch(AuthenticationException |DataAccessException e) {
                    		System.err.println( e.getMessage());
                    	}
                    	break;
                    case 7:
                    	try {
                    	System.out.println(userService.getAllUsers());
                    	}catch(DataAccessException e) {
                    		System.out.println(e.getMessage());
                    	}
                    	break;
                    case 8:
                    	Project project = new Project(3,"JDBC"," this is jdbc",LocalDate.now(),ProjectStatus.inProgress);
                    		System.out.println(project);
                    	try {
//                    		Project project =projectDao.getProjectById(2);
//                    		System.out.println(project);
                    	projectDao.createProject(project);
                    	}catch(DataAccessException e) {
                    		System.out.println(e.getMessage());
                    	}
                    	break;
                    case 9:
                        System.out.println("Exiting the program.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }

	

}
