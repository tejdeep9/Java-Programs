/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class MinStack {
	LinkedList<Integer> stack;
	LinkedList<Integer> minStack;
	
	MinStack() {
		stack = new LinkedList<Integer>();
		minStack = new LinkedList<Integer>();
	}
	
	void push(int x) {
		stack.add(x);
		if(!minStack.isEmpty() && minStack.getLast() <= x) {
				minStack.add(minStack.getLast());
		} else {
				minStack.add(x);
		}
		
	}
	
	void pop(){
		if(!stack.isEmpty()){
			stack.removeLast();
			minStack.removeLast();
		}
	}
	
	int top() {
		return stack.getLast();
	}
	
	int getMin() {
		return minStack.getLast();
	}
}
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		MinStack ms = new MinStack();
		ms.push(2);
		ms.push(0);
		ms.push(3);
		ms.push(0);
		
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
	}
}