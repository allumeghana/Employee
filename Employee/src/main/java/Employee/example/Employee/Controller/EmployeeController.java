package Employee.example.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Employee.example.Employee.Exeception.EmployeeNotFoundExeception;
import Employee.example.Employee.Model.Employee;
import Employee.example.Employee.Repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	
		@Autowired
		EmployeeRepository employeerepository;
		
		
		@GetMapping("/employee")
		public List<Employee> getallemployee(){
			return employeerepository.findAll();
		}
		@PostMapping("/employee")
		public Employee createemployee(@Validated @RequestBody Employee employee) {
		     return employeerepository.save(employee);	
		}
		@PutMapping("/employee/{id}")
		public Employee updateemployee(@PathVariable(value="id") Long id,
			@Validated @RequestBody Employee Employeedetails)throws EmployeeNotFoundExeception{
			Employee employee=employeerepository.findById(id)
					 .orElseThrow(()->new EmployeeNotFoundExeception(id));
		employee.setName(Employeedetails.getName());
		           employee.setDesgination(Employeedetails.getDesgination());
		           employee.setSalary(Employeedetails.getSalary());
		           Employee updatedemployee=employeerepository.save(employee);
		           return updatedemployee;
			}

	}	
	
	
	
	
	


