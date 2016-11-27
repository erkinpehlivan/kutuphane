package tr.gov.egm.library.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Log implements Serializable {

	private static final long serialVersionUID = -3200797258455797573L;
	public static final String INSERT = "insert";
	public static final String DELETE = "delete";
	public static final String UPDATE = "update";
	public static final String SELECT = "select";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_gen")
	@SequenceGenerator(name = "log_gen", sequenceName = "log_seq")
	private Integer id;
	private String entityType;
	private String operationType;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	@Column(name = "OPERATION_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	public Log() {
	}

	public Log(String entityType, String operationType, User user, Date date) {
		this.entityType = entityType;
		this.operationType = operationType;
		this.user = user;
		this.date = date;
	}

	public Log(Integer id, String entityType, String operationType, User user, Date date) {
		this.id = id;
		this.entityType = entityType;
		this.operationType = operationType;
		this.user = user;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}