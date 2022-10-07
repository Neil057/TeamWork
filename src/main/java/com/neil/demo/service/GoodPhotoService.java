package com.neil.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.demo.model.GoodPhoto;
import com.neil.demo.model.GoodPhotoDao;

@Service
@Transactional
public class GoodPhotoService {
	
	@Autowired
	private GoodPhotoDao gDao;

	
	public GoodPhoto insertGoodPhoto(GoodPhoto gp) {
		return gDao.save(gp);
	}
	
	public List<GoodPhoto> listGoodPhoto() {
		return gDao.findAll();
	}
	
	public GoodPhoto getPhotoById(Integer id) {
		Optional<GoodPhoto> op = gDao.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		}
		
		return null;
	}
	
	
}
