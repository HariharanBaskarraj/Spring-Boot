/**
 * 
 */
package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.IEmployeeRepository;

/**
 * @author HariharanB
 *
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeRepository employeeRepository;

	@Autowired
	public void setEmployeeRepository(IEmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getById(int employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public List<Employee> getByCity(String city) {
		return employeeRepository.findByCity(city);
	}

	@Override
	public List<Employee> getByCourseName(String courseName) {
		return employeeRepository.findByCourseName(courseName);
	}

	@Override
	public List<Employee> getByCategoryMode(String category, String mode) {
		return employeeRepository.findByCategoryMode(category, mode);
	}

	@Override
	public List<Employee> getByCategory(String category) {
		return employeeRepository.findByCategory(category);
	}
	
}
