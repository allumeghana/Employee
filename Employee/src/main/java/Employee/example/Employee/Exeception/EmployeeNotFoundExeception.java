package Employee.example.Employee.Exeception;

public class EmployeeNotFoundExeception extends Exception {
	private long id;
	public EmployeeNotFoundExeception(long id) {
		super(String.format("Employee is not found with id:'%s'",id));
	}

}	


