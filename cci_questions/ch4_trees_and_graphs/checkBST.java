
/* Cracking the Coding Interview 
   Chapter 4 Question 5 */

public class checkBST {

	public static boolean checkBST(BST bst) {
		return checkBST(bst.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean checkBST(BSTNode n, int min, int max) {
		if (n == null) {
			return true;
		}
		if (n.data <= min || n.data > max) {
			return false;
		}
		return (checkBST(n.left, min, n.data) && checkBST(n.right, n.data, max));
	}

	public static void main(String args[]) {
		int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
		BST bst = sortedArrayToBST.sortedArrayBST(nums1);
		assert checkBST(bst) == true;

		int[] nums2 = {1, 2, 3, 3, 5, 6, 7};
		bst = sortedArrayToBST.sortedArrayBST(nums2);
		assert checkBST(bst) == true;

		int[] nums3 = {1, 2, 3, 3, 3, 6, 7};
		bst = sortedArrayToBST.sortedArrayBST(nums3);
		assert checkBST(bst) == false;
	}
}
