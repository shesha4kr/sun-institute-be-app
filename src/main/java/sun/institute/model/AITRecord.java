package sun.institute.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AITRecord {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer recordId;
	public String userName;
	public Integer logicalMarks;
	public Integer quantMarks;
	public Integer gkMarks;
	public String mockTest;
	public LocalDate dateOfExam;

	public AITRecord() {
		super();
	}

	public AITRecord(String userName, Integer logicalMarks, Integer quantMarks, Integer gkMarks,
			String mockTest, LocalDate dateOfExam) {
		super();
		this.userName = userName;
		this.logicalMarks = logicalMarks;
		this.quantMarks = quantMarks;
		this.gkMarks = gkMarks;
		this.mockTest = mockTest;
		this.dateOfExam = dateOfExam;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getLogicalMarks() {
		return logicalMarks;
	}

	public void setLogicalMarks(Integer logicalMarks) {
		this.logicalMarks = logicalMarks;
	}

	public Integer getQuantMarks() {
		return quantMarks;
	}

	public void setQuantMarks(Integer quantMarks) {
		this.quantMarks = quantMarks;
	}

	public Integer getGkMarks() {
		return gkMarks;
	}

	public void setGkMarks(Integer gkMarks) {
		this.gkMarks = gkMarks;
	}

	public String getTestNumber() {
		return mockTest;
	}

	public void setTestNumber(String testNumber) {
		this.mockTest = testNumber;
	}

	public LocalDate getDateOfExam() {
		return dateOfExam;
	}

	public void setDateOfExam(LocalDate dateOfExam) {
		this.dateOfExam = dateOfExam;
	}

}
