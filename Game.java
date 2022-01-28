//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Frog and Toad Game
// Files: Game.java
// Description: This program allows the user to play frogs and toads game.
// The game is a simple command line game. Where the user can input commands.
// Author: Jules Vigy
// Email: jules.vigy@aol.com
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Scanner;

public class Game {

  /**
    Main method for frogs and toads.
  */
  public static void main(String[] args) {
    @SuppressWarnings("resource") // makes the compiler happy
    Scanner scan = new Scanner(System.in);
    System.out.println("How many frogs would you like to play with?");
    int frogNum = scan.nextInt();
    int gameBoardSize = frogNum * 2 + 1;
    char[] gameArray = new char[gameBoardSize];
    fillArray(gameArray, frogNum);
    printArray(gameArray);

    do { // do while loop to start the game
      System.out.println(
        "Enter an integer between 0 and " + gameBoardSize + "."
      );
      int move = scan.nextInt();
      System.out.println("You entered: " + move);
      handleMove(gameArray, move);
      printArray(gameArray);
    } while (!done(gameArray, frogNum));
  }

  /**
    Method to intialize game board.
  */
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

  /**
    Method used to print the state of the game.
  */
  private static void printArray(char[] gameArray) {
    for (int i = 0; i < gameArray.length; i++) {
      System.out.print(gameArray[i]);
    }
    System.out.println();
  }

  /**
    Method to handle the user's move.
  */
  private static void handleMove(char[] gameArray, int move) {
    try {
      if (gameArray[move] == 'F') {
        if (move != gameArray.length - 1 && gameArray[move + 1] == '_') {
          gameArray[move] = '_';
          gameArray[move + 1] = 'F';
        } else if (
          move < gameArray.length - 2 &&
          gameArray[move + 1] == 'T' &&
          gameArray[move + 2] == '_'
        ) {
          gameArray[move] = '_';
          gameArray[move + 2] = 'F';
        } else {
          System.out.println("The frog at index " + move + " cannot move");
        }
      } else if (gameArray[move] == 'T') {
        if (move != 0 && gameArray[move - 1] == '_') {
          gameArray[move] = '_';
          gameArray[move - 1] = 'T';
        } else if (
          move >= 2 && gameArray[move - 1] == 'F' && gameArray[move - 2] == '_'
        ) {
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

  /**
    Method to check if the game is done.
  */
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
