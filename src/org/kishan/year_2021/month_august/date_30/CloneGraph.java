package org.kishan.year_2021.month_august.date_30;

import org.kishan.utils.GraphNode;

import java.util.HashMap;

/**
 * Given a reference of a node in a connected undirected graph, Return the deep copy of graph
 * Solution Algorithms
 * - Recursive approach
 * - create recursive method with below 2 parameter
 * - node, current node to clone
 * - map, to keep track of previously cloned nodes
 * - in recursive method do following
 * - base condition
 * - if node is null
 * - return null
 * - if map contains node
 * - return map.get(node)
 * - in recursive call
 * - create clone of node
 * - put node and clone in map
 * - Iterate the neighbors of node
 * - recursively clone neighbor
 * - add cloned neighbor to the list of neighbors of clone node
 * return clone
 *
 * Time : O(n + e) , visit all nodes and edges
 * Space : O(n + e) + O(n) + O(n) = O(n + 2), n,e are number of nodes and edge
 * 		O(n) = recursive call stack
 * 		O(n) = map
 */
public class CloneGraph {
	static GraphNode cloneGraph(GraphNode node) {
		return cloneGraph(node, new HashMap<GraphNode, GraphNode>());
	}
	private static GraphNode cloneGraph(GraphNode node, HashMap<GraphNode, GraphNode> map) {
		//base condition
		if(node == null) {
			return null;
		}
		if(map.containsKey(node)) {
			return map.get(node);
		}
		GraphNode clone = new GraphNode(node.getValue());
		map.put(node, clone);
		for(GraphNode neighbor : node.getNeighbors()) {
			clone.getNeighbors().add(cloneGraph(neighbor, map));
		}
		return clone;
	}
	public static void main(String[] args) {
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);
		node1.getNeighbors().add(node2);
		node1.getNeighbors().add(node4);
		node2.getNeighbors().add(node1);
		node2.getNeighbors().add(node3);
		node3.getNeighbors().add(node2);
		node3.getNeighbors().add(node4);
		node4.getNeighbors().add(node1);
		node4.getNeighbors().add(node3);
		System.out.println("Before clone -> ");
		node1.print();
		GraphNode cloneGraph = cloneGraph(node1);
		System.out.println("After clone -> ");
		cloneGraph.print();
	}
}
