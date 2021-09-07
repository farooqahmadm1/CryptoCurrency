package co.farooq.cryptocurrency.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import co.farooq.cryptocurrency.presentation.ui.theme.CryptoCurrencyTheme


@Composable
fun MyApp(content : @Composable () -> Unit) {
    CryptoCurrencyTheme(){
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}