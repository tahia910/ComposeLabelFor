package fr.tahia910.composelabelfor.textField

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * - labelFor効果無し
 * - ヒントや入力テキストがないとTalkBackに無視されてしまう（TextFieldにフォーカスできない）
 */
@Composable
fun SeparateLabelOutlinedTextFieldExample(
    inputValue: String,
    label: String,
    onInputChanged: (String) -> Unit
) {
    Column {
        Text(text = label, modifier = Modifier.padding(bottom = 12.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = inputValue,
            onValueChange = { newText -> onInputChanged(newText) }
        )
    }
}

/**
 * - labelFor効果無し
 */
@Composable
fun SeparateLabelBasicTextFieldExample(
    inputValue: String,
    label: String,
    onInputChanged: (String) -> Unit
) {
    Column {
        Text(text = label, modifier = Modifier.padding(bottom = 12.dp))

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(percent = 8)
                )
                // TextFieldPaddingのデフォルト値
                .padding(16.dp),
            // フォントサイズを指定し直す必要がある
            // TextStyle.Default.copy(fontSize = 16.sp)はinnerTextFieldのレイアウトが崩れるから使えない
            textStyle = TextStyle(fontSize = 16.sp),
            value = inputValue,
            onValueChange = { newText -> onInputChanged(newText) }
        )
    }
}
