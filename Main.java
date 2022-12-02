package Hangman;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Words words = new Words();
        String randomWord = words.pickingRandomWord();
        randomWords(randomWord);
        

    }

    public static void randomWords(String randomWord) {
        char[] theWord = randomWord.toCharArray();
        char[] guessWord = new char[randomWord.length()];
        for(int i = 0;i < guessWord.length;i++){
            guessWord[i]= '*';
        }

        int countLifes = 10;
        System.out.println("You got " + countLifes + " lifes!");
       

        Scanner scanner = new Scanner(System.in);

        while (countLifes > 0) {
            System.out.println("Please input a letter from a to z ?");
            System.out.println(guessWord);

            String letterInWord = scanner.nextLine();
            char letters = letterInWord.charAt(0);

            boolean hasFoundLetter = false;
            for (int i = 0; i < theWord.length; i++) {
                if (theWord[i] == letters) {
                    guessWord[i] = letters;
                    hasFoundLetter = true;

                }

            }
            if(Arrays.equals(theWord, guessWord)) {
                System.out.println("Congrats, you won!");
                System.out.println(randomWord);
                break;
            }
            if (!hasFoundLetter) {
                countLifes--;
                if(countLifes == 0) {

                    System.out.println("You lost!");
                    System.out.println(randomWord);
                    break;
                }
            }

            System.out.println("You got " + countLifes + "lifes left!");
        }
        scanner.close();

    }

}
