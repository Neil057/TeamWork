package com.neil.demo.cram_model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="STUDENT")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private Integer id;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "student",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ClassStudentList> classStudentLists;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_user_id")
	private Users users;
	
	@Column(name="name",columnDefinition = "nvarchar(15)", nullable = false)
	private String name;
	
	@Column(name="gender",columnDefinition = "nvarchar(5)", nullable = false)
	private String gender;
	
	@Column(name="schooltype",columnDefinition = "nvarchar(5)", nullable = false)
	private String schoolType;
	
	@Column(name="schoolname",columnDefinition = "nvarchar(10)", nullable = false)
	private String schoolName;
	
	@Column(name="grade",columnDefinition = "nvarchar(5)", nullable = false)
	private String grade;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_parent_id")
	private Parent parent;
	
	@Column(name="relationship",columnDefinition = "varchar(10)", nullable = false)
	private String relationship;
	
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







	public List<ClassStudentList> getClassStudentLists() {
		return classStudentLists;
	}



	public void setClassStudentLists(List<ClassStudentList> classStudentLists) {
		this.classStudentLists = classStudentLists;
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



	public String getSchoolType() {
		return schoolType;
	}



	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}



	public String getSchoolName() {
		return schoolName;
	}



	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public Parent getParent() {
		return parent;
	}



	public void setParent(Parent parent) {
		this.parent = parent;
	}



	public String getRelationship() {
		return relationship;
	}



	public void setRelationship(String relationship) {
		this.relationship = relationship;
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



	public Student() {
		// TODO Auto-generated constructor stub
	}

}
