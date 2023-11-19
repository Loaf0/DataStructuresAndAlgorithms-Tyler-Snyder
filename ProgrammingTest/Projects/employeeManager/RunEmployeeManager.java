package employeeManager;

public class RunEmployeeManager
{
	public static void main(String[] args) 
	{
		/*
		Department dept = new Department("test Department");
		dept.addEmployee(new Employee("Bob"));
		dept.addEmployee(new Employee("Cob"));
		dept.addEmployee(new Employee("Lob"));
		
//		dept.showPay("Bob");
//		dept.showPay("Cob");
//		dept.showPay("Lob");
		
		dept.payroll();
		
		dept.addEmployee(dept.removeEmployee("Cob"));
		System.out.println(dept.contains("Cob"));
		dept.payroll()*/
		EmployeeManager em = new EmployeeManager();
		em.runManager();
	}
}
