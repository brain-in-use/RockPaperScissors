package com.example.rockpaperscissors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.rockpaperscissors.ui.theme.RockPaperScissorsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RockPaperScissorsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Game(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Game(modifier: Modifier = Modifier) {

    Player("Computer")
}

@Composable
fun Player(name: String, modifier: Modifier=Modifier){
    Text(
        text = name,
        modifier = modifier
    )
    Image(painter = painterResource(id = R.drawable.rock), contentDescription =null )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RockPaperScissorsTheme {
        Game()
    }
}