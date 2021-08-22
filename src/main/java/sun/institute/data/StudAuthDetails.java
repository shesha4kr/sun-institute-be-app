package sun.institute.data;

public class StudAuthDetails {

	String userName;
	String password;

	public StudAuthDetails(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public StudAuthDetails() {
		super();
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

}
