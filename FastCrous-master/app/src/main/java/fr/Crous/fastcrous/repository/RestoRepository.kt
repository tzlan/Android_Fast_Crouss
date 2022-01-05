package fr.Crous.fastcrous.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import fr.Crous.fastcrous.repository.RestoRepository.Singleton.RestoList
import fr.Crous.fastcrous.repository.RestoRepository.Singleton.databaseReference
import fr.Crous.fastcrous.model.RestoModel


class RestoRepository {

    object Singleton{

        //Se connecter a la base
        val databaseReference=Firebase.database.getReference("Crous")

        // créer une liste de crous
        val RestoList= arrayListOf<RestoModel>()
    }

    fun updateData(callback:()->Unit){
        //recuperer les donnees et les ajoutées dans la liste
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                //mettre a zero la liste
                RestoList.clear()
                for (elem in p0.children){
                    val resto=elem.getValue(RestoModel::class.java)
                    //verifier si l'elem esr chargé
                    if(resto!=null){
                        //ajouter a la liste
                        RestoList.add(resto)
                    }
                }
                //actionner le callback
                callback()
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.w(TAG, "Failed to read value.", p0.toException())
            }

        })
    }
}