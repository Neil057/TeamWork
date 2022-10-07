package com.neil.demo.cram_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neil.demo.cram_model.ClassList;
import com.neil.demo.cram_model.ClassListDao;

@Service
@Transactional
public class ClassListService {

		@Autowired
		private ClassListDao classListDao;
		
		//找所有已開課課程資訊ClassList
		public List<ClassList> findAllClassList() {
			List<ClassList> clList = classListDao.findAll();
			return clList;
		}
}
