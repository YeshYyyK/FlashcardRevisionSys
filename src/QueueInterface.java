public interface QueueInterface<T> {
    /**
     * adds newEntry to queue back of queue.
     * @param newEntry whatever object is being added
     */
    public void enqueue(T newEntry);

    /**
     * remove & return entry at front of queue.
     * @return object at front of queue
     * @throws java.util.NoSuchElementException if queue empty before operation.
     */
    public T dequeue();

    /**
     * retrieves entry at front of queue
     * @return object at front of queue
     * @throws java.util.NoSuchElementException if queue is empty before operation.
     */
    public T getFront();
    /**
     * checks if queue is empty
     * @return true if queue is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * removes all entries from queue.
     */
    public void clear();

    /**
     *
     * @param someEntry
     * @return
     */
    public boolean hasEntry(T someEntry);
}
