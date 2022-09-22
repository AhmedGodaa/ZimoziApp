package co.zimozi.zimoziapp.presentation.splash

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import co.zimozi.zimoziapp.common.openActivity
import co.zimozi.zimoziapp.databinding.ActivitySplashBinding
import co.zimozi.zimoziapp.presentation.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class WelcomeActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            delay(3000)
            openActivity(MainActivity::class.java)
            finish()


        }


    }


}



