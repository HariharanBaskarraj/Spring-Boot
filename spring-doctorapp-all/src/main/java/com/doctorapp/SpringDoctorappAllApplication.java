package com.doctorapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDoctorappAllApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorappAllApplication.class, args);
	}
//	private IDoctorService doctorService;
//	@Autowired
//	public void setDoctorService(IDoctorService doctorService) {
//		this.doctorService = doctorService;
//	}
//
//	private IHospitalService hospitalService;
//	@Autowired
//	public void setHospitalService(IHospitalService hospitalService) {
//		this.hospitalService = hospitalService;
//	}
//
//	private ISpecialityService specialityService;
//	@Autowired
//	public void setHospitalService(ISpecialityService specialityService) {
//		this.specialityService = specialityService;
//	}
	@Override
	public void run(String... args) throws Exception {
		
//		Address address = new Address("Rajaji Nagar","Bangalore","Karnataka");
//		Speciality specialityOne = new Speciality(Specialisation.CARDIO.getSpecialityName());
//		Speciality specialityTwo = new Speciality(Specialisation.PEDO.getSpecialityName());
//		Set<Speciality> specialities = new HashSet<>(Arrays.asList(specialityOne,specialityTwo));
//		Hospital hospital = new Hospital("Malar Hospital","Bangalore");
//		Casesheet caseOne= new Casesheet("Fever and Cough");
//		Casesheet caseTwo =new Casesheet("Vomiting and cold");
//		Set<Casesheet> casesheets = new HashSet<>(Arrays.asList(caseOne,caseTwo));	
//		Doctor doctor = new Doctor("Shreedhar","shree@gmail.com",600,12,address);
//		doctor.setHospital(hospital);
//		doctor.setCasesheet(casesheets);
//		doctor.setSpeciality(specialities);
//		doctorService.addDoctor(doctor);
//		
//		hospital = new Hospital("Yashoda Hospital","Hyderabad");
//		hospitalService.addHospital(hospital);
//		Speciality speciality = new Speciality(Specialisation.DERMA.getSpecialityName());
//		specialityService.addSpeciality(speciality);
//		
//		hospital = new Hospital("Apollo Hospital", "Chennai");
//		hospitalService.addHospital(hospital);
//		speciality = new Speciality(Specialisation.GENERAL.getSpecialityName());
//		specialityService.addSpeciality(speciality);
//		speciality = new Speciality(Specialisation.NEURO.getSpecialityName());
//		specialityService.addSpeciality(speciality);
//		speciality = new Speciality(Specialisation.OPTHAL.getSpecialityName());
//		specialityService.addSpeciality(speciality);
		
//		Address address = new Address("100 feet road","Hyderabad","Telangana");
//		Doctor doctor = new Doctor ("Pavan","pavan@gmail.com",1600,10,address);
//		Hospital hospital = hospitalService.getById(402);
//		Speciality specialityOne = specialityService.getById(303);
//		Speciality specialityTwo = specialityService.getById(304);
//		Set<Speciality> specialities = new HashSet<>(Arrays.asList(specialityOne,specialityTwo));		
//		Casesheet caseOne= new Casesheet("Tooth ache");
//		Casesheet caseTwo =new Casesheet("Root Canal surgery");
//		Set<Casesheet> casesheets = new HashSet<>(Arrays.asList(caseOne,caseTwo));	
//		doctor.setHospital(hospital);
//		doctor.setCasesheet(casesheets);
//		doctor.setSpeciality(specialities);
//		doctorService.addDoctor(doctor);
		
//		Address address = new Address("Greams Road","Chennai","Tamilnadu");
//		Doctor doctor = new Doctor ("Hariharan","hariharan@gmail.com",1200,7,address);
//		Hospital hospital = hospitalService.getById(403);
//		Speciality specialityOne = specialityService.getById(305);
//		Speciality specialityTwo = specialityService.getById(306);
//		Set<Speciality> specialities = new HashSet<>(Arrays.asList(specialityOne,specialityTwo));		
//		Casesheet caseOne= new Casesheet("Brain fever");
//		Casesheet caseTwo =new Casesheet("Cataract surgery");
//		Set<Casesheet> casesheets = new HashSet<>(Arrays.asList(caseOne,caseTwo));	
//		doctor.setHospital(hospital);
//		doctor.setCasesheet(casesheets);
//		doctor.setSpeciality(specialities);
//		doctorService.addDoctor(doctor);

//		doctorService.deleteDoctor(103);
//		hospitalService.deleteHospital(401);
	}

}
