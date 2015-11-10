/**
 * This is free to use in courses at University of Gävle.
 */
package se.hig.ad1.lab1;

/**
 * A Java Interface for the Abstract Data Type Stack
 * 
 * If you try to remove or look at the top element when the
 * stack is empty, an {@link StackIsEmptyException} will be thrown.
 * 
 * @author Magnus Hjelmblom
 * @author Anders Jackson
 */

public interface Stack
{
    /** 
     * Destroys the stack (removes all elements and write 
     * a messages on {@link System}.out).
     */
    public void destroy();
    
    /**
     * Checks if the stack is empty.
     * 
     * @return true if stack is empty, else returns false.
     */
    public boolean isEmpty();
    
    /**
     * Checks if the stack is full.
     * 
     * @return true if stack is full, else returns false.
     */
    public boolean isFull();
    
    /**
     * Add an element on the top of the stack.
     * 
     * @param o is the Object added on the top of the stack.
     */
    public void push(Object o);
    
    /**
     * Removes the top element of the stack.
     * Will throw {@link StackIsEmptyException} if stack is empty.
     * 
     * @return the top element of the stack.
     */
    public Object pop();
    
    /**
     * Returns the top element of the stack, without removing it.
     * Will throw {@link StackIsEmptyException} if stack is empty.
     * 
     * @return the top element.
     */
    public Object peek();
    
}
