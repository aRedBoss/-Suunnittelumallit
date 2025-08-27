package composite;

public interface OrganizationComponent {
    default void add(OrganizationComponent component) {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " can't contain children.");
    }

    default void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " can't contain children.");
    }

    double getSalary();

    String toXML();

    default String toXML(int indent) {
        return toXML();
    }

    default void printTotalSalary() {
        System.out.println(getSalary());
    }

    default void printXML() {
        System.out.println(toXML(0));
    }
}
