/* Cracking the Coding Interview 
   Chapter 3: Problem 2 */
public class minStack {
	public static void main(String[] args) {
		mStack s = new mStack();
		s.push(5);
		assert s.min() == 5;
		s.push(6);
		assert s.min() == 5;
		s.push(3);
		assert s.min() == 3;
		s.push(7);
		assert s.min() == 3;
		s.pop();
		assert s.min() == 3;
		s.pop();
		assert s.min() == 5;
	}
}

class mStack {
	private Node top;

	public mStack() {
		this.top = null;
	}
	
	public int pop() {
		if (this.top != null) {
			int item = this.top.data;
			this.top = this.top.next;
			return item;
		}
		throw new java.lang.Error("Popping when stack is empty!");		
	}

	public void push(int item) {
		Node n = new Node();
		n.data = item;
		int oldMin;
		if (this.top == null) {
			oldMin = Integer.MAX_VALUE;
		} else {
			oldMin = this.top.min;
		}
		if (this.top != null) {
			n.next = this.top;
		}
		this.top = n;
		if (this.top.data < oldMin) {
			this.top.min = this.top.data;
		} else {
			this.top.min = oldMin;
		}
	}

	public int peek() {
		return this.top.data;
	}

	public int min() {
		return this.top.min;
	}
}

class Node {
	public int data;
	public Node next;

	public int min;
}
