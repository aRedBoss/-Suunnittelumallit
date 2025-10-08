package facade;

public class Main {
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        try {
            String joke = facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Random joke: " + joke);

            String baseCurrency = facade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest", "base");
            System.out.println("Base currency: " + baseCurrency);

            facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random", "notAKey");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

