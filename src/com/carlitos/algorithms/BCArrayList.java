/** @author Benzon Carlitos Salazar

	This class implements some of the methods of the Java ArrayList class.
	It does not implement the List interface.
*/

import java.util.*;

public class BCArrayList<E> {
	// Default initial capacity
	private static final int INITITAL_CAP = 10;
	// underlying data array
	private E[] dataArray;
	// current size
	private int size = 0; // corresponds to the number of data items
	// current capacity
	private int capacity = 0; // corresponds to the physical size of the array

	// Constructor declaration
	public BCArrayList() {
		capacity = INITITAL_CAP;
		
		/** Allocates storage for an array with object type Object references
			and then casts this array object to type E[] so that it is compatible 
			with the variable dataArray.

			The compiler will issue a warning message because the actual type 
			corresponding to E is not known.

			@SuppressWarnings - enables us to compile without an error message
		*/
		@SuppressWarnings("unchecked")
		E[] dataArray = (E[]) new Object[capacity];
	}

	/**
		add(E anEntry) - appends an item at the end of the ArrayList
	*/
	public boolean add(E anEntry) {
		// if size is equal to the capacity, then reallocate
		if(size == capacity) {
			reallocate();
		}
		// insert anEntry to the end of the array
		dataArray[size] = anEntry;
		// increment the size
		size++;
		// return true to indicate insertion was successful
		return true;
	}

	/**
		add(int index, E anEntry) - adds an item at a given index
	*/
	public void add(int index, E anEntry) {
		// check that the given index is in-bounds
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		// check to see that the size is not equal to the capacity
		if(size == capacity) {
			reallocate();
		}
		// shift data in elements from index to size - 1 starting from 
		// the end towards the beginning of the array
		for(int i = size; i > index; i--) {
			dataArray[i] = dataArray[i - 1];
		}
		// insert the new item and increment the size
		dataArray[index] = anEntry;
		size++;
	}
}