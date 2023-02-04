package fr.tahia910.composelabelfor.textField

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * - labelFor効果あり✅
 */
@Composable
fun MaterialDesignTextFieldExample(
    inputValue: String,
    label: String,
    onInputChanged: (String) -> Unit
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = inputValue,
        onValueChange = { newText -> onInputChanged(newText) },
        label = { Text(text = label) }
    )
}

/**
 * - labelFor効果あり✅
 */
@Composable
fun MaterialDesignOutlinedTextFieldExample(
    inputValue: String,
    label: String,
    onInputChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = inputValue,
        onValueChange = { newText -> onInputChanged(newText) },
        label = { Text(text = label) }
    )
}
