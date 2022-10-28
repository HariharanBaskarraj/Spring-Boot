package com.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.Address;
import com.studentapp.model.Student;
import com.studentapp.service.IStudentService;

@SpringBootApplication
public class SpringDatajpaOnetooneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetooneApplication.class, args);
	}

	private IStudentService studentService;

	@Autowired
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public void run(String... args) throws Exception {
//		Address address =new Address("Srivilliputhur","Tamilnadu");
//		Student student =new Student("Hariharan","CSE","hariharanbaskarraj@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("Salem","Tamilnadu");
//		student =new Student("Niroshan","CSE","niroshan.m@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("Cheyyar","Tamilnadu");
//		student =new Student("Salai Arunmani","CSE","salai.jb@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("Erode","Tamilnadu");
//		student =new Student("Logesh","EEE","logesh15eee@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("Salem","Tamilnadu");
//		student =new Student("Pradeish","CSE","pradeish.c@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("Madhapur","Telangana");
//		student =new Student("Praveen","ECE","praveen.reddy@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("Gachibowli","Telangana");
//		student =new Student("Baba","EEE","babadharubai@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("Kukatpally","Telangana");
//		student =new Student("Avinash","CSE","avinash@gmail.com",address);
//		studentService.addStudent(student);
		
		System.out.println("Get by city: ");
		studentService.getByCity("Salem").forEach(System.out::println);
		
		System.out.println("\nGet by city and department:");
		studentService.getByCityAndDepartment("Salem", "CSE").forEach(System.out::println);
		
		System.out.println("\nGet by city and state:");
		studentService.getByCityState("Kukatpally", "Telangana").forEach(System.out::println);
		
	}

}
