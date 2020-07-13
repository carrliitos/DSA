/** @author Benzon Carlitos Salazar
 This is my correct implementation of a single-linked list
*/

	/** Class to represent a linked list with a link from each node to the next node.
	 SingleLinkedList does not implement the List interface.
	*/
public class BCLinkedList<E> {
	/** We create an inner class of Node
	 A Node is the building block for a single-linked list

	 The keyword static in the class header indicates that the 
	 Node<E> class will not reference its outer class.
	*/
	private static class Node<E> {
		// Create a reference to the data
		private E data;
		// Create a reference to the next node
		private Node<E> next;
		
		/** Create a new node constructor with a null next field
		 @param dataItem - The data stored
		*/
		private Node(E dataItem) {
			data = dataItem;
			next = null;
		}

		/** Create a new node constructor that references another node
		 @param dataItem - The data stored
		 @param nodeRef - The node reference by the new node
		*/
		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	}

	// Create a reference to the head of list
	private Node<E> head = null;
	// Initialize the number of items to zero, initially
	private int size = 0;

	/** Adding an item to the front of the list
	 @param dataItem - The item to be added
	*/
	public void addFirst(E dataItem) {
		// Set head to a new Node with dataItem as the data stored and 
		// the old head as the node reference
		head = new Node<>(dataItem, head);
		// increment the size to account for the new size after adding
		size++;
	}

	/** Adding an item after a specific node
	 @param node - The node preceding the new item
	 @param item - The item to insert
	*/
	private void addAfter(Node<E> node, E item) {
		/* Point the preceding node's next to the new node and initialize
		 it to a new node with item as the data and node.next (preceding node's
		 next) as the new node's next
		*/
		node.next = new Node<>(item, node.next);
		// Increment the size
		size++;
	}
}