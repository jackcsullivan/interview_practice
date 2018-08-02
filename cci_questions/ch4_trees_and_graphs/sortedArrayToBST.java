import java.util.*;

/* Cracking the Coding Interview 
   Chapter 4: Problem 3 */
public class sortedArrayToBST {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		BST bst = sortedArrayBST(nums);
		assert bst.height() == Math.ceil((Math.log(nums.length) / Math.log(2)));
	}

	public static BST sortedArrayBST(int[] nums) {
		BST bst = new BST(helperSortedArrayBST(nums));
		return bst;
	}

	private static BSTNode helperSortedArrayBST(int[] nums) {
		if (nums.length < 1) {
			return null;
		}
		BSTNode bstn = new BSTNode(nums[(int) nums.length / 2]);
		bstn.left = helperSortedArrayBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
		bstn.right = helperSortedArrayBST(Arrays.copyOfRange(nums, (nums.length / 2) + 1, nums.length));
		return bstn;
	}
}

class BST {
	private BSTNode root;

	public BST() {
		this.root = null;
	}

	public BST(BSTNode n) {
		this.root = n;
	}

	public BSTNode getRoot() {
		return this.root;
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

class BSTNode {
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