public class BST {
	public class BSTNode {
		public BSTNode left, right;
		public int data;

		public BSTNode() {
			this.left = null;
			this.right = null;
			this.data = 0;
		}

		public BSTNode(int d) {
			this.left = null;
			this.right = null;
			this.data = d;
		}
	}

	private BSTNode root;

	public BST() {
		this.root = null;
	}

	public BST(BSTNode n) {
		this.root = n;
	}

	public Boolean isEmpty() {
		return (this.root == null);
	}

	public void insert(int data) {
		this.root = this.insert(this.root, data);
	}

	private BSTNode insert(BSTNode node, int data) {
		if (node == null) {
			node = new BSTNode(data);
		} else {
			if (data < node.data) {
				node.left = this.insert(node.left, data);
			} else {
				node.right = this.insert(node.right, data);
			}
		}
		return node;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(BSTNode r) {
		if (r == null) {
			return 0;
		}
		return (1 + Math.max(this.height(r.left), this.height(r.right)));
	}
}