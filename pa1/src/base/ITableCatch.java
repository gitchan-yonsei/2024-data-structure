public interface ITableCatch {
	public int numWaiting();
    public void startWaiting(int numPeople);
    public void stopWaiting(int turnNumber);
    public int seatOpened(int personnel);
    public int howManyGroupsAhead(int turnNumber);
}
