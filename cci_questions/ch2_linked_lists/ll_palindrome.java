import java.util.*;

/* Cracking the Coding Interview 
   Chapter 2: Problem 7 */

class LinkedList {

	public Node front;

	public class Node {
		public String data;
		public Node next;
	}

	public LinkedList() {
		front = new Node();
		front = null;
	}

	public LinkedList(String data) {
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

	public void addString(String data) {
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
	public Node delNode(String data) {
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

	public LinkedList clone() {
		LinkedList ll_clone = new LinkedList();
		Node copy = front;
		if (copy != null) {
			while (copy != null) {
				Node clone_copy = new Node();
				clone_copy.data = copy.data;
				ll_clone.addNode(clone_copy);
				copy = copy.next;
			}
		}
		return ll_clone;
	}
}

public class ll_palindrome {

	/* Have two runner, one iterating one node at a time and one 
	   iterating (n-1) nodes at a time and compare the node values 
	   at each pointer until half way. */

	public static Boolean isPalindrome(LinkedList ll) {
		LinkedList ll_clone = ll.clone();
		LinkedList.Node runner1 = ll_clone.front;
		LinkedList.Node runner2 = ll_clone.getEnd();
		int len = ll_clone.getLength();

		/* Make the linked list loop so fast runner can keep looping. */
		ll_clone.getEnd().next = ll_clone.front;

		while (runner1 != runner2) {
			if (runner1.data != runner2.data) {
				return false;
			}	
			runner1 = runner1.next;
			int i = 0;
			while (i < (len - 1)) {
				runner2 = runner2.next;
				i += 1;
			}
		}
		return (runner1.data == runner2.data);
	}


	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addString("R");
        ll.addString("A");
        ll.addString("C");
        ll.addString("E");
        ll.addString("C");
        ll.addString("A");
        ll.addString("R");
        assert isPalindrome(ll) == true;
        ll.addString("R");
        assert isPalindrome(ll) == false;
	}
}