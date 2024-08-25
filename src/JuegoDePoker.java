import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JuegoDePoker {
    private List<Jugador> jugadors;
    private Juego juego;
    private int numberOfRounds;

    public JuegoDePoker(int numberOfPlayers, int numberOfRounds) {
        this.jugadors = new ArrayList<>();
        this.juego = new Juego();
        this.numberOfRounds = numberOfRounds;

        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Introduzca el nombre de la jugador3 " + i + ": ");
            jugadors.add(new Jugador(scanner.nextLine()));
        }
    }

    public void play() {
        for (int round = 1; round <= numberOfRounds; round++) {
            System.out.println("Ronda " + round);
            juego.shuffle();
            dealCards();
            determineRoundWinner();
            clearHands();
        }
        determineGameWinner();
    }

    private void dealCards() {
        for (Jugador jugador : jugadors) {
            for (int i = 0; i < 5; i++) { // Repartir 5 cartas a cada jugador
                jugador.addCardToHand(juego.dealCard());
            }
            System.out.println(jugador);
        }
    }

    private void determineRoundWinner() {
        // Lógica simplificada para determinar el ganador basado en la carta más alta
        Jugador roundWinner = jugadors.get(0);
        for (Jugador jugador : jugadors) {
            if (getHandValue(jugador) > getHandValue(roundWinner)) {
                roundWinner = jugador;
            }
        }
        System.out.println("Ganador de esta ronda: " + roundWinner.getName());
        roundWinner.updateScore(1);
    }

    private int getHandValue(Jugador jugador) {
        // Método simplificado para obtener el valor de la mano
        int value = 0;
        for (Carta carta : jugador.getHand()) {
            value += getCardValue(carta);
        }
        return value;
    }

    private int getCardValue(Carta carta) {
        String rank = carta.getRank();
        switch (rank) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            case "Jack": return 11;
            case "Queen": return 12;
            case "King": return 13;
            case "Ace": return 14;
            default: return 0;
        }
    }

    private void clearHands() {
        for (Jugador jugador : jugadors) {
            jugador.clearHand();
        }
    }

    private void determineGameWinner() {
        Jugador gameWinner = jugadors.get(0);
        for (Jugador jugador : jugadors) {
            if (jugador.getScore() > gameWinner.getScore()) {
                gameWinner = jugador;
            }
        }
        System.out.println("La ganadora del juego es: " + gameWinner.getName());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de jugadoras: ");
        int numberOfPlayers = scanner.nextInt();
        System.out.print("Introduzca el número de rondas: ");
        int numberOfRounds = scanner.nextInt();

        JuegoDePoker game = new JuegoDePoker(numberOfPlayers, numberOfRounds);
        game.play();
    }
}
