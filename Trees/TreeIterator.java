//write and Iterator to traverrse a sorted tree from least to greatest

import java.util.*;
import java.lang.*;
import java.io.*;

class Tree {
	int val; //the value in the each node is less than all of its children
	List<Tree> children;
	
	Tree(int val) {
		this.val = val;
		children = new ArrayList<Tree>();
	}
}

class TreeIterator implements Iterator<Integer> {
	List<Integer> sortedList;
	Iterator it;
	
	private Iterator<Integer>  preOrderTraversal(Tree t) {
		if(t == null)
			return sortedList.iterator();
		Stack<Tree> stack = new Stack<Tree>();
		stack.push(t);
		Tree current = null;
		
		while(!stack.empty()) {
			current = stack.pop();
			sortedList.add(current.val);
			if(current.children != null && current.children.size() != 0) {
				
				for(int i = current.children.size()-1; i >=0; i--) {
					stack.push(current.children.get(i));
				}
			}
		}
		
		return sortedList.iterator();
	}
	
	private Iterator<Integer> getIterator() {
		return sortedList.iterator();
	}
	
	public TreeIterator(Tree t) {
		sortedList =  new ArrayList<Integer>();
		it = preOrderTraversal(t);
	}
	
	@Override	
	public boolean hasNext() {
		return it.hasNext();
	}
	
	@Override
	public Integer next() {
		return (Integer)it.next();
	}
}
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Tree t = new Tree(60); 
		Tree t1 = new Tree(61); 
		Tree t2 = new Tree(62); 
		Tree t3 = new Tree(63); 
		Tree t4 = new Tree(64); 
		Tree t5 = new Tree(65); 
		Tree t6 = new Tree(66); 
		Tree t7 = new Tree(67); 
		Tree t8 = new Tree(68); 
		Tree t9 = new Tree(69); 
		Tree t10 = new Tree(70); 
		Tree t11 = new Tree(71); 
		Tree t12 = new Tree(72); 		
		
		t.children.add(t1);
		t.children.add(t5);
		t.children.add(t9);
		
		t1.children.add(t2);
		t1.children.add(t3);
		t1.children.add(t4);
		
		t5.children.add(t6);
		t5.children.add(t7);
		t5.children.add(t8);
		
		t9.children.add(t10);
		t9.children.add(t11);
		t9.children.add(t12);
		
		TreeIterator it = new TreeIterator(t);
		
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
	}
}