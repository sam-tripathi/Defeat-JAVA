import java.util.Scanner; 
import java.util.Random; 

class Game { 

	static Scanner input; 
	public static void hangman() 
	{ 
		input = new Scanner(System.in); 

		String[] company = { "Maruti", "Tata", "Suzuki", 
							"Ducati", "Toyota" }; 
		System.out.println( 
			" Welcome to HANGMAN GAME "); 

		Random obj = new Random(); 
		int Ran_num = obj.nextInt(5); 

		String word = (company[Ran_num]); 
		word = word.toUpperCase(); 

		String word1 = word.replaceAll("[A-Z]", "_ "); 
 
		System.out.println("let's play the game"); 
		startGame(word, word1); 
	} 
	public static void startGame(String word, String word1) 
	{  
		int guess_ = 0; 

		int wrong = 0; 
 
		String guess; 
		char letter; 

		boolean guessescontainsguess; 
		String guesses = ""; 
		boolean guessinword; 

		while (wrong < 5 && word1.contains("_")) { 

			System.out.println(word1 + "\n"); 
			int temp = 5 - wrong; 
			if (wrong != 0) { 

				System.out.println("You have " + temp 
								+ " guesses left."); 
			} 

			System.out.print("Your Guess:"); 
			guess = input.nextLine(); 
 			guess = guess.toUpperCase(); 
			letter = guess.charAt(0); 
			guessescontainsguess 
				= (guesses.indexOf(letter)) != -1; 
			guesses += letter; 
			letter = Character.toUpperCase(letter); 
			System.out.println(); 

			if (guessescontainsguess == true) { 

				System.out.println("You ALREADY guessed "
								+ letter + ". \n"); 
			} 

			guessinword = (word.indexOf(letter)) != -1; 
 
			if (guessinword == true) { 

				System.out.println( 
					letter + " is present in the word."); 
				System.out.print("\n"); 
 
				for (int position = 0; 
					position < word.length(); position++) { 

						if (word.charAt(position) == letter 
						&& word1.charAt(position) 
							!= letter) { 

						word1 = word1.replaceAll("_ ", "_"); 
						String word2; 
						word2 = word1.substring(0, position) 
								+ letter 
								+ word1.substring(position 
												+ 1); 
						word2 = word2.replaceAll("_", "_ "); 
						word1 = word2; 
					} 
				} 
			} 
 
			else { 

				System.out.println( 
					letter 
					+ " is not present in the word."); 
				wrong++; 
			} 

			guess_++; 

		} 
		if (wrong == 5) { 
			System.out.println( 
				"Oops you lost *_* maximum limit of incorrect guesses reached."); 
		} 
		else { 

      System.out.print( 
				"The word is: " + word1 
				+ "\n Great!! you did it :)"); 
		} 
	} 
	public static void main(String[] args) 
	{  
		hangman(); 
	} 
}
