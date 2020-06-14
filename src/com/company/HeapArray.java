package com.company;

import java.util.Arrays;

public class HeapArray {

    private int[] heap;
    private int size;

    public HeapArray(int capacity) {
        heap = new int[capacity];
    }

    public void inset(int value) {
        if(isFull()) {
            throw new IndexOutOfBoundsException("FULL HEAP");
        }
        heap[size] = value;
        bubbleUp(size);
        size++;
    }

    private void bubbleUp(int index) {
        int holdValue = heap[index];
        while (index > 0 && holdValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = holdValue;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int index) {
        return (index -1) / 2;
    }

    public int getLeftChild(int index) {
        return index * 2 + 1;
    }

    public int getRightChild(int index) {
        return index * 2 + 2;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(this.heap));
    }
}
