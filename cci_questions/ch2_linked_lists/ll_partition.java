import java.util.*;

/* Cracking the Coding Interview 
   Chapter 2: Problem 7 */

class Node {
	public int data;
	public Node next;
}

class LinkedList {

	public Node front;

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

	public Node getEnd() {
		Node copy = front;
		if (copy != null) {
			while (copy.next != null) {
				copy = copy.next;
			}
		}
		return copy;
	}

	public int getLength() {
		Node copy = front;
		int len = 0;
		if (copy != null) {
			len = 1;
			while (copy.next != null) {
				len += 1;
				copy = copy.next;
			}
		}
		return len;
	}

	public void printLLData() {
		Node copy = front;
		while (copy != null) {
			System.out.println(copy.data);
			copy = copy.next;
		}
	}
}

public class ll_partition {

	public static LinkedList partition(LinkedList ll, int elem) {
		LinkedList llNew = new LinkedList();
		llNew.addInt(elem);

		/* Iterate through linked list, placing ints less than elem
		   in the front of the list and greater or equal ints in the
		   back. */
		Node copy = ll.front;
		Node geCopyPtr = llNew.front;
		Boolean seenElem = false;
		while (copy != null) {
			Node nextNode = new Node();
			nextNode.data = copy.data;
			if (copy.data < elem) {
				nextNode.next = llNew.front;
				llNew.front = nextNode;
			} else if (copy.data == elem && !seenElem) {
				seenElem = true;
			} else {
				geCopyPtr.next = nextNode;
				geCopyPtr = geCopyPtr.next;
			}
			copy = copy.next;
		}
		return llNew;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addInt(5);
        ll.addInt(7);
        ll.addInt(3);
        ll.addInt(10);
        ll.addInt(1);
        ll.addInt(2);
        ll.addInt(4);
        LinkedList llPartitioned = partition(ll, 3);
        llPartitioned.printLLData();
	}
}