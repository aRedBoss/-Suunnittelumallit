package template_method;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors extends Game {
    private int roundsToPlay;
    private int currentRound;
    private int[] scores;
    private Random random;
    private Scanner scanner;

    @Override
    public void initializeGame(int numberOfPlayers) {
        scanner = new Scanner(System.in);
        random = new Random();
        scores = new int[numberOfPlayers];
        currentRound = 0;

        System.out.print("Enter number of rounds to play: ");
        roundsToPlay = scanner.nextInt();
        System.out.println("Game started with " + numberOfPlayers + " players for " + roundsToPlay + " rounds.\n");
    }

    @Override
    public boolean endOfGame() {
        return currentRound >= roundsToPlay;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println("Round " + (currentRound + 1) + " - Player " + (player + 1) + "'s turn");

        System.out.print("Choose (0 = Rock, 1 = Paper, 2 = Scissors): ");
        int playerChoice = scanner.nextInt();

        int computerChoice = random.nextInt(3);
        System.out.println("Computer chose: " + choiceToString(computerChoice));

        int result = (3 + playerChoice - computerChoice) % 3;
        if (result == 1) {
            System.out.println("Player " + (player + 1) + " wins this round!\n");
            scores[player]++;
        } else if (result == 2) {
            System.out.println("Computer wins this round!\n");
        } else {
            System.out.println("It's a draw!\n");
        }

        currentRound++;
    }

    @Override
    public void displayWinner() {
        int maxScore = -1;
        int winner = -1;

        for (int i = 0; i < scores.length; i++) {
            System.out.println("Player " + (i + 1) + " score: " + scores[i]);
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                winner = i;
            }
        }

        if (maxScore == 0) {
            System.out.println("No winners this time!");
        } else {
            System.out.println("Player " + (winner + 1) + " is the winner!");
        }
    }

    private String choiceToString(int choice) {
        return switch (choice) {
            case 0 -> "Rock";
            case 1 -> "Paper";
            case 2 -> "Scissors";
            default -> "Unknown";
        };
    }
}

