/** @author Benzon Carlitos Salazar
 	This is the correct implementation of a single-linked list
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

	/** Removes a node afer a given node
		@param node - The node before the one to be removed
		@return - The data from the removed node, or null if there is node to remove
	*/
	private E removeAfter(Node<E> node) {
		// Create a temp node and set it to the given node's next
		Node<E> temp = node.next;
		// if temp is not null, then do the following:
		if(temp != null) {
			// Set the given node's next to the temp's next node
			node.next = temp.next;
			// decrement the size
			size--;
			// return the data of temp
			return temp.data;
		}else { // the temp is null
			return null;
		}
	}

	/** Removes the head node
		@return - The removed node's data or null if the list is empty
	*/
	private E removeFirst() {
		// set temp node to head
		Node<E> temp = head;
		// if head is not null, then do:
		if(head != null) {
			// set the next node as the new head
			head = head.next;
		}
		/*return the data at old head or null if list is empty*/
		if(temp != null) {
			// Decrement the size first to delete the space.
			size--;
			return temp.data;
		}else {
			return null;
		}
	}

	/** Finds the node at a specified position
		@param index - The position of the node we want
		@return - The node at index or null if it does not exist
	*/
	private Node<E> getNode(int index) {
		// Set a placeholder node to the head node
		Node<E> placeholder = head;
		// Run a loop from i to the index, ensuring that placeholder at each iteration is not empty
		for(int i = 0; i < index && placeholder != null; i++){
			// move the placeholder node to its next node until the desired index is reached
			placeholder = placeholder.next;
		}
		// return the node
		return placeholder;
	}

	/** Get the data at a given index
		@param index - The position of the data returned
		@return - The data at index
		@throws IndexOutOfBoundsException - If index is out of range
	*/
	public E get(int index) {
		// Make sure that the index is in-bounds
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		// Call the getNode() on index and set a new placeholder node to the returned node
		Node<E> node = getNode(index);
		// return the data of the node
		return node.data;
	}

	/** Store a reference to anEntry in the element at position index
		@param index - The position of the item to change
		@param newValue - The new data
		@return - The data previously at index
		@throws IndexOutOfBoundsException - If index is out of range
	*/
	public E set(int index, E newValue) {
		// Make sure that the index is in-bounds
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		// Call the getNode() method on the index and set the return node to a new node
		Node<E> node = getNode(index);
		// Create a data item "result" and set it equal to the data of new node
		E result = node.data;
		// Store the newValue to the new node
		node.data = newValue;
		// return the data previously at index
		return result; // this removes the reference
	}

	/** Insert the specified item at given index
		@param index - The position where item is to be inserted
		@param item - The item to be inserted
		@throws IndexOutOfBoundsException - If index is out of range
	*/
	public void add(int index, E item) {
		// Make sure the the index is in-bounds
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		// if index is zero, we simply add it to the beginning of LinkedList
		if(index == 0) {
			addFirst(item);
		}else {
			// Create a new node with getNode() and index-1 as argument
			// we want to set the new node before the given index
			Node<E> node = getNode(index - 1);
			// call addAfter() with new node and item as arguments
			addAfter(node, item);
		}
	}

	/** Appends an item at the end of the list
		@param item - The item to be appended
		@return true - if the adding was successful
	*/
	public boolean add(E item) {
		// call the add() method with size and item as arguments
		// size will give us the index at the end of the list
		add(size, item);
		// return true
		return true;
	}
}