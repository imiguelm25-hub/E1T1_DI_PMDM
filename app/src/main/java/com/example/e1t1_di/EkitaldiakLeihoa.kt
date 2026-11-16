package com.example.e1t1_di

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e1t1_di.ekitaldiDatuak.Ekitaldia
import com.example.e1t1_di.ekitaldiDatuak.EkitaldiZerrenda
import java.time.LocalDate

@Composable
fun ekitaldiGuztiak(onBack: () -> Unit = {}) {
    val context = LocalContext.current
    val ekitaldiak = remember { EkitaldiZerrenda().datuakKargatu(context) }

    var motaAukeratua by remember { mutableStateOf("Antzerkia") }
    var ekitaldiAukeratua by remember { mutableStateOf<Ekitaldia?>(null) }

    val aukeratua = ekitaldiAukeratua
    if (aukeratua != null) {
        BackHandler { ekitaldiAukeratua = null }
        Ekitaldi(
            ekitaldia = aukeratua,
            onBack = { ekitaldiAukeratua = null }
        )
        return
    }

    Column(
        // Zutabe nagusia (Hiru seme nagusi)
        verticalArrangement = Arrangement.spacedBy(31.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(412.dp)
            .height(917.dp)
            .background(
                color = Color(0xFFFFFBEA),
                shape = RoundedCornerShape(size = 50.dp)
            )
            .padding(
                start = 25.dp, top = 50.dp, end = 25.dp,
                bottom = 110.dp
            ),

        ) {

        Goiburua(izenburua = "GUZTIAK", onBack = onBack)

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(362.dp)
                .height(44.dp)
        ) {

            Button(
                onClick = { motaAukeratua = "Antzerkia" },
                modifier = Modifier
                    .weight(1f)
                    .height(42.dp),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Color.Black),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (motaAukeratua == "Antzerkia")
                        Color(0xFF9BC89B)
                    else
                        Color(0xFFFFFBEA)
                )
            ) {
                Text(
                    text = "Antzerkia",
                    fontSize = 15.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }

            Button(
                onClick = { motaAukeratua = "Dantza" },
                modifier = Modifier
                    .weight(1f)
                    .height(42.dp),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Color.Black),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (motaAukeratua == "Dantza")
                        Color(0xFFBDB2FF)
                    else
                        Color(0xFFFFFBEA)
                )
            ) {
                Text("Dantza", fontSize = 15.sp, color = Color.Black)
            }

            Button(
                onClick = { motaAukeratua = "Hitzaldia" },
                modifier = Modifier
                    .weight(1f)
                    .height(42.dp),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Color.Black),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (motaAukeratua == "Hitzaldia")
                        Color(0xFFFFD166)
                    else
                        Color(0xFFFFFBEA)
                )
            ) {
                Text("Hitzaldia", fontSize = 15.sp, color = Color.Black)
            }

            Button(
                onClick = { motaAukeratua = "Kontzertua" },
                modifier = Modifier
                    .weight(1f)
                    .height(42.dp),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Color.Black),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (motaAukeratua == "Kontzertua")
                        Color(0xFFFFB4A2)
                    else
                        Color(0xFFFFFBEA)
                )
            ) {
                Text("Kontzertu", fontSize = 15.sp, color = Color.Black)
            }
        }


        val ekitaldiIragaziak = if (motaAukeratua == "Guztiak") {
            ekitaldiak
        } else {
            ekitaldiak.filter {
                it.mota.equals(motaAukeratua, ignoreCase = true)
            }
        }

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(ekitaldiIragaziak) { ekitaldia ->
                ekitaldiCard(
                    ekitaldia = ekitaldia,
                    onIkusiGehiagoClick = { ekitaldiAukeratua = it }
                )
            }
        }
    }
}

@Composable
fun ekitaldiCard(
    ekitaldia: Ekitaldia,
    onIkusiGehiagoClick: (Ekitaldia) -> Unit = {}
) {

    val kolorea = when (ekitaldia.mota) {
        "Antzerkia" -> Color(0xFF9BC89B)
        "Dantza" -> Color(0xFFBDB2FF)
        "Hitzaldia" -> Color(0xFFFFD166)
        "Kontzertua" -> Color(0xFFFFB4A2)
        else -> Color.LightGray
    }

    val hilabeteak = listOf(
        "Urtarrila",
        "Otsaila",
        "Martxoa",
        "Apirila",
        "Maiatza",
        "Ekaina",
        "Uztaila",
        "Abuztua",
        "Iraila",
        "Urria",
        "Azaroa",
        "Abendua"
    )
    val data1 = ekitaldia.data?.data

    val dataAmaiera = data1?.let {
        LocalDate.parse(it.substring(0, 10))
    }

    val hilaZbk = dataAmaiera?.monthValue
    val eguna = dataAmaiera?.dayOfMonth

    val hilabetea = hilaZbk?.let {
        hilabeteak[it - 1]
    }

    Card(
        shape = RoundedCornerShape(25.dp),
        border = BorderStroke(3.dp, Color.Black),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFBEA)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(112.dp)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(9.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(94.dp)
                    .height(82.dp)
                    .background(
                        color = kolorea,
                        shape = RoundedCornerShape(18.dp)
                    )
                    .border(
                        width = 2.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(18.dp)
                    ),

                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "${hilabetea}",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Text(
                        text = "${eguna}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {

                // Ekitaldiaren izena
                Text(
                    text = ekitaldia.name ?: "",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                // Ordua eta prezioa
                Text(
                    text = "${ekitaldia.ordua ?: ""}  |  ${ekitaldia.prezioaTestua ?: "Doan"}",
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                // Ikusi Gehiago botoia
                Button(
                    onClick = {
                        onIkusiGehiagoClick(ekitaldia)
                    },
                    contentPadding = PaddingValues(
                        horizontal = 32.dp,
                        vertical = 0.dp
                    ),
                    border = BorderStroke(2.dp, Color.Black),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = kolorea,
                        contentColor = Color.Black
                    ), modifier = Modifier.padding(horizontal = 15.dp)
                ) {
                    Text(
                        text = "IKUSI GEHIAGO",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ekitaldiPreview() {
    ekitaldiGuztiak()
}