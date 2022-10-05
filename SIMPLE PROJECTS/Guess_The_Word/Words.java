import java.util.Random;

public class Words {
    
    private String[] randomWords = {"animal","happiness","infinite","steady","birthday","extreme","rights","properties","ceremony",
        "independent","information","teacher","student","school","dinner","teamwork","stubborn","fast","sad",
"dangerous","century","distance","sunrise"};

    private String selectedWords;
    private Random random = new Random();
    private char[] letters;

    public Words() {
        selectedWords = randomWords[random.nextInt(randomWords.length)];
        letters = new char[selectedWords.length()];
    }

    public String toString() {

        StringBuilder text = new StringBuilder();
        
        for(char letter: letters) {

            text.append(letter == '\u0000' ? '-' : letter);
           
            text.append(' ');
        }
        return text.toString();

    }

    public boolean isGuessRight() {

        for(char letter: letters) {
            if(letter == '\u0000') {
                return false;
            }
        }
        return true;
    }

    public boolean guess(char letter) {

        boolean guessRight = false;

        for(int i=0; i<selectedWords.length(); i++) {
            if(letter == selectedWords.charAt(i)) {
                letters[i] = letter;
                guessRight = true;
            }
        }
        return guessRight;
    }   
}
