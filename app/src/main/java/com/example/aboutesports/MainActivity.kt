package com.example.aboutesports

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.aboutesports.databinding.ActivityMainBinding
import com.example.aboutesports.ui.login.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration(
            setOf(
                R.id.navigation_news, R.id.navigation_tournaments, R.id.navigation_personal_account, R.id.navigation_plays
            )
        )
        navView.setupWithNavController(navController)

        sign_in()
    }
    fun sign_in() {

        val myIntent = Intent(this, LoginActivity::class.java)

        this.startActivity(myIntent)
    }

}