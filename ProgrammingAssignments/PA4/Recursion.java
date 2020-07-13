public class Recursion {

	public static int sumEvenDigits(int n) {
		if(n == 0) {
			return 0;
		}
		int lastDig = n % 10;
		int firstDigs = n / 10;
		if(lastDig % 2 == 0) {
			return lastDig + sumEvenDigits(firstDigs);
		}else {
			return 0 + sumEvenDigits(firstDigs);
		}
	}

	public static void binaryStringsWithMoreOnes(int n) {
		binaryStringsWithMoreOnes("", 0, 0, n);
	}

	private static void binaryStringsWithMoreOnes(String str, int numZeroes, int numOnes, int n) {
		if(numOnes < numZeroes) {
			return;
		}
		if(n == 0) {
			System.out.println(str);
			return;
		}
		binaryStringsWithMoreOnes(str + "1", numZeroes, numOnes + 1, n - 1);
		binaryStringsWithMoreOnes(str + "0", numZeroes + 1, numOnes, n - 1);
	}
}