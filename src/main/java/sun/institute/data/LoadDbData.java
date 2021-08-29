package sun.institute.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sun.institute.model.AITRecord;
import sun.institute.model.StudentDetails;
import sun.institute.repository.IAITRepo;
import sun.institute.repository.IStudentDetailsRepo;

@Component
public class LoadDbData {

	boolean requestCameFirstTime = true;

	@Autowired
	IStudentDetailsRepo studentRepo;

	@Autowired
	IAITRepo aitRepo;

	public void setDbData() {
		if (requestCameFirstTime) {
			
			requestCameFirstTime = false;
			loadStudentDetailsDb();
			loadAITRecordsDb();
		}
	}

	private void loadStudentDetailsDb() {
		LocalDate dob = LocalDate.of(1997, 6, 8);

		StudentDetails stud1 = new StudentDetails("Sheshank", "Kumar", dob);
		StudentDetails stud2 = new StudentDetails("Vaibhav", "Dhama", dob);
		StudentDetails stud3 = new StudentDetails("Hari", "Jayarajan", dob);
		StudentDetails stud4 = new StudentDetails("Pinaki", "Bandyopadhyay", dob);

		studentRepo.saveAll(new ArrayList<>(Arrays.asList(stud1, stud2, stud3, stud4)));
	}

	private void loadAITRecordsDb() {
		AITRecord rec1 = new AITRecord(1, 87, 88, 55, "AIT1", getExamDate("AIT1"));
		AITRecord rec2 = new AITRecord(1, 88, 83, 58, "AIT2", getExamDate("AIT2"));
		AITRecord rec3 = new AITRecord(1, 78, 70, 34, "AIT3", getExamDate("AIT3"));

		AITRecord rec4 = new AITRecord(2, 78, 88, 56, "AIT1", getExamDate("AIT1"));
		AITRecord rec5 = new AITRecord(2, 98, 67, 55, "AIT2", getExamDate("AIT2"));
		AITRecord rec6 = new AITRecord(2, 49, 37, 23, "AIT3", getExamDate("AIT3"));

		AITRecord rec7 = new AITRecord(3, 67, 87, 45, "AIT1", getExamDate("AIT1"));
		AITRecord rec8 = new AITRecord(3, 29, 19, 44, "AIT2", getExamDate("AIT2"));
		AITRecord rec9 = new AITRecord(3, 92, 94, 89, "AIT3", getExamDate("AIT3"));

		AITRecord rec10 = new AITRecord(4, 69, 69, 66, "AIT1", getExamDate("AIT1"));
		AITRecord rec11 = new AITRecord(4, 77, 71, 76, "AIT2", getExamDate("AIT2"));
		AITRecord rec12 = new AITRecord(4, 87, 88, 55, "AIT3", getExamDate("AIT3"));

		aitRepo.saveAll(new ArrayList<>(
				Arrays.asList(rec1, rec2, rec3, rec4, rec5, rec6, rec7, rec8, rec9, rec10, rec11, rec12)));
	}

	private LocalDate getExamDate(String mockTest) {
		switch (mockTest) {
		case "AIT1":
			return LocalDate.of(2021, 1, 5);
		case "AIT2":
			return LocalDate.of(2021, 2, 6);
		case "AIT3":
			return LocalDate.of(2021, 3, 7);
		// case "AIT4": return LocalDate.of(2021, 4, 8);
		}
		return null;
	}

}
