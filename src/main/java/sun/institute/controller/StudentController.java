package sun.institute.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sun.institute.data.LoadDbData;
import sun.institute.data.LoginSuccessDTO;
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
		List<AITRecord> listOfExams = new ArrayList<>();
		listOfExams = aitRepo.findExamByUserName(userName);
		fetchExtraDetails(listOfExams);
		return listOfExams;
	}

	public void fetchExtraDetails(List<AITRecord> listOfExams) {

		for (AITRecord exam : listOfExams) {
			exam.setTotalStudents(aitRepo.findTotalRecordsForAMocktest(exam.getMockTest()));
			exam.setTotalStudBehind(aitRepo.findTotalStudentsBehind(exam.getTotalMarks(), exam.getMockTest()));
		}

	}

}
