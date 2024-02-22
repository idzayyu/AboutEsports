package com.example.aboutesports.Repo.fireBase

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DbManager {
    val db = Firebase.database.reference

    fun publishAddTour(){
        db.setValue("hjg")
    }
}