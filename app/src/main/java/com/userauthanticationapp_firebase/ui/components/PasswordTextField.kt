package com.userauthanticationapp_firebase.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    trailingText: String? = null,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    onLeadingClick: () -> Unit = {},
    onTrailingClick: () -> Unit = {},
    isPasswordVisible: Boolean = false,
) {

    var passwordVisible by remember { mutableStateOf(isPasswordVisible) }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.onBackground),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        modifier = modifier,
        decorationBox = { innerTextField ->
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (leadingIcon != null) {
                        Icon(
                            imageVector = leadingIcon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.5f),
                            modifier = Modifier.clickable { onLeadingClick() }
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                    }

                    Box(modifier = Modifier.weight(1f)) {
                        if (value.isEmpty()) {
                            Text(
                                text = hint,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.4f),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        innerTextField()
                    }

                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.5f),
                        modifier = Modifier
                            .padding(4.dp)
                            .clickable {
                                passwordVisible = !passwordVisible
                            }
                    )
                }

                Spacer(Modifier.height(10.dp))

                HorizontalDivider(modifier = Modifier.alpha(0.7f))
            }
        }
    )
}
