import java.security.InvalidParameterException;
import java.util.Arrays;
/**
 * K is some unique user-entered identifier
 * S is the subject of the notecard
 * P is the prompt of the notecard (the question for study)
 * A is the answer to the prompt
 * dictionary is sorted by subject
 * removal is to be done using the user identifier
 * duplicate subjects, prompts, and answers are allowed
 */
public class SortedArrayDictionary<K extends Comparable<? super K> , S extends Comparable<? super S>, P, A > implements DictionaryInterface<K, S, P, A> {
    private NoteCard<K, S,P,A>[] dictionary;
    private int numberOfEntries;
    private boolean integrityOK = false;
    private final static int DEFAULT_CAPACITY = 100;
    private static final int MAX_CAPACITY = 10000;

    public SortedArrayDictionary(int initialCapacity){
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        NoteCard<K,S,P,A>[] tempDictionary = (NoteCard<K, S,P,A>[]) new NoteCard[initialCapacity];
        dictionary = tempDictionary;
        numberOfEntries = 0;
        integrityOK = true;
    }
    //default constructor
    public SortedArrayDictionary(){
        this(DEFAULT_CAPACITY);
    }


    public static class NoteCard<K, S, P, A> {
        K key;
        S subject;
        P prompt;
        A answer;

        public NoteCard(K keyKey, S searchSubject, P prompting, A answering) {
            key = keyKey;
            subject = searchSubject;
            prompt = prompting;
            answer = answering;
        }
        public K getKey(){return key;}
        public S getSubject() {
            return subject;
        }
        public P getPrompt() {
            return prompt;
        }
        public A getAnswer(){
            return answer;
        }

        /**
         *  may remove later, use undetermined
         */
        public void setPrompt(P newPrompt) {
            prompt = newPrompt;
        }
        public void setAnswer(A newAnswer){ answer = newAnswer; }
        public String toString(){
            return key + " " + subject + " " + prompt + " " + answer;
        }
    }
    private void checkIntegrity(){
        if (!integrityOK)
            throw new SecurityException("ArrayBag object is corrupt.");
    }
    private void checkCapacity(int capacity){
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempted to create a bag whose " +
                    "capacity exceeds allotted maximum of " + MAX_CAPACITY);
    }
    //double array if full
    private void ensureCapacity(){
        //if dictionary is full or over capacity
        if (numberOfEntries >= dictionary.length){
            //double length of array
            int newLength = 2 * dictionary.length;
            //ensure that new length is not too large
            checkCapacity(newLength);
            //use copyOf function to set dictionary = to itself with new 2X length
            dictionary = Arrays.copyOf(dictionary, newLength);
        }
    }
    //adds entries to the array
    //this will also check to see if the inputted key already belongs to an entry in the array
    //in which case the entry that key belongs to will be overwritten
    public A add(K key, S subject, P prompt, A answer) {
        checkIntegrity();
        A result = null;
        System.out.println();
        //we don't allow blank cards or cards with duplicate keys
        if ((key == null) || (subject == null) || (prompt == null) || (answer == null) || (contains(key)))
            throw new IllegalArgumentException();
            //If it isn't blank though...
        else {
            //otherwise, this will be a new entry
            makeRoom(getEntryPoint(subject));
            dictionary[getEntryPoint(subject)] = new NoteCard<>(key, subject, prompt, answer);
            numberOfEntries++;
            ensureCapacity();
        }
        return result;
    }
    public int locateIndex(K key){
        int index = 0;
        while ((index < numberOfEntries) && !key.equals(dictionary[index].getKey()))
        {
            index++;
        }
        return index;
    }
    //locates where to place the notecard into the dictionary
    //compares the subject parameter against the subjects in the dictionary
    public int getEntryPoint(S subject)
    {
        int index = 0;
        while ((index < numberOfEntries) && subject.compareTo(dictionary[index].getSubject()) > 0)
            index++;
        return index;
    }
    private void makeRoom(int keyIndex) {
        int index = numberOfEntries;
        //while we have yet to reach the point before our entry,
        //and we have space to move our last entry one spot forward...
        while (index > keyIndex && index < dictionary.length) {
            //when first run: last entry moved to next index
            dictionary[index] = dictionary[index - 1];
            //repeat until we hit our entry point
            index--;
        }
    }
    public P remove(K key){
        //covering case where subject does not have an entry in dictionary
        P result = null;
        //store the to be removed answer in result
        if (contains(key)) {
            //store desired entry location in iterable variable: index
            int index = locateIndex(key);
            //pull answer for return, store in result
            result = dictionary[index].getPrompt();
            //while said location is within the entries we have (last entry is NOE - 1)
            while (index < numberOfEntries) {
                //the entry in the index to be removed shall be overwritten by the next entry
                dictionary[index] = dictionary[(index + 1)];
                //and we shall iterate until the last entry, moving each bacS one space
                //so we avoid holes in the array and maintain desired order
                index++;
            }
            numberOfEntries--;
        }
        return result;
    }

    public P getPrompt(K key) {
        if (contains(key))
            return dictionary[locateIndex(key)].getPrompt();
        else return null;
    }

    public boolean contains(K key) {
        if(dictionary[locateIndex(key)] != null && key.equals(dictionary[locateIndex(key)].getKey()))
            return true;
        else return false;
    }

    public void clear(){
        //while we have entries in array...
        while (numberOfEntries > 0){
            //set the last entry in the array to null repeatedly
            dictionary[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
    }
    public int getSize(){
        return numberOfEntries;
    }
    public boolean isEmpty(){
        //no entries in array = true
        if(numberOfEntries == 0) return true;
            //NOE > 0 = not empty
        else return false;
    }
    //iterates through subjects of dictionary, printing out the subject of each entry
    public void subjectIterator(){
        int index = 0;
        while (index < numberOfEntries){
            System.out.print(dictionary[index].getSubject() + " ");
            index++;
        }
        System.out.println();
    }
    //iterates through the answers of the dictionary, printing out the answer of each entry.
    public void answerIterator(){
        int index = 0;
        while (index < numberOfEntries){
            System.out.print(dictionary[index].getAnswer() + " ");
            index++;
        }
        System.out.println();
    }
    public LinkedQueue<NoteCard> makeQuiz(S subject, int numberOfQuestions){
        LinkedQueue<NoteCard> quiz = new LinkedQueue<>();
        int numberOfQueueEntries = 0;
        int availableQuestions = getNumberOfAvailableQuestions(subject);
        if (numberOfQuestions > availableQuestions){
            throw new InvalidParameterException("Number of questions has exceeded the maximum amount of: " + availableQuestions);
        }
        while((numberOfQueueEntries < numberOfQuestions))
        {
            int index = getRandomSubjectIndex(subject);
            if(quiz.isEmpty() || !quiz.hasEntry(dictionary[index]))
            {
                quiz.enqueue(dictionary[index]);
                numberOfQueueEntries++;
            }
        }
        return quiz;
    }

    private int getNumberOfAvailableQuestions(S subject)
    {
        int counter = 0;
        int index = getEntryPoint(subject);
        while(subject.equals(dictionary[index].getSubject()))
        {
            index++;
            counter++;
        }
        return counter;
    }
    private int getRandomSubjectIndex(S subject)
    {
        //first index of desired range
        int min = getEntryPoint(subject);
        //last index of desired range
        int max = min + getNumberOfAvailableQuestions(subject)-1;
        int rand = min + (int)(Math.random() * ((max - min) + 1));
        //random index within subject range
        return rand;
    }
}

