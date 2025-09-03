package template_method;

public class Main {
    public static void main(String[] args) {
        Game game = new RockPaperScissors();
        game.play(1); // currently supports 1 player vs computer
    }
}

