import java.lang.*;

/* Inspired by https://www.sanfoundry.com/java-program-implement-binary-tree/ 
   NOT A BST (aka no logical order, just a binary tree). */
public class BT {
	public class BTNode {
		private BTNode left, right;
		private int data;

		public BTNode() {
			this.left = null;
			this.right = null;
			this.data = 0;
		}

		public BTNode(int d) {
			this.left = null;
			this.right = null;
			this.data = d;
		}

		public void setLeft(BTNode n) {
			this.left = n;
		}

		public void setRight(BTNode n) {
			this.right = n;
		}

		public void setData(int d) {
			this.data = d;
		}

		public BTNode getLeft() {
			return this.left;
		}

		public BTNode getRight() {
			return this.right;
		}

		public int getData() {
			return this.data;
		}
	}

	private BTNode root;

	public BT() {
		this.root = null;
	}

	public boolean isEmpty() {
		return (this.root == null);
	}

	public void insert(int data) {
		this.root = this.insert(this.root, data);
	}

	private BTNode insert(BTNode node, int data) {
		if (node == null) {
			node = new BTNode(data);
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

	private int countNodes(BTNode r) {
		if (r == null) {
			return 0;
		}
		int c = 1;
		c += this.countNodes(r.getLeft());
		c += this.countNodes(r.getRight());
		return c;
	}

	public void inorder() {
		this.inorder(this.root);
	}

	private void inorder(BTNode r) {
		if (r != null) {
			this.inorder(r.getLeft());
			System.out.println(r.getData());
			this.inorder(r.getRight());
		}
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(BTNode r) {
		if (r == null) {
			return 0;
		}
		return (1 + Math.max(this.height(r.getLeft()), this.height(r.getRight())));
	}

	public static void main(String[] args) {
		/* Simple sanity checks. */
		BT bt = new BT();
		bt.insert(1);
		bt.insert(2);
		bt.insert(29);
		bt.insert(20);
		bt.insert(3);
		bt.inorder();
		System.out.println(bt.countNodes());
		System.out.println(bt.height());
	}
}
