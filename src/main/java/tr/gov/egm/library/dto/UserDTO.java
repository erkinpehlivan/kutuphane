package tr.gov.egm.library.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO {
	
	@NotEmpty
	@Length(min = 5, max = 20)
	private String username;
	@NotEmpty
	@Length(min = 5)
	private String password;
	@NotEmpty
	@Length(min = 5)
	private String passwordAgain;
	@NotEmpty
	@Length(min = 5)
	private String newPassword;
	@NotEmpty
	@Length(min = 5)
	private String newPasswordAgain;

	public UserDTO() {
	}

	public UserDTO(String username, String password, String passwordAgain, String newPassword,
			String newPasswordAgain) {
		this.username = username;
		this.password = password;
		this.passwordAgain = passwordAgain;
		this.newPassword = newPassword;
		this.newPasswordAgain = newPasswordAgain;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordAgain() {
		return newPasswordAgain;
	}

	public void setNewPasswordAgain(String newPasswordAgain) {
		this.newPasswordAgain = newPasswordAgain;
	}

}
