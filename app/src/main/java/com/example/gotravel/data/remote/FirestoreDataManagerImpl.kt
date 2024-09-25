package com.example.gotravel.data.remote

import android.util.Log
import androidx.constraintlayout.helper.widget.MotionEffect
import com.example.gotravel.data.model.Accommodation
import com.example.gotravel.helper.CallbackHelper
import com.example.gotravel.helper.FirestoreHelper.CL_ACCOM
import com.example.gotravel.helper.FirestoreHelper.FL_ACCOMID
import com.example.gotravel.helper.FirestoreHelper.FL_ADDRESS
import com.example.gotravel.helper.FirestoreHelper.FL_CITYID
import com.example.gotravel.helper.FirestoreHelper.FL_DESCRIPTION
import com.example.gotravel.helper.FirestoreHelper.FL_FREEROOM
import com.example.gotravel.helper.FirestoreHelper.FL_IMAGE
import com.example.gotravel.helper.FirestoreHelper.FL_LATITUDE
import com.example.gotravel.helper.FirestoreHelper.FL_LONGTITUDE
import com.example.gotravel.helper.FirestoreHelper.FL_NAME
import com.example.gotravel.helper.FirestoreHelper.FL_PRICE
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import java.util.Objects
import javax.inject.Inject

class FirestoreDataManagerImpl @Inject constructor(
    var db: FirebaseFirestore,
    private val listenerRegistrations: MutableList<ListenerRegistration>
) {

    fun getAccommodationById(idAccom: String, callback: CallbackHelper) {
        val docRef: DocumentReference = db.collection(CL_ACCOM).document(idAccom)
        val registration: ListenerRegistration = docRef.addSnapshotListener { snapshot, error ->
            if (error != null) {
                Log.w(MotionEffect.TAG, "Listen failed.", error)
                return@addSnapshotListener
            }
            if (snapshot != null && snapshot.exists()) {
                val accommodation: Accommodation? = snapshot.toObject(Accommodation::class.java)
                accommodation?.let {
                    callback.onAccommodationRecieved(it)
                } ?: run {
                    Log.w(MotionEffect.TAG, "Accommodation not found.")
                }
            } else {
                Log.w(MotionEffect.TAG, "No accommodation found with the given ID.")
            }
        }
        listenerRegistrations.add(registration)
    }


    fun addAccommodation(accom: Accommodation) {
        val user: MutableMap<String, Any> = HashMap()
        user[FL_ACCOMID] = accom.accommodationId.toString()
        user[FL_NAME] = accom.name.toString()
        user[FL_PRICE] = accom.price
        user[FL_FREEROOM] = accom.freeroom
        user[FL_IMAGE] = accom.image.toString()
        user[FL_DESCRIPTION] = accom.description.toString()
        user[FL_ADDRESS] = accom.address.toString()
        user[FL_LONGTITUDE] = accom.latitude.toString()
        user[FL_LATITUDE] = accom.latitude.toString()
        user[FL_CITYID] = accom.cityId.toString()
        db.collection(CL_ACCOM).document(accom.accommodationId.toString()).set(user)
    }



    fun removeAllListeners() {
        for (registration in listenerRegistrations) {
            registration.remove()
        }
        listenerRegistrations.clear()
    }
}
