package ac.cam.jj625.sets;

public class BinaryTreeNode {
    private int mValue;
    private BinaryTreeNode mLeft;
    private BinaryTreeNode mRight;

    public BinaryTreeNode(int v) {
        mValue = v;
        mLeft = null;
        mRight = null;
    }

    public int getValue() {
        return mValue;
    }
    public void setValue(int n){
        mValue = n;
    }

    public BinaryTreeNode getLeft() {
        return mLeft;
    }
    public BinaryTreeNode getRight() {
        return mRight;
    }

    public void setLeft(BinaryTreeNode n) {
        mLeft = n;
    }
    public void setRight(BinaryTreeNode n) {
        mRight = n;
    }
}
