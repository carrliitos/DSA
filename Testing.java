import java.util.Arrays;

public class Testing {
	public static void main(String[] args) {
		int queueSize = 10;
		int stackSize = 10;
		int queueStackSize = 10;
		int target = -1;
		int[] arr = {100, -1, 13, 17, 8, 14, 1, 0, 0, 21};
		QueueUsingStack qs = new QueueUsingStack(queueStackSize);
		QueueExample queue = new QueueExample(queueSize);
		StackExample stack = new StackExample(stackSize);
		InsertionSort insertionSort = new InsertionSort();
		SelectionSort seletionSort = new SelectionSort();
		RecursiveMethods searching = new RecursiveMethods();

		System.out.println("***Enqueue***");
		for(int i = 1; i <= 5; i++) {
			int x = i;
			queue.enqueue(x);
			qs.enqueue(x);
			System.out.println("Enqueue: " + x + queue.toString());
			System.out.println("Stack Implementation: " + qs.toString());
		}
		System.out.println();

		System.out.println("***Dequeue***");
		System.out.println("Current Queue: " + queue.toString());
		System.out.println("Current Stack Queue: " + qs.toString());
		for(int j = 1; j <= 3; j++) {
			System.out.println("Dequeued: " + queue.dequeue() + queue.toString());
			System.out.println("Dequeued Stack: " + qs.dequeue() + qs.toString());
		}
		System.out.println();

		System.out.println("Peeking: " + queue.peek());
		System.out.println();

		System.out.println("***Push***");
		for(int k = 1; k <= 4; k ++) {
			int y = k;
			System.out.println("Push: " + y);
			stack.push(y);
		}
		System.out.println();

		System.out.println("***Pop***");
		for(int l = 1; l <= 4; l++) {
			System.out.println("Popped: " + stack.pop());
		}
		System.out.println();

		System.out.println("***Sorting***");
		System.out.println("Unsorted Array: " + Arrays.toString(arr));
		System.out.println("Insertion Sort: ");
		insertionSort.sort(arr);
		System.out.println("Sorted Array: " + Arrays.toString(arr));
		System.out.println();
		System.out.println("Selection Sort: ");
		seletionSort.sort(arr);
		System.out.println("Sorted Array: " + Arrays.toString(arr));
		System.out.println();

		System.out.println("***Searching***");
		System.out.println("Recursive Linear Search for: " + Arrays.toString(arr));
		searching.linearSearch(arr, target);
		System.out.println();
		System.out.println("Recursive Binary Search for: " + Arrays.toString(arr));
		searching.binarySearch(arr, target);
	}
}