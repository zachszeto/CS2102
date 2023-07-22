import org.junit.Test;
import static org.junit.Assert.*;

public class Examples {
    IHeap Heap1 = new DataHeap(2, new DataHeap(4), new DataHeap(5));

    /*IHeap Heap2 = new DataHeap(10, new DataHeap(19), new DataHeap(21));

    IBinTree BinaryTree1 = new DataBT(2, new DataBT(4), new DataBT(5, new DataBT(7), new MtBT()));

    IBinTree BinaryTree2 = new DataBT(5, new DataBT(2), new DataBT(4));*/

    //Checks for 7 being added to Heap1
    @Test
    public void addEltValidator1() {
        HeapChecker HT = new HeapChecker();
        assertTrue(HT.addEltValidator(Heap1, 7 , Heap1.addElt(7)));
    }

    //Checks for 10 being added to Heap1 but 7 is added instead
    @Test
    public void addEltValidator2() {
        HeapChecker HT = new HeapChecker();
        assertFalse(HT.addEltValidator(Heap1, 10, Heap1.addElt(7)));
    }

    //Checks for 7 being added to Heap1 but instead an empty heap is returned
    @Test
    public void addEltValidator3() {
        HeapChecker HT = new HeapChecker();
        assertFalse(HT.addEltValidator(Heap1, 7, new MtHeap()));
    }

    //Checks for 7 being added to an empty heap
    @Test
    public void addEltValidator4() {
        HeapChecker HT = new HeapChecker();
        assertTrue(HT.addEltValidator(new MtHeap(), 7, new MtHeap().addElt(7)));
    }

    //Checks for a modified heap being compared to its unmodified version
    @Test
    public void addEltValidator5() {
        HeapChecker HT = new HeapChecker();
        assertFalse(HT.addEltValidator(Heap1, 1, new DataBT(2, new DataBT(4), new DataBT(5))));
    }

    //Checks for the minimum value 2 being removed from Heap1
    @Test
    public void remMinEltValidatorTrue() {
        HeapChecker HT = new HeapChecker();
        assertTrue(HT.remMinEltValidator(Heap1, Heap1.remMinElt()));
    }

    //Checks for the minimum value of 2 being removed from Heap1 but 4 is removed instead
    @Test
    public void remMinEltValidatorFalse() {
        HeapChecker HT = new HeapChecker();
        assertFalse(HT.remMinEltValidator(Heap1, Heap1.remMinElt()));
    }

    //Checks for when the minimum element of an empty heap is being removed
    @Test
    public void remMinEltValidatorEmpty() {
        HeapChecker HT = new HeapChecker();
        assertTrue(HT.remMinEltValidator(new MtHeap(), new MtBT()));
    }

    //Checks for when the minimum element is being removed from a heap of size 1
    @Test
    public void remMinEltValidator4() {
        HeapChecker HT = new HeapChecker();
        assertTrue(HT.remMinEltValidator(new DataHeap(1), new MtBT()));
    }

    //Checks the comparison between Heap1 and itself
    @Test
    public void remMinEltValidator5() {
        HeapChecker HT = new HeapChecker();
        assertFalse(HT.remMinEltValidator(Heap1, new DataBT(2, new DataBT(4), new DataBT(5))));
    }

}
