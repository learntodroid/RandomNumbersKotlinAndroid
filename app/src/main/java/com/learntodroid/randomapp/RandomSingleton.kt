package com.learntodroid.randomapp

import kotlin.random.Random

object RandomSingleton {
    /**
     * Generates and returns a random integer between two integers (inclusive)
     * @param from The random number generated will be greater than or equal to from
     * @param to The random number generated will be less than or equal to to
     * @return The random integer generated
     */
    fun randomInteger(from: Int, to: Int): Int {
        return (from..to).random();
    }

    /**
     * Generates and returns a random double between two double inclusive of from but exlusive of until
     * @param from The random number generated will be greater than or equal to from
     * @param until The random number generated will be less than until
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

    /**
     * Returns a list of random numbers of the size specified with all random numbers between from and to values
     * @param size Amount of random numbers requested
     * @param from All random numbers generated will be greater than or equal to from
     * @param to All random numbers generated will be less than or equal to to
     * @return A list of random numbers
     */
    fun listOfRandomNumbers(size: Int, from: Int, to: Int) : List<Int> {
        var randomNumbers  = (0 until size).map { (from .. to).random() }
        return randomNumbers;
    }
}