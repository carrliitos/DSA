public class LinkedList {

	protected ListNode head, tail;
	protected int size;

	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public ListNode insertAtEnd(int value) {
		ListNode newNode = new ListNode(value);
		if (size == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return newNode;
	}

	public void deleteHead() {
		if (0 == size) {
			return;
		} else if (1 == size) {
			head = tail = null;
			size--;
		} else {
			size--;
			ListNode tmp = head;
			head = head.next;
			tmp.next = null;
			tmp = null;
		}
	}

	public void deleteAfter(ListNode argNode) {
        if (argNode == tail) {
            System.out.println("Cannot delete after tail.");
        } else if (argNode.next == tail) {
            argNode.next = null;
            tail = argNode;
            size--;
        } else {
            ListNode tmp = argNode.next;
            argNode.next = argNode.next.next;
            tmp.next = null;
            tmp = null;
            size--;
        }
	}

	void printList() {
		if (size == 0)
			System.out.println("[]");
		else {
			ListNode tmp = head;
			String output = "[";
			for (int i = 0; i < size - 1; i++) {
				output += tmp.value + " -> ";
				tmp = tmp.next;
			}
			output += tail.value + "]";
			System.out.println(output);
		}
	}
}