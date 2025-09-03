package state;

public class IntermediateState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        character.setExperience(character.getExperience() + 15);
        System.out.println("Training... Experience increased!");
    }

    @Override
    public void meditate(GameCharacter character) {
        character.setHealth(character.getHealth() + 10);
        System.out.println("Meditating... Health increased!");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting not available at Intermediate level.");
    }

    @Override
    public String getStateName() {
        return "Intermediate";
    }
}

