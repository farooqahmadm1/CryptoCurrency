package co.farooq.cryptocurrency.domain.user_case.get_coin

import co.farooq.cryptocurrency.common.Resource
import co.farooq.cryptocurrency.data.remote.dto.toCoin
import co.farooq.cryptocurrency.data.remote.dto.toCoinDetail
import co.farooq.cryptocurrency.domain.model.Coin
import co.farooq.cryptocurrency.domain.model.CoinDetail
import co.farooq.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


// use case should have one public functions
// that we can expose to view Model
// use use_case for only feature or functional

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId : String): Flow<Resource<CoinDetail>> = flow {
        try {
           emit(Resource.Loading<CoinDetail>())
            val coinDetail = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coinDetail))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An UnExpected Error Occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach Server. Check your Internet Connection"))
        }
    }
}