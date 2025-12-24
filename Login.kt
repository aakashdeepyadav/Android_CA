package com.example.ca2_android



import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Login(navController: NavHostController) {
    val context = LocalContext.current
    var rememberMe by rememberSaveable { mutableStateOf(false) }

    var tempEmail by remember { mutableStateOf("") }
    var tempPassword by remember { mutableStateOf("") }

    var savedEmail by rememberSaveable { mutableStateOf("") }
    var savedPassword by rememberSaveable { mutableStateOf("") }

    val email = if (rememberMe) savedEmail else tempEmail
    val password = if (rememberMe) savedPassword else tempPassword

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = email,
            onValueChange = {
                if (rememberMe) savedEmail = it else tempEmail = it
            },
            label = { Text("Email") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = password,
            onValueChange = {
                if (rememberMe) savedPassword = it else tempPassword = it
            },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = { checked ->

                    if (checked && !rememberMe) {
                        savedEmail = tempEmail
                        savedPassword = tempPassword
                        tempEmail = ""
                        tempPassword = ""
                    }

                    if (!checked && rememberMe) {
                        tempEmail = ""
                        tempPassword = ""
                        savedEmail = ""
                        savedPassword = ""
                    }

                    rememberMe = checked
                }
            )
            Text("Remember Me")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (
                    email == "aakash@email.com" &&
                    password == "aakash@123"
                ) {
                    navController.navigate("dashboard/$email")
                }else{
                    Toast.makeText(context,"Invalid email or password",Toast.LENGTH_LONG).show()
                }
            }
        ) {
            Text("Login")
        }
    }
}