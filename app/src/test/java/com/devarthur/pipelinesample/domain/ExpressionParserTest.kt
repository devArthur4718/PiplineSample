package com.devarthur.pipelinesample.domain

import org.junit.Assert.*
import org.junit.Test

class ExpressionParserTest {

    private lateinit var parser: ExpressionParser

    @Test
    fun `simple expression is properly parsed`() {
        // Given an expression
        parser = ExpressionParser("3+5")

        // When its processed
        val parts = parser.parse()

        // Verifity the result
        val expected = listOf(
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Number(5.0)
        )
    }
}
