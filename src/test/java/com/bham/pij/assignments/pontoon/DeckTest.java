package com.bham.pij.assignments.pontoon;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeckTest {

	/*
	@TestParams 
	(
			purpose = "This test checks that your Deck constructor creates a deck of the correct size.",
			fail = "The Deck constructor does not create a deck of the correct size. Check the specification"
					+ " for the size of the deck.",
			marks = 3.0f
	)
	*/
	@Test
	public void testDeck() {
		Deck deck = new Deck();
		int size = deck.size();
		assertTrue(size == 52);
	}
	
	/*
	@TestParams 
	(
			purpose = "This test checks that your Deck deal() method works correctly.",
			fail = "The Deck deal() method does not work correctly. This test creates a new "
					+ " Deck and then deals from that Deck using the dealRandomCard() method."
					+ " That method should remove the dealt card(s) "
					+ "from the deck hence reducing the deck size.",
			marks = 9.0f
	)
	*/
	@Test
	public void testCards_deal() {
		
		Deck deck = new Deck();
		
		Card c = deck.dealRandomCard();
		
		assertTrue(deck.size() == 51);
		
		for (int i = 0; i < deck.size(); i++) {
			Card c2 = deck.getCard(i);
			boolean b = c.getValue()== c2.getValue() && c.getSuit() == c2.getSuit();
			assertFalse(b);
		}
	}

	/*
	@TestParams 
	(
			purpose = "This test checks that your Deck constructor creates correct cards with no duplicates.",
			fail = "There is some issue with your Deck constructor or related methods. This test"
					+ "creates a Deck using your constructor. It then tests if there are any "
					+ "duplicates in the Deck. To do this it must use your getCard() getSuit() and"
					+ " getValue() methods.",
			marks = 9.0f
	)
	*/
	@Test
	public void testCards_duplicates() {
	
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < 52; i++) {
			cards.add(deck.getCard(i));
		}
		
		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < 52; j++) {
				if (i != j) {
					boolean dup = cards.get(i).getSuit() == cards.get(j).getSuit() && cards.get(i).getValue() == cards.get(j).getValue();
					assertFalse(dup);
				}
			}
		}
	}

	/*
	@TestParams 
	(
			purpose = "This test checks that your Deck can be reset.",
			fail = "The Deck constructor does not correctly reset the deck. After calling this "
					+ "method the deck should once again contain a full deck of "
					+ " 52 distinct cards.",
			marks = 7.0f
	)
	*/
	@Test
	public void testDeck_reset() {
	
		Deck deck = new Deck();
		
		for (int i = 0; i < 20; i++) {
			deck.dealRandomCard();
		}
		
		deck.reset();
	
		assertFalse(deck.size() != 52);
	}

	/*
	@TestParams 
	(
			purpose = "This test checks that your Deck can be shuffled.",
			fail = "The shuffle() does not correctly shuffle the deck. After calling this"
					+ " method the deck should have been shuffled. This will leave it with the "
					+ "same number of cards it had before but with those cards now (generally) in different "
					+ "positions in the deck.",
			marks = 7.0f
	)
	*/
	@Test
	public void testDeck_shuffle() {
		
		Deck deck = new Deck();
		
		deck.shuffle();
		
		assertTrue(deck.size() == 52);
		
		for (int i = 0; i < 20; i++) {
			deck.dealRandomCard();
		}
		
		deck.shuffle();
		
		assertTrue(deck.size() == 32);
		
		ArrayList<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < 32; i++) {
			cards.add(deck.getCard(i));
		}
		
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 32; j++) {
				if (i != j) {
					boolean dup = cards.get(i).getSuit() == cards.get(j).getSuit() && cards.get(i).getValue() == cards.get(j).getValue();
					assertFalse(dup);
				}
			}
		}	
	}
}

