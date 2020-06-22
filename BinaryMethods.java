import java.util.Arrays;
import java.util.ArrayList;

public class BinaryMethods {
	public static void main(String[] args) {
		int A[] = {1,2,3,4,5};
		int B[] = {1, 2, 3, 5};
		int lenA = A.length, lenB = B.length;
		System.out.println("Array A: " + Arrays.toString(A));
		System.out.println("Array B: " + Arrays.toString(B));
		commonElements(A, B, lenA, lenB);
	}
	private static int[] binaryMerge(int A[], int B[], int lenA, int lenB) {
		int lenC = lenA + lenB;
		// Create a new array C[] with length = length of A + length of B 
		int C[] = new int[lenC];
		// initialize a, b, c for corresponding arrays
		int a = 0, b = 0, c = 0;
		// Start while loop for merging
		while(a < lenA && b < lenB) {
			if(A[a] < B[b]) {
				C[c] = A[a];
				a++;
			}else {
				C[c] = B[b];
				b++;
			}
			c++;
		}
		while(a < lenA) {
			C[c] = A[a];
			a++;
			c++;
		}
		while(b < lenB) {
			C[c] = B[b];
			b++;
			c++;
		}
		return C;
	}

	/** The commonElements algorithm is usually O(mn) -- pick each number in A[] and 
	* 	scan B[] to verify if the number exists
	*
	*	We can improvie this to O(m log n) or O(n log m) by applying a binary search
	*	-- pick a number from one array and binary search the other one, typically, binary
	*	search the bigger one of the two arrays
	*
	*	The algorithm implement here is an O(m + n), which is as good as it gets
	*/
	public static ArrayList<Integer> commonElements(int A[], int B[], int lenA, int lenB) {
		ArrayList<Integer> dynamicArray = new ArrayList<>();
		int a = 0, b = 0;
		while(a < lenA && b < lenB) {
			if(A[a] < B[b]) {
				a++;
			}else if(A[a] > B[b]) {
				b++;
			}else {
				for(int i = 0; i < lenA - 1; i++){
					if(A[i] == A[i + 1])
						continue;
				}
				dynamicArray.add(A[a]);
				a++;
			}
		}
		System.out.println("Common Elements: " + dynamicArray.toString());
		return dynamicArray;
	}

	public static ArrayList<Integer> binarySearchCommonElements(int A[], int B[], int lenA, int lenB) {
		ArrayList<Integer> dynamicArray = new ArrayList<>();
		if(lenA > lenB) {
			for (int a : A) {
				binarySearchAsc(B, a);
			}
		}else {
			for (int b : B) {
				binarySearchAsc(A, b);
			}
		}
		return dynamicArray;
	}

	public static void mergesort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(array, left, mid);
			mergesort(array, mid + 1, right);
			int A[] = Arrays.copyOfRange(array, left, mid + 1);
			int B[] = Arrays.copyOfRange(array, mid + 1, right + 1);
			int mergedArray[] = binaryMerge(A, B, A.length, B.length);
			int i = left;
			int j = 0;
			while (j <= right - left)
				array[i++] = mergedArray[j++];
		}
	}

	private static int binarySearchAsc(int array[], int key) {
		int arrayLength = array.length;
		int left = 0;
		int right = arrayLength - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(array[mid] == key){
				System.out.println("Found it on index: " + mid);
				return mid;
			}else if(key > array[mid]){ 
				left = mid + 1; // right side of the array
				System.out.printf("Mid: %s%nLeft %s%nRight: %s%n\n", mid, left, right);
			}else{
				right = mid - 1; // left side of the array
				System.out.printf("Mid: %s%nLeft %s%nRight: %s%n\n", mid, left, right);
			}
		}
		return -1;
	}

	private static int binarySearchDesc(int array[], int key) {
		int arrayLength = array.length;
		int left = 0;
		int right = arrayLength - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(array[mid] == key){
				System.out.println("Found it on index: " + mid);
				return mid;
			}else if(key < array[mid]){ 
				left = mid + 1; // right side of the array
				System.out.printf("Mid: %s%nLeft %s%nRight: %s%n\n", mid, left, right);
			}else{
				right = mid - 1; // left side of the array
				System.out.printf("Mid: %s%nLeft %s%nRight: %s%n\n", mid, left, right);
			}
		}
		return -1;
	}	
}