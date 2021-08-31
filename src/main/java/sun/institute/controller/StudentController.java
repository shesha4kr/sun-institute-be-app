package sun.institute.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import sun.institute.data.LoadDbData;
import sun.institute.data.LoginSuccessDTO;
import sun.institute.data.StudAuthDetails;
import sun.institute.data.StudentProfile;
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

	@GetMapping("/profile/{studId}")
	public StudentProfile getStudentProfileById(@PathVariable Integer studId) {
		loadDb.setDbData();
		StudentProfile studProfile = new StudentProfile();

		StudentDetails studDetails = studentRepo.findByStudId(studId);
		List<String> allUserNames = studentRepo.findAllUserNames(studDetails.getUserName());

		setBirthDetails(studProfile, studDetails.getDob());
		studProfile.setFirstName(studDetails.getFirstName());
		studProfile.setLastName(studDetails.getLastName());
		studProfile.setUserName(studDetails.getUserName());
		studProfile.setPassword(studDetails.getPassword());
		studProfile.setAllUserNames(allUserNames);
		return studProfile;
	}

	@PutMapping("/profile/{studId}")
	public String updateStudentProfile(@RequestBody StudentProfile newProfile, @PathVariable Integer studId) {
		loadDb.setDbData();
		try {

			if (newProfile.getUserName() != null) {
				studentRepo.updateUserName(newProfile.getUserName(), studId);
			}

			if (newProfile.getBirthDate() != null && newProfile.getBirthMonth() != null
					&& newProfile.getBirthYear() != null) {
				LocalDate dob = LocalDate.of(newProfile.getBirthYear(), newProfile.getBirthMonth(),
						newProfile.getBirthDate());
				studentRepo.updateDOB(dob, studId);
			}
			
			return "{\"message\"" + ":" + "\"success\"}";
		} catch (Exception e) {
			return "{\"message\"" + ":" + "\"failed\"}";
		}
	}

	@GetMapping("/exam/{studId}")
	public List<AITRecord> getLatestExam(@PathVariable Integer studId) {
		loadDb.setDbData();
		List<AITRecord> listOfExams = new ArrayList<>();
		AITRecord latestExam = fetchExams(Integer.valueOf(studId)).get(0);
		listOfExams.add(latestExam);
		return listOfExams;
	}

	@GetMapping("/exams/{studId}")
	public List<AITRecord> getAllExams(@PathVariable Integer studId) {
		loadDb.setDbData();
		return fetchExams(studId);
	}

	public List<AITRecord> fetchExams(Integer studId) {
		List<AITRecord> listOfExams = new ArrayList<>();
		listOfExams = aitRepo.findExamsByStudId(studId);

		for (AITRecord exam : listOfExams) {
			exam.setTotalStudents(aitRepo.findTotalRecordsForAMocktest(exam.getMockTest()));
			exam.setTotalStudBehind(aitRepo.findTotalStudentsBehind(exam.getTotalMarks(), exam.getMockTest()));
		}
		return listOfExams;
	}

	private void setBirthDetails(StudentProfile studProfile, LocalDate dob) {
		studProfile.setBirthDate(dob.getDayOfMonth());
		studProfile.setBirthMonth(dob.getMonthValue());
		studProfile.setBirthYear(dob.getYear());
	}
}
