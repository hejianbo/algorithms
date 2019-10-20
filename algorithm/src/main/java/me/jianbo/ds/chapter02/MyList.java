package me.jianbo.ds.chapter02;

public interface MyList<E> {
	/**
	 * 创建一个空的线性表
	 * @return
	 */
	MyList<E> makeEmpty();
	
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
	void insert(E x, int index);
	
	/**
	 * 删除索引index上的元数
	 * @param index
	 */
	void delete(int index);
	
	/**
	 * 返回线性表的长度
	 * @return
	 */
	int length();
}
