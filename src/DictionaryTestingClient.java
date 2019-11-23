import java.util.Dictionary;

public class DictionaryTestingClient {
    public static void main(String[] args)
    {
        //expected case where user simply inputs incrementing numbers for each new notecard and has
        //string values for everything else
        DictionaryInterface<Integer, String, String, String> test = new SortedArrayDictionary<>();
        System.out.println("Expect: True Actual: " + test.isEmpty());
        test.add(1, "B", "How do you say hello in spanish?", "Hola");
        test.add(2, "B", "How do you say blue in spanish?", "Azul");
        //We would expect this to come before spanish in the array
        test.add(3, "E", "What is 2 + 9", "11" );
        test.add(4, "A", "What is the slope in the equation y = mx + b?", "m");
        System.out.print("Expect: A B B E Actual: ");
        test.subjectIterator();
        System.out.println("Expect: True Actual: " + test.contains(1));
        System.out.println("Expect: True Actual: " + test.contains(2));
        System.out.println("Expect: True Actual: " + test.contains(3));
        System.out.println("Expect: True Actual: " + test.contains(4));
        //temporarily added locateIndex to interface for testing
        System.out.println(test.locateIndex(4));
        //System.out.println("Testing case where user has entered duplicate key should return illegalArgumentException Actual: " + test.add(1, "1", "1", "1"));
        System.out.println(test.remove(4));
        System.out.print("Expect: B B E Actual: ");
        test.subjectIterator();
        System.out.println(test.remove(3));
        System.out.println("Expect: B B Actual: ");
        test.subjectIterator();
        System.out.println("Expect: false Actual: " + test.isEmpty());
        System.out.println("Expect: 2 Actual: " + test.getSize());
        System.out.println(test.locateIndex(1));
        System.out.println(test.contains(1));
        System.out.println("Expect: How do you say hello in spanish? Actual: " + test.getPrompt(1));
        test.clear();
        //these keys were previously in the dictionary
        System.out.println("Expect: false Actual: " + test.contains(1));
        System.out.println("Expect: false Actual: " + test.contains(2));
    }
}