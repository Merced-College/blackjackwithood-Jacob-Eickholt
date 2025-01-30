//package cardGame;
//Heidy Acosta Emeterio, Jacob Eickholt, Adam Ruiz

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

	private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
	private static ArrayList<Card> playerCards = new ArrayList<Card>();
	// Added Player two 
	private static ArrayList<Card> playerCards2 = new ArrayList<Card>();


	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			// error
			System.out.println("error");
			e.printStackTrace();
		}

		while(input.hasNext()) {
			String[] fields  = input.nextLine().split(",");
			//	public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
			Card newCard = new Card(fields[0], fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3]);
			deckOfCards.add(newCard);	
		}

		shuffle();

		
		//for(Card c: deckOfCards)
			//System.out.println(c);

		//deal the player 5 cards
		for(int i = 0; i < 4; i++) {
			playerCards.add(deckOfCards.remove(i));
		}
		//Deal the second Player 5 cards 
		for(int i = 0; i < 4; i++) {
			playerCards2.add(deckOfCards.remove(i));
		}
		//Prints card for both players 
		System.out.println("First players cards");
		for(Card c: playerCards)
			System.out.println(c);

		System.out.println("Second players cards");
		for(Card c2: playerCards2)
			System.out.println(c2);

		System.out.println("pairs is " + checkFor2Kind());
		System.out.println("higher value is " + higherValue());

	}//end main

	public static void shuffle() {

		//shuffling the cards by deleting and reinserting
		for (int i = 0; i < deckOfCards.size(); i++) {
			int index = (int) (Math.random()*deckOfCards.size());
			Card c = deckOfCards.remove(index);
			//System.out.println("c is " + c + ", index is " + index);
			deckOfCards.add(c);
		}
	}

	//check for 2 of a kind in the players hand
	public static boolean checkFor2Kind() {

		int count = 0;
		for(int i = 0; i < playerCards.size() - 1; i++) {
			Card current = playerCards.get(i);
			Card next = playerCards.get(i+1);
			
			for(int j = i+1; j < playerCards.size(); j++) {
				next = playerCards.get(j);
				//System.out.println(" comparing " + current);
				//System.out.println(" to " + next);
				if(current.equals(next))
					count++;
			}//end of inner for
			if(count == 1)
				return true;

		}//end outer for
		return false;
	}
	// Adds all value for both players and compares it and decideds which player has to higher value 
	public static String higherValue() {
    int player1Wins = 0;
    int player2Wins = 0;

    for (int i = 0; i < playerCards.size(); i++) {
        if (playerCards.get(i).getValue() > playerCards2.get(i).getValue()) {
            player1Wins++;
        } else if (playerCards.get(i).getValue() < playerCards2.get(i).getValue()) {
            player2Wins++;
        }
    }

    if (player1Wins > player2Wins) {
        return "Player 1 wins!";
    } else if (player2Wins > player1Wins) {
        return "Player 2 wins!";
    } else {
        return "It's a tie!";
    }
	}

}
//end class
