package com.neil.demo.cram_service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neil.demo.cram_model.ClassStudentList;
import com.neil.demo.cram_model.ClassStudentListDao;

@Service
@Transactional
public class ClassStudentListService {
	
	@Autowired
	private ClassStudentListDao classStudentListDao;

	// 找所有已上課紀錄ClassRecord
	public List<ClassStudentList> findAllClassStudentList() {
		List<ClassStudentList> cslList = classStudentListDao.findAll();
		return cslList;
	}

}
