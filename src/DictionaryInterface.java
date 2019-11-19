public interface DictionaryInterface<S,P,A> {
    /**
     * Adds new entry to dictionary, finding it's correct location by comparing it's key to other entries
     * If search key already exists, replaces corresponding value.
     * @param subject obj search key of the new entry.
     * @param prompt obj associated with search key
     * @param answer obj associated with search key
     * @return null if new entry was added or the value that was replaced if key already had an entry
     */
    public A add(S subject, P prompt, A answer);
    /**
     * removes given entry from dictionary
     * @param subject obj search key of entry being removed.
     * @return answer associated with search key of null if key DNE
     */
    public A remove(S subject);
    /**
     * retrieves the value associated with given search key
     * @param subject obj search key of entry to be retrieved.
     * @return Either the answer that is associated with the search key or null if no such obj exists.
     */
    public A getAnswer(S subject);
    /**
     * Checks if given entry is in the dictionary
     * @param subject obj search key of desired entry
     * @return True if subject is associated with some entry in the dictionary.
     */
    public boolean contains(S subject);
    /**
     * checks if dictionary is empty
     * @return true if empty.
     */
    public boolean isEmpty();
    /**
     * Gets the size of the dictionary.
     * @return # of entries (subject-prompt-answer triples) currently in dictionary
     */
    public int getSize();
    /**
     * removes all entries from this dictionary
     */
    public void clear();
}
