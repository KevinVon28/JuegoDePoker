public class Carta {
    private String suit; // Palo
    private String rank; // Valor

    public Carta(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " De " + suit;
    }
}
