/*
 * Name:
 * Student ID #:
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

    public SuffixTries(String s){
        this.s = s;
        this.root = new TrieNode();
        /*
         * implement your constructor here. the default constructor is not required.
         * construct the suffix trie from a given string.
         */
    }

    @Override
    public boolean match(String pattern){
        /*
		 * Input: a string pattern
		 *
		 * Output: whether or not the given pattern is a suffix of the string
		 */
        return false;
    }
    
    @Override
    public ArrayList<String> allSuffixes(){
        /*
		 * Input: none
		 *
		 * Output: the ArrayList containing all suffixes of the string with lexicographical order
		 * 
         * Does:
         *  - traverse suffix tries while maintaining substring
         *  - if the current node is end of a suffix, add the current string to the ArrayList
         */
        return null;
    }
}
