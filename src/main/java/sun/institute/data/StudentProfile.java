package sun.institute.data;

import java.util.List;

public class StudentProfile {

	private String firstName;
	private String lastName;
	private Integer birthDate;
	private Integer birthMonth;
	private Integer birthYear;
	private String userName;
	private String password;
	private String newPassword;
	private List<String> allUserNames;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Integer birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(Integer birthMonth) {
		this.birthMonth = birthMonth;
	}

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public List<String> getAllUserNames() {
		return allUserNames;
	}

	public void setAllUserNames(List<String> allUserNames) {
		this.allUserNames = allUserNames;
	}

	@Override
	public String toString() {
		return "StudentProfile [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", birthMonth=" + birthMonth + ", birthYear=" + birthYear + ", userName=" + userName + ", password="
				+ password + ", newPassword=" + newPassword + ", allUserNames=" + allUserNames + "]";
	}

}
