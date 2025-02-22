package com.rajveer.wishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rajveer.wishlistapp.data.Wish
import kotlinx.coroutines.launch

@Composable
fun AddEditDetailView(
    id: Long = 0L,
    navController: NavController,
    viewModel: WishViewModel
){

    val snackMessage = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    //putting the data when arriving to the addEditDetailViewScreen
    if(id!=0L){
        //fetching wish data as per id value from viewModel
        val wish = viewModel.getAWishById(id).collectAsState(initial = Wish(0L,
            "",""))
        //assigning to fields
        viewModel.wishTitleState = wish.value.title
        viewModel.wishDescriptionText = wish.value.description
    }else{
        viewModel.wishTitleState = ""
        viewModel.wishDescriptionText = ""
    }

    Scaffold(
        topBar = { AppBarView(
            title = if(id != 0L) stringResource(R.string.update_wish)
            else stringResource(R.string.add_wish)
        ) { navController.navigateUp() }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            WishTextField(label = "title",
                value = viewModel.wishTitleState,
                onValueChange = {viewModel.onWishTitleChanged(it)})

            Spacer(modifier = Modifier.height(8.dp))
            WishTextField(label = "description",
                value = viewModel.wishDescriptionText,
                onValueChange = {viewModel.onWishDescriptionChanged(it)})

            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    if(viewModel.wishTitleState.isNotEmpty() &&
                        viewModel.wishDescriptionText.isNotEmpty()){
                        if(id!=0L) {
                            // UpdateWish
                            viewModel.updateWish(Wish(
                                id = id,
                                title = viewModel.wishTitleState.trim(),
                                description = viewModel.wishDescriptionText.trim()
                            ))
                        }else {
                            // AddWish
                            viewModel.addWish(
                                Wish(
                                    title = viewModel.wishTitleState.trim(),
                                    description = viewModel.wishDescriptionText.trim()
                                )
                            )
                            snackMessage.value = "Wish has been created"
                        }
                    }else{
                        // Enter fields to be created
                        snackMessage.value = "Enter fields to create a wish"
                    }
                    scope.launch {
//                        scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                        navController.navigateUp()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(R.color.app_bar_color),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = if(id !=0L) stringResource(R.string.update_wish)
                        else stringResource(id = R.string.add_wish),
                    style = TextStyle(
                        fontSize = 16.sp
                    )
                )
            }


        }
    }
}

@Composable
fun WishTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label =  {Text(text = label, color = colorResource(R.color.app_bar_color))} ,
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.app_bar_color),
            unfocusedBorderColor = colorResource(id = R.color.app_bar_color),
            textColor = colorResource(id = R.color.app_bar_color),
            cursorColor = colorResource(id = R.color.app_bar_color),
            focusedLabelColor = colorResource(id = R.color.app_bar_color),
            unfocusedLabelColor = colorResource(id = R.color.app_bar_color),
            trailingIconColor = colorResource(id = R.color.app_bar_color),
            leadingIconColor = colorResource(id = R.color.app_bar_color),
        )
    )
}

//@Preview
//@Composable
//fun WishTextFieldPreview() {
//    WishTextField(
//        label = "Title",
//        value = "this is title",
//        onValueChange = {}
//    )
//}
