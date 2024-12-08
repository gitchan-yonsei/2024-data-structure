public class TrieNode{
    public int start;
    public int end;
    public boolean isEnd;
    public TrieNode[] children;
    public TrieNode(){
        this.children = new TrieNode[26];
        this.isEnd = false;
    }
}