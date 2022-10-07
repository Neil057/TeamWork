package com.neil.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neil.demo.model.Customer;
import com.neil.demo.model.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository cDao;
	

	@GetMapping(path = "/customer/insert")
	public Customer insert() {
		Customer c1 = new Customer();
		c1.setName("廖老大");
		c1.setLevel(5);
		
		Customer resCus = cDao.save(c1);
		
		return resCus;
		
	}
	

	@PostMapping(path = "/customer/insert2")
	public Customer insert2(@RequestBody Customer cus) {
		return cDao.save(cus);
	}
	

	@PostMapping(path = "/customer/insert3")
	public List<Customer> insert3(@RequestBody List<Customer> reqList){
		return cDao.saveAll(reqList);
	}
	
	
	@GetMapping(path = "/customer/{id}")
	public Customer findById(@PathVariable Integer id) {
		Optional<Customer> optional = cDao.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		Customer noFoundC = new Customer();
		noFoundC.setName("沒有這筆資料");
		
		return noFoundC;
		
	}
	
	
	@GetMapping("/customer/all")
	public List<Customer> findAllCustomer(){
		return cDao.findAll();
	}
	
	
	@GetMapping("/customer/delete")
	public String deleteById(@RequestParam Integer id) {
		
		try {
			cDao.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			return "沒有這筆資料";
		}
		
		return "做了一個刪除";
	}
	

	@GetMapping("/customer/page/{pageNumber}")
    public List<Customer> findByPage(@PathVariable Integer pageNumber){
    	Pageable pgb = PageRequest.of(pageNumber-1, 2,Sort.Direction.ASC, "id");
    	Page<Customer> page = cDao.findAll(pgb);
    	List<Customer> list = page.getContent();
    	return list;
    }
	
	
	
	
	@GetMapping("/customer/name")
	public Customer findCustomerByName(@RequestParam String name) {
		return cDao.findCustomerByName3(name);
		//		return cDao.findCustomerByName(name);
	}
	
	
	@GetMapping("/customer/delete/{id}")
	public boolean deleteByid(@PathVariable Integer id) {
		cDao.deleteCustomerById(id);
		return true;
	}
	
	
	//findByLevelOrderById
	@GetMapping("/customer/level/{level}")
	public List<Customer> findByLevel(@PathVariable Integer level){
		return cDao.findByLevelOrderById(level);
	}
	
	

}
