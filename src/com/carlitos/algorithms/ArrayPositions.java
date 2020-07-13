import java.util.Arrays;

public class ArrayPositions {
	public static void main(String[] args) {
		int arr[] = {16, 12, 2, 3, 12, 2, 6, 7, 4, 3, 21, 22};
		System.out.println("Given our array: " + Arrays.toString(arr));
		int firstIndex = 0;
		int lastIndex = arr.length - 1;
		int size = arr.length;
		int rightMostValue = arr[arr.length - 1];
		System.out.printf("The first index: %d%nThe last index: %d%nThe size: %d%n", firstIndex, lastIndex, size);
		System.out.printf("The rightmost value in the array: %s%n", rightMostValue);
	}
}