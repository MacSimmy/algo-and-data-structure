package com.learning.dataStructure;

/**
 * Created by mahendra.chhimwal on 8/17/2016.
 */
public class BinaryHeap extends AbstractBinaryHeap {
    private int[] heap;
    private int size;
    private int capacity;

    private static final int MAX_PRIORITY = 0x7FFFFFFF;


    public BinaryHeap(int capacity) throws Exception {
        if (capacity < 1) {
            throw new Exception("capacity can not be lower than one");
        }
        heap = new int[capacity];
        size = 0;
    }

    public BinaryHeap(int[] array) throws Exception {
        if (array == null) {
            throw new Exception("input  array can not be null");
        }
        heap = array;
        size = heap.length;
        capacity = heap.length;
    }

    private void shiftDown(int item) {
        if (item < size >> 1) {
            int maxItemIndex = item;
            int leftChild = getLeftChildIndex(item);
            if (leftChild < size && heap[leftChild] > heap[item]) {
                maxItemIndex = leftChild;
            }
            int rightChild = getRightChildIndex(item);
            if (rightChild < size && heap[rightChild] > heap[item]) {
                maxItemIndex = rightChild;
            }
            //swap value if required
            if (maxItemIndex != item) {
                swap(item, maxItemIndex);
                shiftDown(maxItemIndex);
            }
        }//nothing to shift  down as already a leaf in tree
    }

    private void shiftUp(int item) {
        if (item == 0) {
            //already have a max priority
            return;
        }
        int parent = getParentIndex(item);
        if (heap[parent] < heap[item]) {
            swap(parent, item);
            shiftUp(parent);
        }

    }

    private void swap(int position1, int position2) {
        int temp = heap[position1];
        heap[position1] = heap[position2];
        heap[position2] = temp;
    }

    @Override
    public int extractMax() {
        return 0;
    }

    @Override
    public void remove(int position) {
        //first make its priority infinity.

    }

    @Override
    public boolean changePriority(int item, int priority) {
        if (item < size) {
            heap[item] = priority;
            return true;
        }
        return false;
    }

    private int getParentIndex(int i) {
        return i / 2;
    }

    private int getLeftChildIndex(int i) {
        return 2 * i;
    }

    private int getRightChildIndex(int i) {
        return 2 * i + 1;
    }

    @Override
    public void add(int priority) {
        if (size == capacity) {
            System.out.println("heap  size is full, please prmovide new capacity");
        }
        //add item at leaf first
        heap[size] = priority;
        int oldLeaf = size;
        size = size + 1;
        // do shiftUp procedure till it find its correct position
        shiftUp(oldLeaf);
    }
}
