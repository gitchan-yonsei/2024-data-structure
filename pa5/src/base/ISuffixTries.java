import java.util.ArrayList;
public interface ISuffixTries {
    public boolean match(String s);
    public ArrayList<String> allSuffixes();
}