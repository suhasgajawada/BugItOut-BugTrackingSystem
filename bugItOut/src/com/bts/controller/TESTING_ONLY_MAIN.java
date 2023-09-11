package com.bts.controller;

import java.util.Scanner;

import com.bts.beans.User;
import com.bts.beans.enums.UserType;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;
import com.bts.exceptions.UserAlreadyExistsException;
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
