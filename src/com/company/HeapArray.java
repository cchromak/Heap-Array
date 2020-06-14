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
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("EMPTY HEAP");
        }
        int parentIndex = getParent(index);
        int deletedValued = heap[index];

        heap[index] = heap[size - 1];
        if(index == 0 || heap[index] > heap[parentIndex]){
            bubbleDown(index, size -1);
        } else {
            bubbleUp(index);
        }
        size--;
        return deletedValued;
    }

    private void bubbleDown(int index, int lastHeapIndex) {
        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild = getLeftChild(index);
            int rightChild = getRightChild(index);
            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break;
                }
                index = childToSwap;
            }
            else {
                break;
            }
        }
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

    public boolean isEmpty() {
        return size == 0;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(this.heap));
    }
}
