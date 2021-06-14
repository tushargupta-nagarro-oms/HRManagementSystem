/*
 * Interface name: ManagerCustomDao
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
 * Description: Extends JPA repository for database operations.
 */
package com.nagarro.assignments.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.assignments.entities.Manager;

public interface ManagerCustomDao extends JpaRepository<Manager, Integer> {

	/**
	 * 
	 * @param username
	 * @param password
	 * @return manager with same username and password from database.
	 */
	public Manager findByManagerUsernameAndManagerPassword(String username, String password);

}
