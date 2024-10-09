/*
 * Name: 조은기
 * Student ID #: 2019147029
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class TableCatch implements ITableCatch {
    private IDoublyLinkedList<Customer> waitingList;
    private int nextTurnNumber;
    // you may declare additional variables here.

    public TableCatch() {
        this.waitingList = new DoublyLinkedList<>();
        this.nextTurnNumber = 1;
    }

    @Override
    public int numWaiting() {
        return this.waitingList.size();
    }

    @Override
    public void startWaiting(int numPeople) {
        final Customer newCustomer = new Customer(this.nextTurnNumber, numPeople);
        this.waitingList.addLast(newCustomer);
        this.nextTurnNumber++;
    }

    @Override
    public void stopWaiting(int turnNumber) {
        this.waitingList.searchDelete(new Customer(turnNumber, 0));
    }

    @Override
    public int seatOpened(int personnel) {
        Node<Customer> currNode = this.waitingList.getHead();

        if (this.waitingList.getHead() == null) {
            return -1;
        }

        while (currNode != null) {
            if (currNode.data.getNumPeople() <= personnel) {
                this.waitingList.searchDelete(currNode.data);
                return currNode.data.getTurnNumber();
            }
            currNode = currNode.next;
        }

        return -1;
    }

    @Override
    public int howManyGroupsAhead(int turnNumber) {
        Node<Customer> currNode = this.waitingList.search(new Customer(turnNumber, 0));

        if (currNode == null) {
            return this.waitingList.size();
        }

        final Node<Customer> head = this.waitingList.getHead();

        int count = 0;
        while (currNode != head) {
            currNode = currNode.prev;
            count++;
        }

        return count;
    }
}
