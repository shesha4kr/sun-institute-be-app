package sun.institute.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class AITRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recordId;
	private Integer studId;
	private Integer logicalMarks;
	private Integer quantMarks;
	private Integer gkMarks;
	private Integer totalMarks;
	private String mockTest;
	private LocalDate dateOfExam;

	@Transient
	public Integer totalStudents;

	@Transient
	public Integer totalStudBehind;

	public AITRecord() {
		super();
	}

	public AITRecord(Integer studId, Integer logicalMarks, Integer quantMarks, Integer gkMarks, String mockTest,
			LocalDate dateOfExam) {
		super();
		this.studId = studId;
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

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
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

	public Integer getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(Integer totalStudents) {
		this.totalStudents = totalStudents;
	}

	public Integer getTotalStudBehind() {
		return totalStudBehind;
	}

	public void setTotalStudBehind(Integer totalStudBehind) {
		this.totalStudBehind = totalStudBehind;
	}

	@Override
	public String toString() {
		return "AITRecord [recordId=" + recordId + ", studId=" + studId + ", logicalMarks=" + logicalMarks
				+ ", quantMarks=" + quantMarks + ", gkMarks=" + gkMarks + ", totalMarks=" + totalMarks + ", mockTest="
				+ mockTest + ", dateOfExam=" + dateOfExam + ", totalStudents=" + totalStudents + ", totalStudBehind="
				+ totalStudBehind + "]";
	}

}
