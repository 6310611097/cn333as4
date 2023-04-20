package com.example.myapplication4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication4.ui.page.ShareViewModel
import com.example.myapplication4.ui.theme.MyApplication4Theme
import com.example.myapplication4.ui.page.mainpage
import com.example.myapplication4.ui.page.picture

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    val shareViewModel:ShareViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable(route = "main") {
            mainpage(navController, shareViewModel)
        }
        composable(route = "pic") {
            picture(shareViewModel)
        }
    }
}