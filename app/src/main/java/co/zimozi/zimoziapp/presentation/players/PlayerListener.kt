package co.zimozi.zimoziapp.presentation.players

import co.zimozi.zimoziapp.domain.models.Player

interface PlayerListener {
   fun onClick(model: Player)
}