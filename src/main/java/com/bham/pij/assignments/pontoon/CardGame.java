package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;

//Silvester Stephens 1437955
public abstract class CardGame
{
    Deck deck = new Deck();
    int nplayers;
    ArrayList<Player> namesListOfPlayer = new ArrayList<>();


    public CardGame(int nplayers)
    {
        this.nplayers = nplayers;
//        for(int i = 0; i < nplayers; i++)
//        {
//        Player thisPlayer = new Player("Player: " + Integer.parseInt(String.valueOf(i)));
//        namesListOfPlayer.add(thisPlayer);
//        }
    }

    public abstract void dealInitialCards();

    public abstract int compareHands(Player hand1, Player hand2);

    public Deck getDeck()
    {
        return deck;
    }
    
    public Player getPlayer(int i)
    {
        return namesListOfPlayer.get(i);
    }

    public int getNumPlayers()
    {
        return nplayers;
    }


}
