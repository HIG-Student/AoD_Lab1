package se.hig.aod.lab1;

/**
 * My interface for a list
 * 
 * @author Viktor Hanstorp (ndi14vhp@student.hig.se)
 */
public interface MyList<T>
{
    /**
     * Get the size of the list
     * 
     * @return the size
     */
    public int getSize();

    /**
     * Check if the list is empty
     * 
     * @return true if it is empty else false
     */
    public boolean isEmpty();

    /**
     * Append multiple elements (0 or more) to the list
     * 
     * @param element
     *            the elements to append
     * @return this list (for chaining)
     */
    @SuppressWarnings("unchecked")
    public MyList<T> add(T... element);

    /**
     * Append multiple elements (0 or more) to the list at the specified index
     * 
     * @param start
     *            the start to add elements at
     * @param element
     *            the elements to append
     * @return this list (for chaining)
     */
    @SuppressWarnings("unchecked")
    public MyList<T> add(int start, T... element);

    /**
     * Check if the list contains an specified object
     * 
     * @param object
     *            the object to look for
     * @return true if the object is in the list else false
     */
    public boolean contains(T object);

    /**
     * Get the index of the specified object, or -1 if it does not exist in the
     * list
     * 
     * @param object
     *            the object to look for
     * @return the index or -1
     */
    public int indexOf(T object);

    /**
     * Removes objects from this list
     * 
     * @param element
     *            the objects to remove
     * @return amount of removed objects
     */
    @SuppressWarnings("unchecked")
    public int remove(T... element);

    /**
     * Removes a object from this list
     * 
     * @param index
     *            the index to remove at
     * @return the removed object or null
     */
    public T removeAt(int index);

    /**
     * Get the object at the index
     * 
     * @param index
     *            the index
     * @return the object or null if out of bounds
     */
    public T get(int index);

    /**
     * Clear the list
     * 
     * @return this list (for chaining)
     */
    public MyList<T> clear();
}
