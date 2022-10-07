package com.neil.demo.cram_controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.neil.demo.cram_model.ClassStudentList;
import com.neil.demo.cram_service.ClassStudentListService;

@Controller
public class ClassStudentListController {
	
	@Autowired
	private ClassStudentListService classStudentListService;
	
	//找全部班級對應學生清單
		@GetMapping("/findAllClassStudentList.controller")
		public String findAllClassStudentList(Model model) {
			 List<ClassStudentList> cslList = classStudentListService.findAllClassStudentList();
			 model.addAttribute("cslList", cslList);
			 return "cs_classStudentList/classStudentListIndex";
		}

}
