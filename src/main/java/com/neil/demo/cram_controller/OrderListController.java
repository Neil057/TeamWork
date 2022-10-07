package com.neil.demo.cram_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.neil.demo.cram_model.OrderList;
import com.neil.demo.cram_service.OrderListService;

@Controller
public class OrderListController {
	
	@Autowired
	private OrderListService orderListService;
	
	//找全部班級對應學生清單
		@GetMapping("/findAllOrderList.controller")
		public String findAllOrderList(Model model) {
			 List<OrderList> orderListList = orderListService.findAllOrderList();
			 model.addAttribute("orderListList", orderListList);
			 return "cs_orderList/orderListIndex";
		}


}
