package employeeManager;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EmployeeManager
{
	public void runManager()
	{
		Scanner scan = new Scanner(System.in);
		Queue<Department> departments = new LinkedList<Department>();
		
		Department unemployeed = new Department("Unemployed");

		boolean running = true;
		
		System.out.println("Welcome to The Employee Manager : \nType \"help\" to view commands");
		while(running)
		{
			String input = scan.next();
			
			if(input.equalsIgnoreCase("help")) 
			{
				System.out.println("• Add <department> - Creates a new department in queue\n"
						+ "• Hire <person> <department> - <person> is added to <department>\n"
						+ "• Quit <person> - <person> is removed from his or her department\n"
						+ "• Change <person> <department> - <person> is moved from old department to "
						+ "<department>\n"
						+ "• Payroll - Each executive's salary is computed and displayed by department in decreasing "
						+ "order of seniority\n"
						+ "• Salary <person> - Gets the salary of a specific person\n"
						+ "• Exit - Ends the program");
			}
			else if(input.equalsIgnoreCase("add")) 
			{
				//System.out.print("Enter new department name : ");
				input = scan.next();
				departments.offer(new Department(input));
				System.out.print("The department " + input + " was created. \n");
			}
			else if(input.equalsIgnoreCase("hire")) 
			{
				//System.out.print("Enter employee name : ");
				String name = scan.next();
				
				Employee emp = new Employee(name);
				
				//System.out.print("Enter department name : ");
				input = scan.next();
				
				Queue<Department> tempDepts = new LinkedList<Department>();
				
				int size = departments.size();
				for(int i = 0; i < size; i++) 
				{
					Department temp = departments.peek();
					if(temp.getName().equalsIgnoreCase(input)) 
					{
						temp.addEmployee(emp);
					}
					tempDepts.offer(departments.poll());
				}
				departments = tempDepts;
				
				System.out.print(name + " was hired into " + input + "\n");

			}
			else if(input.equalsIgnoreCase("quit")) 
			{
				//System.out.print("Enter employee name : ");
				input = scan.next();
				
				Queue<Department> tempDepts = new LinkedList<Department>();
				
				int size = departments.size();
				for(int i = 0; i < size; i++) 
				{
					Department temp = departments.peek();
					
					Employee tempEmployee = temp.removeEmployee(input);
					if(tempEmployee != null) 
					{
						unemployeed.addEmployee(tempEmployee);
						System.out.println("Employee " + input + " has quit from " + temp.getName());
					}
					tempDepts.offer(departments.poll());
				}
				departments = tempDepts;

			}
			else if(input.equalsIgnoreCase("change")) 
			{
				String name = scan.next();
				
				input = scan.next();
				
				Employee empMove = null;
				
				Queue<Department> tempDepts = new LinkedList<Department>();
				
				int size = departments.size();
				for(int i = 0; i < size; i++) 
				{
					Department temp = departments.peek();
					
					Employee tempEmployee = temp.removeEmployee(name);
					if(tempEmployee != null) 
					{
						empMove = tempEmployee;
					}
					tempDepts.offer(departments.poll());
				}
				departments = tempDepts;
				
				// add empMove
				
				tempDepts = new LinkedList<Department>();
				
				size = departments.size();
				for(int i = 0; i < size; i++) 
				{
					Department temp = departments.peek();
					if(temp.getName().equalsIgnoreCase(input)) 
					{
						temp.addEmployee(empMove);
					}
					tempDepts.offer(departments.poll());
				}
				departments = tempDepts;
				
				System.out.print(name + " was moved into " + input + "\n");
			}
			else if(input.equalsIgnoreCase("payroll")) 
			{
				Queue<Department> tempDept = new LinkedList<Department>();
				
				int size = departments.size();
				for(int i = 0; i < size; i++) 
				{
					System.out.println("Department : " + departments.peek().getName());
					Department currentDept = departments.peek();
					currentDept.payroll();
					
					tempDept.offer(departments.poll());
				}
				departments = tempDept;
				
				System.out.println("Unemployeed : ");
				unemployeed.listPeople();
		
			}
			else if(input.equalsIgnoreCase("salary")) 
			{
				//System.out.print("Enter employee name : ");
				input = scan.next();
				
				Queue<Department> tempDepts = new LinkedList<Department>();
				
				int size = departments.size();
				for(int i = 0; i < size; i++) 
				{	
					departments.peek().showPay(input);
					
					tempDepts.offer(departments.poll());
				}
				departments = tempDepts;
				
			}
			else if(input.equalsIgnoreCase("exit")) 
			{
				running = false;
			}
		}
		System.out.println("Ending Program");
		scan.close();
	}
}
