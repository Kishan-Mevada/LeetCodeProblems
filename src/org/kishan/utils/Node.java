package org.kishan.utils;

public class Node {
	int value;
	Node next;
	public int getValue() {
		return value;
	}
	public void setValue(int val) {
		this.value = val;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	public void print(){
		Node temp = this;
		while(temp != null){
			System.out.print(temp.getValue() + " ");
			temp = temp.getNext();
		}
	}
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
	public Node() {
	}
	public Node(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Node{" + "value=" + value + ", next=" + next + '}';
	}
}
