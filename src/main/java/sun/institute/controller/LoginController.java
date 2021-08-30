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

		LoginSuccessDTO loginSuccessDetails = new LoginSuccessDTO();

		StudentDetails studDetails = studentRepo.findByUserName(stud.getUserName());

		if (studDetails != null && studDetails.getPassword().equals(stud.getPassword())) {
			loginSuccessDetails.setValid(true);
			loginSuccessDetails.setUserName(studDetails.getFirstName() + " " + studDetails.getLastName());
			loginSuccessDetails.setStudId(studDetails.getStudId());
		}

		return loginSuccessDetails;
	}

	@GetMapping("/records")
	public List<AITRecord> getRecords() {
		loadDb.setDbData();
		return (List<AITRecord>) mockTestRepo.findAll();
	}

}
