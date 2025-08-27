package abstract_factory;

class TextFieldA extends TextField {
    public TextFieldA(String text) { super(text); }
    public void display() {
        System.out.println("[" + text + "]");
    }
}
