package com.example.aboutesports.Repo

import android.widget.Toast
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataTest.NewsTest.user
import com.example.aboutesports.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseUser

class AccountHelper(private val act:LoginActivity) {
    fun signUpWithEmail(email:String, password:String){
        if (email.isNotEmpty() && password.isNotEmpty()){
            act.mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{task ->
                if (task.isSuccessful){
                    sendEmailVerification(task.result.user!!)
                    user = task.result.user!!
                }else {
                    Toast.makeText(act, act.resources.getString(R.string.sign_up_error), Toast.LENGTH_LONG).show()
                }


            }
        }
    }
    fun signInWithEmail(email:String, password:String){
        if (email.isNotEmpty() && password.isNotEmpty()){
            act.mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{task ->
                if (task.isSuccessful){
                    user = task.result.user!!
                    act.onBackPressedDispatcher.onBackPressed()
                }else {
                    Toast.makeText(act, act.resources.getString(R.string.sign_in_error), Toast.LENGTH_LONG).show()
                }


            }
        }
    }
    private fun sendEmailVerification(user:FirebaseUser){
        user.sendEmailVerification().addOnCompleteListener{task ->
            if (task.isSuccessful){
                Toast.makeText(act, act.resources.getString(R.string.sign_up_verification), Toast.LENGTH_LONG).show()
                act.onBackPressedDispatcher.onBackPressed()
            }else {
                Toast.makeText(act, act.resources.getString(R.string.sign_up_verification_error), Toast.LENGTH_LONG).show()
            }
        }
    }
}