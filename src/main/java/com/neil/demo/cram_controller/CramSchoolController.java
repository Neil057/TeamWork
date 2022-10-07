package com.neil.demo.cram_controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.neil.demo.cram_model.Course;
import com.neil.demo.cram_service.CourseService;


@Controller
public class CramSchoolController {

	@Autowired
	private CourseService courseService;
	
	//課程方案建立Course
	@PostMapping("courseDataCreate.controller")
	public String courseCreateAction(
			@RequestParam(name="courseYear", required = true) int courseYear,
			@RequestParam(name="courseSemester", required = true) String courseSemester,
			@RequestParam(name="courseCategory", required = true) String courseCategory,
			@RequestParam(name="courseSubject", required = true) String courseSubject,
			@RequestParam(name="courseGrade", required = true) String courseGrade,
			@RequestParam(name="courseClass", required = true) int courseClass,
			@RequestParam(name="coursePrice", required = true) int coursePrice,
			@RequestParam(name="courseTeachTime", required = true) String courseTeachTime,
			@RequestParam(name="courseMember", required = true) int courseMember,
			@RequestParam(name="startDate", required = true) Date startDate,
			@RequestParam(name="endDate", required = true) Date endDate,
			@RequestParam(name="courseOnOff", required = true) int courseOnOff,
			@RequestParam(name="coursePic") MultipartFile file,RedirectAttributes redirectAttributes){
		Course course1 = new Course();
		try {
			course1.setCourseCategory(courseCategory);
			course1.setCourseClass(courseClass);
			course1.setCourseGrade(courseGrade);
			course1.setCourseMember(courseMember);
			course1.setCourseOnOff(courseOnOff);
			course1.setCoursePrice(coursePrice);
			course1.setCourseSemester(courseSemester);
			course1.setCourseSubject(courseSubject);
			course1.setCourseTeachTime(courseTeachTime);
			course1.setCourseYear(courseYear);
			course1.setEndDate(endDate);
			course1.setStartDate(startDate);
			course1.setCoursePic(file.getBytes());
			courseService.insertCourse(course1);
			return "redirect:/courseCreate.page";
		} catch (IOException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorMsg", "上傳失敗，請重新上傳");
			return "redirect:/courseCreate.page";
		}
	}
	
	//商品總total頁面(for後台)
	@GetMapping("/AllCourse.page")
	public String findAllCourse(Model model) {
		List<Course> courseList = courseService.findAllCourse();
		model.addAttribute("courseList", courseList);
		return "";
	}
	
	//商品總total頁面(for前台)
	@GetMapping("/AllOnCourse.page")
	public String findAllOnCourse(Model model) {
		List<Course> courseList = courseService.findCourseByOn();
		model.addAttribute("courseList",courseList);
		return "cramschool/courseIndex";
	}
	
	//商品總total頁面--圖片(for前台)
	@GetMapping("AllOnCoursePic/{id}")
	public ResponseEntity<byte[]> downloadImage(@PathVariable Integer id){
		Course Course1 = courseService.getCoursePicById(id);
		byte[] photoFile = Course1.getCoursePic();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		// 資料, header, HttpStatus
		return new ResponseEntity<byte[]>(photoFile, headers, HttpStatus.OK);
	}
	
	//商品總total頁面--以學級(小學/國中/高中)篩選(for前台)
	@GetMapping("/findAllCourseByGrade.page")
	public String findAllCourseByGrade(@RequestParam(name="grade")String grade,Model model) {
		List<Course> courseList = courseService.findCourseByGrade(grade);
		model.addAttribute("courseList", courseList);
		return "cramschool/courseIndex";
	}
	
	//商品總total頁面--以科目(國/英/數)篩選(for前台)
	@GetMapping("/findAllCourseBySubject.page")
	public String findCourseBySubject(@RequestParam(name="subject")String subject,Model model) {
		List<Course> courseList = courseService.findCourseBySubject(subject);
		model.addAttribute("courseList", courseList);
		return "cramschool/courseIndex";
	}
	
	//商品總total頁面--以類型(日常/衝刺)篩選(for前台)
	@GetMapping("/findAllCourseByCategory.page")
	public String findCourseByCategory(@RequestParam(name="category")String category,Model model) {
		List<Course> courseList = courseService.findCourseByCategory(category);
		model.addAttribute("courseList", courseList);
		return "cramschool/courseIndex";
	}

}
