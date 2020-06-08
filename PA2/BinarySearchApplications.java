public class BinarySearchApplications {
	public static int minIndexBinarySearch(int array[], int arrayLength, int key) { 
		int left = 0;
		int right = arrayLength - 1;
		int minIndex = -1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(array[mid] == key){
				minIndex = mid;
				right = mid - 1;
			}else if(array[mid] > key){ 
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return minIndex;
	}

	public static int maxIndexBinarySearch(int array[], int arrayLength, int key) { 
		int left = 0;
		int right = arrayLength - 1;
		int maxIndex = -1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(array[mid] == key){
				maxIndex = mid;
				left = mid + 1;
			}else if(array[mid] > key){ 
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return maxIndex;	
	}

	public static int countNumberOfKeys(int array[], int arrayLength, int key) {
		int maxAnswer = maxIndexBinarySearch(array, arrayLength, key);
		int minAnswer = minIndexBinarySearch(array, arrayLength, key);
		int answer = maxAnswer - minAnswer + 1;
		return answer;
	}

	public static int predecessor(int array[], int arrayLength, int key) {
		int left = 0;
		int right = arrayLength - 1;
		int predIndex = -1;
		while(left <= right) {
			int mid = (left + right) / 2;
			System.out.println("Current mid:" + mid);
			if(array[mid] < key){
				predIndex = mid;
				left = mid + 1;
				System.out.println("Current left: " + left);
			}else{ 
				System.out.println("Current right: " + right);
				right = mid - 1;
			}
		}
		return predIndex;
	}
}