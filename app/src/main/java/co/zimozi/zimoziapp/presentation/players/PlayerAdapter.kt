package co.zimozi.zimoziapp.presentation.players

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.zimozi.zimoziapp.databinding.ItemContainerPlayerBinding
import co.zimozi.zimoziapp.domain.models.Player
import co.zimozi.zimoziapp.presentation.players.PlayerAdapter.PlayerViewHolder

class PlayerAdapter(
    private val data: List<Player>,
) : RecyclerView.Adapter<PlayerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemContainerPlayerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.setPlayerData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class PlayerViewHolder(private var binding: ItemContainerPlayerBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun setPlayerData(model: Player) {
            binding.listItem = model

        }
    }
}