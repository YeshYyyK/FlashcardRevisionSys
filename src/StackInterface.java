public interface StackInterface<T>
{

    // @param newEntry An object to be added to the stack
    public void push(T newEntry);

    public void remove(T anEntry);

    public T pop();

    public T peek();

    public boolean isEmpty();

    public void clear();



}
