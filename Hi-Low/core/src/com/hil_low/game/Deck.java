package com.hil_low.game;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    //Instance variable
    ArrayList<Card> deck = new ArrayList<Card>();

    //Constructor
    public Deck() {
        //Suits
        final int[] CLUBS = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        final int[] DIAMONDS = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        final int[] HEARTS = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        final int[] SPADES = {2,3,4,5,6,7,8,9,10,11,12,13,14};

        //Picture card values
        final String J = "Jack";
        final String Q = "Queen";
        final String K = "King";
        final String A = "Ace";

        int[][] cards = new int[4][13];

        //Fill deck
        for (int i = 0; i < 4; i++) {
            switch(i) {
                case 0: cards[0] = CLUBS;
                case 1: cards[1] = DIAMONDS;
                case 2: cards[2] = HEARTS;
                case 3: cards[3] = SPADES;
            }
        }

        //Assign suit, picture card values, and add cards to deck.
        for (int i = 0; i < cards.length; i++) {
            Suit suit = null;

            switch(i) {
                case 0: suit = Suit.DIAMONDS;
                    break;
                case 1: suit = Suit.HEARTS;
                    break;
                case 2: suit = Suit.SPADES;
                    break;
                case 3: suit = Suit.CLUBS;
            }

            for (int j = 2; j < 15; j++) {
                String card = null;

                switch(j) {
                    case 11: card = J;
                        break;
                    case 12: card = Q;
                        break;
                    case 13: card = K;
                        break;
                    case 14: card = A;
                        break;
                    default: card = String.valueOf(j);
                }

                deck.add(new Card(suit, card, 15 - j));

            }
        }
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Draws a card from the deck, removing it after.
     */
    public Card draw() {
        if(deck.isEmpty())
            return null;

        Card card = deck.get(0);
        deck.remove(0);

        return card;
    }

    /**
     * Burns a card from the deck
     */
    public void burn() {
        if(!deck.isEmpty())
            deck.remove(0);
    }

    /**
     * Prints entire deck of cards to console.
     */
    public void printCards() {
        for (int i = 0; i < deck.size(); i++) {
            System.out.println(deck.get(i));
        }
    }

    /**
     * Get the number of cards in the deck.
     */
    public int getDeckCount() {
        return deck.size();
    }
}