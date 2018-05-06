package application;



class Node<T> {

	public T data = null;
	public Node<T> nextNode = null;
	
	public Node(T data) {
		this.data = data;
	}
	
}



public class LinkedList<T> {

	private Node<T> first = null;

	public void push_back(T data) {
		Node<T> newNode = new Node<T>(data);
		if (first == null) {
			first = newNode;
		} else {
			Node<T> node = first;
			while (node.nextNode != null) {
				node = node.nextNode;	
			}
			node.nextNode = newNode;
		}
	}
	
	public void insertFirst(T data) {
		Node<T> newFirstNode = new Node<T>(data);
		newFirstNode.nextNode = first;
		first = newFirstNode;
	}
	
	public void insertAtPos(T data, int n) {
		if (n == 0)
			insertFirst(data);
		else {
			Node<T> node = first.nextNode;
			Node<T> prevNode = first;
			int i;
			for (i=1; i<n && node != null; i++) {
				node = node.nextNode;
				prevNode = prevNode.nextNode;
			}
			if (i == n) {
				Node<T> newNode = new Node<T>(data);
				newNode.nextNode = node;
				prevNode.nextNode = newNode;				
			}
		}
	}
	
	public Node<T> delete(T data) {
		Node<T> node = first.nextNode;
		Node<T> prevNode = first;
		
		while (node != null) {
			if (node.data.equals(data)) {
				prevNode.nextNode = node.nextNode;
				node = prevNode.nextNode.nextNode;
				continue;
			}
			node = node.nextNode;
			prevNode = prevNode.nextNode;
		}
		
		return null;
	}
	
	public boolean deleteAt(int pos) {
		Node<T> node = first.nextNode;
		Node<T> prevNode = first;
		if (pos == 0) {
			first = first.nextNode;
			return true;
		}
		int i;
		for (i = 0; i < pos-1 && node != null; i++) {
			node = node.nextNode;
			prevNode = prevNode.nextNode;
		}
		if (i == pos-1) {
			prevNode.nextNode = node.nextNode;
			return true;
		}
		else
			return false;
	}
	
	public void deleteLast() {
		Node<T> node = first;
		while (node.nextNode.nextNode != null)
			node = node.nextNode;
		node.nextNode = null;
	}
	
	@Override									// this is used to print out the linkedlist
	public String toString() {
		Node<T> node = first;
		String res = "";
		while (node != null) {
			res += node.data + " -> ";
			node = node.nextNode;
		}
		return res;
	}
}
