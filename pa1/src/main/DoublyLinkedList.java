/*
 * Name: 조은기
 * Student ID #: 2019147029
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class DoublyLinkedList<T> implements IDoublyLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	// you may declare additional variables here.

	public DoublyLinkedList() {
		// implement your constructor here.
	}

	@Override
	public int size() {
		/*
		 * Input: none
		 *
		 * Output: the number of elements in the linked list
		 */
		return -1;
	}

	@Override
	public boolean isEmpty() {
		/*
		 * Input: none
		 *
		 * Output: whether or not the linked list is empty
		 */
		return true;
	}

	@Override
	public Node<T> getHead() {
		/*
		 * Input: none
		 *
		 * Output: the first node of the linked list
		 * 
		 * Does:
		 *  - return the first node of the linked list.
		 *  - if the linked list is empty, return null.
		 */
		return null;
	}

	@Override
	public Node<T> getTail() {
		/*
		 * Input: none
		 *
		 * Output: the last node of the linked list
		 * 
		 * Does:
		 *  - return the last node of the linked list.
		 *  - if the linked list is empty, return null.
		 */
		return null;
	}

	@Override
	public void addFirst(T newElement) {
		/*
		 * Input: element to be inserted to the list
		 *
		 * Output: none
		 * 
		 * Does:
		 *  - insert the given element at the front of the linked list.
		 */
		return;
	}

	@Override
	public void addLast(T newElement) {
		/*
		 * Input: element to be inserted to the list
		 *
		 * Output: none
		 * 
		 * Does:
		 *  - insert the given element at the back of the linked list.
		 */
		return;
	}

	@Override
	public T popFirst() {
		/*
		 * Input: none
		 *
		 * Output: the first element of the linked list
		 * 
		 * Does:
		 *  - remove and return the first element in the linked list.
		 *  - if the linked list is empty return null.
		 */
		return null;
	}

	@Override
	public T popLast() {
		/*
		 * Input: none
		 *
		 * Output: the last element of the linked list
		 * 
		 * Does:
		 *  - remove and return the last element in the linked list.
		 *  - if the linked list is empty return null.
		 */
		return null;
	}

	@Override
	public Node<T> search(T target) {
		/*
		 * Input: target element
		 *
		 * Output: the node containing the target element
		 * 
		 * Does:
		 *  - find and return the first node containing an element which is equal to the target element.
		 *  - check the equivalence by using the method T.equals().
		 *  - if there is no target element, return null.
		 */
		return null;
	}

	@Override
	public void insertAfter(T newElement, T target) {
		/*
		 * Input: element to be inserted to the list, target element
		 *
		 * Output: none
		 * 
		 * Does:
		 *  - find the first node containing an element which is equal to the target element.
		 *  - insert the new element next to the target element.
		 *  - if there is no target element, do not insert the new element.
		 */
		return;
	}

	@Override
	public void searchDelete(T target) {
		/*
		 * Input: target element
		 *
		 * Output: none
		 * 
		 * Does:
		 *  - find and remove the first node containing an element which is equal to the target element.
		 *  - if there is no target element, do nothing.
		 */
		return;
	}
}
