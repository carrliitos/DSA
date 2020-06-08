public class Queue {

	private int maxQueueSize, front, rear, currentSize;
	private int[] queue;

	public Queue(int maxQueueSize) {
		if (maxQueueSize <= 0)
			System.out.println("Queue size should be a positive integer.");
		else {
		this.maxQueueSize = maxQueueSize;
		front = rear = 0; 
		currentSize = 0;
		queue = new int[maxQueueSize];
		}
	}

	public void enqueue(int val) {
		if(currentSize == maxQueueSize) { System.out.println("Cannot enqueue, queue is full."); }
		else {
			currentSize++;
			queue[rear++] = val;
			if(rear == maxQueueSize) { rear = 0; }
		}
	}

	public int dequeue() {
		int y = 0;
		if(currentSize == 0) { System.out.println("Cannot dequeue, queue is empty."); }
		else {
			currentSize--;
			y = queue[front];
			front++;
			if(front == maxQueueSize) { front = 0; }
		}
		return y;
	}

	public int size() { 
		return currentSize;
	}

	public String toString() {
		if (size() == 0)
			return "[]";
		else {
			String output = "[";
			if (rear > front) {
				for (int i = front; i < rear - 1; i++)
					output += queue[i] + ", ";
				output += queue[rear - 1] + "]";
			} else {
				for (int i = front; i < maxQueueSize - 1; i++)
					output += queue[i] + ", ";
				output += queue[maxQueueSize - 1];

				for (int i = 0; i < rear; i++)
					output += ", " + queue[i];
				output += "]";
			}
			return output;
		}
	}
}