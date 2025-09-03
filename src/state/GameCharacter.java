package state;

public class GameCharacter {
    private String name;
    private int experience;
    private int health;
    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.state = new NoviceState(); // Initial state
    }

    public void train() {
        state.train(this);
        checkStateTransition();
    }

    public void meditate() {
        state.meditate(this);
        checkStateTransition();
    }

    public void fight() {
        state.fight(this);
        checkStateTransition();
    }

    public void checkStateTransition() {
        if (experience >= 100 && experience < 200) {
            state = new IntermediateState();
        } else if (experience >= 200 && experience < 300) {
            state = new ExpertState();
        } else if (experience >= 300) {
            state = new MasterState();
        }
    }

    public void displayStatus() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + state.getStateName());
        System.out.println("Experience: " + experience);
        System.out.println("Health: " + health);
        System.out.println("Available actions: ");
        System.out.println(" - train");
        if (state instanceof IntermediateState || state instanceof ExpertState || state instanceof MasterState)
            System.out.println(" - meditate");
        if (state instanceof ExpertState || state instanceof MasterState)
            System.out.println(" - fight");
        System.out.println();
    }

    // Getters and setters
    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
}

