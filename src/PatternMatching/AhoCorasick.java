package PatternMatching;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// Aho-Corasick Algorithm
public class AhoCorasick {

    static final int SIZE = 26; // uppercase alphabet A-Z
    static class TrieNode {
        boolean output;
        Map<Character, TrieNode> child = new HashMap<>();
        TrieNode fail;

        public TrieNode() {}

        public void insert(String word) {
            TrieNode curNode = this;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                curNode.child.putIfAbsent(c, new TrieNode());
                curNode = curNode.child.get(c);

                if (i == word.length() - 1) {
                    curNode.output = true;
                }
            }
        }

        public void computeFailFunc() {
            Queue<TrieNode> queue = new LinkedList<>();
            this.fail = this;
            queue.add(this);

            while (!queue.isEmpty()) {
                TrieNode current = queue.poll();

                for (int i = 0; i < SIZE; i++) {
                    char c = (char) (i + 97);

                    // current -> next
                    TrieNode next = current.child.get(c);
                    if (next == null) continue;;

                    if (current == this) {
                        next.fail = this;
                    } else {
                        TrieNode failLinkNode = current.fail;

                        while (failLinkNode != this && failLinkNode.child.get(c) == null) {
                            failLinkNode = failLinkNode.fail;
                        }

                        if (failLinkNode.child.get(c) != null) {
                            failLinkNode = failLinkNode.child.get(c);
                        }
                        next.fail = failLinkNode;
                    }

                    if (next.fail.output) {
                        next.output = true;
                    }
                    queue.add(next);
                }
            }
        }

        public boolean ahoCorasick(String word) {
            TrieNode curNode = this;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                while (curNode != this && curNode.child.get(c) == null) {
                    curNode = curNode.fail;
                }

                if (curNode.child.get(c) != null) {
                    curNode = curNode.child.get(c);
                }

                if (curNode.output) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        String[] arr = { "he", "she", "hers", "his" };
        String[] words = { "ahishers", "abcd", "hahiss", "dhe" };

        TrieNode trieSet = new TrieNode();
        for (int i = 0; i < arr.length; i++) {
            trieSet.insert(arr[i]);
        }

        trieSet.computeFailFunc();

        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " >>> ");
            if (trieSet.ahoCorasick(words[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
