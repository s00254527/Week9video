package com.example.week9video

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text


/*
View
DisplayCounter
Receive state and callback functions
No counter logic in the view

 */
@Composable
fun CounterScreen(
    count:Int,
    onIncrease:()->Unit,
    onDecrease:() -> Unit,
    onReset:() -> Unit
){
    //arrange the contents vertially
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Count:$count",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(24.dp))

        //button calls funcitons
        Button(onClick = onIncrease){
            Text("Increase")
        }

        Button(onClick = onDecrease){
            Text("Decrease")
        }

        Button(onClick = onReset){
            Text("Reset")
        }
    }


}