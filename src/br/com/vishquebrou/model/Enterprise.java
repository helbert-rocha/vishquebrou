package br.com.vishquebrou.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Enterprise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String type = "";
	private String state = "";
	private String city = "";
	private String district = "";
	
	public Enterprise() {}

	public Enterprise(String name, String type, String state, String city,
			String district) {
		super();
		this.name = name;
		this.type = type;
		this.state = state;
		this.city = city;
		this.district = district;
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
	
	 
	
}
