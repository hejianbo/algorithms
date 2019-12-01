package me.jianbo.ds.chapter11;

public interface SymbolTable<TKey, TValue> {
	/**
	 * 是否存在
	 * @param key
	 * @return
	 */
	boolean contains(TKey key);
	
	/**
	 * 根据key查询
	 * @param key
	 * @return
	 */
	TValue get(TKey key);
	
	/**
	 * 设置key的值为value
	 * @param key
	 * @param value
	 */
	void put(TKey key, TValue value);
	
	/**
	 * 删除key项
	 * @param key
	 */
	void remove(TKey key);
}
