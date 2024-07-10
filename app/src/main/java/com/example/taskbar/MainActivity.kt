package com.example.taskbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskbar.ui.theme.TaskbarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskbarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Taskbar(
                        body1 = stringResource(R.string.completed),
                        body2 = stringResource(R.string.nice_work),
                        image = painterResource(R.drawable.ic_task_completed),
                    )
                }
            }
        }
    }
}

@Composable
fun Taskbar(body1: String, body2: String, image: Painter, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth() //Centers Horizontally
            .fillMaxHeight(), //Centers Vertically
        verticalArrangement = Arrangement.Center, //Vertically Center
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,

        )
        Text(
            text = body1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                top = 24.dp,
                bottom = 8.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = body2,
            fontSize = 16.sp,
            //modifier = Modifier.,
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Taskbar")
@Composable
fun TaskbarPreview() {
    TaskbarTheme {
        Taskbar(
            body1 = stringResource(R.string.completed),
            body2 = stringResource(R.string.nice_work),
            image = painterResource(R.drawable.ic_task_completed),
        )
    }
}