package com.neil.demo.cram_controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.neil.demo.cram_model.ClassRecord;
import com.neil.demo.cram_service.ClassRecordService;

@Controller
public class ClassRecordController {
	
	@Autowired
	private ClassRecordService classRecordService;
	
	//找全部課程
		@GetMapping("/findAllClassRecord.controller")
		public String findAllClssList(Model model) {
			 List<ClassRecord> classRecordList = classRecordService.findAllClassRecord();
			 model.addAttribute("classRecordList", classRecordList);
			 return "cs_classRecord/classRecordIndex";
		}

}
