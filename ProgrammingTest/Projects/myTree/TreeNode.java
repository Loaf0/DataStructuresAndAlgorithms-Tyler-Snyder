package myTree;

import java.util.Queue;

/*
* @author Tyler Snyder
* @date 11/16/23
* This is a node (Data Container) for MyBinaryTree Class
*/

public class TreeNode
{
	TreeNode left;
	TreeNode right;
	int data;

	public TreeNode(int newData)
	{
		data = newData;
	}

	public String dftString()
	{
		String output = "";

		if (left != null)
		{
			output = output + left.dftString();
		}

		output = output + data + " ";

		if (right != null)
		{
			output = output + right.dftString();
		}

		return output;
	}

	public String bfsString(Queue<TreeNode> order)
	{
		String output = "";
		while(!order.isEmpty())
		{
			if(order.peek().getLeft() != null) 
			{
				order.offer(order.peek().getLeft());
			}
			if(order.peek().getRight() != null) 
			{
				order.offer(order.peek().getRight());
			}
			output = output + " " + order.poll().getData();
		}
		return output;
	}

	public boolean dftContains(int target)
	{
		boolean found = false;

		if (left != null && !found)
		{
			found = left.dftContains(target);
		}

		if (target == data)
		{
			return true;
		}

		if (right != null && !found)
		{
			found = right.dftContains(target);
		}

		return found;
	}

	public boolean bfsContains(Queue<TreeNode> order, int target)
	{
		while(!order.isEmpty())
		{
			if(order.peek().getLeft() != null) 
			{
				order.offer(order.peek().getLeft());
			}
			if(order.peek().getRight() != null) 
			{
				order.offer(order.peek().getRight());
			}
			
			if(order.poll().getData() == target) 
			{
				return true;
			}
		}
		return false;
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

	public TreeNode recursiveDelete(TreeNode localRoot, int value) //based on the remove algorithm on digital ocean by Anupam Chugh
	{
		if (localRoot == null) // check if local Root exists
		{
			return localRoot;
		}

		if (value < localRoot.data) // set left to recusiveDeletion from left tree
		{
			localRoot.setLeft(recursiveDelete(localRoot.getLeft(), value));
		}
		else if (value > localRoot.data) // set right to recusiveDeletion from right tree
		{
			localRoot.setRight(recursiveDelete(localRoot.getRight(), value));
		}
		else // item is in local root
		{
			if (localRoot.getLeft() == null)
			{
				return localRoot.getRight();
			}
			else if (localRoot.getRight() == null)
				return localRoot.getLeft();

			localRoot.setData(findSucessor(localRoot.getRight())); // find inorder successor
			localRoot.setRight(recursiveDelete(localRoot.getRight(), localRoot.getData()));
		}
		return localRoot; 
	}

	public String preorderToString()
	{
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

	public int findSucessor(TreeNode node)
	{
		int minimum = node.getData();
		while (node.getLeft() != null)
		{
			minimum = node.getLeft().getData();
			node = node.getLeft();
		}
		return minimum;
	}

	public int findPredecessor(TreeNode node)
	{
		int largest = node.getData();
		while (node.getRight() != null)
		{
			largest = node.getRight().getData();
			node = node.getRight();
		}
		return largest;
	}

	public String postorderToString()
	{
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

	public TreeNode getLeftSubtree()
	{
		if (left != null)
		{
			return left;
		}
		return null;
	}

	public TreeNode getRightSubtree()
	{
		if (right != null)
		{
			return right;
		}
		return null;
	}

	public TreeNode findLargest()
	{
		if (right != null)
		{
			if (right.getRight() != null)
				return right.findLargest();
			else
				return right;
		}
		return null;
	}

	public int children()
	{
		int output = 0;
		if (left != null)
			output++;
		if (right != null)
			output++;
		return output;
	}

	public boolean isLeaf()
	{
		return (left != null && right != null);
	}

	public int getData()
	{
		return data;
	}

	public void setData(int newData)
	{
		data = newData;
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
