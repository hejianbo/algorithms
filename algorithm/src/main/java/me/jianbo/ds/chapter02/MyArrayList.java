package me.jianbo.ds.chapter02;

import java.util.Iterator;

/**
 * 基于数组实现的线性表
 * 
 * @author James
 *
 * @param <E>
 */
public class MyArrayList<E> implements MyList<E> {

	private static final int DEFAULT_SIZE = 16;

	private Object[] elements = null;
	private int size = 0;

	public MyArrayList() {
		this.elements = new Object[DEFAULT_SIZE];
	}

	@Override
	@SuppressWarnings("unchecked")
	public E findKth(int k) {
		return (E) this.elements[k - 1];
	}

	@Override
	public int find(E x) {
		int index = -1;
		for (int i = 0; i < this.size; i++) {
			if (this.elements[i].equals(x)) {
				return i;
			}
		}
		return index;
	}

	@Override
	public void add(E x, int index) {
		if (index > this.size) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = this.size; i >= index; i--) {
			this.elements[i + 1] = this.elements[i];
		}
		this.elements[index] = x;
		this.size++;
	}

	@Override
	public void add(E x) {
		this.elements[this.size++] = x;
	}

	@Override
	public void remove(int index) {
		if (index >= this.size) {
			return;
		}
		for (int i = index + 1; i < this.size; i++) {
			this.elements[i - 1] = this.elements[i];
		}
		this.elements[this.size - 1] = null;
		this.size--;
	}

	@Override
	public int length() {
		return this.size;
	}

	
	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<E> {
		private int cursor = 0;
		@Override
		public boolean hasNext() {
			return this.cursor < MyArrayList.this.size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			return (E) MyArrayList.this.elements[cursor++];
		}

	}

	public static void main(String[] args) {
		MyList<Integer> list = new MyArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(2, 1);
		list.add(4, 3);
		list.add(6, 5);

		for (Integer item : list) {
			System.out.println(item);
		}
	}
}
