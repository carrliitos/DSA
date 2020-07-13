public class Stack {

	private int maxStackSize, topOfStack;
	private int[] stack;

	public Stack(int maxStackSize) {
		if (maxStackSize <= 0)
			System.out.println("Stack size should be a positive integer.");
		else {
			this.maxStackSize = maxStackSize;
			topOfStack = -1;
			stack = new int[maxStackSize];
		}
	}

	public void push(int val) {
		if(topOfStack == maxStackSize - 1) { System.out.println("Stack is full, cannot push"); }
		else { stack[++topOfStack] = val; }
	}

	public int pop() { 
		if(topOfStack == -1) {
			System.out.println("Stack is empty.");
			return 0;
		}else {
			return stack[topOfStack--];
		}
	}

	public int size() { 
		return (topOfStack + 1);
	}
}
