package com.rfutech.structures;

import java.util.*;

public class Structures {

    public static void main(String[] args) {
	Heap<Integer> heap = new Heap<>(Arrays.asList(1,5,67,0,2,34,56));
	System.out.println(heap);
    }
    public static class Heap<A extends Comparable<A>> {
	private final ArrayList<A> array;
	private int size;

	public Heap(List<A> list) {
	    array = new ArrayList<>(list);
	    size = array.size();
	    makeHeap();
	}

	public A max() {
	    return array.get(0);
	}
	public A deleteMax() {
	    A max = max();
	    A last = array.get(--size);
	    array.remove(size);
	    array.set(0, last);
	    siftDown(1);
	    return max;
	}

	@Override
	public String toString() {
	    return array.toString();
	}

	private void makeHeap() {
	    // why do we want to siftDownls
	    int i = size / 2;
	    while(i >= 1)
		siftDown(i--);
	}

	private void siftDown(int i) {
	    int j = i, k = i;

	    do {
		j = k;

		// if has a left child
		if (2 * j <= size) {
		    A left = array.get(2*j-1);
		    if (left.compareTo(array.get(k-1)) > 0)
			k = 2 * j; // the new position is the left child
		}
		// if has a right child
		if (2 * j + 1 <= size) {
		    A right = array.get(2*j+1 -1);
		    if (right.compareTo(array.get(k-1)) > 0)
			k = 2 * j + 1; // the new position is the right child
		}
		// k is the new position: the biggest child if any
		swap(j, k);
	    } while (j != k); // position hasn't changed then stop
	}

	private void precolate(int i) {
	    int k = i;
	    int j;
	    do {
		j = k;
		if (j > 1 && array.get(j % 2 - 1).compareTo(array.get(k-1)) < 0)
		    k = j % 2;
		swap(j, k);
	    } while(j != k);
	}

	private void swap(int j, int k) {
	    if (j == k) return;
	    A tmp = array.get(j - 1);
	    array.set(j - 1, array.get(k - 1));
	    array.set(k - 1, tmp);
	}
    }

}
