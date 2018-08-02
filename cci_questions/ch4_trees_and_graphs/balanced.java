import java.lang.*;
import java.util.Queue;
import java.util.LinkedList;

public class balanced {
	public static void main(String[] args) {
		BT bt = new BT();
		BTNodeH btnh1 = new BTNodeH(1);
		BTNodeH btnh2 = new BTNodeH(2);
		BTNodeH btnh3 = new BTNodeH(3);
		BTNodeH btnh4 = new BTNodeH(4);
		BTNodeH btnh5 = new BTNodeH(5);
		BTNodeH btnh6 = new BTNodeH(6);
		BTNodeH btnh7 = new BTNodeH(7);
		bt.setRoot(btnh1);
		btnh1.left = btnh2;
		btnh1.right = btnh3;
		btnh2.left = btnh4;
		btnh2.right = btnh5;
		btnh3.left = btnh6;
		btnh3.right = btnh7;
		assert balancedTree(bt);

		BT bt1 = new BT();
		btnh1 = new BTNodeH(1);
		btnh2 = new BTNodeH(2);
		btnh3 = new BTNodeH(3);
		btnh4 = new BTNodeH(4);
		btnh5 = new BTNodeH(5);
		btnh6 = new BTNodeH(6);
		btnh7 = new BTNodeH(7);
		bt.setRoot(btnh1);
		btnh1.left = btnh2;
		btnh1.right = btnh3;
		btnh2.left = btnh4;
		btnh3.right = btnh5;
		btnh4.left = btnh6;
		btnh5.right = btnh7;
		assert balancedTree(bt) == false;
	}

	public static Boolean balancedTree(BT bt) {
		bt.fillHeights();
		return balancedTree(bt.getRoot());
	}

	private static Boolean balancedTree(BTNodeH r) {
		if (r == null) {
			return true;
		}
		int leftHeight = 0;
		int rightHeight = 0;
		if (r.getLeft() != null) {
			leftHeight = r.getLeft().getHeight();
		}
		if (r.getRight() != null) {
			rightHeight = r.getRight().getHeight();
		}
		return (balancedTree(r.getLeft()) && balancedTree(r.getRight()) && (Math.abs(leftHeight - rightHeight) <= 1));

	}
}

/* Inspired by https://www.sanfoundry.com/java-program-implement-binary-tree/ 
   NOT A BST (aka no logical order, just a binary tree). */
class BT {
	private BTNodeH root;

	public BT() {
		this.root = null;
	}

	public BTNodeH getRoot() {
		return this.root;
	}

	public void setRoot(BTNodeH n) {
		this.root = n;
	}

	public boolean isEmpty() {
		return (this.root == null);
	}

	public void insert(int data) {
		this.root = this.insert(this.root, data);
	}

	private BTNodeH insert(BTNodeH node, int data) {
		if (node == null) {
			node = new BTNodeH(data);
		} else {
			if (Math.random() < 0.5) {
				node.left = this.insert(node.left, data);
			} else {
				node.right = this.insert(node.right, data);
			}
		}
		return node;
	}

	public int countNodes() {
		return this.countNodes(this.root);
	}

	private int countNodes(BTNodeH r) {
		if (r == null) {
			return 0;
		}
		int c = 1;
		c += this.countNodes(r.getLeft());
		c += this.countNodes(r.getRight());
		return c;
	}

	public int fillHeights() {
		return this.height(this.root);
	}

	private int height(BTNodeH r) {
		if (r == null) {
			return 0;
		}
		int h = 1 + Math.max(this.height(r.getLeft()), this.height(r.getRight()));
		r.height = h;
		return h;
	}
}

class BTNodeH {
		public BTNodeH left, right;
		private int data;
		public int height;

		public BTNodeH() {
			this.left = null;
			this.right = null;
			this.data = 0;
			this.height = 0;
		}

		public BTNodeH(int d) {
			this.left = null;
			this.right = null;
			this.data = d;
			this.height = 0;
		}

		public void setLeft(BTNodeH n) {
			this.left = n;
		}

		public void setRight(BTNodeH n) {
			this.right = n;
		}

		public void setData(int d) {
			this.data = d;
		}

		public void setHeight(int h) {
			this.height = h;
		}

		public BTNodeH getLeft() {
			return this.left;
		}

		public BTNodeH getRight() {
			return this.right;
		}

		public int getData() {
			return this.data;
		}

		public int getHeight() {
			return this.height;
		}
	}
