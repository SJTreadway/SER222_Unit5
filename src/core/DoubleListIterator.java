package core;

import java.util.Iterator;

public class DoubleListIterator<T> implements Iterator<T>
{
    @SuppressWarnings("unused")
	private int count; //The number of elements in the collection.
    private DoubleNode<T> current; //The current position

    /**
     * Sets up this iterator using the specified items.
     */
    public DoubleListIterator (DoubleNode<T> list, int size) {
        current = list;
        count = size;
    }

    /**
     * Returns true if this iterator has at least one more element
     * to deliver in the iteration.
     */
    public boolean hasNext () {
        return (current != null);
    }

    /**
     * Returns the next element in the iteration.  If there are
     * no more elements in this iteration, a NoSuchElementException
     * is thrown
     */
    public T next () {
        if (!hasNext()) throw new ElementNotFoundException("DoubleListIterator");

        T result = current.getElement();
        current = current.getNext();

        return result;
    }

    /**
     * The remove operation is not supported.
     */
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
