package com.local;

public  class MinHeap {
    int size;
    int currentEndPos = -1;
    int[] a;

    public MinHeap(int size) {
        this.size = size;
        a = new int[size];
    }

    public void insert(int val) {
        if (currentEndPos == size - 1) {
            System.out.println("Cannot insert MinHeap full.");
            return;
        }
        currentEndPos++;
        a[currentEndPos] = val;
        int insertPos = currentEndPos;
        while (insertPos != 0) {
            if (a[(insertPos - 1) / 2] > a[insertPos]) {
                swap((insertPos - 1) / 2, insertPos);
                insertPos = (insertPos - 1) / 2;
            } else {
                break;
            }
        }
    }

    public int getMin() {
        if (currentEndPos == -1) {
            System.out.println("No element present in minHeap");
            return -1;
        }
        int min = a[0];
        a[0] = a[currentEndPos];
        currentEndPos--;
        minHeapify(0);
        return min;
    }

    private void minHeapify(int pos) {
        int smallest = a[pos];
        int smallestIndex = pos;
        if ((pos * 2 + 1) <= currentEndPos && smallest > a[(pos * 2 + 1)]) {
            smallestIndex = pos * 2 + 1;
            smallest = a[pos * 2 + 1];
        }

        if ((pos * 2 + 2) <= currentEndPos && smallest > a[pos * 2 + 2]) {
            smallestIndex = pos * 2 + 2;
            smallest = a[pos * 2 + 2];
        }
        if (smallest != a[pos]) {
            swap(pos, smallestIndex);
            minHeapify(smallestIndex);
        }
    }

    private void swap(int pos1, int pos2) {
        int temp = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = temp;
    }
}
