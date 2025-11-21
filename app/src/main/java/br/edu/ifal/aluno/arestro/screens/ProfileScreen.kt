package br.edu.ifal.aluno.arestro.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.edu.ifal.aluno.arestro.components.base.AppBar
import br.edu.ifal.aluno.arestro.db.DatabaseHelper
import br.edu.ifal.aluno.arestro.model.contact.Contact
import br.edu.ifal.aluno.arestro.ui.theme.Gray75
import br.edu.ifal.aluno.arestro.ui.theme.Typography

@Composable
fun ProfileScreen() {
    val dao = DatabaseHelper.getInstance(context = LocalContext.current).contactDao()
    var contacts by remember { mutableStateOf(emptyList<Contact>()) }

    LaunchedEffect(Unit) {
        contacts = dao.findAllByUserId(1)
    }

    Scaffold(
        topBar = {
            AppBar()
        },
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .windowInsetsPadding(WindowInsets.systemBars)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp, vertical = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(96.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "A",
                        style = Typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(Modifier.height(24.dp))
                ElevatedCard(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = Color.White
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                vertical = 12.dp,
                                horizontal = 16.dp,
                            )
                    ) {
                        Text(
                            text = "Personal Info",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black,
                            textAlign = TextAlign.Start,
                        )
                        Spacer(Modifier.height(16.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    vertical = 8.dp,
                                    horizontal = 16.dp,
                                )
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Your Name",
                                    style = Typography.bodyLarge,
                                    fontWeight = FontWeight.Medium,
                                    color = Gray75,
                                )
                                Text(
                                    text = "Alex Rodrigues",
                                    style = Typography.bodyLarge,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.Black,
                                )
                            }
                            Spacer(Modifier.height(12.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Occupation",
                                    style = Typography.bodyLarge,
                                    fontWeight = FontWeight.Medium,
                                    color = Gray75,
                                )
                                Text(
                                    text = "Student",
                                    style = Typography.bodyLarge,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.Black,
                                )
                            }
                            Spacer(Modifier.height(12.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Address",
                                    style = Typography.bodyLarge,
                                    fontWeight = FontWeight.Medium,
                                    color = Gray75,
                                )
                                Text(
                                    text = "Arapiraca, Alagoas",
                                    style = Typography.bodyLarge,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.Black,
                                )
                            }
                        }
                    }
                }
                Spacer(Modifier.height(24.dp))
                ElevatedCard(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = Color.White
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                vertical = 12.dp,
                                horizontal = 16.dp,
                            )
                    ) {
                        Text(
                            text = "Contact Info",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black,
                            textAlign = TextAlign.Start,
                        )
                        Spacer(Modifier.height(16.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    vertical = 8.dp,
                                    horizontal = 16.dp,
                                )
                        ) {
                            if (contacts.isEmpty()) {
                                Text(
                                    text = "No contact information available.",
                                    style = Typography.bodyLarge,
                                    fontWeight = FontWeight.Medium,
                                    color = Gray75,
                                )
                            } else {
                                contacts.forEachIndexed { index, contact ->
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = when (contact.type.name) {
                                                "EMAIL" -> "Email"
                                                "PHONE" -> "Phone Number"
                                                else -> contact.type.name
                                            },
                                            style = Typography.bodyLarge,
                                            fontWeight = FontWeight.Medium,
                                            color = Gray75,
                                        )
                                        Text(
                                            text = contact.value,
                                            style = Typography.bodyLarge,
                                            fontWeight = FontWeight.Medium,
                                            color = Color.Black,
                                        )
                                    }

                                    if (index != contacts.lastIndex) {
                                        Spacer(Modifier.height(12.dp))
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
