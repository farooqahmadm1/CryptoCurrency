package co.farooq.cryptocurrency.domain.user_case.get_coins

import co.farooq.cryptocurrency.common.Resource
import co.farooq.cryptocurrency.data.remote.dto.toCoin
import co.farooq.cryptocurrency.domain.model.Coin
import co.farooq.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


// use case should have one public functions
// that we can expose to view Model
// use use_case for only feature or functional

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
           emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An UnExpected Error Occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach Server. Check your Internet Connection"))
        }
    }

}