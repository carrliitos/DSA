/*Implementation of Selection Sort algorithm*/

public class SelectionSort {
	/* The Selection Sort algorithm sorts an array by repeatedly finding the minimum element
	* from the unsortred part and putting it at the beginning. The algorithm maintains two subarrays in a given way:
	* (i) The subarray which is already sorted
	* (ii) Remainin subarray which is unsorted
	*
	* In every iteration of Selection sort, the minimum element is picked from the unsorted and is moved to the 
	* sorted array.
	*/

	public void sort(int arr[]) {
		int n = arr.length;
		for(int i = 0; i < n - 1; i++) {
			int posMin = i;
			for(int next = i + 1; next < n; next++){
				if(arr[next] < arr[posMin]) {
					posMin = next;
				}
			}
			int temp = arr[posMin];
			arr[posMin] = arr[i];
			arr[i] = temp;
		}
	}
}