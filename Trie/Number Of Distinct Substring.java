class TrieNode {
	TrieNode childern[];

	TrieNode() {
		childern = new TrieNode[26];

	}
}

public class Solution {

	static TrieNode trie;
	static int countNodes;

	// Add string str into the Trie.
	public static void insert(String str) {
		TrieNode curr = trie;

		for (int i = 0; i < str.length(); i++) {
			char ind = (char) (str.charAt(i) - 'a');

			if (curr.childern[ind] == null) {
				curr.childern[ind] = new TrieNode();
			}
			curr = curr.childern[ind];
		}

	}

	// Count Nodes of the Trie.
	public static void countNodeInTrie(TrieNode curr) {

		if (curr == null) {
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (curr.childern[i] != null) {
				countNodes++;
				countNodeInTrie(curr.childern[i]);
			}
		}

	}

	public static int distinctSubstring(String word) {

		trie = new TrieNode();
		countNodes = 0;

		// Iterate over the word and add it's all the characters into the Trie.
		for (int i = 0; i < word.length(); i++) {
			insert(word.substring(i));
		}

		TrieNode curr = trie;
		countNodeInTrie(curr);
		return countNodes;

	}

}
