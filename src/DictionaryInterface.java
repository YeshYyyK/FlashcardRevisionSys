public interface DictionaryInterface<K,S,P,A> {
    /**
     * Adds new entry to dictionary, finding it's correct location by comparing it's key to other entries
     * If search key already exists, replaces corresponding value.
     * Keys for entries are generated automatically, and are equal to the number of entries in the dictionary
     * at the time of addition
     * @param key obj search key of the new entry
     * @param subject obj subject of the new entry
     * @param prompt obj associated with search key
     * @param answer obj associated with search key
     * @return null if new entry was added or the value that was replaced if key already had an entry
     * if a new entry is created it will be given some integer key NOE
     */
    public A add(K key, S subject, P prompt, A answer);
    /**
     * removes given entry from dictionary
     * @param key obj search key of entry being removed.
     * @return prompt associated with search key of null if key DNE
     */
    public P remove(K key);
    /**
     * retrieves the value associated with given search key
     * @param key obj search key of entry to be retrieved.
     * @return Either the prompt that is associated with the search key or null if no such obj exists.
     */
    public P getPrompt(K key);
    /**
     * Checks if given entry is in the dictionary
     * @param key obj search key of desired entry
     * @return True if subject is associated with some entry in the dictionary.
     */
    public boolean contains(K key);
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
    public void subjectIterator();

    public int locateIndex(K key);
}
