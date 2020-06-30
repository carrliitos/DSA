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
		heapArray.set(0, heapArray.get(heapArray.size() - 1));
		// Remove the last number in the heap
		heapArray.remove(heapArray.size() - 1);
		// Let the currentIndex = 0, leftIndex = 1, and rightIndex = 2;
		int currentIndex = 0;
		int leftIndex = 1;
		int rightIndex = 2;
		// While(leftIndex < size of the heap), i.e., as long as current node has a left child, do:
		while(leftIndex < heapArray.size()) {
			// let currentKey be the value at currentIndex
			String currentKey = heapArray.get(currentIndex);
			// let leftKey be the value at leftIndex
			String leftKey = heapArray.get(leftIndex);
			if(rightIndex < heapArray.size()) {
				// let rightKey be the value at rightIndex
				String rightKey = heapArray.get(rightIndex);
				// if(leftKey < currentKey and leftKey < rightKey), then left child is the smallest, so:
				if((heapArray.get(leftKey).compareTo(heapArray.get(currentKey)) < 0) 
					&& (heapArray.get(leftKey).compareTo(heapArray.get(rightKey)) < 0)) {
					// swap values of leftIndex and currentIndex
					swap(leftIndex, currentIndex);
					// set currentIndex to leftIndex
					currentIndex = leftIndex;
				}
			}
		}
	}

	public void insert(String value) {
		// Let currentIndex be the size of the heap
		int currentIndex = heapArray.size();
		// let the parentIndex = (currentIndex - 1) / 2
		int parentIndex = (currentIndex - 1) / 2;
		// add the new value at the of the heap array
		heapArray.add((heapArray.size() - 1), value);
		// while (currentIndex > 0 and (value at parentIndex > value at currentIndex)), do:
		while((currentIndex > 0) && (heapArray.get(currentIndex).compareTo(heapArray.get(parentIndex)) < 0)) {
			// swap the contents of heapArray at the indexes parentIndex and currentIndex
			swap(parentIndex, currentIndex);
			// set currentIndex = parentIndex
			currentIndex = parentIndex;
			// update parentIndex
			heapArray.set(parentIndex, heapArray.get((currentIndex - 1)/2));
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
