package me.jianbo.ds.chapter02;

public interface MyList<E> extends Iterable<E>{
	
	/**
	 * 返回第k个元数
	 * @param k
	 * @return
	 */
	E findKth(int k);
	
	/**
	 * 查找元素x第一次出现的索引位置
	 * @param x
	 * @return
	 */
	int find(E x);
	
	/**
	 * 在索引index插入元数x
	 * @param x
	 * @param index
	 */
	void add(E x, int index);

	/**
	 * 在末尾插入元数x
	 * @param x
	 */
	void add(E x);
	
	/**
	 * 删除索引index上的元数
	 * @param index
	 */
	void remove(int index);
	
	/**
	 * 返回线性表的长度
	 * @return
	 */
	int length();
}
