import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static final String[] WORDS = {"JAVA", "PROGRAMMING", "COMPUTER", "HANGMAN", "DEVELOPER", "SOFTWARE"};
    private static final int MAX_ATTEMPTS = 6;

    private String wordToGuess;
    private char[] wordDisplay;
    private List<Character> incorrectGuesses;
    private int attemptsRemaining;

    public Hangman() {
        wordToGuess = chooseRandomWord();
        wordDisplay = new char[wordToGuess.length()];
        incorrectGuesses = new ArrayList<>();
        attemptsRemaining = MAX_ATTEMPTS;

        // Initialize word display with underscores
        for (int i = 0; i < wordToGuess.length(); i++) {
            wordDisplay[i] = '_';
        }
    }

    // Chooses a random word from the predefined list
    private String chooseRandomWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }

    // Starts the game
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (attemptsRemaining > 0 && !isWordGuessed()) {
            displayWord();
            displayHangman();
            System.out.println("Incorrect guesses: " + incorrectGuesses);
            System.out.print("Guess a letter: ");
            char guess = scanner.nextLine().toUpperCase().charAt(0);

            if (isValidGuess(guess)) {
                processGuess(guess);
            } else {
                System.out.println("Invalid input. Please guess a single letter.");
            }
        }

        if (isWordGuessed()) {
            System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
        } else {
            System.out.println("Game Over! The word was: " + wordToGuess);
            displayHangman();
        }

        scanner.close();
    }

    // Checks if the word is fully guessed
    private boolean isWordGuessed() {
        for (char c : wordDisplay) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    // Displays the word with guessed letters and underscores
    private void displayWord() {
        System.out.print("Word: ");
        for (char c : wordDisplay) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // Checks if the guess is valid (single letter and not already guessed)
    private boolean isValidGuess(char guess) {
        return Character.isLetter(guess) && !incorrectGuesses.contains(guess) && !new String(wordDisplay).contains(String.valueOf(guess));
    }

    // Processes the guessed letter
    private void processGuess(char guess) {
        boolean isCorrect = false;

        // Check if the guessed letter is in the word
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                wordDisplay[i] = guess;
                isCorrect = true;
            }
        }

        // If guess is incorrect, add to incorrect guesses and reduce attempts
        if (!isCorrect) {
            incorrectGuesses.add(guess);
            attemptsRemaining--;
            System.out.println("Wrong guess! Attempts remaining: " + attemptsRemaining);
        }
    }

    // Displays the hangman figure based on the number of remaining attempts
    private void displayHangman() {
        switch (attemptsRemaining) {
            case 6 -> System.out.println("  +---+\n      |\n      |\n      |\n     ===");
            case 5 -> System.out.println("  +---+\n  O   |\n      |\n      |\n     ===");
            case 4 -> System.out.println("  +---+\n  O   |\n  |   |\n      |\n     ===");
            case 3 -> System.out.println("  +---+\n  O   |\n /|   |\n      |\n     ===");
            case 2 -> System.out.println("  +---+\n  O   |\n /|\\  |\n      |\n     ===");
            case 1 -> System.out.println("  +---+\n  O   |\n /|\\  |\n /    |\n     ===");
            case 0 -> System.out.println("  +---+\n  O   |\n /|\\  |\n / \\  |\n     ===");
        }
    }

    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.start();
    }
}
