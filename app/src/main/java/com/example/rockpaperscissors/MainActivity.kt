package com.example.rockpaperscissors

import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rockpaperscissors.ui.theme.RockPaperScissorsTheme
import kotlin.random.Random



class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RockPaperScissorsTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Game(
//                        modifier = Modifier.padding(innerPadding)
//                    )
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = "Rock Paper Scissors",
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            colors = TopAppBarDefaults.largeTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        )
                    }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(MaterialTheme.colorScheme.tertiaryContainer),
                        color = MaterialTheme.colorScheme.background
                    ){
                        Game()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Game(modifier: Modifier = Modifier) {
    var computerChoice = Random.nextInt(1, 4)
    var userChoice by remember { mutableStateOf(0) }

    val imageResource1 = when (computerChoice) {
        1 -> R.drawable.rockc
        2 -> R.drawable.paperc
        3 -> R.drawable.scissorsc
        else -> R.drawable.scissorsc
    }
    val imageResource2 = when (userChoice) {
        1 -> R.drawable.rock
        2 -> R.drawable.paper
        3 -> R.drawable.scissors
        else -> R.drawable.scissors
    }


//    var l by remember {
//        mutableStateOf(listOf("Start Game",0,0))
//    }
//    var result=(l[0]).toString()
//    var computerScore=l[1]
//    var playerScore=l[2]

    var result="Start Game"
    var computerScore =0
    var playerScore =0

    if (computerChoice == userChoice) {
        result="Draw"
    }
    else if (computerChoice == 1 && userChoice == 2) {
        result="You Win"
        playerScore++
    }
    else if (computerChoice == 1 && userChoice == 3) {
        result="You Lose"
        computerScore++
        }
    else if (computerChoice == 2 && userChoice == 1) {
        result="You Lose"
        computerScore++
    }
    else if (computerChoice == 2 && userChoice == 3) {
        result="You Win"
        playerScore++
    }
    else if (computerChoice == 3 && userChoice == 1) {
        result="You Win"
        playerScore++
    }
    else if (computerChoice == 3 && userChoice == 2) {
        result="You Lose"
        computerScore++
    }



    Column(modifier = modifier
        .fillMaxWidth()
        .verticalScroll(state = rememberScrollState()),horizontalAlignment = Alignment.CenterHorizontally) {

//        AppBar()

        Player("Computer", painterResource(id = imageResource1))
//        Spacer(modifier = Modifier.height(16.dp))

            Column(modifier= modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                Text(
                    text = "Computer: ${computerScore}",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Typeface.DEFAULT_BOLD)
                )
                Text(text = "VS", fontSize = 15.sp, fontFamily = FontFamily(Typeface.DEFAULT_BOLD))
                Text(
                    text = "Player: ${playerScore}",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Typeface.DEFAULT_BOLD)
                )

        }

        Player("Player", painterResource(id = imageResource2))

                Spacer(modifier = Modifier.height(20.dp))
//        UserChoice()

        Row() {

            Button(onClick = {
                userChoice=1

            })
            {
                Text(text = "ROCK",modifier=modifier,fontSize = 20.sp, fontFamily = FontFamily(Typeface.DEFAULT_BOLD))
//                CalculateResult(computerChoice = computerChoice, userChoice = userChoice)
            }

            Button(onClick = { /*TODO*/
                userChoice=2
            }) {
                Text(text = "PAPER",modifier=modifier,fontSize = 20.sp, fontFamily = FontFamily(Typeface.DEFAULT_BOLD))
//                CalculateResult(computerChoice = computerChoice, userChoice = userChoice)
            }
            Button(onClick = { /*TODO*/
                userChoice=3
            }) {
                Text(text = "Scissors",modifier=modifier,fontSize = 20.sp, fontFamily = FontFamily(Typeface.DEFAULT_BOLD))
//                CalculateResult(computerChoice = computerChoice, userChoice = userChoice)
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = result,fontSize = 25.sp, fontFamily= FontFamily(Typeface.DEFAULT_BOLD))
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppBar() {
//    TopAppBar(
//        title = {
//            Text(
//                text = stringResource(id = R.string.app_name),
//                fontSize = 25.sp,
//                fontFamily = FontFamily.Default,
//                fontWeight = FontWeight.Bold
//            )
//        }
//    )
//}

@Composable
fun Player(name: String, image: Painter, modifier: Modifier=Modifier){
    Column(modifier= modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (name == "Computer") {
            Text(
                text = name,
                modifier = modifier,
                fontSize = 20.sp, fontStyle = FontStyle.Normal
            )
        }

        Image(painter = image, contentDescription = null,modifier = modifier
            .size(width = 250.dp, height = 250.dp)
            .clip(CircleShape))
        if (name != "Computer") {
            Text(
                text = name,
                modifier = modifier,
                fontSize = 20.sp, fontStyle = FontStyle.Normal
            )
        }
    }
}


//@Composable
//fun CalculateResult(computerChoice: Int, userChoice: Int): List<Any> {
//    var result="Start Game"
//    var computerScore by remember { mutableStateOf(0) }
//    var playerScore by remember { mutableStateOf(0) }
//
//    if (computerChoice == userChoice) {
//        result="Draw"
//    }
//    else if (computerChoice == 1 && userChoice == 2) {
//        result="You Win"
//        playerScore++
//    }
//    else if (computerChoice == 1 && userChoice == 3) {
//        result="You Lose"
//        computerScore++
//    }
//    else if (computerChoice == 2 && userChoice == 1) {
//        result="You Lose"
//        computerScore++
//    }
//    else if (computerChoice == 2 && userChoice == 3) {
//        result="You Win"
//        playerScore++
//    }
//    else if (computerChoice == 3 && userChoice == 1) {
//        result="You Win"
//        playerScore++
//    }
//    else if (computerChoice == 3 && userChoice == 2) {
//        result="You Lose"
//        computerScore++
//    }
//    var l= listOf(result,computerScore,playerScore)
//    return l
//
//}

//@Composable
//fun UserChoice(modifier: Modifier = Modifier) {
//
//}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RockPaperScissorsTheme {
        Game()
    }
}