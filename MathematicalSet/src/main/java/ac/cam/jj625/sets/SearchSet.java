package ac.cam.jj625.sets;

public class SearchSet {
    private int mElements;

    private BinaryTreeNode mHead;

    public SearchSet() {
        mHead = null;
        mElements = 0;
    }

    public void insert(int v) {
        BinaryTreeNode current = mHead;
        if(current == null) {
            mHead = new BinaryTreeNode(v);
            mElements++;
            return;
        }
        while(true) {
            BinaryTreeNode next = null;
            if ( current.getValue() == v ) {
                return;
            } else if (current.getValue() < v ){
                next = current.getRight();
                if(next == null) {
                    current.setRight(new BinaryTreeNode(v));
                    mElements++;
                    return;
                }
            } else {
                next = current.getLeft();
                if(next == null) {
                    current.setLeft(new BinaryTreeNode(v));
                    mElements++;
                    return;
                }
            }
            current = next;
        }
        // Maybe writing this recursively would've been better? Not sure. Recursion feels bad in java.
        // Also, I hate the while(true)
        // Also I feel like there's repeated code in the left and right branches.
    }

    public int getNumberElements() {
        return mElements;
    }

    public boolean contains(int v) {
        BinaryTreeNode current = mHead;
        while(current != null) {
            if(current.getValue()==v) {
                return true;
            } else if(current.getValue() < v) {
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }
        return false;
    }
}
