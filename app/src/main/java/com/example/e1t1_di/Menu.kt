package com.example.e1t1_di

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e1t1_di.ui.theme.E1T1_DITheme

@Composable
fun Menua(
    onBack: () -> Unit, modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(55.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(412.dp)
            .height(917.dp)
            .background(color = Color(0xFFFFFBEA), shape = RoundedCornerShape(size = 50.dp))
            .padding(start = 25.dp, top = 50.dp, end = 25.dp, bottom = 41.dp)
    ) {
        //Goiburua
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(362.dp)
                .height(44.dp)
        ) {
            //Gezia
            Image(
                painter = painterResource(id = R.drawable.botoia),
                contentDescription = "image description",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(0.dp)
                    .width(46.8.dp)
                    .height(44.dp)
            )
            //Frame37
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .border(
                        width = 3.dp,
                        color = Color(0xFF222222),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(1.5.dp)
                    .width(120.dp)
                    .height(40.dp)
                    .background(color = Color(0xFFFFFBEA), shape = RoundedCornerShape(size = 10.dp))
                    .padding(start = 20.dp, top = 3.dp, end = 20.dp, bottom = 4.dp)
            ) {
                Text(
                    text = "MENUA",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,

                    )
            }
            //Profila
            Image(
                painter = painterResource(id = R.drawable.profila),
                contentDescription = "image description",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(0.dp)
                    .width(44.dp)
                    .height(44.dp)
            )
        }

        //Frame10
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .width(343.dp)
                .height(229.dp)
        ) {
            Text(
                text = "GOMENDATUTAKO EKITALDIAK ",
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF1A1A1A),
                modifier = Modifier
                    .width(343.dp)
                    .height(24.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.irudimenu),
                contentDescription = "image description",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .border(
                        width = 3.dp,
                        color = Color(0xFF000000),
                        shape = RoundedCornerShape(size = 35.dp)
                    )
                    .width(343.dp)
                    .height(200.dp)
            )
        }
        //Frame39
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {},
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E7F5C)),
                border = BorderStroke(3.dp, Color.Black),
                modifier = Modifier
                    .width(222.dp)
                    .height(56.dp)
            ) {
                Text(
                    text = "EKITALDI GUZTIAK",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(186.dp)
                        .height(24.dp)
                )
            }
        }

        //Frame9
        Column(
            verticalArrangement = Arrangement.spacedBy(13.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .width(343.dp)
                .height(377.dp)
        ) {
            // Child views.
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MenuaPreview() {
    E1T1_DITheme {
        Menua(onBack = {})
    }
}