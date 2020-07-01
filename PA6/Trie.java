public class Trie {

	TrieNode root;

	Trie() {
		root = new TrieNode();
	}

	void insert(String str) {
		TrieNode tmp = root;

		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(tmp.getChild(c) != null) {
				tmp = tmp.insertChild(c);
			}else {
				while(i < str.length()) {
					tmp.insertChild(str.charAt(i));
					tmp = tmp.insertChild(c);
					i++;
				}
			}
		}
	}

	boolean match(String str) {
		TrieNode tmp = root;

		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(tmp.getChild(c) == null) {
				return false;
			}else {
				tmp = tmp.insertChild(c);
			}
		}
		return true;
	}
}