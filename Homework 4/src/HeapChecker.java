import java.beans.Expression;

public class HeapChecker {
    /**
     * @param aHeap       a heap
     * @param aNum        a number to be added to the heap
     * @param aBinaryTree an expected heap with the same elements as aHeap along with aNum
     * @return whether aBinaryTree is a result of adding aNum to aHeap
     */
    public boolean addEltValidator(IHeap aHeap, int aNum, IBinTree aBinaryTree) {
        return aBinaryTree.isHeap() && (aHeap.size() + 1 == aBinaryTree.size()) && aBinaryTree.sameElementsADD(aHeap, aNum);
    }

    /**
     * @param aHeap       a heap
     * @param aBinaryTree an expected heap with the same elements as aHeap without aNum
     * @return whether aBinaryTree is a result of removing aNum from aHeap
     */
    public boolean remMinEltValidator(IHeap aHeap, IBinTree aBinaryTree) {
        if (aHeap.size() != 0) {
            return aBinaryTree.isHeap() && (aHeap.size() - 1 == aBinaryTree.size()) && aBinaryTree.sameElementsREMOVE(aHeap);
        } else if (aBinaryTree.size() == 0) {
            return true;
        }
        return false;
    }
}

