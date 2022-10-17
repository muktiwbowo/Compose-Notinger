package m.wb.compose.notinger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import m.wb.compose.notinger.ui.theme.NotingerTheme
import m.wb.compose.notinger.ui.theme.defaultGreen

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
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "launcher") {
        composable(route = "launcher") {
            Launcher(navController)
        }
        composable(route = "home") {
            Home()
        }
    }
}

@Composable
fun Launcher(navController: NavController) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 72.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Keep Your Important Notes",
            fontFamily = FontFamily(Font(R.font.poppins_semi)),
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Image(painter = painterResource(id = R.drawable.image_note), contentDescription = "Logo")
        Button(
            onClick = {
                navController.navigate("home")
            }, contentPadding = PaddingValues(horizontal = 72.dp, vertical = 12.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = defaultGreen),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text(
                text = "Write Your Notes",
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun Home() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 72.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Second Screen",
            fontFamily = FontFamily(Font(R.font.poppins_semi)),
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    NotingerTheme {
        Navigation()
    }
}