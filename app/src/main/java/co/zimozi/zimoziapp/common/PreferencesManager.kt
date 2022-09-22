package co.zimozi.zimoziapp.common

import android.content.Context
import android.content.SharedPreferences
import co.zimozi.zimoziapp.domain.models.Player
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PreferencesManager(context: Context) {
    var sharedPreferences: SharedPreferences

    init {
        sharedPreferences =
            context.getSharedPreferences(Constants.KEY_PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun putString(key: String?, value: String?) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }


    fun getString(key: String?): String {
        return sharedPreferences.getString(key, "")!!
    }

    fun clear() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    fun putList(key: String, list: List<Player>) {
        val gson = Gson()
        val json: String = gson.toJson(list)
        putString(key, json)
    }
// get hole list
    fun getList(key: String): Array<Player> {
        val gson = Gson()
        val jsonText: String = getString(key)
        return gson.fromJson(jsonText, Array<Player>::class.java)

    }

    fun getListItem(key: String): Flow<Player> {
        val gson = Gson()
        val jsonText: String = getString(key)
        val array = gson.fromJson(jsonText, Array<Player>::class.java)
        return flow {
            for (player in array) {
                emit(player)

            }

        }
    }


}