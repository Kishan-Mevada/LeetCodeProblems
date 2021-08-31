package org.kishan.year_2021.month_august.date_30;

import org.kishan.utils.Node;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 *  Solution Algorithm
 *
 *  - create a minHeap to keep track of the heads of linked list
 *  - Iterate the lists, variable list
 *     - if list is not null
 *     		- add list to minHeap
 *  - create head and tail node for result
 *  	- head, the sentinel head of th result list
 *  	- tail, the sentinel tail
 *  - while minHeap is not emptu
 *  	- Poll a node from minHeap
 *  	- set tail.next to node
 *   	- tail = node
 *   	- if node.next is not null
 *   		- add node.next to minHeap
 *  - return head.next;
 *
 *   Time : O(klogk) + O(nlogk) = O(nlogk), where
 *   	- n is total number of nodes
 *   	- O(klogk), minHeap
 *   	- O(nlogk), processing all nodes in heap
 *
 *   Space : O(k), where k is number of lists
 *   		- O(k), minHeap
 *
 */

public class MergeKSortedList {

	static Node mergeKSortedList(Node[] lists){
		PriorityQueue<Node> minHeap = createMinHeap(lists);
		Node head = new Node(), tail = head;

		while(!minHeap.isEmpty()){
			Node node = minHeap.poll();
			tail.setNext(node);
			tail = node;

			if(node.getNext() != null){
				minHeap.add(node.getNext());
			}
		}
		return head.getNext();
	}
	private static PriorityQueue<Node> createMinHeap(Node[] lists) {
		PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(Node::getValue));

		for(Node node : lists){
			if(node != null){
				minHeap.add(node);
			}
		}

		return minHeap;
	}
	public static void main(String[] args) {
		Node[] lists = {
				new Node(1,new Node(4,new Node(5))),
				new Node(1,new Node(3,new Node(4))),
				new Node(2,new Node(6))
		};
		Node node = mergeKSortedList(lists);
		node.print();
	}
}
