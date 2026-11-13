package com.example.e1t1_di

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun Login(onLoginSuccess: () -> Unit, modifier: Modifier = Modifier) {
    var postaElektronikoa by remember { mutableStateOf("") }
    var pasahitza by remember { mutableStateOf("") }
    var errorea by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .width(412.dp)
            .height(917.dp)
            .background(color = Color(0xFFFFFBEA), shape = RoundedCornerShape(size = 50.dp))
            .padding(start = 25.dp, top = 150.dp, end = 25.dp, bottom = 113.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(344.dp)
                .height(518.dp)
        ) {

            //Logoa
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "image description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(156.dp)
                    .height(90.dp)
            )

            //Saioa hasi
            Text(
                text = "SAIOA HASI",
                fontSize = 22.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(344.dp)
                    .height(27.dp),

                )

            //Frame 5
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .width(344.dp)
                    .height(128.dp)
            ) {

                //Posta elektronikoa
                OutlinedTextField(
                    modifier = Modifier
                        .width(344.dp)
                        .height(54.dp)
                        .border(2.5.dp, Color(0xFF000000), RoundedCornerShape(size = 12.dp)),
                    value = postaElektronikoa,
                    onValueChange = { postaElektronikoa = it },
                    shape = RoundedCornerShape(size = 12.dp),
                    placeholder = {
                        Text(
                            text = "Posta elektronikoa",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF888888)
                        )
                    }
                )

                //Pasahitza
                OutlinedTextField(
                    modifier = Modifier
                        .width(344.dp)
                        .height(54.dp)
                        .border(2.5.dp, Color(0xFF000000), RoundedCornerShape(size = 12.dp)),
                    value = pasahitza,
                    onValueChange = { pasahitza = it },
                    shape = RoundedCornerShape(size = 12.dp),
                    placeholder = {
                        Text(
                            text = "Pasahitza",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF888888),
                        )
                    }
                )

                //Logina zuzena ez bada, errore mezua agertzen da
                if (errorea) {
                    Text(
                        text = "Posta elektronikoa edo pasahitza okerra",
                        color = Color.Red,
                        fontSize = 12.sp
                    )
                }
            }

            //Frame 7
            Column(
                verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .width(344.dp)
                    .height(164.dp)
            ) {
                //Frame 6
                Column(
                    verticalArrangement = Arrangement.spacedBy(25.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            if (postaElektronikoa.trim() == "admin@gmail.com" && pasahitza == "admin123") {
                                errorea = false
                                onLoginSuccess()
                            } else {
                                errorea = true
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
                            text = "SARTU",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFFDF3),
                            textAlign = TextAlign.Center,
                        )
                    }

                    //Frame 3
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(1.5.dp)
                                .background(Color(0xFFBBBBBB))
                        )
                        Text(
                            text = "edo",
                            fontSize = 11.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF777777),
                            modifier = Modifier.padding(horizontal = 12.dp)
                        )
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(1.5.dp)
                                .background(Color(0xFFBBBBBB))
                        )
                    }

                    //Gonbidatu botoia
                    Button(
                        onClick = { onLoginSuccess() },
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFBEA)),
                        border = BorderStroke(3.dp, Color.Black),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                    ) {
                        Text(
                            text = "GONBIDATU GISA JARRAITU",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Center,
                        )
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    E1T1_DITheme {
        Login(onLoginSuccess = {})
    }
}





