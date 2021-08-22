package sun.institute.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer studId; 
	public String firstName;
	public String lastName;
	public String userName;
	public String password;
	public LocalDate dob;

	public StudentDetails() {
		super();
	}

	public StudentDetails(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = "SI-" + firstName.substring(0, 3) + "-" + lastName.substring(0, 3) + "-"
				+ dob.getDayOfMonth() + dob.getMonthValue() + dob.getYear();
		this.password = dob.getDayOfMonth() + "-" + dob.getMonthValue() + "-" + dob.getYear();
		this.dob = dob;
	}

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
