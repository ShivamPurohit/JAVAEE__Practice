package com.codesp07.RestApiImplementation.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	int Rollno;
	private String username;
	private String email;
	private String pass;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_fk",referencedColumnName = "Rollno")
	private List<Posts> posts = new ArrayList();
	
	private boolean active;
	private int otp;
	private LocalDate localDate;
	private LocalTime localTime;

	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public LocalTime getLocalTime() {
		return localTime;
	}
	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	
	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}

	public User() {}
	
//	public User(String username, String emailId, String pass) {
//		super();
////		Rollno = rollno;
//		this.username = username;
//		this.email = emailId;
//		this.pass = pass;
//	}
	public int getRollno() {
		return Rollno;
	}
	public void setRollno(int rollno) {
		Rollno = rollno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Alien [Rollno=" + Rollno + ", username=" + username + ", emailId=" + email + ", password=" + pass
				+ "]";
	}
	
}
