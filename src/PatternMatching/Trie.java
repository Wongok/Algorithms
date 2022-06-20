package PatternMatching;

public class Trie {
    public static void main(String[] args) {
        String[] strArr = {"HE", "HELLO", "WORLD", "SHE"};
        TrieNode trie = new TrieNode();

        for (String str : strArr) {
            trie.insert(trie.root, str, 0);
        }

        System.out.println(trie.contains(trie.root, "HELLO", 0));
    }

    private static class TrieNode {
        private Node root = new Node();

        public void insert(Node head, String str, int idx) {
            int charIdx = str.charAt(idx) - 65;
            if (head.child[charIdx] == null) {
                head.child[charIdx] = new Node();
            }
            if (idx == str.length() - 1) {
                head.child[charIdx].finish = true;
            } else {
                insert(head.child[charIdx], str, idx + 1);
            }
        }

        public boolean contains(Node head, String str, int idx) {
            int charIdx = str.charAt(idx) - 65;
            if (head.child[charIdx] == null) {
                return false;
            }

            if (idx == str.length() - 1) {
                return head.child[charIdx].finish;
            }
            return contains(head.child[charIdx], str, idx + 1);
        }

        private static class Node {
            Node[] child = new Node[26];
            boolean finish = false;
        }
    }
}
