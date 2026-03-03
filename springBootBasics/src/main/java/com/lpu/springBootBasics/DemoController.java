package com.lpu.springBootBasics;

import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.PageRanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/a")
	public String getHi() {
		return "Hi ra badkow";
	}

//	 http://localhost:9091/path/Varun/12217815
	@GetMapping("/path/{name}/{id}")
	public String sendData(@PathVariable String name, @PathVariable int id) {
		System.out.println(name);
		System.out.println(id);
		return "Received PathVariable -> Name: " + name + ", Id: " + id;
	}

//	    http://localhost:9091/reqParam?name=Varun&id=12217815
	@GetMapping("/reqParam")
	public String getData(@RequestParam String name, @RequestParam int id) {
		System.out.println(name);
		System.out.println(id);
		return "Received RequestParam -> Name: " + name + ", Id: " + id;
	}

	@PostMapping("/emp")
	public String createEmployee(@RequestBody Employee employee) {
		System.out.println("Employee Created Successfully!");
		employeeRepository.save(employee);
		return "Success";

	}

	@GetMapping("/getId/{id}")
	public Employee getById(@PathVariable int id) {
		Optional<Employee> emp = employeeRepository.findById(id);

		if (emp.isPresent()) {
			return emp.get();
		} else {
			throw new EmployeeNotFoundException("Employee not found with id: " + id);

		}

	}

	@GetMapping("/getAll")
	public List<Employee> getAllEmployees() {
		List<Employee> list = employeeRepository.findAll();
		return list;
	}

	@PutMapping("/updateId/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		Employee emp = getById(id);
		if (emp == null) {
			throw new EmployeeNotFoundException("Employee not found with id: " + id);
		}
		emp.setId(employee.getId());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());

		employeeRepository.save(emp);
		return "Data Updated";

	}

	@PatchMapping("/partialUpdate/{id}")
	public String updatePartialEmployee(@PathVariable int id, @RequestBody Employee emp) {
		Employee employee = getById(id);

		if (emp == null) {
			throw new EmployeeNotFoundException("Employee not found with id: " + id);
		}
		if (emp.getName() != null) {
			employee.setName(emp.getName());
		} else if (emp.getId() != 0) {
			employee.setId(emp.getId());
		} else if (emp.getSalary() != 0.0) {
			employee.setSalary(emp.getSalary());

		}
		employeeRepository.save(employee);

		return "Updated the Partial data of the employee";
	}

	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		Employee employee = getById(id);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee not found with id: " + id);
		}
		employeeRepository.delete(employee);

		return "Employee Deleted Successfully";
	}

	@GetMapping("/getEmpByName/{name}")
	public Employee findByName(@PathVariable String name) {
		return employeeRepository.getByName(name);
	}

	@GetMapping("/getBySalary/{salary}")
	public Employee findBySalary(@PathVariable double salary) {
		return employeeRepository.getBySalary(salary);

	}

	@PatchMapping("/updateBuSalary/{oldSalary}/{newSalary}")
	public String updateEmpBySalary(@PathVariable double oldSalary, @PathVariable double newSalary) {
		int count = employeeRepository.updateBySalary(oldSalary, newSalary);

		if (count > 0) {

			return "Successfully Updated!";
		} else {
			throw new EmployeeNotFoundException("Employee Not Found");
		}
	}

	
	
	@GetMapping("/getPage/{page}/{size}")
public Page<Employee> getEmpData(@PathVariable int page,@PathVariable int size) {
	Page<Employee> pageable=employeeRepository.findAll(PageRequest.of(page, size));
	return pageable;
}
	
	
	
	

}
