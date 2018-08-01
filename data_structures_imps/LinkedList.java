import java.util.*;

public class LinkedList {

	public Node front;

	public class Node {
		public int data;
		public Node next;
	}

	public LinkedList() {
		front = new Node();
		front = null;
	}

	public LinkedList(int data) {
		front = new Node();
		front.data = data;
	}

	public void addNode(Node node) {
		Node end = getEnd();
		if (end == null) {
			front = node;
		} else {
			end.next = node;
		}
	}

	public void addInt(int data) {
		Node end = getEnd();

		Node added = new Node();
		added.data = data;

		if (end == null) {
			front = added;
		} else {
			end.next = added;
		}
	}

	/* Returns the resulted linked list and deletes node if exists. */
	public Node delNode(int data) {
		Node copy = front;
		
		if (copy.data == data) {
			return front.next;
		}

		while (copy.next != null) {
			if (copy.next.data == data) {
				copy.next = copy.next.next;
				return front;
			}
			copy = copy.next;
		}
		return front;
	}

	public void combineLL(LinkedList ll) {
		Node end = getEnd();
		end.next = ll.front;
	}

	private Node getEnd() {
		Node copy = front;
		if (copy != null) {
			while (copy.next != null) {
				copy = copy.next;
			}
		}
		return copy;
	}

	/* Reverses this linked list iteratively */
	public void reverse() {
		Node next = null;
		Node prev = null;
		Boolean end = false;

		while (!end) {
			next = front.next;
			front.next = prev;
			prev = front;
			if (next != null) {
				front = next;
			} else {
				end = true;
			}
		}
	}

	/* Returns True if this has a cycle */
	public Boolean hasCycle() {
		HashSet<Node> nodeSet = new HashSet<Node>();
		Node copy = front;

		while (copy != null) {
			if (nodeSet.contains(copy)) {
				return true;
			}
			nodeSet.add(copy);
			copy = copy.next;
		}
		return false;
	}

	public void printLLData() {
		Node copy = front;
		while (copy != null) {
			System.out.println(copy.data);
			copy = copy.next;
		}
	}
}