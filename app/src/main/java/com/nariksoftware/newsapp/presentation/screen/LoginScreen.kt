package com.nariksoftware.newsapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nariksoftware.newsapp.R
import com.nariksoftware.newsapp.presentation.navigation.Screen
import com.nariksoftware.newsapp.presentation.screen.viewmodel.LoginScreenViewModel
import com.nariksoftware.newsapp.presentation.ui.component.StyledButton

@Composable
fun LoginScreen(
    onNavigateTo: (Screen) -> Unit = {},
    viewModel: LoginScreenViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 120.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.login_image_news_app),
            contentDescription = "News app login image",
            modifier = Modifier
                .size(160.dp)
                .padding(top = 20.dp)
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 80.dp),
            value = viewModel.email,
            onValueChange = viewModel::updateEmail,
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Email),
                    contentDescription = null
                )
            },
            placeholder = {
                Text(text = stringResource(R.string.enter_email))
            }
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 10.dp),
            value = viewModel.password,
            onValueChange = viewModel::updatePassword,
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Lock),
                    contentDescription = null
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Text(text = stringResource(R.string.enter_password))
            }
        )

        StyledButton(onClick = {}, modifier = Modifier.padding(top = 20.dp)) {
            Text(
                text = stringResource(id = R.string.login),
                fontSize = 19.sp
            )
        }

        Text(
            text = stringResource(id = R.string.no_acc_register),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top =  15.dp)
                .clickable {
                    onNavigateTo(Screen.Register)
                }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview() {
    LoginScreen()
}