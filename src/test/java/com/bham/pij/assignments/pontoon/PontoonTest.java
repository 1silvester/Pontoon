package com.bham.pij.assignments.pontoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PontoonTest {

	/*
	@TestParams 
	(
			purpose = "This test checks that your Pontoon constructor initialises the game correctly.",
			fail = "Your constructor does not initialise the game correctly. You must make sure that"
					+ " you pass the number of players to the Pontoon constructor. Your constructor"
					+ " must also create the player objects.",
			marks = 3.0f
	)
	*/
	@Test
	public void testPontoon_init() {
	
		CardGame game = new Pontoon(2);
				
		assertTrue(game.getNumPlayers() == 2);
		
		if (game.getPlayer(0).getHandSize() == 0 && game.getPlayer(1).getHandSize() == 0) {
			game.dealInitialCards();
		}
		
		assertTrue(game.getPlayer(0).getHandSize() == 2);
		assertTrue(game.getPlayer(1).getHandSize() == 2);
		
		assertTrue(game.getPlayer(0).getCards().size() == 2);
		assertTrue(game.getPlayer(1).getCards().size() == 2);
	}

	/*
	@TestParams 
	(
	purpose = "This test checks that your 'twist' (dealing an extra card to a player) functionality.",
	fail = "Your 'twist' (dealing an extra card to a player) functionality does not work correctly."
			+ " This test checks what happens when an extra card is dealt to a player. ",
	marks = 3.0f
	)
	*/
	@Test
	public void testPontoon_twist() {

		CardGame game = new Pontoon(2);
	
		Pontoon p = (Pontoon)game;
		
		Player p1 = p.getPlayer(0);
		Player p2 = p.getPlayer(1);
		
		if (p1.getHandSize() == 0 && p2.getHandSize() == 0) {
			p.dealInitialCards();
		}
		
		p1.dealToPlayer(p.getDeck().dealRandomCard());
	
		assertTrue(game.getPlayer(0).getHandSize() == 3);

		p1.dealToPlayer(p.getDeck().dealRandomCard());
		
		assertTrue(game.getPlayer(0).getHandSize() == 4);
		
		p2.dealToPlayer(p.getDeck().dealRandomCard());
		
		assertTrue(game.getPlayer(1).getHandSize() == 3);	
	}

	/*
	@TestParams 
	(
	purpose = "This test checks that your compare hands functionality.",
	fail = "Your compare hands functionality does not work correctly. Make sure that you have "
			+ "read the rules in the specification about the ranking of hands.",
	marks = 3.0f
	)
	*/
	@Test
	public void testPontoon_compare_hands() {
		CardGame game = new Pontoon(2);
	
		Pontoon p = (Pontoon)game;
	
		Player p1 = p.getPlayer(0);
		Player p2 = p.getPlayer(1);
		
		p1.getCards().clear();
		p2.getCards().clear();
		
		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.TEN));

		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.TEN));

		assertTrue(p.compareHands(p1, p2) == 0);
		
		p1.dealToPlayer(new Card(Card.Suit.DIAMONDS, Card.Value.TWO));
		assertTrue(p.compareHands(p1, p2) == -1);

		p2.dealToPlayer(new Card(Card.Suit.DIAMONDS, Card.Value.TWO));
		assertTrue(p.compareHands(p1, p2) == 0);

		p1.getCards().clear();
		p2.getCards().clear();
		
		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.ACE));
		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.TEN));

		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.TEN));
		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.THREE));
		
		assertTrue(p.compareHands(p1, p2) == 1);

		p1.getCards().clear();
		p2.getCards().clear();
		
		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.TWO));
		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.THREE));
		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.FOUR));
		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.FIVE));

		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.ACE));
		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.TEN));

		assertTrue(p.compareHands(p1, p2) == 1);

		p2.getCards().clear();

		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.TWO));
		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.THREE));
		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.FOUR));
		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.FIVE));

		assertTrue(p.compareHands(p1, p2) == 0);
		
		p1.getCards().clear();
		p2.getCards().clear();
		
		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.ACE));
		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.TEN));

		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.ACE));
		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.QUEEN));

		assertTrue(p.compareHands(p1, p2) == 0);
	}
}

