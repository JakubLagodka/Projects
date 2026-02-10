package org.example

class Kotlin {
    val possibleBrackets = mapOf('(' to ')', '{' to '}', '[' to ']')

    fun validateBracketString(input: String): Boolean {
        val openedBrackets = mutableListOf<Char>()

        for (character in input) {
            if (character in possibleBrackets.keys) openedBrackets.add(character)
            else if (isCorrectClosingBracket(openedBrackets, character)) openedBrackets.removeLast()
            else return false
        }

        return openedBrackets.isEmpty()
    }

    fun isCorrectClosingBracket(openedBrackets: List<Char>, character: Char): Boolean {
        return openedBrackets.isNotEmpty() && possibleBrackets.containsValue(character) && possibleBrackets[openedBrackets.last()] == character
    }

    fun main() {
        val input = "(())"

        println(validateBracketString(input))
    }
}