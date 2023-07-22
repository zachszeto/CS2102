import javax.xml.crypto.Data;

class DataBT implements IBinTree {
    int data;
    IBinTree left;
    IBinTree right;

    DataBT(int data, IBinTree left, IBinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // an alternate constructor for when both subtrees are empty
    DataBT(int data) {
        this.data = data;
        this.left = new MtBT();
        this.right = new MtBT();
    }

    // determines whether this node or node in subtree has given element
    public boolean hasElt(int e) {
        return this.data == e || this.left.hasElt(e) || this.right.hasElt(e);
    }

    // adds 1 to the number of nodes in the left and right subtrees
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    // adds 1 to the height of the taller subtree
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }

    /**
     *
     * @param aData
     * @return
     */
    //Checks if current node is the smallest node in the tree
    public boolean isSmallest(int aData) {
        if (aData <= this.data && this.left.isSmallest(aData) && this.right.isSmallest(aData)) {
            return true;
        }
        return false;
    }

    /**
     * @return
     */
    //Checks if a binary tree is a heap
    public boolean isHeap() {
        return this.isSmallest(this.data) && this.left.isHeap() && this.right.isHeap();
    }

    /**
     *
     * @param someHeap a heap
     * @param someNum a number that has been added to someHeap
     * @return whether someHeap has all the same elements as this heap
     */
    //Checks if the binary tree has all the same elements as the heap when adding
    public boolean sameElementsADD(IHeap someHeap, int someNum) {
        return (someHeap.hasElt(this.data) || this.hasElt(someNum))
                && this.left.sameElementsADD(someHeap, someNum)
                && this.right.sameElementsADD(someHeap, someNum);
    }

    /**
     *
     * @param someHeap a heap
     * @return whether someHeap has all the same elements (minus someNum) as this heap
     */
    //Checks if the binary tree has all the same elements as the heap when subtracting
    public boolean sameElementsREMOVE(IHeap someHeap) {
        if(someHeap.size() != 0) {
            int minVal = this.data;
            return (someHeap.hasElt(this.data) && !this.hasElt(minVal))
                    && this.left.sameElementsREMOVE(someHeap)
                    && this.right.sameElementsREMOVE(someHeap);
        } else{
            return true;
        }
    }
}
