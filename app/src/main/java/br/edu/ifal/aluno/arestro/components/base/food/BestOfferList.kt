package br.edu.ifal.aluno.arestro.components.base.food

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import br.edu.ifal.aluno.arestro.model.food.Food
import kotlin.math.abs

@Composable
fun BestOffersList(
    items: List<Food>,
    onItemClick: (Food) -> Unit
) {
    val listState = rememberLazyListState()
    val density = LocalDensity.current
    val itemWidthDp: Dp = 150.dp

    LazyRow(
        state = listState,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(items) { index, item ->

            val scale by remember {
                derivedStateOf {
                    val itemSizePx = with(density) { itemWidthDp.toPx() }

                    val itemOffset = listState.layoutInfo.visibleItemsInfo
                        .find { it.index == index }
                        ?.offset ?: 0

                    val viewportCenter = listState.layoutInfo.viewportSize.width / 2f
                    val itemCenter = itemOffset + itemSizePx / 2f
                    val distanceFromCenter = abs(itemCenter - viewportCenter)

                    val maxScale = 1.2f
                    val minScale = 1.0f
                    val scaleRange = maxScale - minScale


                    val normalizedDistance = (distanceFromCenter / viewportCenter).coerceIn(0f, 1f)

                    maxScale - (scaleRange * normalizedDistance)
                }
            }

            FoodCardItem(
                item = item,
                scale = scale,
                onItemClick = onItemClick
            )
        }
    }
}