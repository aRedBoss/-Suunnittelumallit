package factory_method;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Map map = createMap();
        map.display();
    }

    public static Map createMap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose map type: 1 - City, 2 - Wilderness");
        int choice = scanner.nextInt();

        if (choice == 1) {
            return new CityMap(10, 10); // Example size
        } else {
            return new WildernessMap(10, 10);
        }
    }
}
