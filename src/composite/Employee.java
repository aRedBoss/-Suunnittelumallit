package composite;

public class Employee implements OrganizationComponent {
    private final String name;
    private final double salary;

    public Employee(String name, double salary) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Employee name must not be blank.");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Salary must be non-negative.");
        }
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toXML() {
        return toXML(0);
    }

    @Override
    public String toXML(int indent) {
        String pad = "  ".repeat(Math.max(0, indent));
        // Simple XML; attributes hold leaf data
        return String.format(
                "%s<employee name=\"%s\" salary=\"%.2f\"/>",
                pad, escape(name), salary
        );
    }

    private static String escape(String s) {
        return s
                .replace("&", "&amp;")
                .replace("\"", "&quot;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
}
