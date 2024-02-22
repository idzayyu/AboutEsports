package com.example.aboutesports

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.aboutesports.Repo.dataTest.NewsTest.user
import com.example.aboutesports.Repo.dataTest.NewsTest.userEmail
import com.example.aboutesports.databinding.ActivityMainBinding
import com.example.aboutesports.ui.login.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    // Имя файла для хранения настроек
    private val PREFS_FILE_NAME = "MyPrefsFile"

    // Ключи для данных в SharedPreferences
    private val KEY_EMAIL = "email"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences: SharedPreferences = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)

        val editor: SharedPreferences.Editor = sharedPreferences.edit()


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

        currentUserWithEmail()
        if (user == null){
            sign_in()
        }
    }
    fun currentUserWithEmail(){
        // Получаем экземпляр FirebaseAuth
        val auth = FirebaseAuth.getInstance()

        // Получаем текущего пользователя
        user = auth.currentUser
    }
    fun sign_in() {

        val myIntent = Intent(this, LoginActivity::class.java)

        this.startActivity(myIntent)
        saveUser( user?.email.toString())
    }
    private fun saveUser( email: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        editor.putString(KEY_EMAIL, email)

        editor.apply()
    }
}