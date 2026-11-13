package com.example.e1t1_di

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e1t1_di.ui.theme.E1T1_DITheme

data class GomendatutakoEkitaldia(
    val hilabetea: String,
    val eguna: String,
    val izena: String,
    val ordua: String,
    val kolorea: Color
)

@Composable
fun Menua(
    onBack: () -> Unit = {},
    onEkitaldiGuztiak: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val gomendatutakoEkitaldiak = listOf(
        GomendatutakoEkitaldia(
            hilabetea = "UZTAILAK",
            eguna = "20",
            izena = "Su Ta Gar + Ostrich Wedding",
            ordua = "23:00 · Doan",
            kolorea = Color(0xFFFFB4A2)
        ),
        GomendatutakoEkitaldia(
            hilabetea = "MAIATZAK",
            eguna = "4",
            izena = "Dantzari Txiki Eguna 2024",
            ordua = "19:00 · Doan",
            kolorea = Color(0xFFBDB2FF)
        ),
        GomendatutakoEkitaldia(
            hilabetea = "UZTAILAK",
            eguna = "1",
            izena = "CLOWN tailerra (Bilbao)",
            ordua = "09:00-14:00",
            kolorea = Color(0xFF9BC89B)
        )
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(18.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
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
                    .clickable { onBack() }
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
                    .padding(start = 10.dp, top = 3.dp, end = 10.dp, bottom = 4.dp)
            ) {
                Text(
                    text = "MENUA",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center
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
                    .clip(RoundedCornerShape(size = 35.dp))
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
                onClick = { onEkitaldiGuztiak() },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E7F5C)),
                border = BorderStroke(3.dp, Color.Black),
                contentPadding = PaddingValues(0.dp),
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
            gomendatutakoEkitaldiak.forEach { ekitaldia ->
                MenuEkitaldiTxartela(
                    hilabetea = ekitaldia.hilabetea,
                    eguna = ekitaldia.eguna,
                    izena = ekitaldia.izena,
                    ordua = ekitaldia.ordua,
                    kolorea = ekitaldia.kolorea,
                )
            }
        }
    }
}

@Composable
fun MenuEkitaldiTxartela(
    hilabetea: String,
    eguna: String,
    izena: String,
    ordua: String,
    kolorea: Color,
) {
    Card(
        shape = RoundedCornerShape(size = 25.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFDF3)),
        modifier = Modifier
            .width(343.dp)
            .height(117.dp)
            .border(
                width = 3.dp,
                color = Color(0xFF000000),
                shape = RoundedCornerShape(size = 25.dp)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp)
        ) {
            // Data koadroa
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
                modifier = Modifier
                    .width(96.dp)
                    .height(88.dp)
                    .background(color = kolorea, shape = RoundedCornerShape(size = 18.dp))
                    .border(
                        width = 2.5.dp,
                        color = Color(0xFF000000),
                        shape = RoundedCornerShape(size = 18.dp)
                    )
            ) {
                Text(
                    text = hilabetea,
                    fontSize = 15.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = eguna,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center
                )
            }

            // Ekitaldiaren informazioa eta botoia
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = izena,
                    fontSize = 13.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF1A1A1A)
                )
                Text(
                    text = ordua,
                    fontSize = 11.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF444444)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuaPreview() {
    E1T1_DITheme {
        Menua()
    }
}