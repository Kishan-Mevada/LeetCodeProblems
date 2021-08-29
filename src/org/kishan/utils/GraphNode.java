package org.kishan.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphNode {
	private int value;
	private List<GraphNode> neighbors;
	public GraphNode(int value, List<GraphNode> neighbors) {
		this.value = value;
		this.neighbors = neighbors;
	}
	public GraphNode(int value) {
		this.value = value;
		this.neighbors = new ArrayList<>();
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public List<GraphNode> getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(List<GraphNode> neighbors) {
		this.neighbors = neighbors;
	}

	public void print(){
		Set<GraphNode> visited = new HashSet<>();
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(this);

		while(!queue.isEmpty()){
			GraphNode temp = queue.poll();
			if(visited.contains(temp)){
				continue;
			}
			System.out.print(temp.getValue() + " ");
			visited.add(temp);
			queue.addAll(temp.getNeighbors());
		}
		System.out.println("");
	}
}
