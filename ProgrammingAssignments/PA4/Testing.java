public class Testing {
	public static void main(String[] args) {
		int A[] = {0, 3, 16, 9, 10, 13};
		int left = 0;
		int right = A.length - 1;
		int mid = (left + right) / 2;
		int lastValue = A.length;
		System.out.printf("Middle index: %d%nMiddle Value: %d%n", mid, A[mid]);
		System.out.printf("Middle value: %d%nLast Value: %d%n", A[mid], lastValue);
	}
}