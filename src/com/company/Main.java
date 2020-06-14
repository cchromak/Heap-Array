package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

	    HeapArray heap = new HeapArray(10);

	    heap.inset(1);
        heap.inset(-43);
        heap.inset(34);
        heap.inset(67);
        heap.inset(10);
        heap.inset(-10);
        heap.inset(34);

        heap.printHeap();

    }
}
