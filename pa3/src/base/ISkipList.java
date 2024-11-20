import java.util.List;

public interface ISkipList<K> {
    public int size();
    public boolean isEmpty();
    public void add(K key);
    public void delete(K key);
    public boolean contain(K key);
    public List<K> getEntries();
}