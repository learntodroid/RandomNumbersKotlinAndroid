package com.learntodroid.randomapp

class Deck {
    var faceValues = listOf("A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2");
    var suits = listOf("H", "D", "C", "S");
    var cards = mutableListOf<String>();
    var drawCard = "Shuffle the deck";

    fun initDeck() {
        cards = mutableListOf<String>();
        for (s: String in suits) {
            for (c: String in faceValues) {
                cards.add(c + s);
            }
        }
    }

    fun shuffleDeck() {
        cards = RandomSingleton.shuffleListOfStrings(cards);
        drawCard = "Draw a card";
    }

    fun drawACard(): Boolean {
        if (cards.size > 0) {
            drawCard = cards.removeAt(0);
            return true;
        }
        return false;
    }
}