package ac.cam.jj625.sets;

import java.util.function.Function;

public class FunctionalArray {
    private BinaryTreeNode mHead;
    private final int size;

    private void construct(BinaryTreeNode head, int nodesLeft) {
        if( nodesLeft == 0) {
            return;
        } else {
            int rightNodes = nodesLeft/2;
            int leftNodes = nodesLeft-rightNodes;

            head.setLeft(new BinaryTreeNode(0));
            construct(head.getLeft(), leftNodes-1);

            if (rightNodes > 0) {
                head.setRight(new BinaryTreeNode(0));
                construct(head.getRight(), rightNodes-1);
            }
        }
    }

    public FunctionalArray(int size) {
        this.size = size;
        if ( size > 0 ) {
            mHead = new BinaryTreeNode(0);
            construct(mHead, size - 1);
        }
    }

    private BinaryTreeNode getNode(int index) {
        BinaryTreeNode node = mHead;

        while( index != 1 ) {
            if( index % 2 == 1 ) {
                index = index / 2;
                node = node.getRight();
            } else {
                index = index/2;
                node = node.getLeft();
            }
        }

        return node;
    }

    public void set(int index, int value) {
        if( size <= index ) {
            throw new ArrayIndexOutOfBoundsException();
        }

        getNode(index+1).setValue(value);
    }

    public int get(int index) {
        if( size <= index ) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return getNode(index+1).getValue();
    }
}
