package com.example.e1t1_di

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e1t1_di.ekitaldiDatuak.Ekitaldia
import com.example.e1t1_di.ekitaldiDatuak.Izenematea
import com.example.e1t1_di.ekitaldiDatuak.EkitaldiZerrenda
import java.time.LocalDate


@Composable
fun Ekitaldi(ekitaldia: Ekitaldia) {

    var izenAbizenak by remember { mutableStateOf("") }
    var telefonoa by remember { mutableStateOf("") }
    val izenemateak = remember { mutableStateListOf<Izenematea>() }

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color(0xFFFFFBEA), shape = RoundedCornerShape(size = 50.dp))
            .padding(start = 25.dp, top = 50.dp, end = 25.dp, bottom = 40.dp),
        verticalArrangement = Arrangement.spacedBy(31.dp, Alignment.Top),

    ) {
        //goiburua
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
                    .border(
                        width = 3.dp, color = Color(0xFF222222),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
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
       //ekitaldiaren argazkia
        Image(
            // Profilaren logoa
            painter = painterResource(id = R.drawable.ekitaldi),
            contentDescription = "image description",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .border(
                    width = 3.dp,
                    color = Color(0xFF000000),
                    shape = RoundedCornerShape(size = 30.dp)
                )
                .width(341.dp)
                .height(230.dp)
                .clip(RoundedCornerShape(30.dp))
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "${ekitaldia.name}",
            style = TextStyle(
                fontSize = 17.sp,
                //fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(700),
                color = Color(0xFF1A1A1A),
                textAlign = TextAlign.Center
            )
        )

        Column(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            //Data
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        // Profilaren logoa
                        painter = painterResource(id = R.drawable.ellipse),
                        contentDescription = "image description",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(0.dp)
                            .width(44.dp)
                            .height(44.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.group),
                        contentDescription = "image description",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(22.dp)
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
                    LocalDate.parse(it.substring(0, 10))
                }

                val urtea = dataAmaiera?.year
                val hilaZbk = dataAmaiera?.monthValue
                val eguna = dataAmaiera?.dayOfMonth

                val hilabetea = hilaZbk?.let {
                    hilabeteak[it - 1]
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


            //Ordua
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        // Profilaren logoa
                        painter = painterResource(id = R.drawable.ellipse),
                        contentDescription = "image description",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(0.dp)
                            .width(44.dp)
                            .height(44.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ordua),
                        contentDescription = "image description",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(22.dp)
                    )
                }

                Text(
                    text = "${ekitaldia.ordua}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        //fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    )
                )
            }

            //Lekua
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        // Profilaren logoa
                        painter = painterResource(id = R.drawable.ellipse),
                        contentDescription = "image description",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(0.dp)
                            .width(44.dp)
                            .height(44.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.kokapena),
                        contentDescription = "image description",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(22.dp)
                    )
                }

                Text(
                    text = "${ekitaldia.lekua}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        //fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF1A1A1A),
                    )
                )
            }

            //Prezioa
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        // Profilaren logoa
                        painter = painterResource(id = R.drawable.ellipse),
                        contentDescription = "image description",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(0.dp)
                            .width(44.dp)
                            .height(44.dp)
                    )
                    Text(
                        text = "€",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF1A1A1A)
                        ),
                        modifier = Modifier.offset(x = (-2).dp)
                    )
                }

                Text(
                    text = "${ekitaldia.prezioaTestua}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        //fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF1A1A1A),
                    )
                )
            }
        }

        Text(
            text = "EKITALDIAN IZENA EMAN",
            style = TextStyle(
                fontSize = 20.sp,
                //fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(700),
                color = Color(0xFF1A1A1A),
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(19.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            //Izena eta abizena
            OutlinedTextField(
                value = izenAbizenak,
                onValueChange = { izenAbizenak = it },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                placeholder = {
                    Text(
                        text = "Izena eta Abizena",
                        fontSize = 14.sp,
                        color = Color(0xFF888888)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .border(2.5.dp, Color(0xFF000000), RoundedCornerShape(12.dp))
            )

            //Telefonoa
            OutlinedTextField(
                value = telefonoa,
                onValueChange = { telefonoa = it },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                shape = RoundedCornerShape(12.dp),
                placeholder = {
                    Text(
                        text = "Telefonoa",
                        fontSize = 14.sp,
                        color = Color(0xFF888888)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .border(2.5.dp, Color(0xFF000000), RoundedCornerShape(12.dp))
            )

            //Izena eman botoia
            Button(
                onClick = {
                    if (izenAbizenak.isNotBlank() && telefonoa.isNotBlank()) {
                        izenemateak.add(Izenematea(izenAbizenak.trim(), telefonoa.trim()))
                        izenAbizenak = ""
                        telefonoa = ""
                    }
                },
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E7F5C)),
                border = BorderStroke(3.dp, Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    text = "IZENA EMAN",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFFDF3),
                    textAlign = TextAlign.Center
                )
            }
        }

        }
    }


@Preview(showBackground = true)
@Composable
fun EkitaldiPreview() {
    val context = LocalContext.current
    val ekitaldiak = remember { EkitaldiZerrenda().datuakKargatu(context) }
    val ekitaldia = ekitaldiak[0]

    Ekitaldi(ekitaldia)
}