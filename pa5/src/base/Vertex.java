public class Vertex{
    private Label label;
    private int idx;
    public Vertex(int idx){
        this.label = Label.UNEXPLORED;
        this.idx = idx;
    }
    public int getIdx(){
        return this.idx;
    }
    public void setLabel(Label label){
        this.label = label;
    }
    public Label getLabel(){
        return this.label;
    }
}