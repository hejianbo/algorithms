package me.jianbo.ds.chapter04;

public interface MyBinarySearchTree<T extends Comparable<T>> {
	/**
	 * 是否包含元素item
	 * @param item
	 * @return
	 */
	boolean contains(T item);
	
	/**
	 * 查找最小值
	 * @return
	 */
	T findMin();
	
	/**
	 * 查找最大值
	 * @return
	 */
	T findMax();
	
	/**
	 * 添加元素
	 * @param item
	 * @return
	 */
	boolean add(T item);
	
	/**
	 * 删除元素
	 * @param item
	 * @return
	 */
	boolean remove(T item);
}
