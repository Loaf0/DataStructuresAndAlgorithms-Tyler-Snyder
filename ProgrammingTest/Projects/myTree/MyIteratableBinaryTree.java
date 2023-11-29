package myTree;
import java.util.Stack;

/* @author Tyler Snyder
* @date 11/29/23
* a class for iterating through a complete tree made in the MyBinaryTree Class
*/
public class MyIteratableBinaryTree extends MyBinaryTree
{
	Stack<TreeNode> path;
	TreeNode currentNode;
	int data;
	boolean hasNext;

	public MyIteratableBinaryTree()
	{
		hasNext = true;
		data = 0;
		path = new Stack<TreeNode>();
	}

	public MyIteratableBinaryTree(int data)
	{
		super(data);
		path = new Stack<TreeNode>();
		data = 0;
		hasNext = true;
	}

	public void initilizeCurrent()
	{
		if (getRoot() == null)
		{
			currentNode = null;
		}

		if (currentNode == null)
		{
			currentNode = getRoot();
		}

		while (currentNode.getLeft() != null)
		{
			path.push(currentNode);
			currentNode = currentNode.getLeft();

		}
	}

	public int next()
	{
		int tempData = currentNode.getData();
		if (currentNode.getRight() != null)
		{
			path.push(currentNode);
			currentNode = currentNode.getRight();
			while (currentNode.getLeft() != null)
			{	
				path.push(currentNode);
				currentNode = currentNode.getLeft();
			}
		}
		else
		{
			while (!path.isEmpty() && path.peek().getRight().equals(currentNode))
			{
				currentNode = path.pop();
			}
			if (path.isEmpty())
			{
				currentNode = null; // case where iteration is complete
			}
			else
			{
				currentNode = path.pop();
			}
		}
		return tempData;
	}

	public boolean hasNext()
	{
		TreeNode temp = getRoot();
		while(temp.getRight()  != null) 
		{
			temp = temp.getRight();
		}
		if(currentNode == temp) 
		{
			hasNext = false;
			return true;
		}
		return hasNext;
	}

	public TreeNode getCurrentNode()
	{
		return currentNode;
	}
}
