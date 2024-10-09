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
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Node<T> getHead() {
        if (this.isEmpty()) {
            return null;
        }
        return this.head;
    }

    @Override
    public Node<T> getTail() {
        if (this.isEmpty()) {
            return null;
        }
        return this.tail;
    }

    @Override
    public void addFirst(T newElement) {
        final Node<T> currHead = this.head;
        final Node<T> newHead = new Node<>(newElement);
        newHead.prev = null;
        newHead.next = currHead;
        currHead.prev = newHead;
        this.head = newHead;
        this.size++;
    }

    @Override
    public void addLast(T newElement) {
        final Node<T> currTail = this.tail;
        final Node<T> newTail = new Node<>(newElement);
        currTail.next = newTail;
        newTail.prev = currTail;
        newTail.next = null;
        this.tail = newTail;
        this.size++;
    }

    @Override
    public T popFirst() {
        if (this.isEmpty()) {
            return null;
        }

        final Node<T> currHead = this.head;
        final Node<T> newHead = currHead.next;
        newHead.prev = null;
        this.head = newHead;
        this.size--;

        return currHead.data;
    }

    @Override
    public T popLast() {
        if (this.isEmpty()) {
            return null;
        }

        final Node<T> currTail = this.tail;
        final Node<T> newTail = currTail.prev;
        newTail.next = null;
        this.tail = newTail;
        this.size--;

        return currTail.data;
    }

    @Override
    public Node<T> search(T target) {
        Node<T> currNode = this.head;
        while (true) {
            if (currNode.data.equals(target)) {
                return currNode;
            }
            currNode = currNode.next;
            if (currNode == this.tail) {
                return null;
            }
        }
    }

    @Override
    public void insertAfter(T newElement, T target) {
        final Node<T> targetNode = search(target);
        if (targetNode == null) {
            return;
        }

        if (targetNode == this.tail) {
            addLast(newElement);
            return;
        }

        final Node<T> newNode = new Node<>(newElement);

        final Node<T> newNext = targetNode.next;
        targetNode.next = newNode;
        newNode.prev = targetNode;
        newNode.next = newNext;
        newNext.prev = newNode;

        this.size++;
    }

    @Override
    public void searchDelete(T target) {
        final Node<T> targetNode = search(target);
        if (targetNode == null) {
            return;
        }

        final Node<T> targetPrev = targetNode.prev;
        final Node<T> targetNext = targetNode.next;

        targetPrev.next = targetNext;
        targetNext.prev = targetPrev;

        this.size--;
    }
}
