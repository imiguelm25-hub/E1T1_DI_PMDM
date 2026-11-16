package com.example.e1t1_di

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Goiburua(izenburua: String, onBack: () -> Unit = {}) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.botoia),
            contentDescription = "Atzera",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(46.8.dp)
                .height(44.dp)
                .clickable { onBack() }
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .border(3.dp, Color(0xFF222222), RoundedCornerShape(10.dp))
                .width(120.dp)
                .height(40.dp)
                .background(Color(0xFFFFFBEA), RoundedCornerShape(10.dp))
                .padding(start = 10.dp, top = 3.dp, end = 10.dp, bottom = 4.dp)
        ) {
            Text(
                text = izenburua,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center
                )
            )
        }
        Image(
            painter = painterResource(id = R.drawable.profila),
            contentDescription = "Profila",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(44.dp)
        )
    }
}