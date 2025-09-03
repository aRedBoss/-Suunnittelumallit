package state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameCharacter character = new GameCharacter("Aria");

        while (!(character.getExperience() >= 300)) {
            character.displayStatus();
            System.out.print("Choose action (train/meditate/fight): ");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "train":
                    character.train();
                    break;
                case "meditate":
                    character.meditate();
                    break;
                case "fight":
                    character.fight();
                    break;
                default:
                    System.out.println("Invalid action.");
            }
            System.out.println();
        }

        System.out.println("🎉 Congratulations! You've reached Master level. Game over.");
    }
}

