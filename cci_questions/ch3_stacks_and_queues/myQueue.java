public class myQueue {
	public static void main(String[] args) {
		myQueue mq = new myQueue();
		mq.enqueue(2);
		mq.enqueue(10);
		mq.enqueue(3);
		assert mq.dequeue() == 2;
		mq.enqueue(4);
		assert mq.dequeue() == 10;
		assert mq.dequeue() == 3;
		assert mq.dequeue() == 4;
	}

	Stack s1;
	Stack s2;

	public myQueue() {
		s1 = new Stack();
		s2 = new Stack();
	}

	public void enqueue(int item) {
		s1.push(item);
	}

	public int dequeue() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
}

class Stack {
	Node top;

	public Stack() {
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
		if (this.top == null) {
			this.top = n;
		} else {
			n.next = this.top;
			this.top = n;
		}
	}

	public int peek() {
		return this.top.data;
	}

	public Boolean isEmpty() {
		return (this.top == null);
	}
}

class Node {
	public int data;
	public Node next;
}