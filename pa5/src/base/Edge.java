public class Edge{
    private Vertex s, e;
    private Label label;
    private int idx;
    public Edge(Vertex s, Vertex e, int idx){
        this.idx = idx;
        this.s = s;
        this.e = e;
        this.label = Label.UNEXPLORED;
    }
    public int getIdx(){
        return this.idx;
    }
    public Vertex getS(){
        return this.s;
    }
    public Vertex getE(){
        return this.e;
    }
    public void setLabel(Label label){
        this.label = label;
    }
    public Label getLabel(){
        return this.label;
    }
}