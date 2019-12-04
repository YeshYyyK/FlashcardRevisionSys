import javax.swing.*;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class funcs {
    //composes a static dictionary of static elements
    public DictionaryInterface<Integer, String, String, String> makeDictionary(){
        DictionaryInterface<Integer, String, String, String> dictionary = new SortedArrayDictionary<>();
        dictionary.add(1,"Spanish", "How do you say hello in spanish?", "Hola");
        dictionary.add(2,"Math", "What is an example of a variable?", "x");
        dictionary.add(3,"Math", "What is an example of a constant?", "pi");
        dictionary.add(4,"Math", "What is the perimeter of a square?", "4s");
        dictionary.add(5,"CS", "What is an example of a string?", "This is a string");
        return dictionary;
    }

public void useroption(){

    Scanner actioninput = new Scanner(System.in);
    String action = actioninput.next();
    if (action.equals("help")) {
        displayoptions();
    }else{
        calloption(action);

    }




}

public void calloption(String option){

    switch(option)
    {
        case "Quiz" :
            print("Starting Quizz");
            //stuff
            break;

        case "Multiplayer Quiz" :

            break;

        case "Add concepts" :

            break;

        default :
            print("Invalid option");
            print("Type in 'help' for options");


    }


}

public void displayoptions(){
    print("Quiz"); //uses queue
    print("Multiplayer Quiz"); //uses stack
    print("Add concepts"); //lets user add objects into dictionary
    print("TrueFalse Quiz"); //uses queue?
    // print("Review Quiz"); //lets the user go back
}


public void print(String printstring){
    System.out.println(printstring);
}

    public LinkedQueue<SortedArrayDictionary.NoteCard> makeQuiz(String subject, int numberOfQuestions){
        LinkedQueue<SortedArrayDictionary.NoteCard> quiz = new LinkedQueue<>();
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

    private int getNumberOfAvailableQuestions(String subject)
    {
        SortedArrayDictionary dictionary = new SortedArrayDictionary<>(100);
        int counter = 0;
        int index = makeDictionary().getEntryPoint(subject);
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
