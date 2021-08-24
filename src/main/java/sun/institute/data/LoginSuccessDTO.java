package sun.institute.data;

import sun.institute.model.AITRecord;
import sun.institute.model.StudentDetails;

public class LoginSuccessDTO {

	boolean isValid = false;
	AITRecord latestTestDetails;
	StudentDetails studDetails;
	Integer totalStudents;
	Integer totalStudentsBehind;

	public LoginSuccessDTO() {
		super();
	}

	public LoginSuccessDTO(boolean isValid, AITRecord latestTestDetails, StudentDetails studDetails,
			Integer totalStudents, Integer totalStudentsBehind) {
		super();
		this.isValid = isValid;
		this.latestTestDetails = latestTestDetails;
		this.studDetails = studDetails;
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

	public StudentDetails getStudDetails() {
		return studDetails;
	}

	public void setStudDetails(StudentDetails studDetails) {
		this.studDetails = studDetails;
	}

	@Override
	public String toString() {
		return "LoginSuccessDTO [isValid=" + isValid + ", latestTestDetails=" + latestTestDetails + ", studDetails="
				+ studDetails + ", totalStudents=" + totalStudents + ", totalStudentsBehind=" + totalStudentsBehind
				+ "]";
	}

}
