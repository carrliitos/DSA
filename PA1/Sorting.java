public class Sorting {

	public static void selectionSort(int[] array, int arrayLen) {
		for(int i = 0; i < (arrayLen - 1); i++) {
			int posMin = i;
			for(int next = i + 1; next < arrayLen; next++) {
				if(array[next] < array[posMin]) {
					posMin = next;
				}
				int temp = array[posMin];
				array[posMin] = array[i];
				array[i] = temp;
			}
		}
	}

	public static void insertionSort(int[] array, int arrayLen) {
		for(int i = 1; i < arrayLen; i++) {
			int j = i;
			int t = array[j];
			while(j > 0 && array[j - 1] > t) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = t;
		}
	}
}