public interface IAVLBinaryTree {
    public int size();
    public boolean isEmpty();
    public int getHeight();
    public boolean contains(int val);
    public void put(int val);
    public void remove(int val);
}