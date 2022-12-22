package com.devarthur.pipelinesample.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionParserTest {

    private lateinit var parser: ExpressionParser

    @Test
    fun `simple expression is properly parsed`() {
        // Given an expression
        parser = ExpressionParser("3+5")

        // When its processed
        val actualParsedList = parser.parse()

        // Verifity the result
        val expectedParsedList = listOf(
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Number(5.0)
        )

        assertThat(expectedParsedList).isEqualTo(actualParsedList)
    }
}
