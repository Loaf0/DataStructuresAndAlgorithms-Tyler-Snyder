package myTree;
/*
* @author Tyler Snyder
* @date 11/16/23
* This is a node (Data Container) for MyBinaryTree Class
*/

public class TreeNode
{
	private TreeNode left;
	private TreeNode right;
	private int data;

	public TreeNode(int newData)
	{
		data = newData;
	}
	
	public void remove(int target) 
	{
		if (target != data)
		{
			if (target < data)
			{
				
			}
			else
			{
				
			}
		}
		else 
		{
			
		}
	}
	
	public void add(int newData)
	{
		if (newData != data)
		{
			if (newData < data)
			{
				if (left != null)
					left.add(newData);
				else
					left = new TreeNode(newData);
			}
			else
			{
				if (right != null)
					right.add(newData);
				else
					right = new TreeNode(newData);
			}
		}
	}

	public boolean contains(int value)
	{
		if (value == data)
			return true;

		if (value < data)
		{
			if (left != null) 
			{
				if (left.getData() == value)
					return true; 
				else
					return left.contains(value);
			}
		}
		else
		{
			if (right != null) 
			{
				if (right.getData() == value)
					return true; 
				else
					return right.contains(value);
			}
			else
				return false;
		}
		return false;
	}

	public String preorderToString()
	{
		// grab left side add self grab right side
		String output = "";
		if (left != null)
		{
			output = output + left.preorderToString();
		}

		output = output + " " + data;

		if (right != null)
		{
			output = output + right.preorderToString();
		}

		return output;
	}

	public String postorderToString()
	{
		// grab right side add self grab left side
		String output = "";
		if (left != null)
		{
			output = left.postorderToString() + output;
		}

		output = data + " " + output;

		if (right != null)
		{
			output = right.postorderToString() + output;
		}

		return output;
	}

	public int getData()
	{
		return data;
	}

	public TreeNode getLeft()
	{
		return left;
	}

	public TreeNode getRight()
	{
		return right;
	}

	public void setLeft(TreeNode left)
	{
		this.left = left;
	}

	public void setRight(TreeNode right)
	{
		this.right = right;
	}

}