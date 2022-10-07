package com.neil.demo.cram_controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neil.demo.cram_model.ClassList;
import com.neil.demo.cram_service.ClassListService;

@Controller
public class ClassListController {
	
	@Autowired
	private ClassListService classListService;
	
	//顯示頁面
	@GetMapping("/classListIndexAjax")
	public String showClassListIndexAjax() {
		 return "cs_classList/classListIndexAjax";
	}
	
	//找全部課程
		@GetMapping("/findAllClassListAjax.controller")
		public @ResponseBody List<ClassList> findAllClssList(Model model) {
			 List<ClassList> classListList = classListService.findAllClassList();
			 return classListList;
		}

}
