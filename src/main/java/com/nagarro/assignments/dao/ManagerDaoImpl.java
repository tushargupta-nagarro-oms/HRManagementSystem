/*
 * Class name: ManagerDaoImpl
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
 * Description: Implementation class for ManagerDao.
 */
package com.nagarro.assignments.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.assignments.entities.Manager;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	ManagerCustomDao managerCustomDao;

	/**
	 * Save details of manager into database.
	 */
	@Override
	public void saveDetails(Manager manager) {
		managerCustomDao.save(manager);

	}

}
