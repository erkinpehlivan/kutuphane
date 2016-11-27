package tr.gov.egm.library.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Permission implements Serializable {

	private static final long serialVersionUID = 7871545874084875848L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_gen")
	@SequenceGenerator(name = "permission_gen", sequenceName = "permission_seq")
	private Integer id;
	private String name;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "permissions")
	private List<User> users;

	public Permission() {
	}

	public Permission(String name) {
		this.name = name;
	}

	public Permission(Integer id, String name, List<User> users) {
		this.id = id;
		this.name = name;
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}