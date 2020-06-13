public class BSTApplications extends BST {

	public BSTApplications(int A[]) {
		root = null;
		size = 0;
		for (int a : A)
			insertAndSet(a);
	}

	public BSTNode getPredecessor(int key) {
		BSTNode tmp = root;
		BSTNode predecessor = null;
		while(tmp != null) {
			if(tmp.value == key) {
				return tmp;
			}else if(tmp.value < key) {
				tmp = predecessor;
				tmp.right = tmp;
			}else {
				tmp.left = tmp;
			}
		}
		return predecessor;
	}

	public BSTNode getSuccessor(int key) {
		BSTNode tmp = root;
		BSTNode successor = null;
		while(tmp != null) {
			if(tmp.value == key) {
				return tmp;
			}else if(tmp.value < key) {
				tmp = successor;
				tmp.left = tmp;
			}else {
				tmp.right = tmp;
			}
		}
		return successor;
	}

	public int nearestNeighbour(int key) throws Exception {
		BSTNode successor = getSuccessor(key);
		BSTNode predecessor = getPredecessor(key);
		if(predecessor == null) {
			return successor.value; 
		}else if(successor == null) {
			return predecessor.value;
		}else {
			if(predecessor.value > successor.value){
				return predecessor.value;
			}else {
				return successor.value;
			}
		}
	}

	public BSTNode getLCA(int x, int y) {
		if(x > y) {
			int tmp = 0;
			tmp = x;
			x = y;
			y = tmp;
		}
		BSTNode tmp = root;
		while(tmp != null) {
			if(tmp.value < x) {
				tmp = tmp.right;
			}else if(tmp.value > y) {
				tmp = tmp.left;
			}else {
				break;
			}
		}
		return tmp;
	}

	public int rangeCount(int L, int R) {
		BSTNode lCA = getLCA(L, R);

		if(L > R) {
			return 0;
		}
		if(lCA == null) {
			return 0;
		}
		if(lCA.value == L && lCA.value == R) {
			return 1;
		}

		int counter = 0;

		if(lCA.value > L && lCA.value < R) {
			counter = 1;
		}else if(lCA.value == L || lCA.value == R) {
			counter = 1;
		}
		if(lCA.value > L) {
			BSTNode tmp = lCA.left;
			while(tmp != null) {
				if(L == tmp.value) {
					counter++;
					break;
				}
				if(L < tmp.value){
					counter++;
					tmp.left = tmp;
				}else {
					tmp.right = tmp;
				}
			}
		}
		if(lCA.value < R) {
			BSTNode tmp = lCA.right;
			while(tmp != null) {
				if(R == tmp.value) {
					counter++;
					break;
				}
				if(R > tmp.value) {
					counter++;
					tmp.right = tmp;
				}else {
					tmp.left = tmp;
				}
			}
		}
		return counter;
	}
}