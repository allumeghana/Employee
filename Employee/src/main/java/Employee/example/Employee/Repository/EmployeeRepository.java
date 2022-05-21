package Employee.example.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Employee.example.Employee.Model.Employee;

@Repository
	public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	}


