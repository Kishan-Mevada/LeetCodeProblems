package org.kishan.year_2021.month_september.date_3;

import org.kishan.utils.Node;

/**
 * 	Given the head of linked list and a value x, partition it such that all nodes less than x
 * 	come before nodes greater than or equal to x
 *
 * 	You should preserve the original relative order of the nodes is each of the 2 partition
 *
 * 	-- Time : O(n)
 * 	-- Space : O(1)
 */
public class PartitionList {
	static Node partition(Node head,int x){
		Node h1 = new Node(), t1 = h1;
		Node h2 = new Node(), t2 = h2;

		while(head != null){
			Node next = head.getNext();
			head.setNext(null);
			if(head.getValue() < x){
				t1.setNext(head);
				t1 = head;
			}
			else{
				t2.setNext(head);
				t2 = head;
			}
			head = next;
		}

		t1.setNext(h2.getNext());
		return h1.getNext();
	}
	public static void main(String[] args) {
		Node head = new Node(1,new Node(4,new Node(3,new Node(2,new Node(5,new Node(2))))));
		int x = 3;
		head = partition(head,x);
		head.print();
	}
}
