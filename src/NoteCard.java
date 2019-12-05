public class NoteCard<K, S, P, A> {
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