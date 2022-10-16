package m.wb.compose.notinger

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import m.wb.compose.notinger.ui.theme.NotingerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotingerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Launcher()
                }
            }
        }
    }
}

@Composable
fun Launcher() {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 72.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Keep Your Important Notes",
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Image(painter = painterResource(id = R.drawable.image_note), contentDescription = "Logo")
        Button(onClick = {
            Toast.makeText(context, "This is a Sample Toast", Toast.LENGTH_LONG).show()
        }, contentPadding = PaddingValues(horizontal = 72.dp, vertical = 12.dp)) {
            Text(
                text = "Write Your Notes",
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    NotingerTheme {
        Launcher()
    }
}