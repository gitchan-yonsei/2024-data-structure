public final class BinaryNode {
    private int value, h;
    private BinaryNode left, right, parent;
    public BinaryNode(int val) {
        this.value = val;
        this.h = 1;
        this.parent = this.left = this.right = null;
    }
    public void setValue(int val){
        this.value = val;
    }
    public int getValue(){
        return this.value;
    }
    public void setHeight(int h){
        this.h = h;
    }
    public int getHeight(){
        return this.h;
    }
    public void setLeft(BinaryNode left){
        this.left=left;
    }
    public BinaryNode getLeft(){
        return this.left;
    }
    public void setRight(BinaryNode right){
        this.right=right;
    }
    public BinaryNode getRight(){
        return this.right;
    }
    public void setParent(BinaryNode parent){
        this.parent=parent;
    }
    public BinaryNode getParent(){
        return this.parent;
    }
}