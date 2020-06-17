public class BinaryTree {
	class TreeNode { // inner class
		int value;
		int height;
		int subtreeSize;
		TreeNode parent;
		TreeNode left;
		TreeNode right;

		public TreeNode(int value) {
			height = subtreeSize = 1;
			value = value;
			parent = null;
			left = null;
			right = null;
		}

		public boolean isLeaf() {
			return (left == null && right == null);
		}
		public boolean hasRightChild() {
			return (right != null);
		}
		public boolean hasLeftChild() {
			return (left != null);
		}
		public boolean isLeftChildOfParent() {
			if(isRoot())
				return false;
			else
				return parent.left == this;
		}
		public boolean isRoot() {
			return (parent == null);
		}
		public String toString() {
			if(isRoot())
				return "<" + value + ", null>";
			else
				return "<" + value + " , " + parent.value + ">";
		}
	}

	protected TreeNode root;
	protected int size;

	public BinaryTree() {
		root = null;
		size = 0;
	}

	public TreeNode search(int key) {
		TreeNode tmp = root;
		// Traverse through the tree
		while(tmp != null) {
			if(tmp.value == key) {
				return tmp;
			}else if(tmp.value < key) {
				tmp = tmp.right;
			}else {
				tmp = tmp.left;
			}
		}
		return null;
	}

	private TreeNode insert(int val) {
		// check to see if the tree exists
		// 	if not, create a new one with the val as the node
		if(getSize() == 0) {
			return new TreeNode(val);
		}
		
		TreeNode tmp = root;
		TreeNode parent = null;
		// traverse through and search the tree
		while(tmp != null) {
			if(tmp.value == val) {
				return null;
			}else if(tmp.value < val) {
				tmp = parent;
				tmp.right = tmp;
			}else {
				tmp = parent;
				tmp.left = tmp;
			}
		}

		// once we find where val should be placed,
		// 		create a new tree node with that val
		TreeNode newNode = new TreeNode(val);
		parent = newNode.parent;
		if(parent.value > val) {
			newNode.isLeftChildOfParent();
		}
		size++;
		return newNode;
	}

	public boolean remove(int val) { // This still needs some clarification
		TreeNode delNode = search(val);
		if (delNode == null) {
			return false;
		} else if (delNode.hasLeftChild() && delNode.hasRightChild()) {
			// CASE 3: delNode has both left and right child
			TreeNode maxNodeInLeftSubTree = findMax(delNode.left);
			delNode.value = maxNodeInLeftSubTree.value;
			// reduced to case 1 or 2
			return deleteAtMostOneChild(maxNodeInLeftSubTree);
		} else {
			return deleteAtMostOneChild(delNode);
		}
	}
    
    public boolean insertAndSet(int val) {
        TreeNode newNode = insert(val);
        if (null == newNode)
            return false;
        while (newNode.parent != null) {
            setHeightAndSubtreeSize(newNode);
            newNode = newNode.parent;
        }
        return true;
    }

	public int getHeight() {
		return getHeight(root);
	}

	public TreeNode findMin() {
		return findMin(root);
	}

	public TreeNode findMax() {
		return findMax(root);
	}

	public static TreeNode findMin(TreeNode node) { // By definition, the leftmost node is the minimum
		if (null == node)
			return null;
		while (node.hasLeftChild()) {
			node = node.left;
		}
		return node;
	}

	public static TreeNode findMax(TreeNode node) { // By definition, the rightmost node is the maximum
		if (null == node)
			return null;
		while (node.hasRightChild()) {
			node = node.right;
		}
		return node;
	}

	public static int getHeight(TreeNode node) {
		if (node == null)
			return 0;
		else
			return node.height;
	}
	
	public int getSize() {
		return size;
	}

	public static int getSubtreeSize(TreeNode node) {
		if (node == null)
			return 0;
		else
			return node.subtreeSize;
	}

	public static void setHeightAndSubtreeSize(TreeNode node) {
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		node.subtreeSize = 1 + getSubtreeSize(node.left) + getSubtreeSize(node.right);
	}

	private boolean deleteAtMostOneChild(TreeNode delNode) { // delNode must have at most 1 child
		TreeNode parentOfDelNode = delNode.parent;
		if (delNode.isRoot()) {
			if (delNode.hasLeftChild()) {
				delNode.left.parent = null;
				root = delNode.left;
			} else if (delNode.hasRightChild()) {
				delNode.right.parent = null;
				root = delNode.right;
			} else {
				root = null;
			}
		} else if (delNode.isLeaf()) {
			// CASE 1: delNode is a leaf node
			if (delNode.isLeftChildOfParent())
				parentOfDelNode.left = null;
			else
				parentOfDelNode.right = null;
		} else {
			// CASE 2: delNode only has a left or a right child
			TreeNode correctChild;
			if (delNode.hasLeftChild())
				correctChild = delNode.left;
			else
				correctChild = delNode.right;
			if (delNode.isLeftChildOfParent())
				parentOfDelNode.left = correctChild;
			else
				parentOfDelNode.right = correctChild;
			correctChild.parent = parentOfDelNode;
		}
		while (parentOfDelNode != null) {
			setHeightAndSubtreeSize(parentOfDelNode);
			parentOfDelNode = parentOfDelNode.parent;
		}
		delNode = null;
		size--;
		return true;
	}

	private void print(TreeNode node) {
		if (null != node) {
			System.out.print(node.toString() + " ");
			print(node.left);
			print(node.right);
		}
	}

	public void print() {
		print(root);
	}
}