public interface IExpressionTree {
    public int size();
    public Node<String> getRoot();
    public String infixNotation();
    public String prefixNotation();
    public String postfixNotation();
} 