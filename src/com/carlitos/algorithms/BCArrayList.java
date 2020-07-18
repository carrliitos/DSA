/** @author Benzon Carlitos Salazar

	This class implements some of the methods of the Java ArrayList class.
	It does not implement the List interface.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	/**
		get(int index) - returns the item at a given index
	*/
	public E get(int index) {
		// check that the given index is in-bounds
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		// return the item
		return dataArray[index];
	}

	/**
		set(int index, E newValue) - Method set inserts the new
		item (parameter newValue) at the specified index and returns t
		he value (oldValue) that was previously stored at that index.
	*/
	public E set(int index, E newValue) {
		// check that the given index is in-bounds
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		// swap the oldValue with the newValue
		E oldValue = dataArray[index];
		dataArray[index] = newValue;
		// return oldValue
		return oldValue;
	}

	/**
		remove(int index) - removes an item at a given index and shifts the 
		array elements to close up the gap
	*/
	public E remove(int index) {
		// check to see if the index is in-bounds
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		// initialize/create a returnValue (temp value) equal to the given index to be removed
		E returnValue = dataArray[index];
		// use a for-loop to move the array elements forward to close the gap
		for(int i = index + 1; i < size; i++) {
			dataArray[i - 1] = dataArray[i];
		}
		// decrement the size
		size--;
		// return the returnValue
		return returnValue;
	}

	/**
		reallocate() - creates a new array that is twice the size of the current 
		array and then copies the contents of the current array into the new one.
	*/
	private void reallocate() {
		// double the capacity
		capacity = 2 * capacity;
		// copy the array using Arrays.copyOf() method
		dataArray = Arrays.copyOf(dataArray, capacity);
	}

	public static void main(String[] args) {
		List<Integer> some = new ArrayList<>();
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		try {
			System.out.println("Adding: " + Arrays.toString(nums));
			for (int numsNext : nums) {
				some.add(numsNext);
				System.out.println(some);
			}
			System.out.println("Complete new array: " + some + "\n");

			System.out.println("Removing every first element of array " + Arrays.toString(nums) + "\n");
			for (int numsNext : nums) {
				System.out.println("Removing element " + numsNext);
				some.remove(0);
				System.out.println(some);				
			}
		}catch(Exception ex) {
			System.out.println("\nException Error");
			ex.printStackTrace(System.out);
		}
	}
}