import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego {
    private List<Carta> deck;

    public Juego() {
        deck = new ArrayList<>();
        String[] suits = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Carta(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Carta dealCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        } else {
            return null;
        }
    }
}
