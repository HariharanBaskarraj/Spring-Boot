package com.employee;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employee.model.Course;
import com.employee.model.Employee;
import com.employee.service.ICourseService;
import com.employee.service.IEmployeeService;

@SpringBootApplication
public class SpringDatajpaManytomanyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaManytomanyApplication.class, args);
	}

	private IEmployeeService employeeService;
	private ICourseService courseService;

	@Autowired
	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	@Autowired
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	public void run(String... args) throws Exception {
//		Course jcourse = new Course("Java",Category.BACK.toString(),Mode.ONLINE.toString());
//		Course scourse = new Course("Spring",Category.BACK.toString(),Mode.OFFLINE.toString());
//		Course acourse = new Course("Angular",Category.FRONT.toString(),Mode.OFFLINE.toString());
//		Course tcourse = new Course("Junit",Category.TEST.toString(),Mode.OFFLINE.toString());
//		Course mcourse = new Course("Mockito",Category.TEST.toString(),Mode.ONLINE.toString());
//		Course pcourse = new Course("The art of being happy",Category.PHILOSOPHY.toString(),Mode.ONLINE.toString());
//		Employee employee = new Employee("Sripriya","Fullstack","Bangalore");
//		Set<Course> courses = new HashSet<>(Arrays.asList(jcourse,scourse,tcourse,mcourse));
//		employee.setCourses(courses);
//		employeeService.addEmployee(employee);
		
//		employee = new Employee("Hariharan","Philosophy","Srivilliputhur");
//		courses = new HashSet<>(Arrays.asList(pcourse,acourse));
//		employee.setCourses(courses);
//		employeeService.addEmployee(employee);
		
//		Employee employee = new Employee("Niroshan","Fullstack","Salem");
//		Course jcourse = courseService.getById(201);
//		Course tcourse = courseService.getById(203);
//		Course mcourse = courseService.getById(204);
//		Set<Course>courses = new HashSet<>(Arrays.asList(jcourse,tcourse,mcourse));
//		employee.setCourses(courses);
//		employeeService.addEmployee(employee);
	
//		Employee employee = new Employee("Pradeish","Philosophy","Salem");
//		Course jcourse = courseService.getById(201);
//		Course tcourse = courseService.getById(203);
//		Course mcourse = courseService.getById(204);
//		Set<Course>courses = new HashSet<>(Arrays.asList(jcourse,tcourse,mcourse));
//		employee.setCourses(courses);
//		employeeService.addEmployee(employee);
		
//		Employee employee = new Employee("Pradeish","Testing","Salem");
//		Course jcourse = courseService.getById(201);
//		Course tcourse = courseService.getById(202);
//		Set<Course>courses = new HashSet<>(Arrays.asList(jcourse,tcourse));
//		employee.setCourses(courses);
//		employeeService.addEmployee(employee);
		
//		employeeService.getAll().forEach(System.out::println);
//		System.out.println(employeeService.getById(102));
//		employeeService.getByCity("Salem").forEach(System.out::println);
//		employeeService.getByCourseName("Java").forEach(System.out::println);
//		employeeService.getByCategoryMode("PHILOSOPHY", "ONLINE").forEach(System.out::println);
//		employeeService.getByCategory("BACK").forEach(System.out::println);
//		
//		Employee employee = employeeService.getById(106);
//		employee.setCity("Erode");
//		employeeService.updateEmployee(employee);
//		employeeService.deleteEmployee(107);
		
//		courseService.getAll().forEach(System.out::println);
//		courseService.getByCategory("FRONT").forEach(System.out::println);
//		courseService.getByCategoryMode("FRONT", "OFFLINE").forEach(System.out::println);
//		courseService.getByEmployee("Sripriya").forEach(System.out::println);
//		courseService.getByCity("Salem").forEach(System.out::println);
//		System.out.println(courseService.getById(201));
		
		Course course = courseService.getById(205);
		course.setMode("ONLINE");
		courseService.updateCourse(course);
//		courseService.deleteCourse(206);
		
		
	}

}
