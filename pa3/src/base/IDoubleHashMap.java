public interface IDoubleHashMap {
    public int size();
    public boolean isEmpty();
    public String get(int key);
    public String put(int key, String val);
    public String remove(int key);
}