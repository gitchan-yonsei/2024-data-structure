public class Node<T> {
    private T value;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private Node<T> parent;

    public Node(T value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }
    public Node<T> getParent(){
        return this.parent;
    }
    public void setParent(Node<T> p){
        this.parent = p;
    }
    public Node<T> getLeft(){
        return this.leftChild;
    }
    public void setLeft(Node<T> l){
        this.leftChild = l;
    }
    public Node<T> getRight(){
        return this.rightChild;
    }
    public void setRight(Node<T> r){
        this.rightChild = r;
    }
    public T getValue(){
        return this.value;
    }
    public void setValue(T value){
        this.value = value;
    }
    public boolean isInternal(){
        return (this.leftChild != null) || (this.rightChild != null);
    }
    public boolean isExternal(){
        return (this.leftChild == null) && (this.rightChild == null);
    }
}