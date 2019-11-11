package me.jianbo.ds.chapter06;

/**
 * 邻接矩阵表示的边
 * @author James
 *
 * @param <T>
 */
public class Edge<T> {
	private Vertex<T> v1;
	private Vertex<T> v2;
	private T weight;
}
