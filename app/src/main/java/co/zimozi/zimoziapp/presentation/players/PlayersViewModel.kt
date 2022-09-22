package co.zimozi.zimoziapp.presentation.players

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.zimozi.zimoziapp.data.repositories.DataRepository

import co.zimozi.zimoziapp.domain.models.PlayersResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    private val dataRepository: DataRepository,
) :
    ViewModel() {

    private var _mutablePlayersResponse = MutableLiveData<PlayersResponse>()
    val playersResponse: LiveData<PlayersResponse> = _mutablePlayersResponse


    init {
        viewModelScope.launch {
            _mutablePlayersResponse.value = dataRepository.getData().body()

        }

    }




}