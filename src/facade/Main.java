package facade;

public class Main {
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        try {
            // Chuck Norris joke
            String joke = facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Random joke: " + joke);

            // FX Rates API example (base currency)
            String baseCurrency = facade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest", "base");
            System.out.println("Base currency: " + baseCurrency);

            // Trigger error: wrong attribute
            facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random", "notAKey");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

