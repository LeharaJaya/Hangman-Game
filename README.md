# Hangman-Game
Features:
Random Word Selection: The game will randomly choose a word from a predefined list.
User Input: The user can guess one letter at a time.
Guess Tracking: The game tracks correct and incorrect guesses.
Win/Loss Conditions: The game ends when the user guesses the word correctly or runs out of attempts.
Structure:
Game Logic: Handles word selection, user input, and checks for win/loss conditions.
Word Display: Displays the word with guessed letters revealed and unguessed letters as underscores.
Hangman Display: Shows the hangman figure as the user makes incorrect guesses.
Explanation:
Word Selection:

The game selects a random word from the predefined WORDS array using chooseRandomWord().
Word Display:

The word is displayed as underscores (_) initially. As the user guesses correct letters, they are revealed in place of the underscores.
User Input:

The user enters a single letter as their guess. If the guess is correct, the letter is revealed in the word. If incorrect, it is added to the list of wrong guesses, and the hangman figure progresses.
Hangman Display:

The displayHangman() method updates the hangman figure based on the number of remaining attempts, with a new part of the figure being drawn after each wrong guess.
Win/Loss Conditions:

The game checks if the word has been fully guessed by the player using isWordGuessed(). If all letters are guessed correctly, the player wins. If they run out of attempts, they lose, and the complete hangman figure is shown.
