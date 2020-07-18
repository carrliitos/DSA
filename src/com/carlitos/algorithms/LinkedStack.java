/** @author Benzon Carlitos Salazar
	A class to implement the Linked List in a stack
*/

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements StackInt<E> {
	// insert inner class Node<E> here
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

	/** Create a reference to the first stack node */
	private Node<E> topOfStackRef = null;

	/** Pushes an item onto the top of the stack and returns
		the item pushed
		@post - The object is at the top of the stack 
		@param obj - The object to be inserted
		@return the object inserted
	*/
	@Override
	public E push(E obj) {
		topOfStackRef = new Node<>(obj, topOfStackRef);
		return obj;
	}

	/** Returns the object at the top of the stack
		without removing it
		@post The stack remains unchaged
		@return the object at the top of the stack
		@throws NoSuchElementException if the stack is empty
	*/
	@Override
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return topOfStackRef.data;
	}

	/** Returns the object at the top of the stack and removes it
		@post The stack is one item smaller
		@return the object at the top of the stack
		@throws NoSuchElementException if the stack is empty
	*/
	@Override
	public E pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}else {
			// Create a reference to the data
			E result = topOfStackRef.data;
			// move the topOfStack to the next node
			topOfStackRef = topOfStackRef.next;
			// return the result to be removed
			return result;
		}
	}

	/** Returns true if the stack is empty; otherwise, return
		false
		@return true (false) if the stack is empty (not empty)
	*/
	@Override
	public boolean isEmpty() {
		// Return if the top node is empty
		return topOfStackRef == null;
	}
}