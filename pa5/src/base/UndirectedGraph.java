import java.util.ArrayList;
public class UndirectedGraph {
    private int n, m;
    private ArrayList<Vertex> V;
    private ArrayList<Edge> E;
    private ArrayList<ArrayList<Edge>> incidentE;
    public UndirectedGraph(int n, int[][] edges){
        /*
         * Input: an integer n and an integer array with size 2 x m 
         * 
         * constructor for undirected graph.
         * construct an undirected graph using both the number of vertices and array indicating indexes of two incident vertices.
         * V contains vertices whose indexes are from 0 to n-1.
         * E contains edges whose indexes are from 0 to m-1.
         * incidentE contains n arraylist. i-th arraylist contains edges incident to i-th vertex.
         */
        this.n = n;
        this.m = edges[0].length;
        this.V = new ArrayList<Vertex>();
        this.E = new ArrayList<Edge>();
        this.incidentE = new ArrayList<ArrayList<Edge>>();
        for (int i=0; i<n; i++){
            this.V.add(new Vertex(i));
            this.incidentE.add(new ArrayList<Edge>());
        }
        for (int i=0; i<m; i++){
            Edge e = new Edge(V.get(edges[0][i]), V.get(edges[1][i]), i);
            E.add(e);
            incidentE.get(edges[0][i]).add(e);
            incidentE.get(edges[1][i]).add(e);
        }
    }
    public int numVertices(){
        return this.n;
    }
    public ArrayList<Vertex> vertices(){
        return this.V;
    }
    public int numEdges(){
        return this.m;
    }
    public ArrayList<Edge> edges(){
        return this.E;
    }
    public Vertex opposite(Vertex v, Edge e){
        if (e.getS() == v){
            return e.getE();
        } else if (e.getE() == v){
            return e.getS();
        } else {
            return null;
        }
    }
    public ArrayList<Edge> incidentEdges(Vertex v){
        return incidentE.get(v.getIdx());
    }
}