package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {
    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;
    private final int MIN_TEMP = -10;
    private final int MAX_TEMP = 40;
    private Random rand = new Random();

    public WeatherStation() {

        this.temperature = rand.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
    }

    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
        System.out.println("Observer added.");
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
        System.out.println("Observer removed.");
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    private void updateTemperature() {
        int change = rand.nextBoolean() ? 1 : -1;
        temperature += change;

        if (temperature < MIN_TEMP) temperature = MIN_TEMP;
        if (temperature > MAX_TEMP) temperature = MAX_TEMP;

        System.out.println("\nWeatherStation: Temperature updated to " + temperature + "°C");
        notifyObservers();
    }

    @Override
    public void run() {
        while (true) {
            try {
                int sleepTime = rand.nextInt(5) + 1;
                Thread.sleep(sleepTime * 1000);

                updateTemperature();

            } catch (InterruptedException e) {
                System.out.println("WeatherStation interrupted.");
                break;
            }
        }
    }
}

