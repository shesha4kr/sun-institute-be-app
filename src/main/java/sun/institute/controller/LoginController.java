package sun.institute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sun.institute.data.LoadDbData;
import sun.institute.data.LoginSuccessDTO;
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
	IAITRepo mockTestRepo;

	@Autowired
	LoadDbData loadDb;

	boolean requestCameFirstTime = true;

	@PostMapping("/student")
	public LoginSuccessDTO authenticateStudent(@RequestBody StudAuthDetails stud) {

		loadDb.setDbData();
		
		System.out.println("Entered");

		LoginSuccessDTO loginSuccessDetails = new LoginSuccessDTO();

		StudentDetails studDetails = studentRepo.findByUserName(stud.getUserName());

		if (studDetails != null && studDetails.password.equals(stud.getPassword())) {
			
			AITRecord record = mockTestRepo.findLatestMockTest(stud.getUserName()).get(0);
			loginSuccessDetails.setValid(true);
			loginSuccessDetails.setLatestTestDetails(record);
			loginSuccessDetails.setStudDetails(studDetails);
			loginSuccessDetails.setTotalStudents(mockTestRepo.findTotalRecordsForAMocktest(record.getMockTest()));
			loginSuccessDetails.setTotalStudentsBehind(mockTestRepo.findTotalStudentsBehind(record.getTotalMarks(), record.getMockTest()));
		}
		
		System.out.println("Will send this:"+loginSuccessDetails);

		return loginSuccessDetails;
	}

	@GetMapping("/records")
	public List<AITRecord> getRecords() {
		loadDb.setDbData();
		return (List<AITRecord>) mockTestRepo.findAll();
	}

}
