package com.example.e1t1_di

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e1t1_di.ui.theme.E1T1_DITheme
import java.time.format.TextStyle

@Composable
fun Login(
    onLoginSuccess: () -> Unit,
    modifier: Modifier = Modifier
) {
    var postaElektronikoa by remember { mutableStateOf("") }
    var pasahitza by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(42.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(412.dp)
            .height(917.dp)
            .background(color = Color(0xFFFFFBEA), shape = RoundedCornerShape(size = 50.dp))
            .padding(start = 25.dp, top = 50.dp, end = 25.dp, bottom = 113.dp)
    ) {
        //Gezia
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(362.dp)
                .height(44.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.botoia),
                contentDescription = "Atzera",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(0.dp)
                    .width(46.8.dp)
                    .height(44.dp)
            )
        }
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
                    .height(109.dp)
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

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .width(344.dp)
                    .height(128.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                    .width(344.dp)
                    .height(54.dp),
                    value = postaElektronikoa,
                    onValueChange = { postaElektronikoa = it },
                    shape = RoundedCornerShape(size = 12.dp),
                    placeholder = {
                        Text(
                            text = "Posta elektronikoa",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF888888),
                            modifier = Modifier
                                .width(127.48235.dp)
                                .height(17.dp)
                            )
                    }
                )

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





