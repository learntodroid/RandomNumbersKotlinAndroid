package com.learntodroid.randomapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learntodroid.randomapp.ui.theme.RandomAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        RandomWholeNumber(0, 1)
                        RandomDecimal(0.001, 19.013);
                        RandomList(10, 0, 5);
                        DiceRoll()
                        CoinFlip()
                        ShuffleDraw();
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RandomAppTheme {
        RandomWholeNumber(0, 1)
    }
}

@Composable
fun RandomWholeNumber(from: Int, to: Int) {
    var randomNumber by remember { mutableStateOf(RandomSingleton.randomInteger(from, to)) }
    var context = LocalContext.current;

    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp, 8.dp, 8.dp, 0.dp).border(BorderStroke(1.dp,Color.Black)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "RandomWholeNumber: $randomNumber")
        Button(onClick = {
            randomNumber = RandomSingleton.randomInteger(from, to);
            Toast.makeText(context, "You got $randomNumber", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Randomize")
        }
    }
}

@Composable
fun RandomDecimal(from: Double, until: Double) {
    // from is inclusive, until is exclusive
    var randomNumber by remember { mutableStateOf(RandomSingleton.randomDouble(from, until)) }
    var context = LocalContext.current;

    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp, 8.dp, 8.dp, 0.dp).border(BorderStroke(1.dp,Color.Black)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "RandomDecimal: $randomNumber")
        Button(onClick = {
            randomNumber = RandomSingleton.randomDouble(from, until);
            Toast.makeText(context, "You got a $randomNumber", Toast.LENGTH_SHORT).show()
            var r = (1..10).random()
        }) {
            Text(text = "Randomize")
        }
    }
}

@Composable
fun RandomList(size: Int, from: Int, to: Int) {
    var randomNumbers by remember { mutableStateOf(RandomSingleton.listOfRandomNumbers(size, from, to)) }
    var context = LocalContext.current;

    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp, 8.dp, 8.dp, 0.dp).border(BorderStroke(1.dp,Color.Black)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "RandomNumbers: $randomNumbers")
        Button(onClick = {
            randomNumbers = RandomSingleton.listOfRandomNumbers(size, from, to);
            Toast.makeText(context, "You got a $randomNumbers", Toast.LENGTH_SHORT).show()
            var r = (1..10).random()
        }) {
            Text(text = "Randomize")
        }
    }
}

var diceRollNumber = 1

@Composable
fun DiceRoll() {
    var randomNumber by remember { mutableStateOf(diceRollNumber) }
    var context = LocalContext.current;

    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp, 8.dp, 8.dp, 0.dp).border(BorderStroke(1.dp,Color.Black)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "DiceRoll: $randomNumber")
        Button(onClick = {
            diceRollNumber = RandomSingleton.randomInteger(1, 6);
            randomNumber = diceRollNumber;
            Toast.makeText(context, "You rolled a $randomNumber", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Roll")
        }
    }
}

@Composable
fun CoinFlip() {
    var result by remember { mutableStateOf(RandomSingleton.randomStringFromList(listOf("Heads", "Tails"))) }
    var context = LocalContext.current;

    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp, 8.dp, 8.dp, 0.dp).border(BorderStroke(1.dp,Color.Black)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "CoinFlip: $result")
        Button(onClick = {
            result = RandomSingleton.randomStringFromList(listOf("Heads", "Tails"));
            Toast.makeText(context, "You flipped a $result", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Flip Coin")
        }
    }
}

var deck = Deck()

@Composable
fun ShuffleDraw() {
    var drawCardResult by remember { mutableStateOf(deck.drawCard) }
    var deckResult by remember { mutableStateOf(deck) }

    var context = LocalContext.current;

    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp, 8.dp, 8.dp, 0.dp).border(BorderStroke(1.dp,Color.Black)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "ShuffleDraw: $drawCardResult")
        Button(onClick = {
            deck.initDeck();
            deck.shuffleDeck();
            deckResult = deck;
            drawCardResult = deck.drawCard;
            Toast.makeText(context, "Shuffled successfully", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Shuffle")
        }
        Button(onClick = {
            if (deck.drawACard()) {
                drawCardResult = deck.drawCard;
                deckResult = deck;
                Toast.makeText(context, "Drew a $drawCardResult (${deckResult.cards.size} left)", Toast.LENGTH_SHORT).show()
            }
         }) {
            Text(text = "Draw (${deckResult.cards.size} left)")
        }
    }
}