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
        final Node<T> newHead = new Node<>(newElement);

        if (size == 0) {
            this.head = newHead;
            this.tail = newHead;
            this.size++;
            return;
        }

        final Node<T> currHead = this.head;

        newHead.prev = null;
        newHead.next = currHead;
        currHead.prev = newHead;
        this.head = newHead;
        this.size++;
    }

    @Override
    public void addLast(T newElement) {
        final Node<T> newTail = new Node<>(newElement);

        if (size() == 0) {
            this.head = newTail;
            this.tail = newTail;
            this.size++;
            return;
        }

        final Node<T> currTail = this.tail;

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

        if (this.size == 1) {
            final Node<T> currHead = this.head;
            this.head = null;
            this.tail = null;
            this.size--;
            return currHead.data;
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

        if (this.size == 1) {
            final Node<T> currTail = this.tail;
            this.head = null;
            this.tail = null;
            this.size--;

            return currTail.data;
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
        while (currNode != null) {
            if (currNode.data.equals(target)) {
                return currNode;
            }
            currNode = currNode.next;
        }
        return null;
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

        if (targetNode == this.head) {
            popFirst();
            return;
        }

        if (targetNode == this.tail) {
            popLast();
            return;
        }

        final Node<T> targetPrev = targetNode.prev;
        final Node<T> targetNext = targetNode.next;

        targetPrev.next = targetNext;
        targetNext.prev = targetPrev;

        this.size--;
    }
}
