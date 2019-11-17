import java.util.EmptyStackException;

public final class LinkedStack<T> implements StackInterface<T>{

    private Node topNode;

    public LinkedStack()
    {
        topNode = null;
    }

    public void push(T newEntry)
    {
        topNode = new Node(newEntry,topNode);
    }

    public T peek()
    {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    }

    public T pop()
    {
        T top = peek();
        assert topNode != null;
        topNode = topNode.getNextNode();
        return top;
    }

    @Override
    public boolean isEmpty() {

        return topNode == null;
    }



    public void remove(T anEntry){


    }


    public void clear()
    {
        topNode = null;
    }


    public void print(String text){

        System.out.println(text);
    }








    private class Node
    {

        private T data;
        private Node next;

        private Node( T datavar, Node next){
            data = data;
            next = next;

        }

        public T getData(){
            return data;
        }

        public void setData(T datavar){
                data = datavar;

        }

        public Node getNextNode(){

            return next;
        }

        public void setNextNode(Node nodevar){
            next = nodevar;
        }
    }


















}
