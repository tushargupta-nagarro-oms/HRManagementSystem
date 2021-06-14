/*
 * Interface name: ManagerDao
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
 * Description: Interface for Database function basically for loose coupling.
 */
package com.nagarro.assignments.dao;

import com.nagarro.assignments.entities.Manager;

public interface ManagerDao {

	public void saveDetails(Manager manager);
	
	

}
