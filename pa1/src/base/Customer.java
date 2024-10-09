class Customer {
    private int turnNumber;
    private int numPeople;
    Customer(int turnNumber, int numPeople){
        this.turnNumber = turnNumber;
        this.numPeople = numPeople;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Customer)){
            return false;
        }
        Customer other = (Customer) obj;
        return this.turnNumber == other.turnNumber;
    }
    public int getNumPeople(){
        return this.numPeople;
    }
    public int getTurnNumber(){
        return this.turnNumber;
    }
}