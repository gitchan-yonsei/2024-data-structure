public interface IBinaryTree<T> {
    public int size();
    public boolean isEmpty();
    public Node<T> getRoot();
    public void insert(T element, String position);
    public T pop(String position);
}