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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ekitaldiGuztiak (){
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

           Box (
               modifier = Modifier
                   .padding(0.dp)
                   .width(46.8.dp)
                   .height(44.dp) .size(32.dp)
                   .background(Color.White, CircleShape)
                   .border(1.dp, Color.Black, CircleShape)
                   .clickable {
                       // Acción al pulsar
                   }
           ){
               //Gezia irudia

           }

            Row(
                // Guztiak
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .border(width = 3.dp, color = Color(0xFF222222),
                        shape = RoundedCornerShape(size = 10.dp)).padding(1.5.dp)
                .width(120.dp)
                .height(40.dp)
                .background(color = Color(0xFFFFFBEA), shape = RoundedCornerShape(size = 10.dp))
                .padding(start = 20.dp, top = 3.dp, end = 20.dp, bottom = 4.dp)
            ) {

            }

            Image(
                // Profilaren logoa
                painter = painterResource(id = R.drawable.profila),
                contentDescription = "image description",
                contentScale = ContentScale.None,
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

        }

        Column(
            // Card elementuen zutabea da (Seme 3)
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.width(341.dp).height(645.dp)
        ) {



        }

    }

}

@Preview(showBackground = true)
@Composable
fun ekitaldiPreview(){
    ekitaldiGuztiak()
}


