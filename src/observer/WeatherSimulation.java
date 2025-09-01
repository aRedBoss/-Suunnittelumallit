package observer;

public class WeatherSimulation {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        WeatherObserver display1 = new Display("Display 1");
        WeatherObserver display2 = new Display("Display 2");
        WeatherObserver display3 = new Display("Display 3");

        station.registerObserver(display1);
        station.registerObserver(display2);
        station.registerObserver(display3);

        station.start();

        try {
            Thread.sleep(15000);

            System.out.println("\n>>> Removing Display 2...\n");
            station.removeObserver(display2);

            Thread.sleep(15000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n>>> Ending simulation...");
        station.interrupt();
    }
}

