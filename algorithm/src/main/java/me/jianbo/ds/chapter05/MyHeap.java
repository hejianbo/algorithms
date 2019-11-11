package me.jianbo.ds.chapter05;

public interface MyHeap<T> {
	void add(T item);
	void remove();
	boolean isEmpty();
	boolean isFull();
}
