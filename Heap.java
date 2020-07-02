import java.util.ArrayList;

public class Heap {

	ArrayList<String> heapArray;

	public Heap() {
		heapArray = new ArrayList<String>();
	}

	public String getMinimum() {
		return heapArray.get(0);
	}

	public void deleteMinimum() {
		// update index 0 of heapArray with the last value of the heap
		heapArray.set(0, heapArray.get(size() - 1));
		// Remove the last number in the heap
		heapArray.remove(size() - 1);
		// Let the currentIndex = 0, leftIndex = 1, and rightIndex = 2;
		int currentIndex = 0;
		int leftIndex = 1;
		int rightIndex = 2;
		// While(leftIndex < size of the heap), i.e., as long as current node has a left child, do:
		while(leftIndex < size()) {
			// let currentKey be the value at currentIndex
			String currentKey = heapArray.get(currentIndex);
			// let leftKey be the value at leftIndex
			String leftKey = heapArray.get(leftIndex);
			if(rightIndex < size()) {
				// let rightKey be the value at rightIndex
				String rightKey = heapArray.get(rightIndex);
				// if(leftKey < currentKey and leftKey < rightKey), then left child is the smallest, so:
				if((leftKey.compareTo(currentKey) < 0) 
					&& (leftKey.compareTo(rightKey) < 0)) {
					// swap values of leftIndex and currentIndex
					swap(leftIndex, currentIndex);
					// set currentIndex to leftIndex
					currentIndex = leftIndex;
				// else if (rightKey < currentKey), then the right child is the smallest
				}else if(rightKey.compareTo(currentKey) < 0) {
					// swap the values of rightIndex and currentIndex
					swap(rightIndex, currentIndex);
					// set the currentIndex = rightIndex
					currentIndex = rightIndex;
				// else current node is the smallest
				}else {
					break;
				}
			// else if (leftKey < currentKey) then right child does not exist, left child is the last node, and left child is the smaller; so:
			}else if(leftKey.compareTo(currentKey) < 0) {
				// swap the values of leftIndex and currentIndex
				swap(leftIndex, currentIndex);
				break;
			// else currentIndex is the smallest
			}else { 
				break;
			}
			// set leftIndex = 2 * currentIndex + 1;
			leftIndex = 2 * currentIndex + 1;
			// set rightIndex = leftIndex + 1;
			rightIndex = leftIndex + 1;
		}
	}

	public void insert(String value) {
		// Let currentIndex be the size of the heap
		int currentIndex = size();
		// let the parentIndex = (currentIndex - 1) / 2
		int parentIndex = (currentIndex - 1) / 2;
		// add the new value at the end of the heap array
		heapArray.set(size() - 1, value);
		// while (currentIndex > 0 and (value at parentIndex > value at currentIndex)), do:
		while((currentIndex > 0) && (heapArray.get(parentIndex).compareTo(heapArray.get(currentIndex)) > 0)) {
			// swap the contents of heapArray at the indexes parentIndex and currentIndex
			swap(parentIndex, currentIndex);
			// set currentIndex = parentIndex
			currentIndex = parentIndex;
			// update parentIndex = (currentIndex - 1) / 2
			parentIndex = (currentIndex - 1) / 2;
		}
	}

	private void swap(int index1, int index2) {
		String temp = heapArray.get(index1);
		heapArray.set(index1, heapArray.get(index2));
		heapArray.set(index2, temp);
	}

	public int size() {
		return heapArray.size();
	}
}
