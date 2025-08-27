package abstract_factory;

class CheckboxB extends Checkbox {
    public CheckboxB(String text) { super(text); }
    public void display() {
        System.out.println("[X] " + text);
    }
}
