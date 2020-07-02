public class HeapApplications {

	public static void heapSort(String array[], int arrayLen) throws Exception {
		Heap heap = new Heap();

		for(String string : array) {
			heap.insert(string);
		}

		for(int i = 0; i < arrayLen; i++) {
			array[i] = heap.getMinimum();
			heap.deleteMinimum();
		}
	}

	public static String[] topK(String array[], int arrayLen, int k) {
		if(k > arrayLen) {
			k = arrayLen;
		}
		Heap heap = new Heap();
		for(int i = 0; i < k; i++) {
			heap.insert(array[i]);
		}
		for(int i = k; i < arrayLen; i++) {
			String minString = heap.getMinimum();
			if(minString.compareTo(array[i]) < 0) {
				heap.deleteMinimum();
				heap.insert(array[i]);
			}
		}

		String[] topK = new String[k];
		int pos = 0;

		while(heap.size() > 0) {
			topK[pos] = heap.getMinimum();
			pos++;
			heap.deleteMinimum();
		}
		return topK;
	}
}