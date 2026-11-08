package com.example.e1t1_di

import android.R.attr.onClick
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun ekitaldiGuztiak(){

    Log.d("PRUEBA", "He entrado en ekitaldiGuztiak")

    Column(
        // Zutabe nagusia (Hiru seme nagusi)
        verticalArrangement = Arrangement.spacedBy(31.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(412.dp).height(917.dp).background(color = Color(0xFFFFFBEA),
            shape = RoundedCornerShape(size = 50.dp)).padding(start = 25.dp, top = 50.dp, end = 25.dp,
            bottom = 187.dp),

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
                    text = "GUZTIAK",
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

        Row(
            // Bigarren errenkada, guztiak eta egunak (Seme 2)
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(362.dp).height(34.dp)
        ) {

            Button (onClick = {}, modifier =Modifier
                .padding(0.dp)
                .width(82.dp)
                .height(34.dp),
                contentPadding = PaddingValues(0.dp)){
                Text(
                    text = "Antzerkia\n",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(300),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ), modifier = Modifier
                        .width(59.dp)
                        .height(20.dp)
                )
            }

            Button (onClick = {}, Modifier
                .padding(0.dp)
                .width(82.dp)
                .height(34.dp),contentPadding = PaddingValues(0.dp)){
                Text(
                    text = "Dantza\n",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ), modifier = Modifier
                        .width(59.dp)
                        .height(20.dp)
                )
            }

            Button (onClick = {}, Modifier
                .padding(0.dp)
                .width(82.dp)
                .height(34.dp),contentPadding = PaddingValues(0.dp)){
                Text(
                    text = "Hitzaldia\n",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ), modifier = Modifier
                        .width(59.dp)
                        .height(20.dp)
                )
            }

            Button (onClick = {}, Modifier
                .padding(0.dp)
                .width(82.dp)
                .height(34.dp),contentPadding = PaddingValues(0.dp)){
                Text(
                    text = "Kontzertu\n",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ), modifier = Modifier
                        .width(60.dp)
                        .height(20.dp)
                )
            }

        }

        val context = LocalContext.current
        val ekitaldiak = remember { ekitaldiZerrenda().datuakKargatu(context)}
        Log.d("PRUEBA", "Cantidad de eventos: ${ekitaldiak.size}")
        Log.d("PRUEBA", "Eventos: $ekitaldiak")
        remember { Log.d("Lista de personajes",ekitaldiak.toString())}
        LazyColumn(modifier = Modifier) {
            items(ekitaldiak){ekitaldia -> ekitaldiCard3(ekitaldia)}
        }

    }

}
@Composable
fun ekitaldiCard3(ekitaldia : Ekitaldia){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFDF3)),
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 0.dp, vertical = 0.dp).
        border(width = 3.dp, color = Color.Black, shape = RoundedCornerShape(25.dp))
    ){
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 0.dp, vertical = 0.dp)){
            Column(

            ){
                Text (
                    text = "Uztailak"
                )
                Text (
                    text = "24"
                )
            }

            Column(){
                Text(
                    text = ekitaldia.name.toString()
                )
                Text(
                    text = ekitaldia.ordua.toString()
                )
                Button (onClick = {}){
                    Text (
                        text = "Ikusi Gehiago"
                    )
                }
            }
        }
    }
}

@Composable
fun ekitaldiCard(){
    Card (
        // Lehenik eta behin, Card moduan bistaratuko dugu
    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 4.dp)
    ){
       Row(
           // Row izan behar da, alde batetik dugu data eta bestetik hurrengo informazioa
           modifier = Modifier
               .border(width = 3.dp, color = Color(0xFF000000), shape = RoundedCornerShape(size = 25.dp))
           .height(117.dp)
           .background(color = Color(0xFFFFFDF3), shape = RoundedCornerShape(size = 25.dp))
       ){
           Column(
              modifier = Modifier.border(width = 2.5.dp, color = Color(0xFF000000), shape = RoundedCornerShape(size = 18.dp))
               .width(96.dp)
               .height(87.75.dp)
               .background(color = Color(0xFF9BC899), shape = RoundedCornerShape(size = 18.dp))
           ){
               Text(
                   text = "UZTAILAK",
                   style = TextStyle(
                       fontSize = 15.sp,
                       fontWeight = FontWeight(700),
                       color = Color(0xFF000000),
                       textAlign = TextAlign.Center,
                   ), modifier = Modifier
                       .width(82.dp)
                       .height(13.dp)
               )
               Text(
                   text = "24\n",
                   style = TextStyle(
                       fontSize = 16.sp,
                       fontWeight = FontWeight(700),
                       color = Color(0xFF000000),
                       textAlign = TextAlign.Center,
                   ), modifier = Modifier
                       .width(82.dp)
                       .height(13.dp)
               )


           }

           Column(){
               Text(
                   text = "Su Ta Gar + Ostrich Wedding",
                   style = TextStyle(
                       fontSize = 13.sp,
                       fontWeight = FontWeight(700),
                       color = Color(0xFF1A1A1A),
                   ), modifier = Modifier
                       .width(194.dp)
                       .height(17.0625.dp)
               )
               Text(
               text = "23:00 · Doan",
               style = TextStyle(
                   fontSize = 11.sp,
                   fontWeight = FontWeight(400),
                   color = Color(0xFF444444),
               )
               )
               Button (onClick = {}, modifier = Modifier
                   .border(width = 2.dp, color = Color(0xFF000000))
                   .padding(2.dp)
                   .width(116.dp)
                   .height(32.dp)
                   .background(color = Color(0xFF9BC899)),contentPadding = PaddingValues(0.dp)){
                   Text(
                       text = "IKUSI GEHIAGO",
                       style = TextStyle(
                           fontSize = 10.sp,
                           fontWeight = FontWeight(700),
                           color = Color(0xFF1A1A1A),
                           textAlign = TextAlign.Center,
                       ), modifier = Modifier
                           .width(89.dp)
                           .height(14.625.dp)
                   )
               }

           }

       }
    }
}

@Composable
fun ekitaldiCard2(){
    Card (
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFDF3)),
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 3.dp, color = Color(0xFF000000), shape = RoundedCornerShape(25.dp))
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ){
            // Data koadroa
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(color = Color(0xFF9BC899), shape = RoundedCornerShape(18.dp))
                    .border(width = 2.dp, color = Color(0xFF000000), shape = RoundedCornerShape(18.dp))
                    .padding(vertical = 12.dp, horizontal = 14.dp)
            ){
                Text(
                    text = "UZTAILAK",
                    style = TextStyle(
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center
                    )
                )
                Text(
                    text = "24",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center
                    )
                )
            }

            // Informazioaren zutabea
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.weight(1f)
            ){
                Text(
                    text = "Su Ta Gar + Ostrich Wedding",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A1A1A)
                    )
                )
                Text(
                    text = "23:00 · Doan",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF444444)
                    )
                )

                Spacer(modifier = Modifier.height(2.dp))

                Button (
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9BC899)),
                    shape = RoundedCornerShape(10.dp),
                    border = ButtonDefaults.outlinedButtonBorder.copy(width = 2.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    modifier = Modifier.height(30.dp)
                ){
                    Text(
                        text = "IKUSI GEHIAGO",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1A1A1A),
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ekitaldiPreview(){
    ekitaldiGuztiak()
}


