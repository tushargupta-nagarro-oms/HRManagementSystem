/*
* Class name: ManagerController
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
* Description: Home, Signin, Signup, Logout Controller claas for HR Manager Application.
*/
package com.nagarro.assignments.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarro.assignments.entities.Manager;
import com.nagarro.assignments.service.ManagerService;

@Controller
public class ManagerController {

	@Autowired
	ManagerService managerService;

	@GetMapping("/")
	public String openForm() {
		System.out.println("opening form");

		return "loginpage";
	}

	@PostMapping("/uploadpage")
	public String openUpload() {
		System.out.println("opening Upload form");
		return "uploadpage";
	}

	@GetMapping("/editpage")
	public String openedit() {
		System.out.println("Opening Edit form");
		return "editpage";
	}

	/**
	 * Validate for manager, if valid move to welcomepage.
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@PostMapping("/signin")
	public void validateManager(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		System.out.println("username is :" + username);
		System.out.println("password is :" + password);

		Manager manager = managerService.checkDetails(username, password);

		if (manager == null) {
			System.out.println("login failed");
			response.sendRedirect("/");

		}
		int managerId = manager.getManagerId();
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		session.setAttribute("managerid", managerId);
		System.out.println("manager id :" + managerId);

		response.sendRedirect("employee");

	}

	/**
	 * Signup for new manager.
	 * @return loginpage after signup successful.
	 */
	@GetMapping("/signup")
	@ResponseBody
	public String addManager() {
		Manager manager = new Manager();
		manager.setManagerUsername("tushar123");
		manager.setManagerPassword("12345");
		managerService.addDetails(manager);

		return "success";

	}

	/**
	 * logout from the application and shows loginpage.
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@GetMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("/");
	}

}
