import java.util.Arrays;

public class RecursiveMethods {
	public static void main(String[] args) {
		// int target = 1;
		// int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		// System.out.println("Target: " + target);
		// System.out.println("");
		// System.out.println("Linear Search:");
		// linearSearch(x, target);
		// System.out.println("");
		// System.out.println("Binary Search:");
		// binarySearch(x, target);

		System.out.println("*** Test Recursion ***\n");
		int A[] = { 123076, 689201, 6592073, 12461, 1355171 };
		for (int a = 0; a < A.length; a++)
			System.out.printf("Sum of even digits in %d is %d\n", A[a], sumEvenDigits(A[a]));
		int B[] = { 1, 2, 3, 4, 5, 6 };
		for (int b = 0; b < B.length; b++) {
			System.out.printf("\nAll binary strings of length %d that have more ones than zeroes\n", B[b]);
			binaryStringsWithMoreOnes(B[b]);
		}
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

	private static int binarySearch(int array[], int key) {
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


	/** Recursive example - Fibonacci
	* 	Base-case: fibonacci(1) = 1 andfibonacci(2) = 2
	* 	Recursuve Rule: fibonacci(n) =fibonacci(n − 1) +fibonacci(n − 2)
	*/
	private static int fibonacci(int n) {
		if(n <= 2) {
			return 1;
		}else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	/** sumEvenDigits - Return the sum of digits in n that are even.
	* 	Extract the last digit and check if it is even or not.
	* 		If even, this digit contributes to the overall sum, else it does not.
	*/
	private static int sumEvenDigits(int n) {
		if (n == 0) return 0;
		int lastDigit = n % 10;
		int firstDigits = n / 10;
		if (lastDigit % 2 == 0) {
			return lastDigit + sumEvenDigits(firstDigits);
		} else {
			return 0 + sumEvenDigits(firstDigits);
		}
	}

	/** sumDigits - Consider a number 5671.  Sum of its digits is 5 + 6 + 7 + 1 = 19.
	* 	LetsumDigits(num) be the sumof the digits of the number.
	*/
	private static int sumDigits(int n) {
		if(n < 10) {
			return n;
		}else {
			return sumDigits(n / 10) + n % 10;
		}
	}

	private static void binaryStringsWithMoreOnes(String str, int numZeroes, int numOnes, int n) {
		if(numOnes < numZeroes) {
			return;
		}
		if(n == 0) {
			System.out.println(str);
			return;
		}
		binaryStringsWithMoreOnes(str + "1", numZeroes, numOnes + 1, n - 1);
		binaryStringsWithMoreOnes(str + "0", numZeroes + 1, numOnes, n - 1);
	}

	/*WRAPPER FOR ABOVE METHOD*/
	public static void binaryStringsWithMoreOnes(int n) {
		binaryStringsWithMoreOnes("", 0, 0, n);
	}	
}