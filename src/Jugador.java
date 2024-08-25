import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String name;
    private List<Carta> hand;
    private int score;

    public Jugador(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public List<Carta> getHand() {
        return hand;
    }

    public void addCardToHand(Carta carta) {
        hand.add(carta);
    }

    public void clearHand() {
        hand.clear();
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int points) {
        this.score += points;
    }

    @Override
    public String toString() {
        return name + " Con la mano" + hand.toString();
    }
}
