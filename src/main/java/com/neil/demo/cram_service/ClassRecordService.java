package com.neil.demo.cram_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neil.demo.cram_model.ClassRecord;
import com.neil.demo.cram_model.ClassRecordDao;

@Service
@Transactional
public class ClassRecordService {

	@Autowired
	private ClassRecordDao classRecordDao;

	// 找所有已上課紀錄ClassRecord
	public List<ClassRecord> findAllClassRecord() {
		List<ClassRecord> crList = classRecordDao.findAll();
		return crList;
	}
}
