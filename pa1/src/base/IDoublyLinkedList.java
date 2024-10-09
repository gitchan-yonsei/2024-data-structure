public interface IDoublyLinkedList<T> {
	public int size();
	public boolean isEmpty();
	public Node<T> getHead();
	public Node<T> getTail();
	public void addFirst(T newElement);
	public void addLast(T newElement);
	public T popFirst();
	public T popLast();
	public Node<T> search(T target);
	public void insertAfter(T newElement, T target);
	public void searchDelete(T target);
}
