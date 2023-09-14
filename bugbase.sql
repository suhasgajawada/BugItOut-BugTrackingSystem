DROP DATABASE IF EXISTS `bugbase`;

-- Create a new database called 'bugbase' and use it
CREATE DATABASE `bugbase`;
USE `bugbase`;

/* User Table */
 
CREATE TABLE users(
  `userId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `email` VARCHAR(55) NOT NULL,
  `password` VARCHAR(255)  DEFAULT NULL,
  `loggedIn` BOOLEAN NOT NULL DEFAULT FALSE,
  `userType` ENUM('Project Manager', 'Developer', 'Tester') NOT NULL,
  `lastLoginTime` TIMESTAMP DEFAULT null,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));

/* Project Table */
CREATE TABLE projects(
  `projectId` INT NOT NULL AUTO_INCREMENT,
  `projectManagerId` INT NOT NULL,
  `projectName` VARCHAR(255) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `startDate` DATE NOT NULL,
  `status` ENUM('In Progress', 'Completed') NOT NULL,
  PRIMARY KEY (`projectId`)
  );
  
  /* Team_member Table */
CREATE TABLE team_members(
  `userId` INT NOT  NULL UNIQUE,
  `projectId` INT NOT NULL ,
  PRIMARY KEY (`teamId`),
  INDEX `projectId` (`projectId` ASC) ,
    FOREIGN KEY (`userId`)
    REFERENCES users(`userId`),
    FOREIGN KEY (`projectId`)
    REFERENCES projects(`projectId`)
    );
 
 /* bugs Table */
CREATE TABLE bug(
  `bug_id` INT NOT NULL AUTO_INCREMENT,
  `bug_title` VARCHAR(255) NOT NULL,
  `bug_description` TEXT NOT NULL,
  `projectId` INT NOT NULL,
  `created_by` INT NOT NULL,
  `open_date` TIMESTAMP NOT NULL,
  `assigned_to` INT NULL DEFAULT NULL,
  `marked_for_closing` TINYINT(1) NOT NULL DEFAULT '0',
  `closed_by` INT NULL DEFAULT NULL,
  `closed_on` TIMESTAMP NULL DEFAULT NULL,
  `status` ENUM('Open', 'Closed') NOT NULL,
  `severity` ENUM('Critical', 'Major', 'Minor', 'Trivial') NOT NULL,
  PRIMARY KEY (`bug_id`),
  INDEX `projectId` (`projectId` ASC) ,
  INDEX `created_by` (`created_by` ASC) ,
  INDEX `assigned_to` (`assigned_to` ASC) ,
  INDEX `closed_by` (`closed_by` ASC) ,
    FOREIGN KEY (`projectId`)
    REFERENCES projects(`projectId`),
    FOREIGN KEY (`created_by`)
    REFERENCES users(`userId`),
    FOREIGN KEY (`assigned_to`)
    REFERENCES users(`userId`),
    FOREIGN KEY (`closed_by`)
    REFERENCES users(`userId`)
    );