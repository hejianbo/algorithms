package me.jianbo.ds.chapter02;

import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E> {

	private int size = 0;
	private Node<E> first = null;
	private Node<E> last = null;

	public MyLinkedList() {
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public E findKth(int k) {
		if (k > this.size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> current = this.first;
		int i = 0;
		while (i++ != k) {
			current = current.next;
		}
		return current.item;
	}

	@Override
	public int find(E x) {
		int i = 0;
		Node<E> current = this.first;
		while (current != null) {
			if (current.item.equals(x)) {
				return i;
			} else {
				current = current.next;
				i++;
			}
		}
		return -1;
	}

	@Override
	public void add(E x, int index) {
		if (index > this.size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> newNode = new Node<E>(x, null);
		if (this.size == 0) {
			this.first = newNode;
			this.last = newNode;			
			this.size++;
		} else if (index == this.size) {
			this.add(x);
		} else {
			Node<E> current = this.first;
			int i = 0;
			while(i++ != index - 1) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;			
			this.size++;
		}
	}

	@Override
	public void add(E x) {
		Node<E> node = new Node<E>(x, null);
		if (this.first == null) {
			this.first = node;			
		} else {
			this.last.next = node;
		}
		this.last = node;
		this.size++;
	}

	@Override
	public void remove(int index) {
		if (index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			Node<E> node = this.first;
			this.first = this.first.next;
			node.next = null;
		} else {
			int i = 0;
			Node<E> current = this.first;
			while (i != index - 1) {
				current = current.next;
			}
			
		}
		this.size--;
	}

	@Override
	public int length() {
		return this.size;
	}

	private static class Node<E> {
		E item;
		Node<E> next;

		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
	}
}
