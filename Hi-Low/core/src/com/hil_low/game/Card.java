package com.hil_low.game;

public class Card implements Comparable{

    //Instance variables
    Suit suit;
    String value;
    int rank;
    String color;

    /**
     * Constructs a new default card.
     */
    public Card(){
        this(Suit.JOKER,"Joker",1);
    }

    /**
     * Constructs a new card.
     */
    public Card(Suit suit, String value, int rank){
        this.suit = suit;
        this.value = value;
        this.rank = rank;
        if(suit == Suit.DIAMONDS || suit == Suit.HEARTS)
            color = "Red";
        else
            color = "Black";
    }

    //Getters
    public Suit getSuit() {
        return suit;
    }
    public String getColor() {
        return color;
    }
    public String getValue() {
        return value;
    }
    public int getRank() {
        return rank;
    }

    /**
     * Gets a string description of the card's value and suit.
     */
    public String toString(){
        return this.value + " of " + this.suit;
    }

    /**
     * Comparator that utilizes card rank.
     */
    public int compareTo(Object obj){
        if(!(obj instanceof Card))
            return 0;
        Card other = (Card)obj;
        if(this.rank < other.rank)
            return 1;
        if(this.rank == other.rank)
            return 0;
        if(this.rank > other.rank)
            return -1;
        return 0;
    }
}
