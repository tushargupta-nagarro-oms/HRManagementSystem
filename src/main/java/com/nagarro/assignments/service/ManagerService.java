/*
 * Interface name: ManagerService
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
 * Description: Manager service interface this is basically for loose coupling.
 */
package com.nagarro.assignments.service;

import org.springframework.stereotype.Service;

import com.nagarro.assignments.entities.Manager;

@Service
public interface ManagerService {


	public Manager checkDetails(String username, String password);

	public void addDetails(Manager manager);

}
