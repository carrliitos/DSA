public class BinaryTree {
	private class Node{ // Inner class
		int value; // data item
		Node parent; // reference to parent
		Node left; // reference to left child
		Node right; // reference to right child

		Node(int value) {
			this.value = value;
			parent = null;
			left = null;
			right = null;
		}
	}
	/*Searching in a tree*/
	private Node searchTree(Node node, int value) {
		if(node == null) { return null; }
		if(node.value == value) { return node; }
		if(node.value > value) {
			/*If the node value is greater than the value we're looking for, traverse the left side*/
			return searchTree(node.left, value); 
		}else {
			/*If the node value is less than the value we're looking for, traverse the right side*/
			return searchTree(node.right, value);
		}
	}
}