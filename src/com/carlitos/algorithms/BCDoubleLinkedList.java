/** @author Benzon Carlitos Salazar 
 This is the correct (incomplete) implementation of Double-Linked List
*/

import java.util.*;

/** Class BCDoubleLinkedList implements a double-linked list and
 a ListIterator*/
public class BCDoubleLinkedList<E> {
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
		// Createa a reference to the prev node
		private Node<E> prev;

		/** Create a new node constructor with a null next field
		 @param dataItem - The data stored
		*/
		private Node(E dataItem) {
			data = dataItem;
			next = null;
			prev = null;
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

	/** An inner class to implement the ListIterator interface
	*/
	private class BCListIter implements ListIterator<E> {
		// A reference to the next item
		private Node<E> nextItem;
		// A reference to the lst item returned
		private Node<E> lastItemReturned;
		// The index of the current item
		private int index = 0;

		/** The constructor */
		public BCListIter(int i) {
			// Validate i parameter
			if(i < 0 || i > size) {
				throw new IndexOutOfBoundsException("Invalid index: " + i);
			}
			// set the last item returned to null for now
			lastItemReturned = null;
			// special case of the last item
			if(i == size) {
				index = size;
				nextItem = null;
			}else { // Start at the beginning
				nextItem = head;
				for (index = 0; index < i; index++) {
					nextItem = nextItem.next;
				}
			}
		}

		/** Indicate whether the movement forward is defined
		 @return true if call to next will not throw an exception
		*/
		public boolean hasNext() {
			return nextItem != null;
		}

		/** Move the iterator forward and return the next item.
		 @return the next item in the list
		 @throws NoSuchElementException if there is no such object
		*/
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.next;
			index++;
			return lastItemReturned.data;
		}

		/** Indicate whether the movement backward is defined
		 @return true if call to previous will not throw an exception
		*/
		public boolean hasPrevious() {
			return (nextItem == null && size != 0)
				|| nextItem.prev != null;
		}

		/** Move the iterator backward and return the previous item.
		 @return the previous item in the list
		 @throws NoSuchElementException if there is no such object
		*/
		public E previous() {
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if(nextItem == null) {
				nextItem = tail;
			}else {
				nextItem = nextItem.prev;
			}
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}
	}

	// Create a reference to the head of the list
	private Node<E> head = null;
	// Create a reference to the tail of the list
	private Node<E> tail = null;
	// The size of the list
	private int size = 0;
}