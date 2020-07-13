import java.util.Arrays;
import java.util.ArrayList;

public class Mergesort {
	public static void main(String[] args) {
		int A[] = {4, 5, 1, 7, 12, 8};
		int B[] = {23, 32, 44, 12, 21, 2, 1, 3};
		mergesort(A, 0, A.length - 1);
		mergesort(B, 0, B.length - 1);
		int[] binaryMerged = binaryMerge(A, B, A.length, B.length);
		for(int i = 0; i < binaryMerged.length; i++){
			System.out.println(binaryMerged[i]);
		}
		testCommonElements();
	}

	private static void testCommonElements() {
		System.out.println("\n*** Test Common Elements in Sorted Arrays ***\n");
		int A[] = { 1, 1, 3, 7, 9, 14, 14, 14, 14, 14, 14, 18, 23, 39, 39, 39 };
		int B[] = { 1, 1, 5, 7, 9, 14, 23, 27, 39, 39 };
		System.out.println("Array 1: " + Arrays.toString(A));
		System.out.println("Array 2: " + Arrays.toString(B));
		System.out.println("Common elements are " + commonElements(A, B, A.length, B.length));

		int C[] = { 1, 1, 3, 7, 9, 14, 14, 14, 14, 14, 14, 18, 23, 39, 39, 39 };
		int D[] = { 8, 17, 17, 26, 38, 43, 43 };
		System.out.println("\nArray 1: " + Arrays.toString(C));
		System.out.println("Array 2: " + Arrays.toString(D));
		System.out.println("Common elements are " + commonElements(C, D, C.length, D.length));

		int E[] = { 1, 3, 7, 9, 14, 18, 23, 39 };
		int F[] = { 1, 5, 7, 9, 14, 39 };
		System.out.println("\nArray 1: " + Arrays.toString(E));
		System.out.println("Array 2: " + Arrays.toString(F));
		System.out.println("Common elements are " + commonElements(E, F, E.length, F.length));
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

	public static ArrayList<Integer> commonElements(int A[], int B[], int lenA, int lenB) {
		ArrayList<Integer> dynamicArray = new ArrayList<>();
		int a = 0, b = 0;
		while(a < lenA && b < lenB) {
			if(A[a] < B[b]) {
				a++;
			}else if(A[a] > B[b]) {
				b++;
			}else {
				// do {
				// 	dynamicArray.add(A[a]);
				// 	a++;
				// }while(a < lenA && A[a] == B[b]);
				// for(int i = a; i < A.length; i++) {
				// 	dynamicArray.add(A[a]);
				// }
				// while(a < lenA && A[a] == B[b]){
				// 	dynamicArray.retainAll(A[a]);
				// 	a++;
				// }

				// for(int i = 0; i < A.length; i++) {
				// 	if(!dynamicArray.contains(A[i])) {
				// 		dynamicArray.add(A[a]);
				// 		a++;
				// 	}
				// }
			}
		}
		return dynamicArray;
	}
}