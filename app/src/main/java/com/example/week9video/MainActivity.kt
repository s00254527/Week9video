package com.example.week9video

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.week9video.ui.theme.Week9VideoTheme

/*
Main activity
Connecting the view moel and the view.
State flow down to the view
Events flow up to the view model
 */
class  MainActivity : ComponentActivity(){
    //view model survivices configuration changes
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setContent {
            Week9VideoTheme{
                val counter by viewModel.counter.collectAsStateWithLifecycle()
                CounterScreen(
                   //pass state to the view
                  count = counter.value,
                    /*
                    Collecting state flow from the view model
                    using collectAsState
                    latetest stateflow value into compose state
                    When state flow changes, compose
                    can automoatically upate the screen
                     */
                    //send events to the viewModel
                    onIncrease = {viewModel.increaseCounter()},
                    onDecrease = {viewModel.decreaseCounter()},
                    onReset = {viewModel.resettingCounter()},
                )

            }

        }
    }
}