//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Frog and Toad Game
// Files: Game.java
// Course: CS 300, Summer, 2019
//
// Author: Jules Vigy
// Email: vigy@wisc.edu
// Lecturer's Name: Andrew Kuemmel
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        @SuppressWarnings("resource") // makes the compiler happy
        Scanner scan = new Scanner(System.in);
        System.out.println("How many frogs would you like to play with?");
        int frogNum = scan.nextInt();
        int gameBoardSize = frogNum * 2 + 1;
        char[] gameArray = new char[gameBoardSize];
        fillArray(gameArray, frogNum);
        printArray(gameArray);

        do {
            System.out.println("Enter an integer between 0 and " + gameBoardSize + ".");
            int move = scan.nextInt();
            System.out.println("You entered: " + move);
            handleMove(gameArray, move);
            printArray(gameArray);
        } while (!done(gameArray, frogNum));

    }

    private static void fillArray(char[] gameArray, int frogNum) {
        int i;
        for (i = 0; i < frogNum; i++) {
            gameArray[i] = 'F';
        }
        gameArray[frogNum] = '_';
        i += 1;

        for (; i < gameArray.length; i++) {
            gameArray[i] = 'T';
        }
    }

    private static void printArray(char[] gameArray) {
        for (int i = 0; i < gameArray.length; i++) {
            System.out.print(gameArray[i]);
        }
        System.out.println();
    }

    private static void handleMove(char[] gameArray, int move) {
        try {
            if (gameArray[move] == 'F') {
                if (move != gameArray.length - 1 && gameArray[move + 1] == '_') {
                    gameArray[move] = '_';
                    gameArray[move + 1] = 'F';
                } else if (move < gameArray.length - 2 && gameArray[move + 1] == 'T'
                    && gameArray[move + 2] == '_') {
                    gameArray[move] = '_';
                    gameArray[move + 2] = 'F';
                } else {
                    System.out.println("The frog at index " + move + " cannot move");

                }
            } else if (gameArray[move] == 'T') {
                if (move != 0 && gameArray[move - 1] == '_') {
                    gameArray[move] = '_';
                    gameArray[move - 1] = 'T';
                } else if (move >= 2 && gameArray[move - 1] == 'F' && gameArray[move - 2] == '_') {
                    gameArray[move] = '_';
                    gameArray[move - 2] = 'T';
                } else {
                    System.out.println("The toad at index " + move + " cannot move");
                }
            } else {
                System.out.println("The _ can not be moved.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Can not make this move at index " + move + "!");
        } catch (Exception e) {
            System.out.println("Can not make this move at index " + move + "!");
        }
    }

    private static boolean done(char[] gameArray, int frogNum) {
        int i;
        for (i = 0; i < frogNum; i++) {
            if (!(gameArray[i] == 'T')) {
                return false;
            }
        }
        if (!(gameArray[frogNum] == '_')) {
            return false;
        }
        i += 1;

        for (; i < gameArray.length; i++) {
            if (!(gameArray[i] == 'F')) {
                return false;
            }
        }
        System.out.println("Congrats you won!");
        return true;
    }
}
