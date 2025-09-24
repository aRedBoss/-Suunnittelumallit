package builder;

public class Main {
    public static void main(String[] args) {

        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector gamingDirector = new ComputerDirector(gamingBuilder);
        Computer gamingPC = gamingDirector.constructComputer();
        System.out.println("=== Gaming Computer ===");
        System.out.println(gamingPC);

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector officeDirector = new ComputerDirector(officeBuilder);
        Computer officePC = officeDirector.constructComputer();
        System.out.println("=== Office Computer ===");
        System.out.println(officePC);
    }
}

