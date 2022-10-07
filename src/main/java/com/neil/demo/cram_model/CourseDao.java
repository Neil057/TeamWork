package com.neil.demo.cram_model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseDao extends JpaRepository<Course,Integer> {

	
	@Query(value = "from Course where courseOnOff = ?1")
	List<Course> findCourseByOnOrOff(int courseOnOff);
	
	@Query(value = "from Course where courseGrade = ?1 and courseOnOff = ?2")
	List<Course> findCourseByGrade(String grade,int courseOnOff);
	
	@Query(value = "from Course where courseSubject = ?1")
	List<Course> findCourseBySubject(String subject,int courseOnOff);
	
	@Query(value = "from Course where courseCategory = ?1")
	List<Course> findCourseByCategory(String category,int courseOnOff);
}
