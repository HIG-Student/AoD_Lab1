package se.hig.aod.lab1;

/**
 * My interface for a queue
 * 
 * @author Viktor Hanstorp (ndi14vhp@student.hig.se)
 */
public interface MyQueue<T>
{
    /**
     * Peek on the first element in the queue
     * 
     * @return the first element (or null if empty)
     */
    public T peek();

    /**
     * Get the size of the queue
     * 
     * @return the size
     */
    public int getSize();

    /**
     * Append multiple elements (0 or more) to the queue
     * 
     * @param element
     *            the elements to append
     * @return this queue (for chaining)
     */
    @SuppressWarnings("unchecked")
    public MyQueue<T> append(T... element);

    /**
     * Fetch the first element
     * 
     * @return the element (or null if empty)
     */
    public T fetch();
    
    /**
     * Check if it contains an object
     * 
     * @return true if it contains the object, else false
     */
    public boolean contais(T object);

    /**
     * Rotates the queue (puts the first element last)
     * 
     * @return the rotated element (or null if empty)
     */
    public T rotate();

    /**
     * Clear the queue
     * 
     * @return this queue (for chaining)
     */
    public MyQueue<T> clear();
}
