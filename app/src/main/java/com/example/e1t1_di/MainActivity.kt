package com.example.e1t1_di

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.e1t1_di.ui.theme.E1T1_DITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            E1T1_DITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNabigazio(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}