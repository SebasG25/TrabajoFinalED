/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.util.ArrayList;

/**
 *
 * @author samaniw
 */
public class MaxHeap {

    private ArrayList<Integer> dataHeap;

    public MaxHeap() {
        dataHeap = new ArrayList<>();
        dataHeap.add(null);
    }

    private void swap(int son, int father) {
        int temp = getDataHeap().get(son);
        getDataHeap().set(son, getDataHeap().get(father));
        getDataHeap().set(father, temp);
    }

    private int parent(int son) {
        return son / 2;
    }

    public void insert(int element) {
        getDataHeap().add(element);
        int i = getDataHeap().size() - 1;
        while (i > 1 && getDataHeap().get(parent(i)) < getDataHeap().get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private boolean isLeaf(int i) {
        return (getLeftChild(i) > dataHeap.size() - 1);
    }

    private int getLeftChild(int i) {
        return i * 2;
    }

    private int getRightChild(int i) {
        return i * 2 + 1;

    }

    private int maxSon(int i) {
        if (getRightChild(i) > dataHeap.size() - 1) {
            return getLeftChild(i);
        } else if (dataHeap.get(getLeftChild(i)) > dataHeap.get(getRightChild(i))) {
            return getLeftChild(i);
        } else {
            return getRightChild(i);

        }
    }

    public void ExtractMax() {
        //A[1] = A[A.length-1]

        dataHeap.set(1, dataHeap.get(dataHeap.size() - 1));
        dataHeap.remove(dataHeap.size() - 1);
        //i = 1; 
        int i = 1;
        //while (i < A.length)
        while ((i < dataHeap.size() - 1) && !isLeaf(i)) {
            //  if A[i] < (L = the larger of i's children)
            int L = dataHeap.get(maxSon(i));
            if (dataHeap.get(i) < L) {
                //    swap(A[i], L)
                swap(i, maxSon(i));
            }
            i = maxSon(i);
        }
    }

    /**
     * @return the dataHeap
     */
    public ArrayList<Integer> getDataHeap() {
        return dataHeap;
    }

}
