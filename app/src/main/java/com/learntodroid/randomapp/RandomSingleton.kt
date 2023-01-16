package com.learntodroid.randomapp

import kotlin.random.Random

object RandomSingleton {
    /**
     * Generates and returns a random integer between two integers (inclusive)
     * @param from The random generated will be greater than or equal to from
     * @param to The random generated will be less than or equal to to
     * @return The random integer generated
     */
    fun randomInteger(from: Int, to: Int): Int {
        return (from..to).random();
    }

    /**
     * Generates and returns a random double between two double inclusive of from but exlusive of until
     * @param from The random generated will be greater than or equal to from
     * @param until The random generated will be less than
     * @return The random double generated
     */
    fun randomDouble(from: Double, until: Double): Double {
        return Random.nextDouble(from, until);
    }

    /**
     * Returns a random string from a list of strings
     * @param list List of strings
     * @return A random string from the list
     */
    fun randomStringFromList(list: List<String>): String {
        return list.random()
    }

    /**
     * Returns a shuffled order of a list of strings
     * @param list List of strings
     * @return A shuffled list of the provided list of strings
     */
    fun shuffleListOfStrings(list: MutableList<String>): MutableList<String> {
        list.shuffle();
        return list;
    }
}