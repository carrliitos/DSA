public class Hashing {

	LinkedList hashTable[];
	int TABLE_SIZE;

	public Hashing(int tableSize) {
		TABLE_SIZE = tableSize;
		hashTable = new LinkedList[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			hashTable[i] = new LinkedList();
	}

	protected int getHashValue(int val) {
		int hashValue = (37 * val + 61) % TABLE_SIZE; // modded to decrease the size of the unique values created
		System.out.println("Hash value: " + hashValue);
		return hashValue;
	}

	public boolean search(int key) {
		int hash = getHashValue(key);
		LinkedList list = hashTable[hash];
		for(int i = 0; i < list.size; i++){
			if(i == key)
				return true;
		}
		return false;
	}

	public boolean insert(int val) {
		if(search(val)){
			return false;
		}else {
			int hash = getHashValue(val);
			LinkedList list = hashTable[hash];
			list.insertAtEnd(val);			
		}
		return true;
	}

	public boolean remove(int val) {
		int hash = getHashValue(val);
		LinkedList list = hashTable[hash];
		if(list.size == 0) {
			return false;
		}
		if(list.head.value == val) {
			list.deleteHead();
		}else {
			ListNode tmp = new ListNode(val); 
			while(tmp.next != null) {
				if(tmp.next.value == val){
					list.deleteAfter(tmp);
					return true;
				}else {
					tmp = tmp.next;
				}
			}
		}
		return false;
	}

	public void printStatistics() {
		int maxSize = hashTable[0].size;
		int minSize = maxSize, total = maxSize;
		for (int i = 1; i < TABLE_SIZE; i++) {
			int size = hashTable[i].size;
			if (size > maxSize)
				maxSize = size;
			else if (size < minSize)
				minSize = size;
			total += size;
		}
		System.out.printf(
				"Max length of a chain = %d%n" + "Min length of a chain = %d%n" + "Avg length of chains = %d%n",
				maxSize, minSize, total / TABLE_SIZE);
	}
}