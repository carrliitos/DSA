/* Implementation of Insertion Sort algorithm */

public class InsertionSort {
	/*
	* To sort an array A, position 0, A[0], should containt the least element, A[1] should containt
	* the second least element, and so on
	*/
	public void sort(int[] arr) {
		int n = arr.length;
		for(int i = 1; i < n; i++) {
			int j = i;
			int t = arr[j];
			while(j > 0 && arr[j - 1] > t) { // this is where the shifting happens
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = t;
		}
	}

	public static void printArray(int[] arr) {
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}