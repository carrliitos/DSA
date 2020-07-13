public class QueueUsingStack {

	Stack mainStack;
	int maxQueueSize;

	public QueueUsingStack(int maxQueueSize) {
		this.maxQueueSize = maxQueueSize;
		mainStack = new Stack(maxQueueSize);
	}

	public void enqueue(int val) { 
		Stack tempStack;
		tempStack = new Stack(maxQueueSize);
		if(mainStack.size() == maxQueueSize) { System.out.println("Cannot enqueue, stack is full!"); }
		else {
			while(mainStack.size() != 0) {
				tempStack.push(mainStack.pop());
			}
			mainStack.push(val);
			while(tempStack.size() != 0) {
				mainStack.push(tempStack.pop());
			}
		}
	}

	public int dequeue() { 
		int y = 0;
		if(mainStack.size() == 0) { System.out.println("Cannot dequeue! Stack is empty"); }
		else {
			y = mainStack.pop();
		}
		return y;
	}

	public int size() { 
		return mainStack.size();
	}

	public String toString() {
		if (size() == 0) {
			return "[]";
		} else {
			String output = "[";
			int n = size();
			for (int i = 0; i < n - 1; i++) {
				int x = dequeue();
				output += x + ", ";
				enqueue(x);
			}
			int x = dequeue();
			output += x + "]";
			enqueue(x);
			return output;
		}
	}
}