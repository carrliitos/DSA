/** @author Benzon Carlitos Salazar
	
	Class ListStack<E> implements the interface StackInt<E> as
	an adapter to the List.
	@param <E> - The type of elements in the stack.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ListStack<E> implements StackInt<E> {
	// The List containing the data
	private List<E> theData;
	
	/** Construct an empty stack using the ArrayList as the container */
	public ListStack() {
		theData = new ArrayList<>();
	}

	/** Pushes an item onto the top of the stack and returns
		the item pushed
		@post - The object is at the top of the stack 
		@param obj - The object to be inserted
		@return the object inserted
	*/
	@Override
	public E push(E obj) {
		theData.add(obj);
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
		return theData.get(theData.size() - 1);
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
		}
		return theData.remove(theData.size() - 1);
	}

	/** Returns true if the stack is empty; otherwise, return
		false
		@return true (false) if the stack is empty (not empty)
	*/
	@Override
	public boolean isEmpty() {
		return theData.isEmpty();
	}
}