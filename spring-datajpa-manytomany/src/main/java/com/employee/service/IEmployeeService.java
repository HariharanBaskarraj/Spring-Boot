/**
 * 
 */
package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

/**
 * @author HariharanB
 *
 */
public interface IEmployeeService {

	Employee addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(int employeeId);
	List<Employee> getAll();
	Employee getById(int employeeId);
	
	//derived
	List<Employee> getByCity(String city);
	
	//custom
	List<Employee> getByCourseName(String courseName);
	List<Employee> getByCategoryMode(String category, String mode);
	List<Employee> getByCategory(String category);
}
