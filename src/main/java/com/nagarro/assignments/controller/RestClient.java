/*
 * Class name: RestClient
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
 * Description: Rest Template class for calling REST API CRUD functions.
 */
package com.nagarro.assignments.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.assignments.entities.Employee;

@RestController
public class RestClient {

	private static RestTemplate restTemplate = new RestTemplate();

	/**
	 * Call the REST API to get List of employee.
	 * 
	 * @param session
	 * @param requestEntity
	 * @return the welcomepage with List of employee that manager has uploaded till
	 *         now.
	 */
	@GetMapping("/employee")
	public ModelAndView getemployees(HttpSession session, HttpEntity<Employee> requestEntity) {
		Integer managerid = (Integer) session.getAttribute("managerid");
		System.out.println("url managerid: " + managerid);
		final String baseUrl = "http://localhost:9092/ems/showallemployee/" + managerid;
		ResponseEntity<Employee[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, requestEntity,
				Employee[].class);
		Employee[] employees = responseEntity.getBody();
		List<Employee> asList = Arrays.asList(employees);
		System.out.println(asList);
		ModelAndView mv = new ModelAndView();
		mv.addObject("allEmployee", asList);
		mv.setViewName("welcomepage");
		return mv;
	}

	/**
	 * Call the REST API to Save the employee details in database.
	 * 
	 * @param employee
	 * @param response
	 * @throws IOException
	 */
	@PostMapping("/save")
	public void addEmployee(@ModelAttribute Employee employee, HttpServletResponse response) throws IOException {
		System.out.println(employee.getManagerId());
		final String baseUrl = "http://localhost:9092/ems/addemployee";
		ResponseEntity<String> result = restTemplate.postForEntity(baseUrl, employee, String.class);
		System.err.println(result.getStatusCode());
		System.err.println(result.getBody());
		response.sendRedirect("employee");

	}

	/**
	 * Call the REST API to update the details.
	 * 
	 * @param employee
	 * @param response
	 * @throws IOException
	 */
	@PostMapping("/edit")
	public void editEmployee(@ModelAttribute Employee employee, HttpServletResponse response) throws IOException {
		final String baseUrl = "http://localhost:9092/ems/editemployee";
		ResponseEntity<String> result = restTemplate.postForEntity(baseUrl, employee, String.class);
		System.err.println(result.getStatusCode());
		System.err.println(result.getBody());
		response.sendRedirect("employee");
	}

	/**
	 * Download the employee details in CSV format.
	 * @param response
	 * @param session
	 * @param requestEntity
	 * @throws IOException
	 */
	@GetMapping("/download")
	public void exportToCsvFile(HttpServletResponse response, HttpSession session, HttpEntity<Employee> requestEntity)
			throws IOException {
		Integer managerid = (Integer) session.getAttribute("managerid");
		final String baseUrl = "http://localhost:9092/ems/showallemployee/" + managerid;
		ResponseEntity<Employee[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, requestEntity,
				Employee[].class);
		Employee[] employees = responseEntity.getBody();
		List<Employee> employeesList = Arrays.asList(employees);

		response.setContentType("text/csv");
		String fileName = "employee.csv";
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + fileName;
		response.setHeader(headerKey, headerValue);
		ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = { "Employee Id", "Manager Id", "Employee Name", "Location", "Employee Email",
				"Date Of Birth" };
		String[] nameMapping = { "employeeId", "managerId", "employeeName", "location", "employeeEmail",
				"dateOfBirth" };

		csvBeanWriter.writeHeader(csvHeader);
		for (Employee employee : employeesList) {
			csvBeanWriter.write(employee, nameMapping);
		}
		csvBeanWriter.close();
	}

}
