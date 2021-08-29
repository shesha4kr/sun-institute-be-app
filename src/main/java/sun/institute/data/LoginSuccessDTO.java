package sun.institute.data;

public class LoginSuccessDTO {

	boolean isValid = false;
	String userName;
	Integer studId;

	public LoginSuccessDTO() {
		super();
	}

	public LoginSuccessDTO(boolean isValid, String userName, Integer studId) {
		super();
		this.isValid = isValid;
		this.userName = userName;
		this.studId = studId;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
	}

	@Override
	public String toString() {
		return "LoginSuccessDTO [isValid=" + isValid + ", userName=" + userName + ", studId=" + studId + "]";
	}

}
