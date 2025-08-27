package composite;

public class Main {
    public static void main(String[] args) {

        Organization org = new Organization("Headquarters");

        Department it = new Department("IT");
        Department hr = new Department("HR");
        Department rAndD = new Department("R&D");

        Employee alice = new Employee("Alice", 4000);
        Employee bob = new Employee("Bob", 5000);
        Employee carol = new Employee("Carol", 3500);
        Employee dave = new Employee("Dave", 6200);
        Employee eva = new Employee("Eva", 5800);

        it.add(alice);
        it.add(bob);

        hr.add(carol);

        rAndD.add(dave);
        rAndD.add(eva);

        org.getRoot().add(it);
        org.getRoot().add(hr);
        org.getRoot().add(rAndD);

        System.out.println("Total salary of the organization:");
        org.printTotalSalary();

        System.out.println("\nOrganization structure in XML:");
        org.printXML();

        Employee newHire = new Employee("Frank", 4200);
        hr.add(newHire);
        hr.remove(newHire);

        System.out.println("\nAfter add/remove demonstration, total salary:");
        org.printTotalSalary();

        System.out.println("\nXML again:");
        org.printXML();
    }
}
