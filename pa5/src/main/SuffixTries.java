/*
 * Name: 조은기
 * Student ID #: 2019147029
 */

import java.util.ArrayList;

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class SuffixTries implements ISuffixTries {
    private TrieNode root;
    private String s;
    // you may declare additional variables here.

    public SuffixTries(String s) {
        this.s = s;
        this.root = new TrieNode();
        /*
         * implement your constructor here. the default constructor is not required.
         * construct the suffix trie from a given string.
         */
        if (s == null || s.isEmpty()) {
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            addSuffix(i);
        }
    }

    private void addSuffix(final int start) {
        TrieNode current = root;

        for (int i = start; i < s.length(); i++) {
            final int index = s.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.isEnd = true;
    }

    @Override
    public boolean match(String pattern) {
        /*
         * Input: a string pattern
         *
         * Output: whether or not the given pattern is a suffix of the string
         */
        if (pattern.length() > s.length()) {
            return false;
        }

        TrieNode current = root;

        for (int i = 0; i < pattern.length(); i++) {
            final int index = pattern.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }

        return current.isEnd;
    }

    @Override
    public ArrayList<String> allSuffixes() {
        /*
         * Input: none
         *
         * Output: the ArrayList containing all suffixes of the string with lexicographical order
         *
         * Does:
         *  - traverse suffix tries while maintaining substring
         *  - if the current node is end of a suffix, add the current string to the ArrayList
         */
        ArrayList<String> result = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();

        collectSuffixes(root, currentString, result);
        return result;
    }

    private void collectSuffixes(TrieNode node, StringBuilder currentString, ArrayList<String> result) {
        if (node == null) return;

        if (node.isEnd) {
            result.add(currentString.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                currentString.append((char) ('a' + i));
                collectSuffixes(node.children[i], currentString, result);
                currentString.deleteCharAt(currentString.length() - 1);
            }
        }
    }
}
