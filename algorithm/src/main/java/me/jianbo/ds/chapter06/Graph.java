package me.jianbo.ds.chapter06;

public interface Graph<T> {
	/**
	 * 向图中添加顶点
	 * @param vertex
	 * @return
	 */
	Graph<T> addVertex(Vertex<T> vertex);
	
	/**
	 * 向图中添加边
	 * @param edge
	 * @return
	 */
	Graph<T> addEdge(Edge<T> edge);
	
	/**
	 * 从顶点startVertex深度优先遍历图
	 * @param startVertex
	 */
	void dfs(Vertex<T> startVertex);
	
	/**
	 * 从顶点startVertex广度优先遍历图
	 * @param startVertex
	 */
	void bfs(Vertex<T> startVertex);
	
	/**
	 * 最短路径
	 * @return
	 */
	Vertex<T>[] shortestPath();
	
	/**
	 * 最小生成树
	 */
	void mst();
}
