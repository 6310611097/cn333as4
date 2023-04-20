package com.example.myapplication4.ui.page

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ShareViewModel:ViewModel() {
    var wide by  mutableStateOf<Int?>(null)
        private set
    var long by  mutableStateOf<Int?>(null)
        private set
    var type by  mutableStateOf<String?>(null)
        private set

    fun commit(Wide: Int,Long: Int,Type: String){
        wide = Wide
        long = Long
        type = Type
    }
}