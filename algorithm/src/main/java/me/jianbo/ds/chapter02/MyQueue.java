package me.jianbo.ds.chapter02;

public interface MyQueue<E> {
	/**
	 * 创建一个队列
	 * @param maxSize
	 * @return
	 */
	MyQueue<E> createQueue(int maxSize);
	
	/**
	 * 检测队列是否满
	 * @return
	 */
	Boolean isFull();
	
	/**
	 * 检测队列是否是空的
	 * @return
	 */
	Boolean isEmpty();
	
	/**
	 * 添加元素到队列中
	 * @param item
	 */
	void add(E item);
	
	/**
	 * 从队列中删除元素
	 * @return
	 */
	E delete();
}
