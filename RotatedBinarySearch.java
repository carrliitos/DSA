import java.util.Arrays;

public class RotatedBinarySearch {
	public static void main(String[] args) throws Exception {
		testRotatedArray();
	}

	public static int search(int array[], int length, int key) {
		// Find the index of the maximum value in the array by calling the 
		// maxIndex function with the arguments: the array, its last value, leftmost index, and rightmost index.
		// Call this index, maxInd
		int maxInd = maxIndex(array, array[length - 1], 0, (length - 1));
		// If the key equals array[maxInd], return maxIndex
		if(key == array[maxInd]){
			return maxInd;
		}
		// if key >= array[0], then binary search the array from the index 0 to maxIndex - 1,
		// both inclusive, and return the index found by binary search
		if(key >= array[0]) {
			return binarySearch(array, 0, (maxInd - 1), key);
		}else {
			return binarySearch(array, (maxInd + 1), (length - 1), key);
		}
	}	

	public static int maxIndex(int array[], int lastValue, int left, int right) {
		// The base case is when left equals right; here you return left
		// if(left == right) {
		// 	return left;
		// }else {
		// 	// Compute mid
		// 	int mid = (left + right) / 2;
		// 	System.out.println("mid: " + mid);
		// 	// if value at mid exceeds value at (mid + 1), then the maximum is at mid
		// 	if(array[mid] > array[mid + 1]) {
		// 		return mid;
		// 	}
		// 	// else if value at mid is less than the last value, then the maximum
		// 	// lies to the left side of mid. Hence, recursively call and return the function with arguments:
		// 	// array, lastValue, left, and mid - 1
		// 	else if(array[mid] < array[array.length - 1]) {
		// 		System.out.printf("array[array.length - 1]: %s%n", array[array.length - 1]);
		// 		System.out.printf("lastValue: %s%nLeft: %s%nMid - 1: %s%n\n", lastValue, left, right, mid - 1);
		// 		return maxIndex(array, lastValue, left, mid - 1);
		// 	}
		// 	// else, the maximum lies to the right side. Hence, recursively call and return the function with arguments:
		// 	// array, lastValue, mid + 1, right
		// 	else {
		// 		return maxIndex(array, lastValue, mid + 1, right);
		// 	}
		// }

		if(left == right) {
			return left;
		}
		int mid = (left + right) / 2;
		if(array[mid] > array[mid + 1]) {
			return mid;
		}else if(array[mid] < array[array.length - 1]) {
			return maxIndex(array, lastValue, left, mid - 1);
		}else {
			return maxIndex(array, lastValue, mid + 1, right);
		}
	}

	private static int binarySearch(int array[], int left, int right, int key) {
		if (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] == key) {
				return mid;
			} else if (array[mid] < key)
				return binarySearch(array, mid + 1, right, key);
			else
				return binarySearch(array, left, mid - 1, key);
		}
		return -1;
	}

	/** ============ TESTS ===========*/
	private static void testRotatedHelper(int array[], int arrayLen, int keys[], int numKeys) throws Exception {
		System.out.println("Array is: " + Arrays.toString(array));
		for (int a = 0; a < numKeys; a++) {
			int index = search(array, arrayLen, keys[a]);
			boolean actuallyExists = false;
			for (int i = 0; i < arrayLen; i++)
				if (array[i] == keys[a]) {
					actuallyExists = true;
					break;
				}
			if ((actuallyExists && index < 0) || (!actuallyExists && index >= 0)
					|| (index >= 0 && array[index] != keys[a])) {
				throw new Exception("Something is wrong!!!");
			}
			if (index >= 0)
				System.out.printf("Key %2d found at index %d\n", keys[a], index);
			else
				System.out.printf("Key %2d not found\n", keys[a]);
		}
	}

	private static void testRotatedArray() throws Exception {
		System.out.println("\n*** Test Rotated Array ***\n");
		int A[] = { 8, 10, 14, 17, 19, 21, 1, 3, 5, 6 };
		int keys_A[] = { 8, 9, 13, 14, 15, 17, 18, 19, 20, 21, 24, 1, 2, 3, 4, 5, 6, 7, 9, 10, 12 };
		testRotatedHelper(A, A.length, keys_A, keys_A.length);

		System.out.println();
		int B[] = { 10, 1, 5, 7 };
		int keys_B[] = { 8, 10, 12, 0, 1, 3, 5, 6, 7, 9 };
		testRotatedHelper(B, B.length, keys_B, keys_B.length);

		System.out.println();
		int C[] = { 12, 1, 5, 7, 10, 11 };
		int keys_C[] = { 8, 10, 11, 12, 0, 1, 3, 5, 6, 7, 9 };
		testRotatedHelper(C, C.length, keys_C, keys_C.length);

		System.out.println();
		int D[] = { 12, 10, 11 };
		int keys_D[] = { 8, 10, 11, 12, 15 };
		testRotatedHelper(D, D.length, keys_D, keys_D.length);

		System.out.println();
		int E[] = { 12, 1 };
		int keys_E[] = { 0, 1, 4, 12, 14 };
		testRotatedHelper(E, E.length, keys_E, keys_E.length);
	}	
}