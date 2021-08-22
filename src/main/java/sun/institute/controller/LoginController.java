package sun.institute.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sun.institute.data.LoadDbData;
import sun.institute.data.StudAuthDetails;
import sun.institute.model.AITRecord;
import sun.institute.model.StudentDetails;
import sun.institute.repository.IAITRepo;
import sun.institute.repository.IStudentDetailsRepo;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

	@Autowired
	IStudentDetailsRepo studentRepo;
	
	@Autowired
	IAITRepo aitRepo;
	
	@Autowired
	LoadDbData loadDb;
	
	boolean requestCameFirstTime = true;

	@PostMapping("/student")
	public boolean authenticateStudent(@RequestBody StudAuthDetails stud) {
		
		loadDb.setDbData();

		StudentDetails studDetails = studentRepo.findByUserName(stud.getUserName());
		System.out.println("STUD FROM DB:" + studDetails);
		
		if(studDetails != null && studDetails.password.equals(stud.getPassword())) {
			return true;
		}
		
		return false;
	}

	
	@GetMapping("/records")
	public List<AITRecord> getRecords() {
		loadDb.setDbData();
		return (List<AITRecord>) aitRepo.findAll();
	}

}
