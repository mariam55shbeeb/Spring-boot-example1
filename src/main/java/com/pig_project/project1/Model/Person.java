package com.pig_project.project1.Model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Persons")
public class Person {
	@Id
	String id;
	
	String fullName;
	List<String> email;
	
	
	
	public Person(String id, String fullName, List<String> email) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
	}
	/**
	 * @return the id
	 */
	
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the email
	 */
	public List<String> getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(List<String> email) {
		this.email = email;
	}
	
	
	

}
