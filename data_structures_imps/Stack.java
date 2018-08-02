public class Stack {
	Node top;

	public Stack() {
		this.top = null;
	}
	
	public Object pop() {
		if (this.top != null) {
			Object item = this.top.data;
			this.top = this.top.next;
			return item;
		}
		return null;
	}

	public void push(Object item) {
		Node n = new Node();
		n.data = item;
		if (this.top == null) {
			this.top = n;
		} else {
			n.next = this.top;
			this.top = n;
		}
	}

	public Object peek() {
		return this.top.data;
	}
}

class Node {
	public Object data;
	public Node next;
}