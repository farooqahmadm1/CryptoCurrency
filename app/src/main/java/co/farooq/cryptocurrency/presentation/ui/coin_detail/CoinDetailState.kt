package co.farooq.cryptocurrency.presentation.ui.coin_detail

import co.farooq.cryptocurrency.domain.model.Coin
import co.farooq.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin : CoinDetail? = null,
    val error : String = ""
)
