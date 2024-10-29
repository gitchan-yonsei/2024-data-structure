/*
 * Name:
 * Student ID #:
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

import java.util.Stack;

public class ExpressionTree implements IExpressionTree {
    private Node<String> rootNode;
    private int treeSize;
    // you may declare additional variables here.

    public ExpressionTree(String[] expression){
        this.rootNode = null;
        this.treeSize = 0;
        // implement your constructor here. the default constructor is not required.
    }

    @Override 
    public int size() {
        /*
		 * Input: none
		 *
		 * Output: the number of elements in the tree
		 */
        return -1;
    }

    @Override 
    public Node<String> getRoot() {
        /*
		 * Input: none
		 *
		 * Output: the root node of the tree
		 * 
		 * Does:
		 *  - return the root node of the tree.
		 *  - if the tree is empty, return null.
		 */
        return null;
    }

    @Override 
    public String infixNotation() {
        /*
		 * Input: none
		 *
		 * Output: infix notation of the tree
		 * 
		 * Does:
		 *  - return the fully parenthesized infix notation represented by the expression tree.
         *  - there should be a space between all the values.
		 */
        return "";
    }

    @Override
    public String prefixNotation() {
        /*
		 * Input: none
		 *
		 * Output: prefix notation of the tree
		 * 
		 * Does:
		 *  - return the prefix notation represented by the expression tree.
         *  - there should be a space between all the values.
		 */
        return "";
    }

    @Override
    public String postfixNotation() {
        /*
		 * Input: none
		 *
		 * Output: postfix notation of the tree
		 * 
		 * Does:
		 *  - return the postfix notation represented by the expression tree.
         *  - there should be a space between all the values.
		 */
        return "";
    }
}
