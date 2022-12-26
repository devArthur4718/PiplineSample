package com.devarthur.pipelinesample.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionEvaluatorTest {

    private lateinit var evaluator: ExpressionEvaluator

    @Test
    fun `Simple expression properly evaluated`() {
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.0),
                ExpressionPart.Op(Operation.ADD),
                ExpressionPart.Number(5.0),
                ExpressionPart.Op(Operation.SUBTRACT),
                ExpressionPart.Number(3.0),
                ExpressionPart.Op(Operation.MULTIPLY),
                ExpressionPart.Number(5.0),
                ExpressionPart.Op(Operation.DIVIDE),
                ExpressionPart.Number(3.0)
            )
        )

        assertThat(evaluator.evaluate()).isEqualTo(4)
    }

    @Test
    fun `Decimal expresssion properly evaluated`() {
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(5.5),
                ExpressionPart.Op(Operation.ADD),
                ExpressionPart.Number(10.8)
            )
        )

        assertThat(evaluator.evaluate()).isEqualTo(16.3)
    }

    @Test
    fun `Big decimal expresssion properly evaluated`() {
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(5.0),
                ExpressionPart.Op(Operation.MULTIPLY),
                ExpressionPart.Number(1000000000.0)
            )
        )

        assertThat(evaluator.evaluate()).isEqualTo(5000000000.0)
    }

    @Test
    fun `Negative expresssion properly evaluated`() {
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(25.00),
                ExpressionPart.Op(Operation.SUBTRACT),
                ExpressionPart.Number(100.00)
            )
        )

        assertThat(evaluator.evaluate()).isEqualTo(-75.00)
    }
}
