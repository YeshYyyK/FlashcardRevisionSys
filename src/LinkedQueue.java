import java.util.*;
public final class LinkedQueue<T> implements QueueInterface<T>{

    private class Node {
        private T data;
        private Node next;

        private T getData(){return data;}
        private void setData(T newData){data = newData;}
        private Node getNextNode(){return next;}
        private void setNextNode(Node nextNode){next = nextNode;}
        private Node(T dataPortion){this(dataPortion, null);}
        private Node (T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }
    }//end node class

    private Node firstNode;
    private Node lastNode;

    public LinkedQueue(){
        firstNode = null;
        lastNode = null;
    }
    public void enqueue(T newEntry){
        Node newNode = new Node(newEntry, null);
        //special case where one entry is first and last
        if (isEmpty())
            firstNode = newNode;
            //stick in node at end, have it point to wherever the last node was pointing
        else lastNode.setNextNode(newNode);//done before pointing lastNode so we preserve location of prior node
        lastNode = newNode;//pointer updated

    }
    public T dequeue(){
        T result = getFront();//might throw NoSuchElementException
        //"hop over" first node, let java clean it up
        firstNode = firstNode.getNextNode();
        if(firstNode == null)
            lastNode = null;
        return result;
    }
    public T getFront(){
        T result = null;
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            result = firstNode.getData();
        }
        return result;
    }
    //checks if queue is empty
    public boolean isEmpty(){
        //if nodes don't point to anything queue is empty...
        if (firstNode == null && lastNode == null){
            //so we return true
            return true;
        }
        //if they point to something, then it is not empty
        else return false;
    }
    public void clear(){
        firstNode = null;
        lastNode = null;
    }

    public boolean hasEntry(T someEntry) {
        boolean result = false;
        Node currentNode = firstNode;
        while(currentNode != null)
        {
            if (someEntry.equals(currentNode.getData()))
            {
                return true;
            }
            else
                currentNode = currentNode.getNextNode();
        }
        return result;
    }
}
