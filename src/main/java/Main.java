/****
Project2 - Guess the Number
 **/

import java.util.Scanner;

public class Main {
    private static final String greetingMsg = "Hello! What is your name? ";
    private static final String askGuess = "Well, %s, I m thinking of a number between 1 and 20.\n" +
            "Take a guess. You have six tries for the game, good luck!\n ";
    private static final int randNumFrom = 1;
    private static final int randNumTo = 20;

    public static void main(String[] args) {
        final String urGuess = "Your guess: ";
        final String tooLo = " is too low, try again.";
        final String tooHi = " is too high, try again.";
        final String lost = "Game over, you lost.\n";
        final String win = " is correct. You win the game!!";
        final String again = "try again";

        //get a random number
        int randNum = getRandNum();
        //for testing only
        System.out.println(randNum);

        //User greeting and get inputs
        //Max 6 tries for a game
        Object usrAns = getUserInput(greetingMsg);
        if (usrAns instanceof String) {
            usrAns = (int)getUserInput(strInterpo(askGuess, (String) usrAns));
            for (int i = 0; i < 6; i++) {
                if ((int)usrAns == randNum) {
                    System.out.println(urGuess + usrAns + win);
                    break;
                } else if ((int)usrAns < randNum) {
                    if (i == 5) {
                        System.out.println(lost);
                        break;
                    }
                    System.out.println(urGuess + usrAns + tooLo);
                    usrAns = (int)getUserInput(again);
                    continue;
                } else if ((int)usrAns > randNum) {
                    if (i == 5) {
                        System.out.println(lost);
                        break;
                    }
                    System.out.println(urGuess + usrAns + tooHi);
                    usrAns = (int)getUserInput(again);
                    continue;
                }
            }
        }
    }

    //Method: get user input and return an object
    // based on the challenge message/ask string
    public static Object getUserInput(String askStr) {
        Scanner scanner = new Scanner(System.in);
        if (askStr.equals(greetingMsg)) {
            System.out.println(greetingMsg);
            return scanner.nextLine();
        } else {
            System.out.println(askStr);
            return scanner.nextInt();
        }
    }

    //Method: string interpolation
    // inserted interStr into mainStr where %s
    public static String strInterpo(String mainStr, String interStr) {
        return String.format(mainStr, interStr);
    }

    //Method: get a random number between 1 and 20
    public static int getRandNum() {
        //auto-generate a random integer between 1 and 20
        return (int)(Math.random() * randNumTo + randNumFrom);
    }

}
