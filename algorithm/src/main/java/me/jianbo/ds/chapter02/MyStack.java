package me.jianbo.ds.chapter02;

public interface MyStack<E> {
	/**
	 * 创建空栈, 最大长度为maxSize
	 * @param maxSize
	 * @return
	 */
	MyStack<E> createStack(int maxSize);
	
	/**
	 * 栈是否满 
	 * @return
	 */
	Boolean isFull();
	
	/**
	 * 栈是否是空栈
	 * @return
	 */
	Boolean isEmpty();
	
	/**
	 * 入栈
	 * @param element
	 */
	void push(E element);
	
	/**
	 * 出栈
	 * @return
	 */
	E pop();
}
