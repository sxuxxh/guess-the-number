/****
Project2 - Guess the Number
 **/

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String greetingMsg = "Welcome to Guess The Number! What is your name? ";
    private static final String askGuess = "Well, %s, I m thinking of a number between 1 and 20." +
            "Take a guess. You have 6-try for the game, good luck!\n ";
    private static final int randNumFrom = 1;
    private static final int randNumTo = 20;
    private static final String quitOrNot = "Enter \"q\" to quit the game and any other key to continue.";
    private static final String badName = "Wrong input, please enter your name.";
    private static final String badGuess = "Wrong input, please enter a number between 1 and 20.";
    private static final String tryLeft = " You have %s-try left.";

    public static void main(String[] args) {
        final String urGuess = "Your guess: ";
        final String tooLo = " is too low, try again.";
        final String tooHi = " is too high, try again.";
        final String lost = "Game over, you lost.\n";
        final String win = " is correct. You win the game!!";
        final String exMsg1 = "Something is wrong with your input. Here is the stacktrace...";
        final String bye = "Goodbye, see you again!";

        //User greeting and get name
        //Max 6 tries for a game
        String usrName = getUserName();

        do {
            //get a random number
            int randNum = getRandNum();
            //print it for testing only
            System.out.println("The secret number is: " + Integer.toString(randNum));

            System.out.println(strInterpo(askGuess, usrName));
            try {
                int usrGuess = Integer.parseInt(getGuess());
                for (int i = 0; i < 6; i++) {
                    if (usrGuess == randNum) {
                        System.out.println(urGuess + usrGuess + win);
                        break;
                    } else if (usrGuess < randNum && usrGuess != -1) {
                        if (i == 5) {
                            System.out.println(lost);
                            break;
                        }
                        System.out.println(urGuess + usrGuess + tooLo + strInterpo(tryLeft, Integer.toString(5-i)));
                        usrGuess = Integer.parseInt(getGuess());
                    } else if ((usrGuess > randNum && usrGuess != -1)) {
                        if (i == 5) {
                            System.out.println(lost);
                            break;
                        }
                        System.out.println(urGuess + usrGuess + tooHi + strInterpo(tryLeft, Integer.toString(5-i)));
                        usrGuess = Integer.parseInt(getGuess());
                    }
                }
            } catch (Exception e) {
                System.out.println(exMsg1);
                e.printStackTrace();
            }
        } while (!stayOrQuit());
        System.out.println(bye);
    }

    //Method: continue to play or exit
    public static boolean stayOrQuit() {
        System.out.println(quitOrNot);
        String quit = scanner.next();
        return quit.equals("q");
    }

    //Method: get user name
    public static String getUserName() {
        System.out.println(greetingMsg);
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            System.out.println(badName);
            e.printStackTrace();
            return "-1";
        }
    }

    //Method: get user guess number as string
    public static String getGuess() {
        try {
            return scanner.next();
        } catch (Exception e) {
            System.out.println(badGuess);
            e.printStackTrace();
            return "-1";
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
