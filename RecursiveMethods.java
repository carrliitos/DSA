import java.util.Arrays;

public class RecursiveMethods {
	public static void main(String[] args) {
		int target = 16;
		int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		int B[] = {3, 7, 9, 14, 15, 17, 24, 81};
		System.out.println("Target: " + target);
		System.out.println("");
		System.out.println("Linear Search:");
		linearSearch(x, target);
		System.out.println("");
		System.out.println("Binary Search:");
		binarySearch(x, target);
		int y = predecessor(B, B.length, target);
		System.out.println("The predecessor of: " + target + " is on index: " + y + ", which is: " + B[y]);
	}

	/* Recursive Linear Array Search
	* @param items -- the items array being being searched
	* @param target -- the item being search for
	* @param posFirst -- the position of the current first element
	*/
	private static int linearSearch(int[] items, Object target, int posFirst) {
		// Base case 1 -- check that the current first element is in the bounds of the array
		if(posFirst == items.length) {
			System.out.println("Target out of bounds of the array.");
			return -1;
		// Base case 2 -- check that the current first element is the target
		}else if(target.equals(items[posFirst])) {
			System.out.println("Target found at index: " + posFirst);
			return posFirst;
		// Recursive case -- Recursively search through again, incrementing posFirst to exclude
		// the first current element
		}else {
			System.out.println("Going again!");
			return linearSearch(items, target, posFirst + 1);
		}
	}

	/* linearSearch wrapper
	* The third @param will always be zero anyway
	* so we write a wrapper that only takes in 2 arguments: items[] and target
	*/
	public static int linearSearch(int[] items, Object target) {
		return linearSearch(items, target, 0);
	}

	/* Recursive binary Search
	* @param <T> -- the item type
	* @param items -- array being searched
	* @param target -- object being searched for
	* @param first -- subscript of first element
	* @param last -- subscript of last element
	* @return -- subscript of target if found; otherwise, return -1;
	*/
	// private static int binarySearch(int[] items, int target, int first, int last) {
	// 	// Base case 1 -- unsuccessful search
	// 	if(first > last){
	// 		System.out.println("Target not in the array.");
	// 		return -1;
	// 	}else {
	// 		int middle = (first + last) / 2; // next probe index
	// 		if(items[middle] == target) {
	// 			System.out.println("Found it on index: " + middle);
	// 			return middle; // Successful base case
	// 		}else if(target < items[middle]) { // left half
	// 			System.out.println("Going on the left half.");
	// 			return binarySearch(items, target, first, middle - 1); // Recursive step				
	// 		}else{  // right half
	// 			System.out.println("Going on the right half.");
	// 			return binarySearch(items, target, middle + 1, last); // recursive step
	// 		}
	// 	}
	// }

	// /*binarySearch wrapper*/
	// public static int binarySearch(int[] items, int target) {
	// 	return binarySearch(items, target, 0, items.length -1);
	// }

	public static int binarySearch(int array[], int key) {
		int arrayLength = array.length;
		int left = 0;
		int right = arrayLength - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(array[mid] == key){
				System.out.println("Found it on index: " + mid);
				return mid;
			}else if(array[mid] > key){ 
				right = mid - 1; // left side of the array
			}else{
				left = mid + 1; // right side of the array
			}
		}
		return -1;
	}

	public static int predecessor(int array[], int arrayLength, int key) {
		int left = 0;
		int right = arrayLength - 1;
		int predIndex = -1;
		while(left <= right) {
			int mid = (left + right) / 2;
			System.out.println("Current mid:" + mid);
			if(array[mid] < key){
				predIndex = mid;
				left = mid + 1;
				System.out.println("Current left: " + left);
			}else{ 
				System.out.println("Current right: " + right);
				right = mid - 1;
			}
		}
		return predIndex;
	}
}