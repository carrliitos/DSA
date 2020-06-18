import java.util.Arrays;

public class ArrayPositions {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		System.out.println("Given our array: " + Arrays.toString(arr));
		int firstIndex = 0;
		int lastIndex = arr.length - 1;
		int size = arr.length;
		System.out.printf("The first index: %d%nThe last index: %d%nThe size: %d%n", firstIndex, lastIndex, size);
		System.out.println("From index 0 to 3: " + arr[0, 3]);
	}
}