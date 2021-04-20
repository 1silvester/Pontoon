package com.bham.pij.assignments.pontoon;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

	/*
	@TestParams 
	(purpose = "This test checks that you have provided the correct Card constructor.",
	fail = "You Card constructor does not construct cards as expected. Your constructor"
			+ " must enable the setting of all Suit and Value combinations. For this you must have "
			+ " already created the relevant enums. Also make sure you Card constructor takes the parameters"
			+ " in the order Suit Value.",
	marks = 5.0f
	)
	 */
	@Test
	public void testCard() {

		Card c = new Card(Card.Suit.CLUBS, Card.Value.ACE);
		c = new Card(Card.Suit.HEARTS, Card.Value.TWO);
		c = new Card(Card.Suit.SPADES, Card.Value.THREE);
		c = new Card(Card.Suit.DIAMONDS, Card.Value.FOUR);
		c = new Card(Card.Suit.CLUBS, Card.Value.FIVE);
		c = new Card(Card.Suit.HEARTS, Card.Value.SIX);
		c = new Card(Card.Suit.SPADES, Card.Value.SEVEN);
		c = new Card(Card.Suit.DIAMONDS, Card.Value.EIGHT);
		c = new Card(Card.Suit.HEARTS, Card.Value.NINE);
		c = new Card(Card.Suit.SPADES, Card.Value.TEN);
		c = new Card(Card.Suit.DIAMONDS, Card.Value.JACK);
		c = new Card(Card.Suit.SPADES, Card.Value.QUEEN);
		c = new Card(Card.Suit.DIAMONDS, Card.Value.KING);
	}

	/*
	@TestParams 
	(purpose = "This test checks that your getSuit() method returns the correct value.",
	fail = "Your getSuit() method does not return the correct value. This test creates a Card"
			+ " with a particular Suit and then calls the getSuit() method to check that the"
			+ " Suit has been correctly set.",
	marks = 3.0f
	)
	 */
	@Test
	public void testgetSuit() {

		Card c = new Card(Card.Suit.CLUBS, Card.Value.TWO);
		assertTrue(c.getSuit() == Card.Suit.CLUBS);
		c = new Card(Card.Suit.DIAMONDS, Card.Value.ACE);
		assertTrue(c.getSuit() == Card.Suit.DIAMONDS);		
	}

	/*
	@TestParams 
	(purpose = "This test checks that your getValue() method returns the correct value.",
	fail = "Your getValue() method does not return the correct value. This test creates a Card"
			+ "with a particular Value and then calls the getValue() method to check that the"
			+ "Value has been correctly set.",
			marks = 3.0f
			)
	*/
	@Test
	public void testgetValue() {

		Card c = new Card(Card.Suit.CLUBS, Card.Value.TWO);
		assertTrue(c.getValue() == Card.Value.TWO);
		c = new Card(Card.Suit.DIAMONDS, Card.Value.ACE);
		assertTrue(c.getValue() == Card.Value.ACE);	
	}

	/*
	@TestParams 
	(purpose = "This test checks that your getNumericalValue() method returns the correct value(s).",
	fail = "Your getNumericalValue() method does not return the correct value(s). This test"
			+ " creates some cards and then checks the numerical value of those cards. "
			+ "This test does not check ACEs.",
			marks = 4.0f
			)
	*/
	@Test
	public void testgetNumericalValue_1() {

		Card c = new Card(Card.Suit.DIAMONDS, Card.Value.EIGHT);
		ArrayList<Integer> vals = c.getNumericalValue();
		assertTrue(vals.size() == 1); 

		c = new Card(Card.Suit.DIAMONDS, Card.Value.TWO);
		vals = c.getNumericalValue();
		assertTrue(vals.size() == 1);

		c = new Card(Card.Suit.DIAMONDS, Card.Value.KING);
		vals = c.getNumericalValue();
		assertTrue(vals.size() == 1);
	}

	/*
	@TestParams 
	(purpose = "This test checks that your getNumericalValue() method returns the correct value(s).",
	fail = "Your getNumericalValue() method does not return the correct value(s). This test"
			+ " creates some cards and then checks the numerical value of those cards. "
			+ "This test does not check ACEs.",
			marks = 10.0f
			)
	*/
	@Test
	public void testgetNumericalValue_2() {

		Card c = new Card(Card.Suit.DIAMONDS, Card.Value.EIGHT);
		ArrayList<Integer> vals = c.getNumericalValue();
		assertTrue(vals.get(0) == 8);

		c = new Card(Card.Suit.DIAMONDS, Card.Value.TWO);
		vals = c.getNumericalValue();
		assertTrue(vals.get(0) == 2);

		c = new Card(Card.Suit.DIAMONDS, Card.Value.KING);
		vals = c.getNumericalValue();
		assertTrue(vals.get(0) == 10);

		c = new Card(Card.Suit.CLUBS, Card.Value.JACK);
		vals = c.getNumericalValue();
		assertTrue(vals.get(0) == 10);

		c = new Card(Card.Suit.CLUBS, Card.Value.TEN);
		vals = c.getNumericalValue();
		assertTrue(vals.get(0) == 10);

		c = new Card(Card.Suit.CLUBS, Card.Value.NINE);
		vals = c.getNumericalValue();
		assertTrue(vals.get(0) == 9);
	}

	/*
	@TestParams 
	(purpose = "This test checks that your getNumericalValue() method returns the correct value(s).",
	fail = "Your getNumericalValue() method does not return the correct value(s). This test"
			+ " creates some cards and then checks the numerical value of those cards. "
			+ "This test tests ACEs.",
			marks = 7.0f
			)
	*/
	@Test
	public void testgetNumericalValue_3() {

		Card c = new Card(Card.Suit.HEARTS, Card.Value.ACE);
		ArrayList<Integer> vals = c.getNumericalValue();
		assertTrue(vals.size()==2);
		assertTrue(vals.get(0) == 1);
		assertTrue(vals.get(1) == 11);
	}
}
