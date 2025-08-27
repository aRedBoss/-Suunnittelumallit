package abstract_factory;

class ButtonA extends Button {
    public ButtonA(String text) { super(text); }
    public void display() {
        System.out.println("+" + "-".repeat(text.length() + 2) + "+");
        System.out.println("| " + text + " |");
        System.out.println("+" + "-".repeat(text.length() + 2) + "+");
    }
}
