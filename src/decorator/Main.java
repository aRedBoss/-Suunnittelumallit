package decorator;

public class Main {
    public static void main(String[] args) {
        Printer printer1 = new BasicPrinter();
        printer1.print("Hello World!");

        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");
    }
}

