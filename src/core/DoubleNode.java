package core;

/**
 * DoubleNode class - used to create/maintain nodes in
 * our DoublyLinkedList.
 *
 * @author Steven Treadway
 * @version 1.0
 */

public class DoubleNode<T> {
	private T data;
	private DoubleNode<T> next, prev;
	
	public DoubleNode () {
		data = null;
		next = null;
		prev = null;
	}
	
	public DoubleNode (T d, DoubleNode<T> n, DoubleNode<T> p) {
		data = d;
		next = n;
		prev = p;
	}
	
	public DoubleNode<T> getNext () {
		return next;
	}
	
	public void setNext (DoubleNode<T> n) {
		next = n;
	}
	
	public DoubleNode<T> getPrevious () {
		return prev;
	}
	
	public void setPrevious (DoubleNode<T> p) {
		prev = p;
	}
	
	public T getElement () {
		return data;
	}
	
	public void setElement (T d) {
		data = d;
	}
}
