/**
 * DemoClass.java Driver class that uses methods from AssistantJack and Theory classes to find the right
 * combination of murderer, item, and location to solve the mystery in less than 20 tries
 *
 * @author    Matt Aros<matthew.aros@gmail.com>
 * @version   1.0
 *
 * Algorithm:
 *    1. Import the AssistantJack, Theory, and Scanner classes and create corresponding objects named jack, rightCombo,
 *            and keyboard respectively
 *    2. Declare int variables selection, theoryTest, area, item, and person
 *    3. Declare and initialize boolean variable found to false
 *    4. Initialize area, item, and person to 1, each representing the first option
 *    5. Prompt and read user input for the theory they would like to test and store the input in selection
 *    6. Pass in selection into the AssistantJack object to create the right combination
 *    7. In a while loop that iterates until found is true
 *            7a. Initialize theoryTest to jack.checkanswer(item, area, person)
 *            7b. Check if theorytest == 1, if so increment item
 *            7c. Check if theorytest == 2, if so increment area
 *            7d. Check if theorytest == 3, if so increment person
 *            7e. Check if theorytest == 0, if so the solution has been found and exit the loop
 *    8. Store the correct item, area, and person in rightCombo
 *    9. Display report showing the total tries, correct theory and if the mystery was solved in less than 20
 *       tries
 */



package edu.miracosta.cs113;

import model.AssistantJack;
import model.Theory;
import java.util.Scanner;

public class DemoClass
{
    public static void main(String [] args)
    {
        int selection, theoryTest, area = 1, item = 1, person = 1;

        Scanner keyboard = new Scanner(System.in);
        AssistantJack jack;
        Theory rightcombo;
        boolean found = false;

        // prompt and read user input
        System.out.println("Please select a theory to test:");
        System.out.println("\tTheory 1\n\tTheory 2\n\tTheory 3");
        System.out.print("Enter Selection:");
        selection = keyboard.nextInt();

        // jack will create the answer combination based on user input
        jack = new AssistantJack(selection);

        // loop until solution is found
        while(found == false) {

            // create theory combo
            theoryTest = jack.checkAnswer(item, area, person);

            if(theoryTest == 1) {
                item++;   // wrong item
            }
            else if(theoryTest == 2) {
                area++;   // wrong area
            }
            else if(theoryTest == 3) {
                person++;  //wrong person
            }
            else if(theoryTest == 0) {
                found = true; //break loop
            }
        }

        // save solution
        rightcombo = new Theory(item, area, person);

        // display report
        System.out.println("Total Tries: " + jack.getTimesAsked());
        System.out.println("The correct theory is " + rightcombo + "\n\n");

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        }
        else {
            System.out.println("WOW! You might as well be called Batman!");
        }
    }
}

