public class Test {
    public static void main(String[] args) {
        QueueInterface<String> test = new LinkedQueue<>();
        DictionaryInterface<Integer, String, String, String> dictionary = new SortedArrayDictionary<>();
        dictionary.add(1,"Spanish", "How do you say hello in spanish?", "Hola");
        dictionary.add(2,"Math", "What is an example of a variable?", "x");
        dictionary.add(3,"Math", "What is an example of a constant?", "pi");
        dictionary.add(4,"Math", "What is the perimeter of a square?", "4s");
        dictionary.add(5,"CS", "What is an example of a string?", "This is a string");

        //testing for random logic needed in quiz generation
       /* int Min = 1;
        int Max = 3;
        int rand = Min + (int)(Math.random() * ((Max - Min) + 1));
        System.out.println(rand);
        */
        NoteCard tempCard = new NoteCard(null, null, null, null);
        LinkedQueue testQueue = dictionary.makeQuiz("Math", 3);
        tempCard = (NoteCard) testQueue.dequeue();
        System.out.println(tempCard.getKey());
        System.out.println(tempCard.getAnswer());
        System.out.println(tempCard.getPrompt());
        while(!testQueue.isEmpty()){
            System.out.println(testQueue.dequeue().toString());
        }
        System.out.println("End of quiz 1");
        LinkedQueue testQueue2 = dictionary.makeQuiz("CS", 1);
        while(!testQueue2.isEmpty()){
            System.out.println(testQueue2.dequeue().toString());
        }
        System.out.println("End of quiz 2");
        LinkedQueue testQueue3 = dictionary.makeQuiz("Math", 2);
        while(!testQueue3.isEmpty()) {
            System.out.println(testQueue3.dequeue().toString());
        }
        System.out.println("End of quiz 3");
        LinkedQueue testQueue4 = dictionary.makeQuiz("CS", 2);
    }
}
