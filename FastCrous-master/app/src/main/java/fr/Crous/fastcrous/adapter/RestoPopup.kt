package fr.Crous.fastcrous.adapter

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import fr.Crous.fastcrous.R
import fr.Crous.fastcrous.model.RestoModel

class  RestoPopup (private val adapter: RestoAdapter,
                   private val currentResto: RestoModel
): Dialog(adapter.context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_resto_details)
        setupComponents()
        setupCloseButton() /* private fun setupComponents() {
         //actualiser l'image du resto
         val restoImage =findViewById<ImageView>(R.id.image_resto)
         Glide.with(adapter.context).load(Uri.parse(currentResto.ImageUrl)).into(restoImage)
         TODO("Not yet implemented")
     }*/

    }

    private fun setupComponents() {
        //actualiser l'image
        val plantImage=findViewById<ImageView>(R.id.image_resto_popup)
        Glide.with(adapter.context).load(Uri.parse(currentResto.ImageUrl)).into(plantImage)

        //actualiser le nom du resto dans la pop up
        findViewById<TextView>(R.id.popup_resto_name).text=currentResto.Name

        //actualiser l'adresse  du resto dans la pop up
        findViewById<TextView>(R.id.popup_resto_adresse).text=currentResto.Adresse

        //actualiser le temps  dans la pop up
        findViewById<TextView>(R.id.popup_resto_time).text=currentResto.Time

        //actualiser le paiement  du resto dans la pop up
        findViewById<TextView>(R.id.popup_resto_CbIzly).text=currentResto.Paiement
        //actualiser l'heure du resto dans la pop up
        findViewById<TextView>(R.id.popup_resto_h).text=currentResto.Heure


    }

    private fun setupCloseButton() {

        findViewById<ImageView>(R.id.close_button).setOnClickListener{dismiss()}
    }

}