public class HashData{
    private int key;
    private String val;
    public HashData(){
        this.key = -1;
    }
    public HashData(int key, String val){
        this.key = key;
        this.val = val;
    }
    public int getKey(){
        return key;
    }
    public String getValue(){
        return val;
    }
    public void setValue(String val){
        this.val = val;
    }
}