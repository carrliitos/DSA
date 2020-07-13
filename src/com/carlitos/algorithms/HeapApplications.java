public class HeapApplications {

	public static void heapSort(String array[], int arrayLen) throws Exception {
		// create a heap via a constructor call to the Heap class
		Heap heap = new Heap();
		// insert all the strings of the array into the heap using a for loop
		for(int i = 0; i < arrayLen; i++) {
			heap.insert(array[i]);
		}
		// for(String string : array) {
		// 	heap.insert(string);
		// }
				
		// for (i = 0 to i < arrayLen), do the following:
		for(int i = 0; i < arrayLen; i++) {
			// set array[i] to the smallest string in the heap (use getMinimum() function of the heap to get the minimum string)
			array[i] = heap.getMinimum();
			// delete the minimum from the heap
			heap.deleteMinimum();
		}
	}

	public static String[] topK(String array[], int arrayLen, int k) {
		// if(k > arrayLen) then set k = arrayLen
		if(k > arrayLen) {
			k = arrayLen;
		}
		// create a heap via a constructor call to the Heap class
		Heap heap = new Heap();
		// Insert the first k elements of the array into the heap using a loop
		for(int i = 0; i < k; i++) {
			heap.insert(array[i]);
		}
		// for (i = k to i < arrayLen), do the following:
		for(int i = k; i < arrayLen; i++) {
			// let minString be the smallest string in the heap
			String minString = heap.getMinimum();
			// if (minString is smaller than array[i]), then:
			if(minString.compareTo(array[i]) < 0) {
				// delete the minimum from the heap
				heap.deleteMinimum();
				// insert array[i] into the heap
				heap.insert(array[i]);
			}
		}
		// Create a string array topK[] of size k
		String[] topK = new String[k];
		// initialize an integer pos = 0
		int pos = 0;
		// while(size of the heap > 0), do the following:
		while(heap.size() > 0) {
			// set topK[pos] = the minimum string in the heap
			topK[pos] = heap.getMinimum();
			// increment pos by one
			pos++;
			// delete the minimum from the heap
			heap.deleteMinimum();
		}
		return topK;
	}
}