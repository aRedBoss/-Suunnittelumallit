package state;

public class NoviceState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        character.setExperience(character.getExperience() + 20);
        System.out.println("Training... Experience increased!");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditation not available at Novice level.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting not available at Novice level.");
    }

    @Override
    public String getStateName() {
        return "Novice";
    }
}

