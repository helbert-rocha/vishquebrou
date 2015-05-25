package br.com.vishquebrou.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String fname;
	private String lname;
	
	@Column(nullable=false, unique=true)
	private String username;
	private String password;
	@Column(nullable=false, unique=true)
	private String email;
	
	@ManyToOne
	private Enterprise enterprise;
	
	public Employee(){}

	public Employee(String fname, String lname, String username,
			String password, String email, Enterprise enterprise) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.enterprise = enterprise;
	}
	
	public long getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	
}
