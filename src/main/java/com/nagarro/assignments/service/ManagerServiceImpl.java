/*
 * Class name: ManagerServiceImpl
 *
 * Version info: JavaSE-11
 *
 * Copyright notice:
 * 
 * Author info: Tushar Gupta
 *
 * Creation date: 07/June/2021
 *
 * Last updated By: Tushar Gupta
 *
 * Last updated Date: 14/June/2021
 *
 * Description: Manager service implementation class.
 */
package com.nagarro.assignments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.assignments.dao.ManagerCustomDao;
import com.nagarro.assignments.dao.ManagerDao;
import com.nagarro.assignments.entities.Manager;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerDao managerDao;

	@Autowired
	ManagerCustomDao managerCustomDao;

	/**
	 * Add details of manager.
	 */
	@Override
	public void addDetails(Manager manager) {
		managerDao.saveDetails(manager);
	}

	/**
	 * Validate for manager.
	 */
	@Override
	public Manager checkDetails(String username, String password) {
		Manager manager = managerCustomDao.findByManagerUsernameAndManagerPassword(username, password);
		return manager;

	}
}
