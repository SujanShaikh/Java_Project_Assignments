import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Game game = new Game();
        Player player1 = new Player("Player 1", game);
        Player player2 = new Player("Player 2", game);
        player1.start();
        player2.start();
    }
}

class Game {
    private boolean player1Ready = false;
    private boolean player2Ready = false;
    private int player1Choice;
    private int player2Choice;

    synchronized void playerReady(int playerNumber, int choice) {
        if (playerNumber == 1) {
            player1Choice = choice;
            player1Ready = true;
        } else {
            player2Choice = choice;
            player2Ready = true;
        }
        notifyAll();
    }

    synchronized void play() {
        while (!player1Ready || !player2Ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (player1Choice == player2Choice) {
            System.out.println("Draw!");
        } else if (player1Choice == 0 && player2Choice == 1 ||
                player1Choice == 1 && player2Choice == 2 ||
                player1Choice == 2 && player2Choice == 0) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("Player 1 wins!");
        }
        player1Ready = false;
        player2Ready = false;
    }
}


class Player extends Thread {
    private String name;
    private Game game;
    private Scanner scanner;

    Player(String name, Game game) {
        this.name = name;
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(" players  enter your move (0 = Rock, 1 = Paper, 2 = Scissors): ");
            int choice = scanner.nextInt();
            game.playerReady(getPlayerNumber(), choice);
            game.play();
        }
    }

    private int getPlayerNumber() {
        if (name.equals("Player 1")) {
            return 1;
        } else {
            return 2;
        }
    }
}
