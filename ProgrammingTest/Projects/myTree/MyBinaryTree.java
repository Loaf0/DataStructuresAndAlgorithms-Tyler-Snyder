package myTree;
/*
* @author Tyler Snyder
* @date 11/16/23
* This is a binary tree data type I programmed for class
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

	public void dftPrint()
	{
		System.out.println(root.dftString());
	}

	public void bfsPrint()
	{
		Queue<TreeNode> order = new LinkedList<TreeNode>();
		order.offer(root);
		System.out.println(root.bfsString(order));
	}

	public boolean dftContains(int target)
	{
		return root.dftContains(target);
	}

	public boolean bfsContains(int target)
	{
		Queue<TreeNode> order = new LinkedList<TreeNode>();
		order.offer(root);
		return root.bfsContains(order, target);
	}

	public int findLargestValue()
	{
		return root.findSucessor(root);
	}

	public void add(int[] arr)
	{
		for (int i : arr)
		{
			add(arr[i]);
		}
	}
	
	public void add(ArrayList<Integer> arr)
	{
		for(int i = 0; i < arr.size(); i++)
		{
			add(arr.get(i));
		}
	}

	public void add(int newData)
	{
		size = getSize() + 1;

		if (root == null)
		{
			root = new TreeNode(newData);
		}
		else
		{
			root.add(newData);
		}
	}

	public TreeNode delete(int target)
	{
		return root.recursiveDelete(root, target);
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
		System.out.println(root.preorderToString().substring(1)); // clean up output
	}

	public void printPostorder()
	{
		System.out.println(root.postorderToString());
	}
}
