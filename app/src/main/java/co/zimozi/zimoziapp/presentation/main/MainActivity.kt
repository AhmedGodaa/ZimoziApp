package co.zimozi.zimoziapp.presentation.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import co.zimozi.zimoziapp.common.Constants.KEY_PLAYERS_SET
import co.zimozi.zimoziapp.common.PreferencesManager
import co.zimozi.zimoziapp.databinding.ActivityMainBinding
import co.zimozi.zimoziapp.domain.models.Player
import co.zimozi.zimoziapp.presentation.players.PlayerAdapter
import co.zimozi.zimoziapp.presentation.players.PlayersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: PlayersViewModel by viewModels()
    private lateinit var adapter: PlayerAdapter
    val mutablePlayers = mutableListOf<Player>()


    @Inject
    lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()


    }

    private fun getData() {
        val players = mutableListOf<Player>()
        viewModel.playersResponse.observe(this) {
            for (player in it.data) {
                players.add(player)
            }
            saveToSharedPreferecnes(players)

        }

        getFromSharedPreferecnes()
        setRecyclerView()


    }

    private fun getFromSharedPreferecnes() {

        lifecycleScope.launch {
            preferencesManager.getListItem(KEY_PLAYERS_SET).collect {
                mutablePlayers.add(it)
            }
        }

    }

    private fun setRecyclerView() {
        adapter = PlayerAdapter(mutablePlayers.toList())
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = adapter

    }


    private fun saveToSharedPreferecnes(players: List<Player>) {
        preferencesManager.putList(KEY_PLAYERS_SET, ArrayList<Player>(players))

    }


}