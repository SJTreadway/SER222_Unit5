package core;

import java.util.Iterator;

/**
 * DoubleList class - implements ListADT<T> & Iterable<T>
 * Contains linked DoubleNodes
 *
 * @author Steven Treadway
 * @version 1.0
 */

public class DoubleList<T> implements ListADT<T>, Iterable<T>{

	protected DoubleNode<T> start, end;
	protected int size;
	
	public DoubleList () {
		start = null;
		end = null;
		size = 0;
	}
	
	/**  
    * Returns an iterator for this class
    *
    * @return iterator
    */
	
	@Override
	public Iterator<T> iterator () {
		return new DoubleListIterator<T>(start, size);
	}
	
	/**  
    * Returns the number of elements in this list. 
    *
    * @return the integer representation of number of elements in this list
    */
	
	public int size () {
		return size;
	}
	
	/**  
    * Returns a reference to the first element in this list. 
    *
    * @return a reference to the first element in this list
    */
	
	public T first () {
		return start.getElement();
	}

	/**  
	* Returns a reference to the last element in this list. 
	*
	* @return a reference to the last element in this list
	*/
	
	public T last () {
		return end.getElement();
	}
	
	/**  
    * Removes and returns the first element from this list. 
    * 
    * @return the first element from this list
    */
	
   public T removeFirst() {
	   if (size == 0) throw new EmptyCollectionException("DoubleList");
	   DoubleNode<T> temp = start;
	   start = start.getNext();
	   start.setPrevious(null);
	   size--;
	   return temp.getElement();
   }

   /**  
    * Removes and returns the last element from this list. 
    *
    * @return the last element from this list
    */
   
   public T removeLast() {
	   if (size == 0) throw new EmptyCollectionException("DoubleList");
	   DoubleNode<T> temp = end;
	   end = end.getPrevious();
	   end.setNext(null);
	   size--;
	   return temp.getElement();
   }

   /**  
    * Removes and returns the specified element from this list. 
    *
    * @param element the element to be removed from the list
    */
   
   public T remove(T element) throws ElementNotFoundException {
       T result;
       DoubleNode<T> ptr = find(element);

       if (ptr == null)
    	   throw new ElementNotFoundException("DoubleList");

       result = ptr.getElement();

       if (ptr == start)
           result = this.removeFirst();
       else if (ptr == end)
           result = this.removeLast();
       else {
    	   ptr.getNext().setPrevious(ptr.getPrevious());
    	   ptr.getPrevious().setNext(ptr.getNext());
           size--;
       }

       return result;
   }
   
   /**
    * Returns a reference to the specified element, or null if it
    * is not found.
    */
   public DoubleNode<T> find (T target) {
       boolean found = false;
       DoubleNode<T> traverse = start;
       DoubleNode<T> result = null;

       if (!isEmpty()) {
           while (!found && traverse != null) {
               if (target.equals(traverse.getElement()))
                   found = true;
               else
                   traverse = traverse.getNext();
           }
       }
       if (found)
           result = traverse;

       return result;
   }
	
	/**  
    * Returns true if this list contains the specified target element. 
    *
    * @param target the target that is being sought in the list
    * @return true if the list contains this element
    */
	
	public boolean contains (Object obj) {
		DoubleNode<T> current = start;
		
		while (current != null) {
			if (current == obj) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
	/**  
    * Returns true if this list contains no elements. 
    *
    * @return true if this list contains no elements
    */
	
	public boolean isEmpty () {
		return size == 0;
	}
	
	/**  
    * Returns a string representation of this list. 
    *
    * @return a string representation of this list
    */
	
	public String toString () {
		Iterator<T> itr = this.iterator();
		String str = "";
		if (size == 0) 
			throw new EmptyCollectionException("DoubleList");
		else if (size == 1) 
			return str + start.getElement();
		
		while (itr.hasNext())
			str = str + itr.next() + " ";
		
		return str;
	}
	
}
