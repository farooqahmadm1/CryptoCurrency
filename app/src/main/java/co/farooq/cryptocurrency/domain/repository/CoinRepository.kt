package co.farooq.cryptocurrency.domain.repository

import co.farooq.cryptocurrency.data.remote.dto.CoinDetailDto
import co.farooq.cryptocurrency.data.remote.dto.CoinDto
import co.farooq.cryptocurrency.domain.model.CoinDetail

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId : String) : CoinDetailDto

}