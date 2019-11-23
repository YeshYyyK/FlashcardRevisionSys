import javax.swing.*;
import java.util.Scanner;

public class funcs {

public void useroption(){

    System.out.println("What do you want to do?");
    System.out.println("Type in 'help' for options");

    Scanner actioninput = new Scanner(System.in);
    String action = actioninput.nextLine();
    if (action == "help") {
        displayoptions();
    }else{

        

    }




}

public void calloption(String option){

    switch(option)
    {
        case "Quiz" :
            //stuff
            break;

        case "Multiplayer Quiz" :

            break;

        case "Add concepts" :

            break;

        default :
            print("Invalid option");


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
