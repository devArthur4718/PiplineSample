package com.devarthur.pipelinesample.presentation

import androidx.compose.runtime.Composable
import com.devarthur.pipelinesample.domain.CalculatorAction

data class CalculatorUiAction(
    val text: String?,
    val highlightLevel: HighLightLevel,
    val action: CalculatorAction,
    val content: @Composable () -> Unit = {},
)

sealed interface HighLightLevel {
    object Neutral : HighLightLevel

    object SemiHighlighted : HighLightLevel

    object Highlighted : HighLightLevel

    object StronglyHighlithed : HighLightLevel
}
