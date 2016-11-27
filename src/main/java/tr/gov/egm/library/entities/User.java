package tr.gov.egm.library.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
	@SequenceGenerator(name = "user_gen", sequenceName = "users_seq")
	private Integer id;
	private String username;
	private String password;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USERS_PERMISSION", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID"))
	private List<Permission> permissions;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Log> logs;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Rezervation> rezervations;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(Integer id, String username, String password, List<Permission> permissions, List<Log> logs, List<Rezervation> rezervations) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.permissions = permissions;
		this.logs = logs;
		this.rezervations = rezervations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public List<Rezervation> getRezervations() {
		return rezervations;
	}

	public void setRezervations(List<Rezervation> rezervations) {
		this.rezervations = rezervations;
	}

}