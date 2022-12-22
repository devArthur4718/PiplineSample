package com.devarthur.pipelinesample.domain

sealed interface ExpressionPart {
    data class Number(val number: Double) : ExpressionPart
    data class Op(val operation: Operation) : ExpressionPart
    data class Parentheses(val isOpening: Boolean) : ExpressionPart
}

sealed interface ParenthesesType {
    object Opening : ParenthesesType
    object Closing : ParenthesesType
}
