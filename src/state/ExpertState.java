package state;

public class ExpertState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        character.setExperience(character.getExperience() + 10);
        System.out.println("Training... Experience increased!");
    }

    @Override
    public void meditate(GameCharacter character) {
        character.setHealth(character.getHealth() + 5);
        System.out.println("Meditating... Health increased!");
    }

    @Override
    public void fight(GameCharacter character) {
        character.setExperience(character.getExperience() + 30);
        character.setHealth(character.getHealth() - 20);
        System.out.println("Fighting... Experience increased, but health decreased!");
    }

    @Override
    public String getStateName() {
        return "Expert";
    }
}

