package observer;

public class Display implements WeatherObserver {
    private String name;

    public Display(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " received update: Current temperature is " + temperature + "°C");
    }
}

