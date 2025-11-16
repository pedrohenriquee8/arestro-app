package br.edu.ifal.aluno.arestro.components.cart

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifal.aluno.arestro.ui.theme.Green90

@Composable
fun Summary(
    subtotal: Double,
    deliveryFee: Double = 5.00,
) {
    Column(
        Modifier
            .padding(16.dp)
            .background(
                color = Green90,
                shape = RoundedCornerShape(12.dp)
            ),
    ) {
        val total = subtotal + deliveryFee

        Spacer(Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Sub-Total", color = Color.White, fontSize = 14.sp)
            Text(
                "Rs %.2f".format(subtotal),
                color = Color.White,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        }
        Spacer(Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Delivery Fee", color = Color.White, fontSize = 14.sp)
            Text(
                "Rs %.2f".format(deliveryFee),
                color = Color.White,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 1.dp,
            color = Color.White.copy(alpha = 0.3f)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Total", color = Color.White, fontSize = 18.sp)
            Text(
                "Rs %.2f".format(total),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = { Log.d("OrderDetailsScreen", "Place My Order clicked") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                "Place My Order",
                color = Green90,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}