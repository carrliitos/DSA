public class DynamicArrays { // O(n)
	public static void main(String[] args) {
		int A[] = {1, 3, 12, 54};
		int length; // the length of, initialized to power of 2 -- 1, 2, 4, 6,...
		int numElements = A.length; // initialized to 0
		A.accessIndex(2);
	}

	// O(1)
	private int accessIndex(int[] A, int i, int numElements) {
		if(i < numElements)
			return A[i];
		else
			System.out.println("Cannot return an element outside array range");
			return 0;
	}

	private void update(int[] A, int i, int val, int numElements) {
		if(i < numElements)
			A[i] = val;
		else
			System.out.println("Cannot update outside the array range");
	}

	// O(n)
	private void insertAtEnd(int[] A, int val, int numElements, int length) {
		if(numElements == length){
			length = 2 * length;
			int B[] = new int[length];
			for(int i = 0; i < length; i++) {
				B[i] = A[i];
			}
			A = B;
		}
		A[numElements++] = val;
	}

	// O(n)
	private void deleteLast(int[] A, int numElements, int length) {
		if(numElements == 0){
			System.out.println("Cannot delete from an empty array");
		}else if(numElements == 1) {
			numElements = 0;
			length = 1;
			int[] A = new int[length];
		}else {
			numElements--;
			if((4 * numElements) == length) {
				length = 2 * numElements;
				int B[] = new int[length];
				for(int i = 0; i < length; i++) {
					B[i] = A[i];
				}
				A = B;
			}
		}
	}
}