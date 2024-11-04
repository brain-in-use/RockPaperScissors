package com.example.rockpaperscissors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rockpaperscissors.ui.theme.RockPaperScissorsTheme
import kotlin.random.Random

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
    val computerChoice = Random.nextInt(1, 4)
    var result by remember { mutableStateOf(3) }
    val imageResource1 = when (computerChoice) {
        1 -> R.drawable.rock
        2 -> R.drawable.paper
        else -> R.drawable.scissors
    }
    val imageResource2 = when (result) {
        1 -> R.drawable.rock
        2 -> R.drawable.paper
        else -> R.drawable.scissors
    }

    Column(modifier = modifier.fillMaxWidth().verticalScroll(state = rememberScrollState()), verticalArrangement = Arrangement.Center) {
        Player("Computer", painterResource(id = imageResource1))
//        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "vs")
//        Spacer(modifier = Modifier.height(16.dp))
        Player("Player", painterResource(id = imageResource2))
    }
}



@Composable
fun Player(name: String, image: Painter, modifier: Modifier=Modifier){
    Column(modifier= modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        Text(
            text = name,
            modifier = modifier
        )
        Image(painter = image, contentDescription = null)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RockPaperScissorsTheme {
        Game()
    }
}