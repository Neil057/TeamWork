package com.neil.demo.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "from Customer where name = ?1")
	Customer findCustomerByName(String name);
	
	@Query(value = "from Customer where name = :name")
	Customer findCustomerByName2(@Param("name") String name);
	
	@Query(value = "select * from Customer where name = :name", nativeQuery = true)
	Customer findCustomerByName3(@Param("name") String name);
	
	@Transactional
	@Modifying
	@Query(value="delete from customer where id = :id", nativeQuery = true) 
	void deleteCustomerById(@Param("id") Integer id);
	
    List<Customer> findByLevelOrderById(Integer level);
	
}
