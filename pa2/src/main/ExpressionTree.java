/*
 * Name: 조은기
 * Student ID #: 2019147029
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

    public ExpressionTree(String[] expression) {
        this.rootNode = null;
        this.treeSize = 0;

        if (expression.length == 0) {
            return;
        }

        Stack<String> operatorStack = new Stack<>();
        Stack<Node<String>> nodeStack = new Stack<>();

        // 중위 표기식을 후위 표기식으로 변환하며 동시에 트리 생성
        for (String it : expression) {
            final String operators = "+-*/()";
            if (!operators.contains(it)) {  // 피연산자인 경우
                nodeStack.push(new Node<>(it));
                this.treeSize++;
            } else if (it.equals("(")) {
                operatorStack.push(it);
            } else if (it.equals(")")) {
                // ')'가 나올 경우 '('를 만날 때까지 연산자를 처리하여 트리 생성
                if (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    Node<String> rightNode = nodeStack.pop();
                    Node<String> leftNode = nodeStack.pop();
                    Node<String> operatorNode = new Node<>(operatorStack.pop());
                    operatorNode.setLeft(leftNode);
                    operatorNode.setRight(rightNode);
                    nodeStack.push(operatorNode);
                    this.treeSize++;
                }
                operatorStack.pop();
            } else {
                if (!operatorStack.isEmpty() &&
                        ((operatorStack.peek().equals("*") || operatorStack.peek().equals("/")) || // higher level operands
                                (operatorStack.peek().equals("+") || operatorStack.peek().equals("-")) && // same level operands
                                        (it.equals("+") || it.equals("-")))) {
                    Node<String> rightNode = nodeStack.pop();
                    Node<String> leftNode = nodeStack.pop();
                    Node<String> operatorNode = new Node<>(operatorStack.pop());
                    operatorNode.setLeft(leftNode);
                    operatorNode.setRight(rightNode);
                    nodeStack.push(operatorNode);
                    this.treeSize++;
                }
                operatorStack.push(it);
            }
        }

        // 스택에 남아 있는 연산자를 처리
        if (!operatorStack.isEmpty()) {
            Node<String> rightNode = nodeStack.pop();
            Node<String> leftNode = nodeStack.pop();
            Node<String> operatorNode = new Node<>(operatorStack.pop());
            operatorNode.setLeft(leftNode);
            operatorNode.setRight(rightNode);
            nodeStack.push(operatorNode);
            this.treeSize++;
        }

        if (!nodeStack.isEmpty()) {
            this.rootNode = nodeStack.pop();
        }
    }

    @Override
    public int size() {
        return this.treeSize;
    }

    @Override
    public Node<String> getRoot() {
        if (treeSize == 0) {
            return null;
        }
        return rootNode;
    }

    @Override
    public String infixNotation() {
        return infixTraversal(rootNode);
    }

    private String infixTraversal(Node<String> node) {
        if (node == null) {
            return "";
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return node.getValue();  // 피연산자일 경우 괄호 없이 반환}
        }
        return "( " + infixTraversal(node.getLeft()) + " " + node.getValue() + " " + infixTraversal(node.getRight()) + " )";
    }

    @Override
    public String prefixNotation() {
        return prefixTraversal(rootNode);
    }

    private String prefixTraversal(Node<String> node) {
        if (node == null) return "";
        return node.getValue() + " " + prefixTraversal(node.getLeft()) + prefixTraversal(node.getRight());
    }

    @Override
    public String postfixNotation() {
        return postfixTraversal(rootNode);
    }

    private String postfixTraversal(Node<String> node) {
        if (node == null) return "";
        return postfixTraversal(node.getLeft()) + postfixTraversal(node.getRight()) + node.getValue() + " ";
    }
}
