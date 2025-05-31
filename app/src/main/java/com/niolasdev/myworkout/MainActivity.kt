package com.niolasdev.myworkout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.niolasdev.myworkout.ui.MainScreen
import com.niolasdev.myworkout.ui.theme.DefaultTheme
import com.niolasdev.myworkout.ui.theme.Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DefaultTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Theme.colors.primary,
                ) {
                    MainScreen()
                }
            }
        }
    }
}