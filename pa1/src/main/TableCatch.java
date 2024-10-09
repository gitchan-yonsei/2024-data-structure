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
        // implement your constructor here.
    }

    @Override
    public int numWaiting() {
        /*
		 * Input: none
		 *
		 * Output: the number of groups in the waiting list.
		 */
        return -1;
    }

    @Override
    public void startWaiting(int numPeople) {
        /*
		 * Input: the number of people in the group
		 *
		 * Output: none
         * 
         * Does:
         *  - add a new group to the waiting list.
		 */
        return;
    }

    @Override
    public void stopWaiting(int turnNumber) {
        /*
		 * Input: the turn number
		 *
		 * Output: none
         * 
         * Does:
         *  - remove the group with the given turn number from the waiting list.
         *  - If there is no such group, do nothing.
		 */
        return;
    }
    
    @Override
    public int seatOpened(int personnel) {
        /*
		 * Input: the maximum number of people that can sit at the table
		 *
		 * Output: the number of people in the group
         * 
         * Does:
         *  - Find and remove the group with the smallest turn number among those where the number of people is less than the given personnel.
         *  - Return the turn number of the group.
         *  - If there is no such group, return -1.
		 */
        return -1;
    }

    @Override
    public int howManyGroupsAhead(int turnNumber) {
        /*
		 * Input: the turn number
		 *
		 * Output: the number of groups ahead of the given turn number
         * 
         * Does:
         *  - return the number of groups ahead of the given turn number.
         *  - if the given turn number is not in the waiting list, return the total number of groups in the waiting list.
		 */
        return -1;
    }
}
