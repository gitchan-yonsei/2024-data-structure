class Node<T> {
    Node<T> next;
    Node<T> prev;
    T data;
    Node(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}