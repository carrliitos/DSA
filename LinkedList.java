public class LinkedList {
	class ListNode {
		protected int value;
		protected ListNode next;
		/* Constructor that accepts a value as an argument and creates
		* a ListNode object with that value
		*/
		public ListNode(int val) {
			value = val;
			next = null;
		}
	}

	protected ListNode head, tail;
	protected int size;

	/*
	* LinkedList class is a wrapper around the LinkedNode class
	* To access any node in the linked list, we have to locate where the linked list starts
	* @var head -- reference to the first node
	* @var tail -- reference to the end node
	* @var size -- size of the linked list, i.e., the current number of nodes on the linked list
	*/
	public LinkedList() { 
		head = tail = null;
		size = 0;
	}

	/* @method insertAtFront -- adds a new node at the front of the linked list
	* @param val -- the value we want to add
	*/
	public ListNode insertAtFront(int value) { // Inner class
		ListNode newNode = new ListNode(value); // create an object of ListNode having a value val
		if(size == 0) { // check to see if the size is empty
			head = tail = newNode; // head and tail references are the newNode
		}else {
			newNode.next = head; // if list is not empty, point next of newNode to head
			head = newNode; // set head to be the newNode
		}
		size++; // increment the size
		return newNode;
	}

	/* @method insertAtEnd -- adds a new node at the end of the linked list
	* @param val -- the value we want to add
	*/
	public ListNode insertAtEnd(int value){ // Inner class
		ListNode newNode = new ListNode(value); // Create an object of ListNode having a value val
		if(size == 0) { // Check that the list is empty,
			head = tail = newNode; // if it is empty, point the head and tail to the newNode
		}else {
			tail.next = newNode; // point the next of tail to the newNode
			tail = newNode; // set the tail as the newNode
		}
		size++; // Increment the size
		return newNode;
	}
	
	/* @method deleteHead -- removes the head node
	* 
	*/
	public void deleteHead() {
		if(size == 0) { // Check that the list is empty
			System.out.println("Cannot delete from an empty list."); // Return error if it is
		}else if(1 == size) { // if we only have 1 node, 
			head = tail = null; // set both head and tail to null
			size--; // empty the list by decrementing
		}else { // if size > 1
			size--; // decerement the size;
			ListNode temp = head; // re-assign head to temp so that we can still keep track of it
			head = head.next; // set the new head to the next value of the head
			temp.next = null; // delete the next of the place value (old next)
			temp = null; // delete temp (old head)
		}
	}

	/* @method getNodeAt -- Returns the node at specified position
	* @param pos -- the position we want returned
	*/
	public ListNode getNodeAt(int pos) {
		if(pos < 0 || pos >= size || 0 == size) { // make sure the position of the node exists first
			System.out.println("No such position exists."); // if it doesnt exist, return an error message
			return null;
		}else {
			ListNode temp = head; // put a placeholder for the head value
			for(int i = 0; i < pos; i++) { // run a loop from i = 0 until i < pos
				temp = temp.next; // move the temp to its next node until pos value is reached
			}
			return temp; // return the value 
		}
	}

	/* @method getSize -- returns the size, i.e., the number of nodes
	* 
	*/
	public int getSize() {
		return size;
	}

	/* @method insertAfter -- adds a new node at a certain position
	* @param argNode -- 
	*/
	public ListNode insertAfter(ListNode argNode, int val) {
		ListNode newNode = new ListNode(val);
		while(argNode != null){
			if(size == 0) {
				System.out.println("Can't insert value at specified node, list is empty.");
			}else if(argNode == tail) {
				tail.next = newNode;
				tail = newNode;
			}else {
				newNode.next = argNode.next; // newNode's next points at argNode's next
				argNode.next = newNode; // argNode's next points to newNode
			}
		}
		size++;
		return newNode;			
	}

	public void deleteAfter(ListNode argNode) {
		if(argNode == tail) {
			System.out.println("Cannot delete from given argument node."); // if the argNode is the tail, we return nothing
		}else if(argNode.next == tail) {
			ListNode temp = tail;
			argNode.next = null;
			temp = null;
			tail = argNode;
			size--;
		}else {
			ListNode temp = argNode.next;
			if(temp != null) {
				argNode.next = temp.next;
				temp = null;
				size--;
			}
		}
	}

	public boolean removeDuplicatesSorted() {
		ListNode tmp = head;
		int pos = size;
		for(int i = 0; i < pos; i++) {
			if(tmp.value > tmp.next.value)
				return false;
		}

		for(int j = 0; j < pos; j++) {
			if(tmp.value == tmp.next.value){
				deleteHead();
			}
		}
		return true;
	}

	void printList() {
		if (size == 0)
			System.out.println("[]");
		else {
			ListNode tmp = head;
			String output = "[";
			for (int i = 0; i < size - 1; i++) {
				output += tmp.value + " -> ";
				tmp = tmp.next;
			}
			output += tail.value + "]";
			System.out.println(output);
		}
	}	
}