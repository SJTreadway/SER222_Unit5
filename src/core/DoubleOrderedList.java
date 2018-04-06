package core;

/**
 * DoubleOrderedList class - implements DoubleList<T> & OrderedListADT<T>
 * Used to add elements to a DoubleList
 *
 * @author Steven Treadway
 * @version 1.0
 */

public class DoubleOrderedList<T> extends DoubleList<T> implements OrderedListADT<T> {
	
	/**
     * Creates an empty list using the default capacity.
     */
    public DoubleOrderedList() {
        super();
    }
	
	/**
     * Adds the specified element to this list at the proper location
     *
     * @param element the element to be added to this list
     */
	
    public void add (T element) throws NonComparableElementException {
    	@SuppressWarnings("unchecked")
		Comparable<T> temp = (Comparable<T>) element;

        DoubleNode<T> current = start;
        DoubleNode<T> newnode = new DoubleNode<T>(element, null, null);

        if (isEmpty()) {
            start = newnode;
            end = newnode;
        }
        else if (temp.compareTo(end.getElement()) >= 0) {
        	end.setNext(newnode);
            newnode.setPrevious(end);
            newnode.setNext(null);
            end = newnode;
        }
        else if (temp.compareTo(start.getElement()) <= 0) {
        	start.setPrevious(newnode);
            newnode.setNext(start);
            newnode.setPrevious(null);
            start = newnode;
        }
        else {
            while ((temp.compareTo(current.getElement()) > 0)) {
            	current = current.getNext();
            }

            newnode.setNext(current);
            newnode.setPrevious(current.getPrevious());
            current.getPrevious().setNext(newnode);
            current.setPrevious(newnode);
        }
        size++;
    }
}
