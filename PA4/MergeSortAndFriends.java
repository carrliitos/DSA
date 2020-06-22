import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortAndFriends {

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
				for(int i = 0; i < lenA - 1; i++){
					if(A[i] == A[i + 1])
						continue;
				}
				dynamicArray.add(A[a]);
				a++;
				// while(a < lenA && A[a] == B[b]){
				// 	dynamicArray.add(A[a]);
				// 	if(A[a] == A[a + 1]){
				// 		dynamicArray.remove(A[a]);
				// 	}
				// 	a++;
				// }
			}
		}
		return dynamicArray;
	}

	public static int[] kWayMerge(int lists[][], int listLengths[], int k) {
		if(k == 1) {
			int firstRow[] = lists[0];
			return firstRow;
		}else if(k == 2) {
			return binaryMerge(lists[0], lists[1], listLengths[0], listLengths[1]);
		}else {
			int newK = (k + 1)/2;
			int mergedLists[][] = new int[newK][]; // This will store the pairwise merged lists
			int mergedListLengths[] = new int[newK]; // This will store the lengths of the pairwise merged lists
			for(int i = 0; i <= k/2 - 1; i++) {
				mergedListLengths[i] = listLengths[2 * i] + listLengths[(2 * i) + 1];
				mergedLists[i] = binaryMerge(lists[2 * i], lists[(2 * i) + 1], listLengths[2 * i], listLengths[(2 * i) + 1]);
			}
			if(k % 2 != 0) {
				mergedLists[newK - 1] = lists[k - 1];
				mergedListLengths[newK - 1] = listLengths[k - 1];
			}
			/** Note to self:
			* 	If k is odd, then the last row in lists does not have a pair to
			* 	be merged with, so we simply copy it mergedLists[newK - 1]
			*/
			return kWayMerge(mergedLists, mergedListLengths, newK);
		}
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
}