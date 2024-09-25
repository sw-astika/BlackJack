// swastika bansal

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Player player = new Player();
        Player dealer = new Player();

        // Initial deal
        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        System.out.println("Player's hand:");
        player.showHand();
        System.out.println("Player's score: " + player.getScore());

        // Player's turn
        while (true) {
            System.out.print("Do you want to hit or stand? (hit/stand): ");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("hit")) {
                player.addCard(deck.drawCard());
                System.out.println("Player's hand:");
                player.showHand();
                System.out.println("Player's score: " + player.getScore());

                if (player.isBusted()) {
                    System.out.println("Player busted! Dealer wins.");
                    return;
                }
            } else {
                break;
            }
        }

        // Dealer's turn
        while (dealer.getScore() < 17) {
            dealer.addCard(deck.drawCard());
        }

        System.out.println("\nDealer's hand:");
        dealer.showHand();
        System.out.println("Dealer's score: " + dealer.getScore());

        if (dealer.isBusted()) {
            System.out.println("Dealer busted! Player wins.");
        } else if (player.getScore() > dealer.getScore()) {
            System.out.println("Player wins!");
        } else if (player.getScore() < dealer.getScore()) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}
