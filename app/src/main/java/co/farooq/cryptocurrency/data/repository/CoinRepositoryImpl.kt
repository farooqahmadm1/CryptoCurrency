package co.farooq.cryptocurrency.data.repository

import co.farooq.cryptocurrency.data.remote.CoinPaprikaAPI
import co.farooq.cryptocurrency.data.remote.dto.CoinDetailDto
import co.farooq.cryptocurrency.data.remote.dto.CoinDto
import co.farooq.cryptocurrency.domain.model.CoinDetail
import co.farooq.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaAPI
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto  {
        return api.getCoinById(coinId)
    }
}