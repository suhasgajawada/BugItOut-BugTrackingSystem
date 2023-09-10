/**
 * 
 */
package com.bts.util;

import com.bts.dao.BugDao;
import com.bts.dao.BugDaoImpl;
import com.bts.dao.ProjectDao;
import com.bts.dao.ProjectDaoImpl;
import com.bts.dao.TeamDao;
import com.bts.dao.TeamDaoImpl;
import com.bts.dao.UserDao;
import com.bts.dao.UserDaoImpl;
import com.bts.service.BugService;
import com.bts.service.BugServiceImpl;
import com.bts.service.ProjectService;
import com.bts.service.ProjectServiceImpl;
import com.bts.service.TeamService;
import com.bts.service.TeamServiceImpl;
import com.bts.service.UserService;
import com.bts.service.UserServiceImpl;

/**
 * 
 */
public class ObjectFactory {
	public static BugService getBugServiceInstance() {
		BugService service = new BugServiceImpl();
		return service;
	}
	public static ProjectService getProjectServiceInstace() {
		ProjectService service = new ProjectServiceImpl();
		return service;
	}
	public static TeamService getTeamServiceInstance() {
		TeamService service = new TeamServiceImpl();
		return service;
	}
	public static UserService getUserInstance() {
		UserService service = new UserServiceImpl();
		return service;
	}
	public static BugDao getBugDaoInstance() {
		BugDao daoService = new BugDaoImpl();
		return daoService;
		
	}
	public static ProjectDao getProjectDaoInstance() {
		ProjectDao daoService = new ProjectDaoImpl();
		return daoService;
	}
	public static TeamDao getTeamDaoInstance() {
		TeamDao daoService = new TeamDaoImpl();
		return daoService;
	}
	public static UserDao getUserDaoInstance() {
		UserDao daoService = new UserDaoImpl();
		return daoService;
	}

}
