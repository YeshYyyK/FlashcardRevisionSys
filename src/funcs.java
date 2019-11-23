import javax.swing.*;
import java.util.Scanner;

public class funcs {

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


}
