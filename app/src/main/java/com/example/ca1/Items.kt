package com.example.ca1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun FitnessScreen() {
var progress1 by remember { mutableStateOf(0.2f) }
var progress2 by remember { mutableStateOf(0.4f) }
var progress3 by remember { mutableStateOf(0.3f) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4CAF50))
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = "Fitness Tracker",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        FitnessDropdown(
            options = options,
            selected = selectedOption,
            onSelectedChange = { selectedOption = it }
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(options) { activity ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(12.dp)
                ) {
                    Column {
                        Text(
                            text = activity,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 24.sp
                        )
                        when (activity) {
                            "Calories" -> {
                                Text(text = "20", color = Color.Black, fontSize = 20.sp)
                                LinearProgressIndicator(
                                    progress = progress1,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 8.dp)
                                )
                            }

                            "Steps" -> {
                                Text(text = "400", color = Color.Black, fontSize = 20.sp)
                                CircularProgressIndicator(
                                    progress = progress2,
                                    modifier = Modifier.padding(top = 8.dp)
                                )
                            }

                            "Distance" -> {
                                Text(text = "3km", color = Color.Black, fontSize = 20.sp)
                                LinearProgressIndicator(
                                    progress = progress3,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
