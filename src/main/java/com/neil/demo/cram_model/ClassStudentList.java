package com.neil.demo.cram_model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ClassStudentList")
public class ClassStudentList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="classStudentList_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="fk_classlist_id")
	@JsonBackReference
	private ClassList classList;
	
	@ManyToOne
	@JoinColumn(name="fk_student_id")
	@JsonBackReference
	private Student student;
	
	@Column(name="studentId")
	private int studentId;

	public ClassStudentList() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClassList getClassList() {
		return classList;
	}

	public void setClassList(ClassList classList) {
		this.classList = classList;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	

}
