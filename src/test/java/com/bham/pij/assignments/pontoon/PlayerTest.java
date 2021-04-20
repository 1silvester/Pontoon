package com.bham.pij.assignments.pontoon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

	/*
	@TestParams 
	(
			purpose = "This test checks that you correctly deal cards to a player.",
			fail = "Your dealToPlayer() method does not correctly deal cards to players. The "
					+ " card that has been dealt should be properly added to the player's "
					+ "hand of cards. This test relies on the Card Deck AND Player classes.",
			marks = 3.0f
	)
	*/
	@Test
	public void testPlayer_deal() {
		
		Player p = new Player("test");
		Deck deck = new Deck();
		Card c = deck.dealRandomCard();
		p.dealToPlayer(c);
		assertTrue(p.getHandSize() == 1);
		c = deck.dealRandomCard();
		p.dealToPlayer(c);
		assertTrue(p.getHandSize() == 2);
		c = deck.dealRandomCard();
		p.dealToPlayer(c);
		c = deck.dealRandomCard();
		p.dealToPlayer(c);
		assertTrue(p.getHandSize() == 4);
	}
	
	/*
	@TestParams 
	(
			purpose = "This test checks that you correctly remove cards from players.",
			fail = "Your dealToPlayer() method does not correctly remove cards from players."
					+ " This test relies on the Card Deck AND Player classes.",
			marks = 3.0f
	)
	*/
	@Test
	public void testPlayer_remove() {

		Player p = new Player("test");
		Deck deck = new Deck();
		Card c = deck.dealRandomCard();
		p.dealToPlayer(c);
		p.removeCard(c);
		assertTrue(p.getHandSize() == 0);
	}

	/*
	@TestParams 
	(
			purpose = "This test checks that your class computes the numerical value(s) of a hand with a single card correctly.",
			fail = "Your class does not compute the numerical value of hands with single cards correctly.",
			marks = 3.0f
	)
	*/
	@Test
	public void testPlayer_hand_singlevalue() {
	
		// single value
		Player p1 = new Player("test");
		Card c1 = new Card(Card.Suit.CLUBS, Card.Value.EIGHT);
		p1.dealToPlayer(c1);
		ArrayList<Integer> values = p1.getNumericalHandValue();
		assertTrue(values.size() == 1);
		assertTrue(values.get(0) == 8);
		
		Player p2 = new Player("test");		
		c1 = new Card(Card.Suit.CLUBS, Card.Value.JACK);
		p2.dealToPlayer(c1);
		values = p2.getNumericalHandValue();
		assertTrue(values.size() == 1);
		assertTrue(values.get(0) == 10);
	}
	
	/*
	@TestParams 
	(
			purpose = "This test checks that your class computes the numerical value(s) of a hand with multiple cards correctly.",
			fail = "Your class does not compute the numerical value of hands with multiple cards correctly."
					+ " This method checks ACEs. ",
			marks = 3.0f
	)
	*/
	@Test
	public void testPlayer_hand_multivalue() {
	
		Player p1 = new Player("test");
		Card c1 = new Card(Card.Suit.CLUBS, Card.Value.EIGHT);
		p1.dealToPlayer(c1);
		ArrayList<Integer> values = p1.getNumericalHandValue();
		c1 = new Card(Card.Suit.CLUBS, Card.Value.JACK);
		p1.dealToPlayer(c1);
		
		values = p1.getNumericalHandValue();
		
		assertTrue(values.size() == 1);
		assertTrue(values.get(0) == 18);
		
		c1 = new Card(Card.Suit.CLUBS, Card.Value.FIVE);
		p1.dealToPlayer(c1);
		values = p1.getNumericalHandValue();
		
		assertTrue(values.size() == 1);
		assertTrue(values.get(0) == 23);
		
		Player p2 = new Player("test");
		c1 = new Card (Card.Suit.CLUBS, Card.Value.ACE);
		Card c2 = new Card(Card.Suit.HEARTS, Card.Value.JACK);
		p2.dealToPlayer(c1);
		p2.dealToPlayer(c2);
		values = p2.getNumericalHandValue();
		
		assertTrue(values.size() == 2);
		assertTrue(values.get(0) == 11);
		assertTrue(values.get(1) == 21);
		
		p2.dealToPlayer(new Card(Card.Suit.HEARTS, Card.Value.THREE));
		values = p2.getNumericalHandValue();
		
		assertTrue(values.size() == 2);
		assertTrue(values.get(0) == 14);
		assertTrue(values.get(1) == 24);
		
		p2.dealToPlayer(new Card(Card.Suit.HEARTS, Card.Value.ACE));
		values = p2.getNumericalHandValue();
		
		assertTrue(values.size() == 3);
		assertTrue(values.get(0) == 15);
		assertTrue(values.get(1) == 25);
		assertTrue(values.get(2) == 35);
		
		Player p3 = new Player("test");
		p3.dealToPlayer(new Card(Card.Suit.HEARTS, Card.Value.ACE));
		p3.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.ACE));
		values = p3.getNumericalHandValue();
		
		assertTrue(values.size() == 3);
		assertTrue(values.get(0) == 2);
		assertTrue(values.get(1) == 12);
		assertTrue(values.get(2) == 22);
		
		Player p4 = new Player("test");
		p4.dealToPlayer(new Card(Card.Suit.HEARTS, Card.Value.ACE));
		p4.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.KING));
		p4.dealToPlayer(new Card(Card.Suit.HEARTS, Card.Value.KING));
		p4.dealToPlayer(new Card(Card.Suit.SPADES, Card.Value.KING));
		values = p4.getNumericalHandValue();
		
		assertTrue(values.size() == 2);
		assertTrue(values.get(0) == 31);
		assertTrue(values.get(1) == 41);	
	}
}

