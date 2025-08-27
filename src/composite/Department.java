package composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department implements OrganizationComponent {
    private final String name;
    private final List<OrganizationComponent> children = new ArrayList<>();

    public Department(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Department name must not be blank.");
        }
        this.name = name;
    }

    @Override
    public void add(OrganizationComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("component must not be null");
        }
        children.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        children.remove(component);
    }

    public List<OrganizationComponent> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public double getSalary() {
        double sum = 0.0;
        for (OrganizationComponent c : children) {
            sum += c.getSalary();
        }
        return sum;
    }

    @Override
    public String toXML() {
        return toXML(0);
    }

    @Override
    public String toXML(int indent) {
        String pad = "  ".repeat(Math.max(0, indent));
        StringBuilder sb = new StringBuilder();
        sb.append(pad).append("<department name=\"").append(escape(name)).append("\">").append("\n");
        for (OrganizationComponent c : children) {
            sb.append(c.toXML(indent + 1)).append("\n");
        }
        sb.append(pad).append("</department>");
        return sb.toString();
    }

    private static String escape(String s) {
        return s
                .replace("&", "&amp;")
                .replace("\"", "&quot;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
}
