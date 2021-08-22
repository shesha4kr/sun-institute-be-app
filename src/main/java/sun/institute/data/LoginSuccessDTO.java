package sun.institute.data;

import sun.institute.model.AITRecord;

public class LoginSuccessDTO {

	boolean isValid = false;
	AITRecord latestTestDetails;
	Integer totalStudents;
	Integer totalStudentsBehind;

	public LoginSuccessDTO() {
		super();
	}

	public LoginSuccessDTO(boolean isValid, AITRecord latestTestDetails, Integer totalStudents,
			Integer totalStudentsBehind) {
		super();
		this.isValid = isValid;
		this.latestTestDetails = latestTestDetails;
		this.totalStudents = totalStudents;
		this.totalStudentsBehind = totalStudentsBehind;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public AITRecord getLatestTestDetails() {
		return latestTestDetails;
	}

	public void setLatestTestDetails(AITRecord latestTestDetails) {
		this.latestTestDetails = latestTestDetails;
	}

	public Integer getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(Integer totalStudents) {
		this.totalStudents = totalStudents;
	}

	public Integer getTotalStudentsBehind() {
		return totalStudentsBehind;
	}

	public void setTotalStudentsBehind(Integer totalStudentsBehind) {
		this.totalStudentsBehind = totalStudentsBehind;
	}

}
