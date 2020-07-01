public class Trie {

	TrieNode root;

	Trie() {
		root = new TrieNode();
	}

	void insert(String str) {
		// Set a TrieNode temporary variable tmp to the root. (In C++, tmp has to be a pointer.)
		TrieNode tmp = root;
		// for (i = 0 to i < str.length()), do the following:
		for(int i = 0; i < str.length(); i++) {
			// Let c be the character at position i of str.
			char c = str.charAt(i);
			// Use the getChild method on tmp with c as argument to get the child of tmp, such that the corresponding edge is labeled by c.
			// If the child is not null, set tmp to child, i.e., just move to the child.
			if(tmp.getChild(c) != null) {
				tmp = tmp.insertChild(c);
			}else {
				// Else, as long as i < str.length(), do the following:
				while(i < str.length()) {
					// Use the insertChild method on tmp with the character at position i of str as argument (to insert a new child of tmp).
					tmp.insertChild(str.charAt(i));
					// The insertChild method returns the child; set tmp to the child.
					tmp = tmp.insertChild(c);
					// Increment i by 1.
					i++;
				}
			}
		}
	}

	boolean match(String str) {
		// Set a TrieNode temporary variable tmp to the root. (In C++, tmp has to be a pointer.)
		TrieNode tmp = root;
		// for (i = 0 to i < str.length()), do the following:
		for(int i = 0; i < str.length(); i++) {
			// Let c be the character at position i of str.
			char c = str.charAt(i);
			// Use the getChild method on tmp with c as argument to get the child of tmp, such that the corresponding edge is labeled by c.
			// If the child is null, then a mismatch has occurred; hence, return false.
			if(tmp.getChild(c) == null) {
				return false;
			// Else, set tmp to the child.
			}else {
				tmp = tmp.insertChild(c);
			}
		}
		// Once the for-loop is done, the entire string has matched. Hence, return true.
		return true;
	}
}