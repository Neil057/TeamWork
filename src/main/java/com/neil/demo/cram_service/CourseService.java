package com.neil.demo.cram_service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neil.demo.cram_model.Course;
import com.neil.demo.cram_model.CourseDao;

@Service
@Transactional
public class CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	//新增課程商品
	public void insertCourse(Course course) {
		courseDao.save(course);
	}
	//找課程商品圖片
	public Course getCoursePicById(Integer id) {
		Optional<Course> op = courseDao.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
	
	//找所有商品for後端使用
	public List<Course> findAllCourse(){
		return courseDao.findAll();
	}
	
	//找所有上架中的商品
	public List<Course> findCourseByOn(){
		 List<Course> courseList = courseDao.findCourseByOnOrOff(1);
		 return courseList;
	}
	
	//找對應的學級商品
	public List<Course> findCourseByGrade(String grade){
		return courseDao.findCourseByGrade(grade,1);
	}
	
	//找對應的主科商品
	public List<Course> findCourseBySubject(String subject){
		return courseDao.findCourseBySubject(subject,1);
	}
	
	//找對應的主科商品
	public List<Course> findCourseByCategory(String category){
		return courseDao.findCourseByCategory(category,1);
	}
	
	

}
