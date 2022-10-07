package com.neil.demo.cram_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CS_PageController {
	
	@GetMapping("/course.page")
	public String coursePage() {
		return "cramschool/courseIndex";
	}
	
	//商品Create頁面-Course(for後台)
	@GetMapping("/courseCreate.page")
	public String courseCreatePage() {
		return "cramschool/courseCreate";
	}
	
	//教室Create頁面-Room(for後台)
	@GetMapping("/roomCreate.page")
	public String roomCreatePage() {
		return "cs_room/roomCreate";
	}
	
	//教室findAll頁面-Room(for後台)
	@GetMapping("/roomIndex.page")
	public String roomAllPage() {
		return "cs_room/roomIndex";
	}
	
	//教室Update頁面-Room(for後台)
	@GetMapping("/roomUpdate.page")
	public String roomUpdatePage() {
		return "cs_room/roomUpdate";
	}

}
