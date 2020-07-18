/** @author Benzon Carlitos Salazar 
 A Stack is an data structure in which objects are inserted into
 and removed from the same end (i.e., Last In, First Out).
 @param <E> The element type
*/
public interface StackInt<E> {
	/** Pushes an item onto the top of the stack and returns
		the item pushed 
		@param obj - The object to be inserted
		@return the object inserted
	*/
	E push(E obj);

	/** Returns the object at the top of the stack
		without removing it
		@post The stack remains unchaged
		@return the object at the top of the stack
		@throws NoSuchElementException if the stack is empty
	*/
	E peek();

	/** Returns the object at the top of the stack and removes it
		@post The stack is one item smaller
		@return the object at the top of the stack
		@throws NoSuchElementException if the stack is empty
	*/
	E pop();

	/** Returns true if the stack is empty; otherwise, return
		false
		@return true (false) if the stack is empty (not empty)
	*/
	boolean isEmpty();
}