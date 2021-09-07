package co.farooq.cryptocurrency.presentation.ui.coin_list

import co.farooq.cryptocurrency.domain.model.Coin

data class CoinListSate(
    val isLoading : Boolean = false,
    val coins : List<Coin> = emptyList(),
    val error : String = ""
)
