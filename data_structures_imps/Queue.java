public class Queue {
	Node first, last;

	public Queue() {
		this.first = null;
		this.last = null;
	}

	public void enqueue(Object item) {
		Node n = new Node();
		n.data = item;
		if (this.first == null) {
			this.last = n;
			this.first = last;
		} else {
			this.last.next = n;
			this.last = this.last.next;
		}
	}

	public Object dequeue() {
		if (this.first != null) {
			Object item = this.first.data;
			this.first = this.first.next;
			if (this.first == null) {
				this.last = null;
			}
			return item;
		}
		return null;
	}
}

class Node {
	public Object data;
	public Node next;
}
