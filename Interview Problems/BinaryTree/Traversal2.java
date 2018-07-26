package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal2 {
    Stack<TreeNode> node_stack=new Stack<TreeNode>();

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre_list=new ArrayList<Integer>();
        if(root==null)
        return pre_list;
        node_stack.push(root);
        while(!node_stack.isEmpty())
        {
            TreeNode element=node_stack.pop();
            pre_list.add(element.val);
            if(element.right!=null)
            node_stack.add(element.right);
            if(element.left!=null)
            node_stack.add(element.left);
        }
        return pre_list;       
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in_list=new ArrayList<Integer>();
        if(root==null)
        return in_list;
        
        addToStack(root);
        
        while(!node_stack.isEmpty())
        {
            TreeNode element=node_stack.pop();
            in_list.add(element.val);
            if(element.right!=null)
            addToStack(element.right);
           
        }
        return in_list;
        
    }
    
    public void addToStack(TreeNode root)
    {
    	while(root!=null)
    	{
    		node_stack.push(root);
    		root=root.left;
    	}
    }
}
