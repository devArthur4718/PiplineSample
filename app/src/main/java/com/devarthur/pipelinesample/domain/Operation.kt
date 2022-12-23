package com.devarthur.pipelinesample.domain

enum class Operation(val symbol: Char) {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    PERCENT('%')
}

val operationsSymbols = Operation.values().map { it.symbol }.joinToString("")

fun operationFromSymbol(symbol: Char): Operation {
    return Operation.values().find { it.symbol == symbol }
        ?: throw IllegalArgumentException("Invalid Symbol")
}
