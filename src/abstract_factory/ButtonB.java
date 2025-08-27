package abstract_factory;

class ButtonB extends Button {
    public ButtonB(String text) { super(text); }
    public void display() {
        System.out.println("/" + "*".repeat(text.length() + 2) + "\\");
        System.out.println("* " + text + " *");
        System.out.println("\\" + "*".repeat(text.length() + 2) + "/");
    }
}

