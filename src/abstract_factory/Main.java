package abstract_factory;

public class Main {
    public static void main(String[] args) {

        UIFactory factoryA = new AFactory();
        Button buttonA = factoryA.createButton("Click Me");
        TextField textFieldA = factoryA.createTextField("Hello");
        Checkbox checkboxA = factoryA.createCheckbox("Accept Terms");

        System.out.println("Style A:");
        buttonA.display();
        textFieldA.display();
        checkboxA.display();

        buttonA.setText("Submit");
        System.out.println("\nAfter text change:");
        buttonA.display();

        UIFactory factoryB = new BFactory();
        Button buttonB = factoryB.createButton("Press");
        TextField textFieldB = factoryB.createTextField("World");
        Checkbox checkboxB = factoryB.createCheckbox("Subscribe");

        System.out.println("\nStyle B:");
        buttonB.display();
        textFieldB.display();
        checkboxB.display();
    }
}
