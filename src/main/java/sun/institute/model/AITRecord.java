package sun.institute.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AITRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer recordId;
	public String userName;
	public Integer logicalMarks;
	public Integer quantMarks;
	public Integer gkMarks;
	public Integer totalMarks;
	public String mockTest;
	public LocalDate dateOfExam;

	public AITRecord() {
		super();
	}

	public AITRecord(String userName, Integer logicalMarks, Integer quantMarks, Integer gkMarks, String mockTest,
			LocalDate dateOfExam) {
		super();
		this.userName = userName;
		this.logicalMarks = logicalMarks;
		this.quantMarks = quantMarks;
		this.gkMarks = gkMarks;
		this.mockTest = mockTest;
		this.dateOfExam = dateOfExam;
		this.totalMarks = logicalMarks + quantMarks + gkMarks;
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

	public LocalDate getDateOfExam() {
		return dateOfExam;
	}

	public void setDateOfExam(LocalDate dateOfExam) {
		this.dateOfExam = dateOfExam;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getMockTest() {
		return mockTest;
	}

	public void setMockTest(String mockTest) {
		this.mockTest = mockTest;
	}

	@Override
	public String toString() {
		return "AITRecord [recordId=" + recordId + ", userName=" + userName + ", logicalMarks=" + logicalMarks
				+ ", quantMarks=" + quantMarks + ", gkMarks=" + gkMarks + ", totalMarks=" + totalMarks + ", mockTest="
				+ mockTest + ", dateOfExam=" + dateOfExam + "]";
	}

}
