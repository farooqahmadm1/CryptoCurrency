package co.farooq.cryptocurrency.presentation.ui.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.farooq.cryptocurrency.common.Resource
import co.farooq.cryptocurrency.domain.user_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


// why viewModel now like we have Use Case
// Maintain our state like ui changes
// now they contain less logic

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListSate())
    val state : State<CoinListSate> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinListSate(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListSate(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinListSate(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}