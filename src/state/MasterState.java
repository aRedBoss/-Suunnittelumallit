package state;

public class MasterState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("You are a Master. No need to train.");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You are a Master. No need to meditate.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You are a Master. No need to fight.");
    }

    @Override
    public String getStateName() {
        return "Master";
    }
}

