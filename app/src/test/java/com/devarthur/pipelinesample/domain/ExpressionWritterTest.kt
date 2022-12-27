package com.devarthur.pipelinesample.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ExpressionWritterTest {

    private lateinit var writter: ExpressionWriter

    @Before
    fun setUp() {
        writter = ExpressionWriter()
    }

    @Test
    fun `Initial parentheses parsed`() {
        writter.processAction(CalculatorAction.Parentheses)
        writter.processAction(CalculatorAction.Number(5))
        writter.processAction(CalculatorAction.Op(Operation.ADD))
        writter.processAction(CalculatorAction.Number(4))
        writter.processAction(CalculatorAction.Parentheses)

        assertThat(writter.expression).isEqualTo("(5+4)")
    }

    @Test
    fun `Closing parentheses at the start not parsed`() {
        writter.processAction(CalculatorAction.Parentheses)
        writter.processAction(CalculatorAction.Parentheses)

        assertThat(writter.expression).isEqualTo("((")
    }

    @Test
    fun `Parentheses around a number are parsed`() {
        writter.processAction(CalculatorAction.Parentheses)
        writter.processAction(CalculatorAction.Number(5))
        writter.processAction(CalculatorAction.Parentheses)

        assertThat(writter.expression).isEqualTo("(5)")
    }
}
