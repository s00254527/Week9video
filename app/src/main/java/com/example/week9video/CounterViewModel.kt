package com.example.week9video

//import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

//import androidx.compose.runtime.*
/*
View model
manage the state of the counter data model
Retain state during the screen roations
 */
class CounterViewModel : ViewModel() {
    //observable state that componse can monitor
    //only the view model can change the fallen property
    //var counter by mutableStateOf(Counter())
     //   private set
    //increase by 1
    //the objective is to create a prive muteable stateflow.

    private val _counter = MutableStateFlow(Counter())


    //expose a readonly satateflow to the ui.
    //the ui can observe the counter
    //cannot change it  directly.

    val counter: StateFlow<Counter> = _counter.asStateFlow()

    fun increaseCounter(){
        _counter.update { current ->
            current.copy(value = current.value + 1)
        }
    }
    //decreasse by 1
    fun decreaseCounter(){
        _counter.update { current ->
            current.copy(value = current.value -1)
        }
    }
    //set to 0
    fun resettingCounter(){
        _counter.value = Counter()
        }
    }

