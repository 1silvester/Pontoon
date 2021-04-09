package com.bham.pij.assignments.pontoon;

// Silvester Stephens 1437955

import java.util.*;

public class Player
{
    String name;
    ArrayList<Card> hand = new ArrayList<Card>();





    public Player(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void dealToPlayer(Card card)
    {
//
        hand.add(card);

//        Random randInt = new Random();
//        int chosenIndex;
//        int chosenIndexSuit;
//
//
//        Card.Suit[] setOfSuits = Card.Suit.values();
//        Card.Value[] setOfValues = Card.Value.values();
//
//
//        for( int i = 0; i < 3; i++)
//        {
//            chosenIndex = randInt.nextInt((setOfValues.length ) - 1);
//
//            chosenIndexSuit = randInt.nextInt((setOfSuits.length ) -1);
//
//            Card.Value aRandomValue = setOfValues[chosenIndex];
//            Card.Suit aRandomSuit = setOfSuits[chosenIndexSuit];
//
//            card = new Card(aRandomSuit, aRandomValue);
//            hand.add(card);
//        }


    }

    public void removeCard(Card card)
    {
        hand.remove(card);
//        for(Card c: hand)
//        {
//        hand.remove(c);
//        break;
//        }

    }


    public ArrayList<Integer> getNumericalHandValue()
    {
        ArrayList <Integer> bestNumericHand = new ArrayList<Integer>();

        // this will most likely just deal with the initial 2 cards
//        if(bestNumericHand.isEmpty())

//        {
        ArrayList<Integer> values = new ArrayList<Integer>();
        int totalNoAces = 0;
        ArrayList<Integer> acesSum = new ArrayList<>();


        for (int i = 0;  i < hand.size(); i++)
        {
            for(Integer c : hand.get(i).getNumericalValue())
            {
                values.add(c);
            }

        }


        Collections.sort(values); //sort the arraylist

        //find the aces in the hand
        for(Integer i : values) //new line of code
        {
            if(i == 1)
            {
                acesSum.add(i);
            }
            else if(i == 11)
            {
                acesSum.add(i);
            }
        }

        values.removeIf(i -> i == 1 || i == 11);


        //
        // removing duplicate values

//        for(int i = 0; i < values.size(); i++)
//        {
//        for(Integer v : values)
//        {
//            if(!valuesNoDuplicates.contains(v))
//            {
//                valuesNoDuplicates.add(v);
//            }
//        }
//        }


        // find aces and add to an array list
        //total the rest of the card values

//        for(Integer i : valuesNoDuplicates) {
//            if (i == 1) {
//                aces.add(i);
//
//            } else if(i == 11)
//            {
//                aces.add(i);
//                break;
//            }
//            else {
//                totalNoAces += i;
//            }
//        }
        // summing total of all values
        for(Integer i : values)
        {
            totalNoAces += i;
        }

        //adding the two possible values of an aces to the total hand value

//        for(int i : acesSum)
//        {
//            if(i == 1)
//            {
//                bestNumericHand.add(i + totalNoAces);
//
//            }
//            else if(i == 11)
//            {
//                bestNumericHand.add(i + totalNoAces);
//            }
//        }

        // adding two sets of aces together
        // all new code
        if(acesSum.size() == 8)
        {
            int totalElevens = 0;
            int totalOnes = 0;
            ArrayList<Integer> countingOnes = new ArrayList<>();
            ArrayList<Integer> countingElevens = new ArrayList<>();

            for(int ace : acesSum)
            {

                if(ace == 1)
                {
                    totalOnes += ace;
                    countingOnes.add(ace);
                    if (countingOnes.size() > 3)
                    {
                        bestNumericHand.add(totalOnes + totalNoAces);

                    }
                }
                else if(ace == 11)
                {
                    totalElevens += ace;
                    countingElevens.add(ace);
                    if(countingElevens.size() > 3)
                    {
                        bestNumericHand.add(totalElevens + totalNoAces);
                        bestNumericHand.add(totalNoAces + countingElevens.get(0) + countingOnes.get(0) + countingOnes.get(1) + countingOnes.get(2));
                        bestNumericHand.add(totalNoAces + countingElevens.get(0) + countingElevens.get(1) + countingOnes.get(0) + countingOnes.get(1));
                        bestNumericHand.add(totalNoAces + countingElevens.get(0) + countingElevens.get(1) + countingElevens.get(2) + countingOnes.get(0));
                    }
                }

            }}
        if(acesSum.size() == 6)
        {
            int totalElevens = 0;
            int totalOnes = 0;
            ArrayList<Integer> countingOnes = new ArrayList<>();
            ArrayList<Integer> countingElevens = new ArrayList<>();

            for(int ace : acesSum)
            {

                if(ace == 1)
                {
                    totalOnes += ace;
                    countingOnes.add(ace);
                    if (countingOnes.size() > 2)
                    {
                        bestNumericHand.add(totalOnes + totalNoAces);

                    }
                }
                else if(ace == 11)
                {
                    totalElevens += ace;
                    countingElevens.add(ace);
                    if(countingElevens.size() > 2)
                    {
                        bestNumericHand.add(totalElevens + totalNoAces);
                        bestNumericHand.add(totalNoAces + countingElevens.get(0) + countingOnes.get(0) + countingOnes.get(1));
                        bestNumericHand.add(totalNoAces + countingElevens.get(0) + countingElevens.get(1) + countingOnes.get(0));
                    }
                }

            }}
            {if(acesSum.size() == 4)
        {
            int totalElevens = 0;
            int totalOnes = 0;
            ArrayList<Integer> countingOnes = new ArrayList<>();
            ArrayList<Integer> countingElevens = new ArrayList<>();

            for(int ace : acesSum)
            {

                if(ace == 1)
                {
                    totalOnes += ace;
                    countingOnes.add(ace);
                    if (countingOnes.size() > 1)
                    {
                    bestNumericHand.add(totalOnes + totalNoAces);

                    }
                }
                else if(ace == 11)
                {
                    totalElevens += ace;
                    countingElevens.add(ace);
                    if(countingElevens.size() > 1)
                    {
                    bestNumericHand.add(totalElevens + totalNoAces);
                    bestNumericHand.add(totalNoAces + countingElevens.get(0) + countingOnes.get(0));
                    }
                }

            }}


        } if(acesSum.size() == 2) //adding the two possible values of an aces to the total hand value
        {
            for(int i : acesSum)
            {
                if(i == 1)
                {
                    bestNumericHand.add(i + totalNoAces);

                }
                else if(i == 11)
                {
                    bestNumericHand.add(i + totalNoAces);
                }
            }
        }

        if(acesSum.size() == 0)
        {
        bestNumericHand.add(totalNoAces);
        }

        Collections.sort(bestNumericHand);

//        }
//
//        else if(hand.size() == 1)
//        {
//            ArrayList<Integer> values = new ArrayList<>();
//            ArrayList<Integer> acesSum = new ArrayList<>();
//            int totalNoAces = 0;
//
//            // this for loop should get just the last element in the array list hand
//
////            for(int i = hand.size()-1; i >= hand.size()-2; i--)
////            {
//            for(Integer c: hand.get(hand.size()).getNumericalValue())
//            {
//                values.add(c);
//                break;
//            }
////            }
//
//
//
//            // this loop should add aces to acesSum array list and then they are removed from values after the loop
//            for(Integer i : values) //new line of code
//            {
//                if(i == 1)
//                {
//                    acesSum.add(i);
//                }
//                else if(i == 11)
//                {
//                    acesSum.add(i);
//                }
//            }
//
//            values.removeIf(i -> i == 1 || i == 11);
//
//            // totals the values that aren't aces
//            for(Integer i : values)
//            {
//                totalNoAces += i;
//            }
//
//            //adds non aces values to numeric hand values
//            if(acesSum.size() == 0)
//            {
//                bestNumericHand.add(totalNoAces);
//            }
//            // adds the aces to the bestNumericHand value
//            else if(acesSum.size() == 2)
//            {
//                for(int i : acesSum)
//                {
//                    if(i == 1)
//                    {
//                        bestNumericHand.add(i);
//
//                    }
//                    else if(i == 11)
//                    {
//                        bestNumericHand.add(i);
//                    }
//                }
//            }
//
//        }
//
//        // new card added to the hand
//        else if(hand.size() == 3)
//        {
//            ArrayList<Integer> values = new ArrayList<>();
//            ArrayList<Integer> acesSum = new ArrayList<>();
//            int totalNoAces = 0;
//
//            // this for loop should get just the last element in the array list hand
//
////            for(int i = hand.size()-1; i >= hand.size()-2; i--)
////            {
//                for(Integer c: hand.get(hand.size()-1).getNumericalValue())
//                {
//                    values.add(c);
//                    break;
//                }
////            }
//
//
//
//            // this loop should add aces to acesSum array list and then they are removed from values after the loop
//            for(Integer i : values) //new line of code
//            {
//                if(i == 1)
//                {
//                    acesSum.add(i);
//                }
//                else if(i == 11)
//                {
//                    acesSum.add(i);
//                }
//            }
//
//            values.removeIf(i -> i == 1 || i == 11);
//
//            // totals the values that aren't aces
//            for(Integer i : values)
//            {
//                totalNoAces += i;
//            }
//
//            //adds non aces values to numeric hand values
//            if(acesSum.size() == 0)
//            {
//                bestNumericHand.add(bestNumericHand.get(0) + totalNoAces);
//            }
//            // adds the aces to the bestNumericHand value
//            else if(acesSum.size() == 2)
//            {
//                for(int i : acesSum)
//                {
//                    if(i == 1)
//                    {
//                        bestNumericHand.add(i);
//
//                    }
//                    else if(i == 11)
//                    {
//                        bestNumericHand.add(i);
//                    }
//                }
//            }
//
//        }else if(hand.size() == 4)
//        {
//            ArrayList<Integer> values = new ArrayList<>();
//            ArrayList<Integer> acesSum = new ArrayList<>();
//            int totalNoAces = 0;
//
//            // this for loop should get just the last element in the array list hand
//
////            for(int i = hand.size()-1; i >= hand.size()-2; i--)
////            {
//            for(Integer c: hand.get(hand.size()-1).getNumericalValue())
//            {
//                values.add(c);
//                break;
//            }
////            }
//
//
//
//            // this loop should add aces to acesSum array list and then they are removed from values after the loop
//            for(Integer i : values) //new line of code
//            {
//                if(i == 1)
//                {
//                    acesSum.add(i);
//                }
//                else if(i == 11)
//                {
//                    acesSum.add(i);
//                }
//            }
//
//            values.removeIf(i -> i == 1 || i == 11);
//
//            // totals the values that aren't aces
//            for(Integer i : values)
//            {
//                totalNoAces += i;
//            }
//
//            //adds non aces values to numeric hand values
//            if(acesSum.size() == 0)
//            {
//                bestNumericHand.add( totalNoAces);
//            }
//            // adds the aces to the bestNumericHand value
//            else if(acesSum.size() == 2)
//            {
//                for(int i : acesSum)
//                {
//                    if(i == 1)
//                    {
//                        bestNumericHand.add(i);
//
//                    }
//                    else if(i == 11)
//                    {
//                        bestNumericHand.add(i);
//                    }
//                }
//            }
//
//        }else if(hand.size() == 5)
//        {
//            ArrayList<Integer> values = new ArrayList<>();
//            ArrayList<Integer> acesSum = new ArrayList<>();
//            int totalNoAces = 0;
//
//            // this for loop should get just the last element in the array list hand
//
////            for(int i = hand.size()-1; i >= hand.size()-2; i--)
////            {
//            for(Integer c: hand.get(hand.size()-1).getNumericalValue())
//            {
//                values.add(c);
//                break;
//            }
////            }
//
//
//
//            // this loop should add aces to acesSum array list and then they are removed from values after the loop
//            for(Integer i : values) //new line of code
//            {
//                if(i == 1)
//                {
//                    acesSum.add(i);
//                }
//                else if(i == 11)
//                {
//                    acesSum.add(i);
//                }
//            }
//
//            values.removeIf(i -> i == 1 || i == 11);
//
//            // totals the values that aren't aces
//            for(Integer i : values)
//            {
//                totalNoAces += i;
//            }
//
//            //adds non aces values to numeric hand values
//            if(acesSum.size() == 0)
//            {
//                bestNumericHand.add(totalNoAces);
//            }
//            // adds the aces to the bestNumericHand value
//            else if(acesSum.size() == 2)
//            {
//                for(int i : acesSum)
//                {
//                    if(i == 1)
//                    {
//                        bestNumericHand.add(i);
//
//                    }
//                    else if(i == 11)
//                    {
//                        bestNumericHand.add(i);
//                    }
//                }
//            }
//
//        }

        return bestNumericHand;

    }


    public int getBestNumericalHandValue()
    {
        int bestHandValue = 0;
        //adds every sin


        for( int i = 0; i< getNumericalHandValue().size(); i++)
        {
//            if( bestNumericHand.contains(2) && bestNumericHand.contains(22))
            if(hand.get(i).getNumericalValue().contains(1) || hand.get(i).getNumericalValue().contains(11))
            {
                if(getNumericalHandValue().get(getNumericalHandValue().size()-1) < 21)
//                if(bestNumericHand.get(bestNumericHand.size()-1) < 21)
//                { bestHandValue = bestNumericHand.get(bestNumericHand.size()-1); break;}
                {bestHandValue = getNumericalHandValue().get(getNumericalHandValue().size()-1); break;}
//                else if(bestNumericHand.get(bestNumericHand.size()-1) > 21 && bestNumericHand.get(bestNumericHand.size()-2) > 21)
                else if(getNumericalHandValue().get(getNumericalHandValue().size()-2) > 21)
                {bestHandValue = getNumericalHandValue().get(getNumericalHandValue().size()-3); break;}
//                {bestHandValue = bestNumericHand.get(bestNumericHand.size()-3); break;}
//                else if(bestNumericHand.get(bestNumericHand.size()-1) > 21)
                else if(getNumericalHandValue().get(getNumericalHandValue().size()-1) > 21)
                {bestHandValue = getNumericalHandValue().get(getNumericalHandValue().size()-2); break;}
//                {bestHandValue = bestNumericHand.get(bestNumericHand.size()-2); break;}
            }

            else
                if(bestHandValue < 21)
                {
                    bestHandValue += getNumericalHandValue().get(i);
                }
        }


        return bestHandValue;
       }


    public ArrayList<Card> getCards()
    {
        ArrayList<Card> listOfCards = new ArrayList<>();
        for(Card i : hand)
        {
            listOfCards.add(i);

        }hand.clear();

        hand.addAll(listOfCards);

        return hand;
    }

    public int getHandSize()
    {
        int numberOfCards;
        numberOfCards = hand.size();
        return numberOfCards;
    }


}
