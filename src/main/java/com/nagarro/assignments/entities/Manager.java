/*
 * Class name: Manager
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
 * Description: Model class for Manager Information.
 */
package com.nagarro.assignments.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int managerId;
	private String managerUsername;
	private String managerPassword;

	public Manager() {

	}

	public int getManagerId() {
		return managerId;
	}

	public String getManagerUsername() {
		return managerUsername;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public void setManagerUsername(String managerUsername) {
		this.managerUsername = managerUsername;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

}
