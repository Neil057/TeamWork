package com.neil.demo.cram_service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neil.demo.cram_model.OrderList;
import com.neil.demo.cram_model.OrderListDao;

@Service
@Transactional
public class OrderListService {
	
	@Autowired
	private OrderListDao orderListDao;

	// 找所有訂單紀錄OrderList
	public List<OrderList> findAllOrderList() {
		List<OrderList> orderListList = orderListDao.findAll();
		return orderListList;
	}

}
