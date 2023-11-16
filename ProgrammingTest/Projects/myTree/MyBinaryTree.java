package myTree;
/*
* @author Tyler Snyder
* @date 11/16/23
* This is a binary tree data type I programmed for class
*/ 

public class MyBinaryTree
{
	private TreeNode root;
	private int size = 0;
	
	public MyBinaryTree() 
	{
		
	}
	
	public MyBinaryTree(int data) 
	{
		root = new TreeNode(data);
	}

	public boolean contains(int value) 
	{
		if(root.getData() == value) 
		{
			return true;
		}
		
		return root.contains(value);
	}
	
	public void add(int[] arr) 
	{
		for(int i : arr) 
		{
			add(i);
		}
	}
	
	public void add(int newData) 
	{
		size = getSize() + 1;
		if(root == null) 
		{
			root = new TreeNode(newData);
		}
		else 
		{
			root.add(newData);
		}
	}
	
	public boolean remove(int target) // node.remove() is UNFINISHED wont run
	{
		if(root.contains(target)) 
		{
			root.remove(target);
			return true;
		}
		return false; //target doesn't exist
	}
	
	public TreeNode getRoot()
	{
		return root;
	}

	public void setRoot(TreeNode root)
	{
		this.root = root;
	}

	public int getSize()
	{
		return size;
	}
	
	public void printPreorder()
	{
		System.out.println(root.preorderToString().substring(1)); //clean up output
	}
	
	public void printPostorder()
	{
		System.out.println(root.postorderToString());
	}
}
