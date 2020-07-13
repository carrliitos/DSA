public class QueueExample {
	private int MAX_SIZE;
	private int queueSize;
	private int front, rear; // Index counters of our array
	private int queueArray[];

	/*
	* Determine the size of the queue array
	* Initialize the maximum size, front, and rear -- remember, front and rear and index-based
	*/
	public QueueExample(int MAX_SIZE) { // Simulate the Queue
		if(MAX_SIZE <= 0) { System.out.println("Queue size should be a positive integer"); }
		else{
			this.MAX_SIZE = MAX_SIZE;
			front = 0;
			rear = 0;
			queueArray = new int[MAX_SIZE];
		}
	}

	/*
	* enqueue(i) - adds an item i into the collection
	* Check to see that the queue size is full -- if not keep going 
	* If queue not full, increment the queueSize
	* increment rear
	* assign queueArray[rear] = val
	* if rear equals MAX_SIZE, then reset rear = 0
	*/
	public void enqueue(int val) {
		if(queueSize == MAX_SIZE) { System.out.println("Cannot enqueue! Queue is full!"); }
		else {
			queueSize++;
			queueArray[rear++] = val;
			if(rear == MAX_SIZE) { rear = 0; }
		}
	}

	/*
	* dequeue() - returns and removes the OLDEST item; provided the queue is not empty
	* check to see that the queue size is empty -- if not keep going
	* decrement queueSize
	* Store queueArray[front] = y
	* increment front by one
	* if queueArray[front] == MAX_SIZE, reset front = 0
	* return y
	*/
	public int dequeue() {
		int y = 0;
		if(queueSize == 0) { System.out.println("Cannot dequeue! Queue is empty"); }
		else {
			queueSize--;
			y = queueArray[front];
			front++;
			if(front == MAX_SIZE) { front = 0; }
		}
		return y;
	}

	public int peek() {
		if(queueSize == 0) { 
			System.out.println("Stack is empty, can't peak");
			return 0;
		}
		else { 
			return queueArray[front];
		}
	}

	public int size() { return queueSize; }

	public String toString() {
		if (size() == 0)
			return "[]";
		else {
			String output = "[";
			if (rear > front) {
				for (int i = front; i < rear - 1; i++)
					output += queueArray[i] + ", ";
				output += queueArray[rear - 1] + "]";
			} else {
				for (int i = front; i < MAX_SIZE - 1; i++)
					output += queueArray[i] + ", ";
				output += queueArray[MAX_SIZE - 1];

				for (int i = 0; i < rear; i++)
					output += ", " + queueArray[i];
				output += "]";
			}
			return output;
		}
	}
}