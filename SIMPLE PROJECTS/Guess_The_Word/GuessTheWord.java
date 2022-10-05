import java.util.Scanner;

public class GuessTheWord {

    private boolean play = true;
    private Words randomWords = new Words();
    private Scanner scanner = new Scanner(System.in);
    private int rounds = 15;
    private char lastRound;
    
    public void start() {

        do {
            showWord();
            getInput();
            checkInput();

        }while(play);
    }

    void showWord() {
        System.out.println("You have "  +rounds+ " tries left");
        System.out.println(randomWords);
    }

    void getInput() {
        System.out.println("enter a letter to guess word:");
        String userGuess = scanner.nextLine();

        lastRound = userGuess.charAt(0);
        
    }

    void checkInput() {
        boolean isGuessRight = randomWords.guess(lastRound);
        
        if(isGuessRight) {
           if(randomWords.isGuessRight()) {
              System.out.println("Congratulation You WON!!");
              System.out.println("the word is:" +randomWords);
              play = false;
            }
        }
        else {
            rounds--;

            if(rounds == 0) {
                System.out.println("game over !!!");
                play = false;
            }
        }
    }

    public void end() {
        scanner.close();
    }
}