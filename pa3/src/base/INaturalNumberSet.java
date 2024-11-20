public interface INaturalNumberSet {
    public int size();
    public boolean isEmpty();
    public boolean contains(int val);
    public boolean add(int val);
    public int remove(int val);
    public int[] iterator();
    public void addAll(INaturalNumberSet T);
    public void retainAll(INaturalNumberSet T);
    public void removeAll(INaturalNumberSet T);
}