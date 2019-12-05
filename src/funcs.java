import javax.swing.*;
import java.security.InvalidParameterException;
import java.util.Queue;
import java.util.Scanner;

public class funcs {



    public void CreateCollection{

        DictionaryInterface<Integer, String, String, String> collection = new SortedArrayDictionary<>();
        collection.add(1,"Math", "What is the x axis","horizontal line");
        collection.add(2,"Math","What is an example of a variable?","x");
        collection.add(3, "Math","What is an example of a constant?","pi");
        collection.add(4, "Math","What is the perimeter of a square?","4 x sides");
        collection.add(5, "Math","What is the area of a rectangle?","length times width");
        collection.add(6, "Math","What is the volume of a rectangular prism?","lwh");
        collection.add(7, "Math","What is the circumference?","perimeter of a circle");
        collection.add(8, "Math","What does a function do?","gives an output with an input");
        collection.add(9, "Math","What is a sum?","addition of numbers");
        collection.add(10, "Math","What is a quotient?","division of numbers");
        collection.add(11, "Math","What is a product?","multiplication of numbers");
        collection.add(12, "Math","What is the derivative?","rate of change");
        collection.add(13, "Math","What is a prime number divisible by?","1 and itself");
        collection.add(14, "Math","What is an inverse of a number?","1 divided by that number");
        collection.add(15, "CS","What is an example of a string?","This is a string");
        collection.add(16, "CS","What is an array?","collection of elements");
        collection.add(17, "CS","What is a queue?","a FIFO collection of elements");
        collection.add(18, "CS","What is a stack?","a LIFO collection of elements");
        collection.add(19, "CS","What is an exception?","error handling technique");
        collection.add(20, "CS","What is a linked list?","linked collection of nodes");
        collection.add(21, "CS","What is a method?","it performs processes");
        collection.add(22, "CS","What is recursion?","when a function calls itself");
        collection.add(23, "CS","What is a get method?","It gets the data from the object");
        collection.add(24, "CS","What is a set method?","It sets the objects' data");
        collection.add(25,"English","What is a similie?","Compares using 'as' or 'like'");
        collection.add(26,"English","What is an irony?","Uses contrary for effect");
        collection.add(27,"English","What is a metaphor?","Applying a word for comparison");
        collection.add(28,"English","What is a hyperbole?","Exaggerations");
        collection.add(29,"English","What is an aliteration?","Phrases' words that start with the same sound");


        public int totalCollection = 29;


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
            print("Starting Quiz");
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
    // print("Review Quiz"); //lets the user go back
}


public void displayquiz(LinkedQueue<NoteCard> input){

        //takes the output of makequiz - queue
    int correctanswers = 0;
    int totalquestions = 0;
    NoteCard<Integer, String, String, String> placeholder= new NoteCard<>(null,null,null,null);
    String rightanswer;

        while (!input.isEmpty()){

           placeholder = input.dequeue();
           rightanswer = placeholder.getAnswer();
           Math.random();


    }

        // loops the number of notecards in the queue
        // counters for correct answers and total questions
        // retrieve right answer from current notecard - using getfront or otherwise
        // use math.random to place it in 1-4 (of an array?)
        // use getwronganswers to fill in the other slots
        // displays prompt from notecard
        // displays answers from array
        // let user input a letter/number of the answer - using scanner
        // comparison to see if it is the right answer
        // increment correct answers and total questions accordingly
        // repeat loop

        // correct / total = score/whatever



}


public void multiplayerquiz(){


}


public void addconcepts(){
        //scanner that asks 3 times for subject, prompt, answer
        // key = totalCollection + 1
        // totalcollection++

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
