import java.util.Arrays;

public class Mergesort {
	public static void main(String[] args) {
		int array[] = {4, 5, 1, 7, 12, 8};
		mergesort(array, 0, array.length-1);
	}

	public static void mergesort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(array, left, mid);
			mergesort(array, mid + 1, right);
			int A[] = Arrays.copyOfRange(array, left, mid + 1);
			int B[] = Arrays.copyOfRange(array, mid + 1, right + 1);
			int mergedArray[] = merge(A, B, A.length, B.length);
			int i = left;
			int j = 0;
			while (j <= right - left)
				array[i++] = mergedArray[j++];
		}
	}

	private static int[] merge(int A[], int B[], int lenA, int lenB) {
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
}