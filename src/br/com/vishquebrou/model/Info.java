package br.com.vishquebrou.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Info {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String description;
	private String date;
	private String status;
	
	@ManyToOne
	private Enterprise enterprise;
	
	public Info(){}

	public Info(String description, String date, String status, Enterprise enterprise) {
		this.description = description;
		this.date = date;
		this.status = status;
		this.enterprise = enterprise;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public long getId() {
		return id;
	}
	
}
