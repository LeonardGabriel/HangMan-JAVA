import java.util.Random;
import java.util.Scanner;

public class Main {

    private static String[] words = {"terminator", "computer", "web", "cow", "rain", "water"};
    private static String wordToFind = words[(int) (Math.random() * words.length)];
    private static String asterisk = new String(new char[wordToFind.length()]).replace("\0", "*");
    private static int count = 0;
    private static String choice;
    private static char choiceToPlay;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        do {

            System.out.print("Do you want to play hangman? [Y/N]: ");
            choice = scan.nextLine();
            choiceToPlay = choice.charAt(0);

            if (!(choiceToPlay == 'Y' || choiceToPlay == 'y' || choiceToPlay == 'N' || choiceToPlay == 'n')) {

                System.out.println("You have entered an invalid option. Try again!");

            }

        }while (!(choiceToPlay == 'Y' || choiceToPlay == 'y' || choiceToPlay == 'N' || choiceToPlay == 'n'));


        if (choiceToPlay == 'N' || choiceToPlay == 'n') {
            System.out.println("You have choosen to leave the game!");
            System.out.println("GoodBye!");
            System.exit(0);

        } else {

            while (count < 7 && asterisk.contains("*")) {
                System.out.println("Guess any letter in the word");
                System.out.println(asterisk);
                String guess = scan.next();
                hang(guess);
            }
        }
        
        scan.close();

    }

    public static void hang(String guess){

        String newAsterisk = "";

            for (int i = 0; i < wordToFind.length(); i++) {
                if (wordToFind.charAt(i) == guess.charAt(0)) {
                    newAsterisk += guess.charAt(0);
                } else if (asterisk.charAt(i) != '*') {
                    newAsterisk += wordToFind.charAt(i);
                } else {
                    newAsterisk += "*";
                }
            }


        if(asterisk.contains(newAsterisk)){
            count++;
            hangManImage();
        } else {
            asterisk = newAsterisk;
        }

        if(asterisk.equals(wordToFind)) {
            System.out.println("Corret! You win the game! The word was: " + wordToFind);
        }

    }

    public static void hangManImage(){
        if (count == 1) {
            System.out.println("Wrong guess, try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (count == 2) {
            System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 3) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (count == 4) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 5) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 6) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (count == 7) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.println("GAME OVER! The word was " + wordToFind);
        }
    }

}

