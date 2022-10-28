package com.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.service.IAddressService;
import com.studentapp.service.IStudentService;

@SpringBootApplication
public class SpringJpaOnetooneBidirectionalApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOnetooneBidirectionalApplication.class, args);
	}

	private IStudentService studentService;

	@Autowired
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	private IAddressService addressService;
	
//	@Autowired
//	public void setAddressService(IAddressService addressService) {
//		this.addressService = addressService;
//	}
	@Autowired
	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}

	@Override
	public void run(String... args) throws Exception {
//		Address address =new Address("A105","GM ","Srivilliputhur","Tamilnadu");
//		Student student =new Student("Hariharan","CSE","hariharanbaskarraj@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("A105","Seelai Street","Salem","Tamilnadu");
//		student =new Student("Niroshan","CSE","niroshan.m@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("B06","Main Street","Cheyyar","Tamilnadu");
//		student =new Student("Salai Arunmani","CSE","salai.jb@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("C107","Car Street","Erode","Tamilnadu");
//		student =new Student("Logesh","EEE","logesh15eee@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("D108","String Street","Salem","Tamilnadu");
//		student =new Student("Pradeish","CSE","pradeish.c@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("E109","Car Street","Madhapur","Telangana");
//		student =new Student("Praveen","ECE","praveen.reddy@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("F110","Main Street","Gachibowli","Telangana");
//		student =new Student("Baba","EEE","babadharubai@gmail.com",address);
//		studentService.addStudent(student);
//		
//		address =new Address("G111","Vinayak Street","Kukatpally","Telangana");
//		student =new Student("Avinash","CSE","avinash@gmail.com",address);
//		studentService.addStudent(student);	
		
		System.out.println("Get by city: ");
		studentService.getByCity("Salem").forEach(System.out::println);
		
		System.out.println("\nGet by city and department:");
		studentService.getByCityAndDepartment("Salem", "CSE").forEach(System.out::println);
		
		System.out.println("\nGet by city and state:");
		studentService.getByCityState("Kukatpally", "Telangana").forEach(System.out::println);		
		System.out.println("By City: ");
		addressService.getByCity("Salem").forEach(System.out::println);
		System.out.println("\nBy Name and City");
		addressService.getByNameAndCity("Niroshan", "Salem").forEach(System.out::println);
		System.out.println("\nBy Name");
		addressService.getByName("Logesh").forEach(System.out::println);
		System.out.println("\nBy Department");
		addressService.getByDepartment("CSE").forEach(System.out::println);
		System.out.println("\nBy StudentId");
		System.out.println(addressService.getByStudentId(105));
		System.out.println("\nBy Name and Street");
		addressService.getNameAndStreet("Pradeish", "String Street").forEach(System.out::println);
	}

}
