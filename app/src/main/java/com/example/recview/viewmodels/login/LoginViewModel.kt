package com.example.recview.viewmodels.login

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recview.entities.User
import com.example.recview.entities.UserSingleton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class LoginViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val db = Firebase.firestore
    var user : MutableLiveData<FirebaseUser?> = MutableLiveData(auth.currentUser)

    fun login(email : String, pass : String) {
        auth.signInWithEmailAndPassword(email, pass)
            .addOnSuccessListener{
                Log.d(TAG, "signInWithEmail:success")
                user.value = auth.currentUser
            }
            .addOnFailureListener {
                Log.d(TAG, "signInWithEmail:error" + it)
            }
    }

    fun logout(){
        auth.signOut()
    }

}