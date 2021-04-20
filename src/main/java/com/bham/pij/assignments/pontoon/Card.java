package com.bham.pij.assignments.pontoon;

// Silvester Stephens 1437955


import java.util.ArrayList;


public class Card {

    public Card(Suit suit, Value value)
    {
        this.setSuit(suit);
        this.setValue(value);
    }
    Suit suit;
    Value value;


    public static enum Suit
    {
       CLUBS,HEARTS,DIAMONDS,SPADES;
    }


    public static enum Value
    {
        ACE(1,11),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10)
        ;

        public int[] intValue;

        Value(int... value)
        {
            this.intValue = value;
        }

        public int[] getIntValue()
        {
            return this.intValue;
        }

    }

    public void setSuit(Suit suit)
    {
        this.suit = suit;
    }

    public void setValue(Value value)
    {
        this.value = value;
    }

    public Suit getSuit()
    {
        return this.suit;
    }

    public Value getValue()
    {
        return this.value;
    }


    public ArrayList<Integer> getNumericalValue()
    {
        ArrayList<Integer> cardArrayValue = new ArrayList<Integer>();
        for(int i : value.getIntValue())
        {
            cardArrayValue.add(i);
        }
        return cardArrayValue;
    }


}
