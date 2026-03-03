package com.lpu.springBootBasics;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	public Employee getByName(String name);
	
	// So spring automatically converts this into 
	//select * from employees where name=:name;
	// # keywords getBy, findBy, readBy
	
	
	public Employee getBySalary(double salary);
	
	@Modifying //As we know this repository only understands the query commands like select read we are telling the spring that this function modifies the data
	@Transactional //this method is binded with a transaction for the consistency because we are modifying the data
	@Query(value="update employees set salary=:newSalary where salary=:oldSalary",nativeQuery = true)
	public int updateBySalary(@Param("oldSalary") double oldSalary,@Param("newSalary") double newSalary);
	
	
	
	
	
	

	
	
}
