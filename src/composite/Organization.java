package composite;

public class Organization {
    private final Department root;

    public Organization(String rootDepartmentName) {
        this.root = new Department(rootDepartmentName);
    }

    public Department getRoot() {
        return root;
    }

    public void printTotalSalary() {
        root.printTotalSalary();
    }

    public void printXML() {
        root.printXML();
    }

    public double getTotalSalary() {
        return root.getSalary();
    }
}
