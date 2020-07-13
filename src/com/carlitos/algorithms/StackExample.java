public class StackExample {
	private int MAX_SIZE;
	private int topOfStack; // var topOfStack is the index counter of the array
	private int stackArray[];
	/*
	* Determine the size of the stack array
	* Initialize the maximum size and top of the stack -- Remember: index based
	*/
	public StackExample(int MAX_SIZE){ // Simulate the stack
		if(MAX_SIZE <= 0) { System.out.println("Stack size should be a postive integer!"); }
		else{ 
			this.MAX_SIZE = MAX_SIZE;
			topOfStack = -1;
			stackArray = new int[MAX_SIZE];		
		}
	}

	/*
	* push(i) - adds an item i into the stack
	* check to see if stack is full
	* if not, add i to the stack
	*/
	public void push(int val) {
		if(topOfStack == MAX_SIZE - 1) { System.out.println("Stack is full! Cannot push " + val); }
		else { stackArray[++topOfStack] = val; } // ++topOfStack = we add to the top
	}

	/*
	* pop() - removes and returns the latest item -- Provided, the stack is not empty
	* check to see if stack is empty
	* if not, return and remove the latest item
	*/
	public int pop() {
		if(topOfStack == -1) { 
			System.out.println("Can't pop, stack is empty!");
			return 0;
		}else {
			return stackArray[topOfStack--]; // we first assign topOfStack, and then decrement them! (i.e. remove the top)
		}
	}

	public int peek() {
		if(topOfStack == -1) {
			System.out.println("Stack is empty, can't peek");
			return 0;
		}else {
			return stackArray[topOfStack];
		}
	}

	/*
	* To check the size of the stack, just return the topOfStack + 1
	* topOfStack returns the index of the array, but since it is zero-based, we do +1
	*/
	public int size() {
		return (topOfStack + 1);
	}
}