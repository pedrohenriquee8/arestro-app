    package br.edu.ifal.aluno.arestro.screens

    import androidx.compose.runtime.Composable

    import androidx.compose.foundation.BorderStroke
    import androidx.compose.foundation.background
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.rememberScrollState
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.foundation.verticalScroll
    import androidx.compose.material.icons.Icons
    import androidx.compose.material3.*
    import androidx.compose.runtime.*
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.input.PasswordVisualTransformation
    import androidx.compose.ui.text.input.VisualTransformation
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.compose.material.icons.filled.Visibility
    import androidx.compose.material.icons.filled.VisibilityOff
    import androidx.compose.ui.platform.LocalContext
    import br.edu.ifal.aluno.arestro.db.DatabaseHelper
    import br.edu.ifal.aluno.arestro.model.user.User
    import kotlinx.coroutines.launch

    @Composable
    fun SignUpScreen(onSignUpClick: () -> Unit, onLoginClick: () -> Unit) {
        var username by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }

        val context = LocalContext.current
        val scope = rememberCoroutineScope()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(32.dp))

                // Logo
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(
                            color = Color(0xFF16A34A),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "🍽️",
                        fontSize = 40.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Criar conta",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Usuário",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF666666),
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = { Text("Coloque seu usuário") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        unfocusedIndicatorColor = Color(0xFFE0E0E0),
                        focusedIndicatorColor = Color(0xFF16A34A)
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Email",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF666666),
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("Coloque seu Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        unfocusedIndicatorColor = Color(0xFFE0E0E0),
                        focusedIndicatorColor = Color(0xFF16A34A)
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Número de celular",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF666666),
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    placeholder = { Text("Coloque seu número de celular") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        unfocusedIndicatorColor = Color(0xFFE0E0E0),
                        focusedIndicatorColor = Color(0xFF16A34A)
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Senha",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF666666),
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("Coloque sua senha") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(8.dp),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                tint = Color(0xFF666666)
                            )
                        }
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        unfocusedIndicatorColor = Color(0xFFE0E0E0),
                        focusedIndicatorColor = Color(0xFF16A34A)
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Sign Up Button
                Button(
                    onClick = {
                        scope.launch {
                            val newUser = User(
                                username = username,
                                email = email,
                                phoneNumber = phoneNumber,
                                password = password
                            )

                            val db = DatabaseHelper.getInstance(context)
                            db.userDao().insert(newUser)

                            onSignUpClick()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF16A34A)
                    )
                ) {
                    Text(
                        text = "Cadastrar",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Divider(
                        modifier = Modifier.weight(1f),
                        color = Color(0xFFE0E0E0),
                        thickness = 1.dp
                    )
                    Text(
                        text = "ou continue com",
                        fontSize = 12.sp,
                        color = Color(0xFF999999),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Divider(
                        modifier = Modifier.weight(1f),
                        color = Color(0xFFE0E0E0),
                        thickness = 1.dp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedButton(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFFE0E0E0))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Registrar com google",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Já tem uma conta ?  ",
                        fontSize = 14.sp,
                        color = Color(0xFF666666)
                    )
                    Text(
                        text = "Login",
                        fontSize = 14.sp,
                        color = Color(0xFF2196F3),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { onLoginClick() }
                    )
                }
            }
        }
    }