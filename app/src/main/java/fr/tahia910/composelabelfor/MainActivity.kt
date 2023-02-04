package fr.tahia910.composelabelfor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.tahia910.composelabelfor.textField.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 40.dp)
    ) {
        var name by rememberSaveable { mutableStateOf("") }
        val label = "お名前"

        SectionContainer(title = "① デフォルト") {
            SectionSubtitle("MaterialDesignTextField")
            MaterialDesignTextFieldExample(
                inputValue = name,
                label = label,
                onInputChanged = { newText -> name = newText }
            )

            Spacer(Modifier.height(40.dp))

            SectionSubtitle("MaterialDesignOutlinedTextField")
            MaterialDesignOutlinedTextFieldExample(
                inputValue = name,
                label = label,
                onInputChanged = { newText -> name = newText }
            )
        }

        SectionContainer(title = "② ラベルと分ける（何もしない）") {
            SectionSubtitle("OutlinedTextField")
            SeparateLabelOutlinedTextFieldExample(
                inputValue = name,
                label = label,
                onInputChanged = { newText -> name = newText }
            )

            Spacer(Modifier.height(40.dp))

            SectionSubtitle("BasicTextField")
            SeparateLabelBasicTextFieldExample(
                inputValue = name,
                label = label,
                onInputChanged = { newText -> name = newText }
            )
        }

        SectionContainer(title = "③ Modifier.semantics(mergeDescendants = true)") {
            SectionSubtitle("OutlinedTextField")
            MergeSemanticsOutlinedTextFieldExample(
                inputValue = name,
                label = label,
                onInputChanged = { newText -> name = newText }
            )

            Spacer(Modifier.height(40.dp))

            SectionSubtitle("BasicTextField")
            MergeSemanticsBasicTextFieldExample(
                inputValue = name,
                label = label,
                onInputChanged = { newText -> name = newText }
            )
        }

        SectionContainer(title = "④ BasicTextField - custom DecorationBox") {
            CustomDecorationBoxTextFieldExample(
                inputValue = name,
                label = label,
                onInputChanged = { newText -> name = newText }
            )
        }
    }
}

@Composable
fun SectionSubtitle(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        color = Color(0xFFC5846B),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SectionContainer(title: String, content: @Composable () -> Unit) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 20.dp)
            .background(Color(0xFFFFE6CA))
            .padding(12.dp)
    )

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 40.dp, end = 40.dp)
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        MainScreen()
    }
}
