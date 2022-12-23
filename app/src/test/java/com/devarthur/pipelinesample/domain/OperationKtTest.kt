package com.devarthur.pipelinesample.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class OperationKtTest {

    @Test
    fun `verify if invalid symbol returns an exception with message`() {
        try {
            // Given an invalid symbol like:
            val invalidSymbol = '#'

            // When we call the operationFromSymbol method.
            operationFromSymbol(invalidSymbol)
        } catch (e: Exception) {
            assertThat(e)
                .hasMessageThat()
                .startsWith("Invalid")
        }
    }

    @Test
    fun `verify if valid symbol returns an object of type Operation`() {
        // Given an valid symbol like +(ADD)
        val validSymbol = '+'

        // When we parse it, it should return an object of type Operation
        val returned = operationFromSymbol(validSymbol)

        // verify that the returned object is an Operation
        assertThat(returned)
            .isInstanceOf(Operation::class.java)
    }
}
