package sun.institute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sun.institute.data.LoadDbData;
import sun.institute.model.AITRecord;
import sun.institute.model.StudentDetails;
import sun.institute.repository.IAITRepo;
import sun.institute.repository.IStudentDetailsRepo;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	IStudentDetailsRepo studentRepo;
	
	@Autowired
	IAITRepo aitRepo;
	
	@Autowired
	LoadDbData loadDb;
	
	@GetMapping("")
	public List<StudentDetails> getStudents() {
		loadDb.setDbData();
		return (List<StudentDetails>) studentRepo.findAll();
	}
	
	@GetMapping("/{userName}")
	public List<AITRecord> getExamsByUserName(@PathVariable String userName) {
		loadDb.setDbData();
		return (List<AITRecord>) aitRepo.findExamByUserName(userName);
	}

}
