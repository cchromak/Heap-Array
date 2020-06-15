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

    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parent = getParent(index);
        int deletedValue = heap[index];

        heap[index] = heap[size - 1];

        if (index == 0 || heap[index] < heap[parent]) {
            bubbleDown(index, size - 1);
        }
        else {
            bubbleUp(index);
        }

        size--;

        return deletedValue;

    }
    
    public void heapSort() {
        int lastHeapIndex = size - 1;
        for (int i = 0; i < lastHeapIndex; i++) {
            int temp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = temp;
            bubbleDown(0, lastHeapIndex - i - 1);
        }
    }

    private void bubbleUp(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    private void bubbleDown(int index, int lastHeapIndex) {
        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                }
                else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if (heap[index] < heap[childToSwap]) {
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                }
                else {
                    break;
                }

                index = childToSwap;
            }
            else {
                break;
            }
        }
    }

    public int peek() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Empty Heap");
        }
        return heap[0];
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int index) {
        return (index -1) / 2;
    }

    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            if(i + 1 != size){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
