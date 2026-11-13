package com.example.e1t1_di

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e1t1_di.ekitaldiDatuak.Ekitaldia
import com.example.e1t1_di.ekitaldiDatuak.ekitaldiZerrenda
import java.time.LocalDate


@Composable
fun Ekitaldi(ekitaldia: Ekitaldia) {
    Column(
        verticalArrangement = Arrangement.spacedBy(31.dp, Alignment.Top),
        modifier = Modifier
            .padding(20.dp)
    ) {
    Row(
        // Tituluaren errenkada nagusia (Seme 1)
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(362.dp)
            .height(44.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.botoia),
            contentDescription = "image description",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(0.dp)
                .width(46.8.dp)
                .height(44.dp)
                //.clickable { onBack() }
        )

        Row(
            // Guztiak
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .border(width = 3.dp, color = Color(0xFF222222),
                    shape = RoundedCornerShape(size = 10.dp))
                .width(120.dp)
                .height(40.dp)
                .background(color = Color(0xFFFFFBEA), shape = RoundedCornerShape(size = 10.dp))
                .padding(start = 10.dp, top = 3.dp, end = 10.dp, bottom = 4.dp)
        ) {

            Text(
                // Textua
                text = "EKITALDI",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.height(24.dp)
            )

        }

        Image(
            // Profilaren logoa
            painter = painterResource(id = R.drawable.profila),
            contentDescription = "image description",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(0.dp)
                .width(44.dp)
                .height(44.dp)
        )
    }

        Image(
            // Profilaren logoa
            painter = painterResource(id = R.drawable.ekitaldi),
            contentDescription = "image description",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .border(width = 3.dp, color = Color(0xFF000000), shape = RoundedCornerShape(size = 30.dp))
            .width(341.dp)
            .height(230.dp)
            .clip(RoundedCornerShape(30.dp))
        )

        Text(
            modifier = Modifier
                .width(274.dp)
                .height(21.dp),
            text = "${ekitaldia.name}",
            style = TextStyle(
                fontSize = 17.sp,
                //fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(700),
                color = Color(0xFF1A1A1A),
            )
        )

        Column(
            modifier = Modifier
                .padding(0.dp)
                .width(250.dp)
                .height(146.dp)
        ) {
            //Data
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(25.dp)
            ) {
                Box(

                ) {
                    Image(
                        // Profilaren logoa
                        painter = painterResource(id = R.drawable.ellipse_7),
                        contentDescription = "image description",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(0.dp)
                            .width(44.dp)
                            .height(44.dp)
                    )
                }
                val hilabeteak = listOf(
                    "Urtarrilak",
                    "Otsailak",
                    "Martxoak",
                    "Apirilak",
                    "Maiatzak",
                    "Ekainak",
                    "Uztailak",
                    "Abuztuak",
                    "Irailak",
                    "Urriak",
                    "Azaroak",
                    "Abenduak"
                )
                val data1 = ekitaldia.data?.data

                val dataAmaiera = data1?.let {
                    LocalDate.parse(it.substring(0,10))
                }

                val urtea = dataAmaiera?.year
                val hilaZbk = dataAmaiera?.monthValue
                val eguna = dataAmaiera?.dayOfMonth

                val hilabetea = hilaZbk?.let {
                    hilabeteak[it -1]
                }


                Text(
                    text = "${urtea}ko ${hilabetea} ${eguna}a",
                    style = TextStyle(
                        fontSize = 14.sp,
                        //fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    )
                )
                }

            }

            //Ordua
            Row() {
                Text(
                    text = "23:00",
                    style = TextStyle(
                        fontSize = 14.sp,
                        //fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    )
                )
            }

            //Lekua
            Row() { }

            //Prezioa
            Row() { }
        }
}


@Preview(showBackground = true)
@Composable
fun EkitaldiPreview(){
    val context = LocalContext.current
    val ekitaldiak = remember { ekitaldiZerrenda().datuakKargatu(context)}
    val ekitaldia = ekitaldiak[0]

    Ekitaldi(ekitaldia)
}