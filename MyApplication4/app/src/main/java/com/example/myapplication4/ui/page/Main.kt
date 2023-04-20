package com.example.myapplication4.ui.page

import android.app.AlertDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun mainpage(navController: NavHostController, shareViewModel:ShareViewModel){
    Column {
        Tittle()
        var wide:Int = InputSize("wide")
        Spacer(modifier = Modifier.height(10.dp))
        var long:Int = InputSize("long")
        var type:String = ""
        var showView by remember { mutableStateOf(false) }

        Text(
            text = "choose type",
            fontSize = 18.sp,
            color = Color.Blue,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.padding(horizontal = 10.dp).clickable {
                showView = true
            }
        )

        if(showView) {
            type = ChoiceMaker()
        }

        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                shareViewModel.commit(wide,long,type)
                navController.navigate("pic")
                showView = false
                      },
            modifier = Modifier
                .padding(10.dp)
                .width(120.dp)
                .height(45.dp)
        ) {
            Text(text = "Search")
        }
    }
}

@Composable
fun Tittle(){
    Column() {
        Text(
            text = "Random Image",
            fontSize = 35.sp,
            color = Color.White,
            modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxWidth()
                .height(90.dp)
                .padding(20.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Fill the form!",
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputSize(side:String): Int{
    var Input by remember { mutableStateOf("") }
    Column() {
        Row() {
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                value = Input ,
                onValueChange = {Input = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                label = { Text(text = "Enter "+side+" size") }
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        if(Input != "" && Input.toIntOrNull()?:0 <= 0){
            Row() {
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "please enter number properly*",
                    color = Color.Red
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }else {
            Spacer(modifier = Modifier.height(22.dp))
        }
    }
    return Input.toIntOrNull()?:0
}

@Composable
fun ChoiceMaker() :String{
    val context = LocalContext.current

    // setup the alert builder
    val builder = AlertDialog.Builder(context)
    builder.setTitle("Choose a keyword")

    val keyword = arrayOf("kitten", "dog", "paris", "brazil")
    var checkedItem by remember { mutableStateOf(0) }
    builder.setSingleChoiceItems(keyword, checkedItem) { dialog, which ->
        checkedItem = which
    }

// add OK and Cancel buttons
    builder.setPositiveButton("OK",null)
    builder.setNegativeButton("Cancel", null)

// create and show the alert dialog
    val dialog = builder.create()
    dialog.show()
    return keyword[checkedItem]
}
