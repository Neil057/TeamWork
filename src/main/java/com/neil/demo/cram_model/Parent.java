package com.neil.demo.cram_model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="PARENT")
public class Parent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="parent_id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_user_id" , nullable = false)
	private Users users;
	
	@Column(name="name",columnDefinition = "nvarchar(15)", nullable = false)
	private String name;
	
	@Column(name="gender",columnDefinition = "nvarchar(5)", nullable = false)
	private String gender;
	
	@Column(name="tel",columnDefinition = "nvarchar(15)", nullable = false)
	private String tel;
	
	@Column(name="email",columnDefinition = "nvarchar(50)", nullable = false)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	@Column(name="create_at", columnDefinition = "datetime default getDate()", nullable = false)
	private Date create_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	@Column(name="update_at", columnDefinition = "datetime default getDate()", nullable = false)
	private Date update_at;



	public Parent() {
		
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Users getUsers() {
		return users;
	}



	public void setUsers(Users users) {
		this.users = users;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getCreate_at() {
		return create_at;
	}



	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}



	public Date getUpdate_at() {
		return update_at;
	}



	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}
	
	

}
