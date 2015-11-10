/**
 * This is free to use in courses at University of Gävle.
 */
package se.hig.ad1.lab1;

/**
 * A Java Interface for the Abstract Data Type Queue
 * 
 * It you try to remove or look at an queue when the 
 * queue is empty, an {@link QueueIsEmptyException} will be thrown.
 * 
 * @author Magnus Hjelmblom
 * @author Anders Jackson
 */

public interface Queue
{
    /** 
     * Destroys the queue (removes all elements and write 
     * a messages on {@link System}.out).
     */
    public void destroy();
    
    /**
     * Checks if the queue is empty.
     * 
     * @return true if queue is empty, else returns false.
     */
    public boolean isEmpty();
    
    /**
     * Checks if the queue is full.
     * 
     * @return true if queue is full, else returns false.
     */
    public boolean isFull();
    
    /**
     * Add an element last in the queue.
     * 
     * @param o is the Object added last in the queue.
     */
    public void enqueue(Object o);
    
    /**
     * Removes the first element in the queue.
     * If the queue is empty, it will throw 
     * an {@link QueueIsEmptyException}.
     * 
     * @return the first element.
     */
   public Object dequeue();
    
    /**
     * Returns the first element in the queue, without removing it.
     * If the queue is empty, it will throw 
     * an {@link QueueIsEmptyException}.
     * 
     * @return the first element.
     */
    public Object getFront();
}
