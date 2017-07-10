package com.learning.dataStructure;

/**
 * Created by mahendra.chhimwal on 8/17/2016.
 */
public abstract class AbstractBinaryHeap {

    public abstract int extractMax();

    public abstract void remove(int position);

    public abstract boolean changePriority(int item, int priority);

    public abstract void add(int priority);
}
