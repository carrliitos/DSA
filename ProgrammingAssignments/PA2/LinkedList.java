public class LinkedList {

	public ListNode head, tail;
	public int size;

	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	public void insertAfter(ListNode argNode, int value) {
		ListNode newNode = new ListNode(value);
		if(size == 0) {
			System.out.println("Can't insert value at specified node, list is empty.");
		}else if(argNode == tail) {
			tail.next = newNode;
			tail = newNode;
		}else {
			newNode.next = argNode.next;
			argNode.next = newNode;
		}
		size++;
	}

	public void deleteAfter(ListNode argNode) {
		if(argNode == tail) {
			System.out.println("Cannot delete from given argument node.");
		}else if(argNode.next == tail) {
			ListNode temp = tail;
			argNode.next = null;
			temp = null;
			tail = argNode;
			size--;
		}else {
			ListNode temp = argNode.next;
			if(temp != null) {
				argNode.next = temp.next;
				temp = null;
				size--;
			}
		}
	}

	public void selectionSort() {
		for(ListNode iNode = head; iNode != null; iNode = iNode.next) {
			ListNode minNode = iNode;
			for(ListNode jNode = iNode; jNode != null; jNode = jNode.next){
				if (minNode.value > jNode.value) {
					minNode = jNode;
				}
			}
			ListNode temp = new ListNode(iNode.value);
			iNode.value = minNode.value;
			minNode.value = temp.value;
		}
	}

	public boolean removeDuplicatesSorted() {
		for(int i = 0; i < size; i++) {
			ListNode tmp = head;
			if(tmp.value > head.value){
				return false;
			}else{
				tmp = tmp.next;
			}
			return true;
		}

		for(int j = 0; j < size; j++){
			ListNode temp = head;
			if(temp.value == head.next.value){
				deleteHead();
			}else {
				temp = temp.next;
			}
		}
		return true;
	}

	public void pushOddIndexesToTheBack() {
		ListNode evenHead = null;
		ListNode evenTail = null;

		ListNode oddHead = null;
		ListNode oddTail = null;

		while (head != null) {
			if(head.value % 2 == 0) {
				if (evenHead == null) {
					evenHead = new ListNode(head.value);
					evenTail = evenHead;
				} else {
					evenTail.next = new ListNode(head.value);
					evenTail = evenTail.next;
				}
			} else {
		        if (oddHead == null) {
					oddHead = new ListNode(head.value);
					oddTail = oddHead;
				} else {
					oddTail.next = new ListNode(head.value);
					oddTail = oddTail.next;
				}
		    }
		}
	}

	ListNode insertAtFront(int value) {
		ListNode newNode = new ListNode(value);
		if (size == 0) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
		return newNode;
	}

	ListNode insertAtEnd(int value) {
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

	void deleteHead() {
		if (0 == size) {
			System.out.println("Cannot delete from an empty list");
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

	public ListNode getNodeAt(int pos) {
		if (pos < 0 || pos >= size || 0 == size) {
			System.out.println("No such position exists");
			return null;
		} else {
			ListNode tmp = head;
			for (int i = 0; i < pos; i++)
				tmp = tmp.next;
			return tmp;
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

	public int getSize() {
		return size;
	}
}