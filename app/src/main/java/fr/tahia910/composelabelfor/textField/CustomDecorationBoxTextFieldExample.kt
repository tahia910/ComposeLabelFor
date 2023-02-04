package fr.tahia910.composelabelfor.textField

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * labelFor効果あり✅
 */
@Composable
fun CustomDecorationBoxTextFieldExample(
    inputValue: String,
    label: String,
    onInputChanged: (String) -> Unit
) {
    BasicTextField(
        value = inputValue,
        onValueChange = { newText -> onInputChanged(newText) },
        // フォントサイズを指定し直す必要がある
        // TextStyle.Default.copy(fontSize = 16.sp)はinnerTextFieldのレイアウトが崩れるから使えない
        textStyle = TextStyle(fontSize = 16.sp),
        decorationBox = { innerTextField ->
            Column {
                // ラベル
                Text(text = label, modifier = Modifier.padding(bottom = 12.dp))

                // 枠のあるTextField（自作のComposable）
                OutlinedTextFieldInput(
                    inputValue = inputValue,
                    innerTextField = innerTextField
                )
            }
        }
    )
}

/**
 * DecorationBox用のヘルパー関数
 * innerTextFieldにデフォルトUIコンポーネントと同じ枠やpaddingをつけて、wrapする
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OutlinedTextFieldInput(
    inputValue: String,
    innerTextField: @Composable () -> Unit
) {
    // 枠をつけてもらう
    TextFieldDefaults.OutlinedTextFieldDecorationBox(
        value = inputValue,
        innerTextField = {
            Box(modifier = Modifier.fillMaxWidth()) {
                // 入力したものは実際これで表示される
                innerTextField()
            }
        },
        // 本来ここから下は親のBasicTextFieldから引き継ぐべきもの
        // （とりあえずデフォルトの値にする）
        visualTransformation = VisualTransformation.None,
        interactionSource = MutableInteractionSource(),
        enabled = true,
        singleLine = false
    )
}
