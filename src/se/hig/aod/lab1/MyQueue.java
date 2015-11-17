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
     * Peek on a element in the queue
     * <br><br>
     * Negative index begins at the end of the queue
     * 
     * @param index
     *            the index of the element
     * @return the element (or null if empty)
     */
    public T peek(int index);

    /**
     * Get the size of the queue
     * 
     * @return the size
     */
    public int getSize();

    /**
     * Append a element to the queue
     * 
     * @param element
     *            the element to append
     * @return this queue (for chaining)
     */
    public MyQueue<T> append(T element);

    /**
     * Fetch the first element
     * 
     * @return the element (or null if empty)
     */
    public T fetch();

    /**
     * Clear the queue
     * 
     * @return this queue (for chaining)
     */
    public MyQueue<T> clear();
}
