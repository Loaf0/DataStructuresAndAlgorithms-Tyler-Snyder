package employeeManager;

import java.util.LinkedList;
import java.util.Queue;

public class Department
{
	private Queue<Employee> queue;
	private String name;

	public Department(String newName)
	{
		name = newName;
		queue = new LinkedList<Employee>();
	}

	public Employee poll() 
	{
		return queue.poll();
	}
	
	public void addEmployee(Employee employee)
	{
		queue.add(employee);
	}
	
	public void addEmployee(String name)
	{
		queue.add(new Employee(name));
	}

	public Employee removeEmployee(String name)
	{
		Queue<Employee> temp = queue;
		Employee emp = null;

		int size = queue.size();
		
		for (int i = 0; i < size; i++)
		{
			if (queue.peek().getName().equals(name))
			{
				emp = queue.poll();
			}
			else
			{
				temp.offer(queue.poll());				
			}
		}
		queue = temp;
		return emp;
	}

	public int getSize()
	{
		return queue.size();
	}

	public boolean contains(String target) 
	{
		Queue<Employee> temp = queue;
		int size = queue.size();
		for (int i = 0; i < size; i++)
		{
			if(queue.peek().getName().equalsIgnoreCase(target)) 
			{
				return true;
			}
			temp.offer(queue.poll());
		}
		queue = temp;
		return false;
	}
	
	public void payroll()
	{
		Queue<Employee> temp = queue;
		int pay = 40000 + (queue.size()-1) * 5000;
		int size = queue.size();
		for (int i = 0; i < size; i++)
		{
			System.out.println("The pay of " + queue.peek().getName() + " is $" + pay + ".00");
			pay -= 5000;
			temp.offer(queue.poll());
		}
		queue = temp;
	}
	
	public void listPeople() 
	{
		Queue<Employee> temp = queue;
		int size = queue.size();
		for (int i = 0; i < size; i++)
		{
			System.out.println(queue.peek().getName());
			temp.offer(queue.poll());
		}
		queue = temp;
	}

	public void showPay(String name)
	{
		boolean found = false;
		int pay = 40000;
		Queue<Employee> temp = queue;

		int size = queue.size();
		for (int i = 0; i < size; i++)
		{
			if (found)
			{
				pay += 5000;
			}
			if (queue.peek().getName().equalsIgnoreCase(name))
			{
				found = true;
			}
			temp.offer(queue.poll());
		}
		queue = temp;
		
		if(found)
			System.out.println("The pay of " + name + " is $" + pay + ".00");
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
