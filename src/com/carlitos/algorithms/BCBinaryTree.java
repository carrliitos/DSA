/** @author Benzon Carlitos Salazar
	A binary tree is a tree that has, at most, two subtrees.
	A set of nodes T is a binary tree if either of the following is true:
	  a) T is empty
	  b) If T is not empty, its root node has two subtrees, T-left and T-right,
	    such that T-left and T-right are binary trees

	We represent the Binary Tree as a linked data structure
*/

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Scanner;

public class BCBinaryTree<E> implements Serializable {
	/** Inner class to encapsulate a tree node.*/
	private static class Node<E> implements Serializable {
		/** Data Fields */
		// The information stored in this node
		protected E data;
		// Reference to the left child
		protected Node<E> leftChild;
		// Reference to the right child
		protected Node<E> rightChild;

		/** Construct a node with given data and no children
			@param data - The data to store in this node
		*/
		public Node(E data) {
			this.data = data;
			leftChild = null;
			rightChild = null;
		}

		/** Return a string representation of the node.
			@return a string representation of the data fields.
		*/
		public String toString() {
			return data.toString();
		}
	}

	// Root node
	protected Node<E> root;

	/** Non-parameter constructor sets the data field root to null */
	public BCBinaryTree() {
		root = null;
	}
	/** A Protected constructor that can only be used by methods
		internal to the BinaryTree class and its subclasses
		@param root - The root data field
	*/
	protected BCBinaryTree(Node<E> root) {
		this.root = root;
	}
	/** Constructs a new binary tree with data in its root,
		leftTree as its left subtree, and rightTree as its
		right subtree
	*/
	public BCBinaryTree(E data, BCBinaryTree<E> leftTree, BCBinaryTree<E> rightTree) {
		// Create a root node with data as the root
		root = new Node<>(data);
		// if left tree is not empty/null
		if(leftTree != null) {
			// set the root's left child as the leftTree's root node
			root.leftChild = leftTree.root;
		}else {
			// there exists no leftTree, therefore, set root's left child as null
			root.leftChild = null;
		}
		// if right tree is not empty/null
		if(rightTree != null) {
			// set the root's right child as the rightTree's root node
			root.rightChild = rightTree.root;
		}else {
			// there exists no rightTree, therefore, set root's right child as null
			root.rightChild = null;
		}
	}

	// Methods
	/** Return the left subtree
		@return the left subtree or null if either the root or
				the left subtree is null
	*/
	public BCBinaryTree<E> getLeftSubtree() {
		if(root != null && root.leftChild != null) {
			return new BCBinaryTree<>(root.leftChild);
		}else {
			return null;
		}
	}
	/** Return the right subtree
		@return the right subtree or null if either the root or
				the right subtree is null
	*/
	public BCBinaryTree<E> getRightSubtree() {
		if(root != null && root.rightChild != null) {
			return new BCBinaryTree<>(root.rightChild);
		}else {
			return null;
		}
	}
	/** Determine whether this tree is a leaf.
		@return true if the root has no children
	*/
	public boolean isLeaf() {
		return (root.leftChild == null && root.rightChild == null);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(root, 1, sb); // Calls the toString() method
		return sb.toString();
	}
	/** Recursively converts a sub-tree to a string.
		Performs a preorder traversal
		@param node - The local root
		@param dept - The depth
		@param sb - The stringbuilder to save the output
	*/
	private void toString(Node<E> node, int depth, StringBuilder sb) {
		// traverse the depth
		for (int i = 0; i < depth; i++) {
			// create an empty string
			sb.append(" ");
		}
		// if the node is null, append "null" to an empty string
		if(node == null) {
			sb.append("null\n");
		}else {
			// Add each node as a string recursively
			sb.append(node.toString());
			sb.append("\n");
			// recursively traverse the left subtree
			toString(node.leftChild, depth + 1, sb);
			// recursively traverse the right subtree
			toString(node.rightChild, depth + 1, sb);
		}
	}
	/** Method to read a binary tree.
		pre: The input consists of a preorder traversal
			of the binary tree. The line "null" indicates a null tree
		@param scan - The Scanner attached to the input file
		@return the binary tree
	*/
	public static BCBinaryTree<String> readBinaryTree(Scanner scan) {
		// Read a line and trim leading and trailing spaces
		String data = scan.nextLine().trim();
		// if it is null, return null
		if(data.equals("null")) {
			return null;
		}else {
			// Recursively read the left child
			BCBinaryTree<String> leftTree = readBinaryTree(scan);
			// Recursively read the right child
			BCBinaryTree<String> rightTree = readBinaryTree(scan);
			// Return a tree consisting of the root and the two children
			return new BCBinaryTree<>(data, leftTree, rightTree);
		}
	}
}