import Entities.Player;

public class Game {

    private Player player;

    public void loop() {
        this.player = new Intro().playerCreation();
    }
}
