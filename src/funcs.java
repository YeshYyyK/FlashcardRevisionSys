import javax.swing.*;
import java.security.InvalidParameterException;
import java.util.Queue;
import java.util.Scanner;

public class funcs {
    //composes a static dictionary of static elements
    private DictionaryInterface<Integer, String, String, String> dictionary = new SortedArrayDictionary<>(100);
    public DictionaryInterface<Integer, String, String, String> makeDictionary(){
        dictionary.add(1,"Spanish", "How do you say hello in spanish?", "Hola");
        dictionary.add(2,"Math", "What is an example of a variable?", "x");
        dictionary.add(3,"Math", "What is an example of a constant?", "pi");
        dictionary.add(4,"Math", "What is the perimeter of a square?", "4s");
        dictionary.add(5,"CS", "What is an example of a string?", "This is a string");
        return dictionary;
    }
    NoteCard tempCard = new NoteCard(null, null, null, null);
    LinkedQueue testQueue = dictionary.makeQuiz("Math", 3);

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

//makes and displays the quiz
//takes in a linked queue with all notecards needed for the quiz
public void displayQuiz(LinkedQueue<NoteCard> quiz){

}
public LinkedQueue getWrongAnswers(String correctAnswer, String subject){
    //grabs the subject from the single subject queue so we can search through relevant dictionary entries
    String subject = (String) quiz.getFront().getSubject();
}




}
