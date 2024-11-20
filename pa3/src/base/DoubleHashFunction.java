public class DoubleHashFunction{
    private int N;
    private int q;
    public DoubleHashFunction(int N, int q){
        this.N = N;
        this.q = q;
    }
    public int firstHash(int val){
        return val%N;
    }
    public int secondHash(int val){
        return q-(val%q);
    }
}