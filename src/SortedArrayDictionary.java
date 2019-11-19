import java.util.Arrays;

public class SortedArrayDictionary<K extends Comparable<? super K>, S, P, A > implements DictionaryInterface<K, S, P, A> {
        private Entry<K, S,P,A>[] dictionary;
        private int numberOfEntries;
        private boolean integrityOK = false;
        private final static int DEFAULT_CAPACITY = 50;
        private static final int MAX_CAPACITY = 10000;

        public SortedArrayDictionary(int initialCapacity){
            checkCapacity(initialCapacity);
            @SuppressWarnings("unchecked")
            Entry<K,S,P,A>[] tempDictionary = (Entry<K, S,P,A>[]) new Entry[initialCapacity];
            dictionary = tempDictionary;
            numberOfEntries = 0;
            integrityOK = true;
        }
        //default constructor
        public SortedArrayDictionary(){
            this(DEFAULT_CAPACITY);
        }
        private class Entry<K, S, P, A> {
            private K key;
            private S subject;
            private P prompt;
            private A answer;

            private Entry(K keyKey,S searchSubject, P prompting, A answering) {
                key = keyKey;
                subject = searchSubject;
                prompt = prompting;
                answer = answering;
            }
            private K getKey(){return key;}
            private S getSubject() {
                return subject;
            }
            private P getPrompt() {
                return prompt;
            }

            /**
             *  may remove later, use undetermined
             */
            private void setPrompt(P newPrompt) {
                prompt = newPrompt;
            }
            private A getAnswer(){
                return answer;
            }
            private void setAnswer(A newAnswer){ answer = newAnswer; }
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
        public A add(K key, S subject, P prompt, A answer) {
            checkIntegrity();
            if ((key == null) || (subject == null) || (prompt == null) || (answer == null))
                throw new IllegalArgumentException();
            else {
                A result = null;
                int keyIndex = locateIndex(key);
                //case where key is found. simply replace entry answer
                if (keyIndex < numberOfEntries && key.equals(dictionary[keyIndex].getKey())) {
                    result = dictionary[keyIndex].getAnswer();
                    dictionary[keyIndex].setAnswer(answer);
                }//end if
                //otherwise, this will be a new entry
                else {
                    makeRoom(keyIndex);
                    dictionary[keyIndex] = new Entry<>(key, subject, prompt, answer);
                    numberOfEntries++;
                    ensureCapacity();
                }
                return result;
            }
        }
        //changed to also find where to make the insertion into the array
    //returns the index of the entry that contains the subject or the location that should have it, if no entry exists
        private int locateIndex(K key){
            int index = 0;
            while ((index < numberOfEntries) &&
                    //compare answer of inputted subject to the current subject in iteration
                    //if return int > 0 then subject should be later in list, so we iterate further
                    key.compareTo(dictionary[index].getKey()) > 0)
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
        public A remove(K key){
            //covering case where subject does not have an entry in dictionary
            A result = null;
            //store the to be removed answer in result
            if (contains(key)) {
                //store desired entry location in iterable variable: index
                int index = locateIndex(key);
                //pull answer for return, store in result
                result = dictionary[index].getAnswer();
                //while said location is within the entries we have (last entry is NOE - 1)
                while (index < numberOfEntries) {
                    //the entry in the index to be removed shall be overwritten by the next entry
                    dictionary[index] = dictionary[index + 1];
                    //and we shall iterate until the last entry, moving each bacS one space
                    //so we avoid holes in the array and maintain desired order
                    index++;
                }
                numberOfEntries--;
            }
            return result;
        }

        public A getAnswer(K key) {
            if (contains(key))
                return dictionary[locateIndex(key)].getAnswer();
            else return null;
        }

        public boolean contains(K key) {
            if(dictionary[locateIndex(key)] != null && key.equals(dictionary[locateIndex(key)].getSubject()))
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
                System.out.print(dictionary[index].getKey() + " ");
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
    }

