package fr.Crous.fastcrous.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.Crous.fastcrous.activity.MainActivity
import fr.Crous.fastcrous.R
import fr.Crous.fastcrous.model.RestoModel

class RestoAdapter(
    val context: MainActivity,
    private val restoList: List<RestoModel>,
    private val layoutId: Int
) : RecyclerView.Adapter<RestoAdapter.viewHolder>() {


    //boite pour ranger tout les composants à controler
    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val restoImage: ImageView = view.findViewById(R.id.image_item_vertical)
        val NomResto: TextView? = view.findViewById(R.id.name_resto)
        val adresseResto: TextView? = view.findViewById(R.id.detail_item_vertical)
        val time: TextView? = view.findViewById(R.id.detail_horizental)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        //recuperer les info de la plancte
        val currentresto = restoList[position]

        println(currentresto.ImageUrl + "\n\n\n\n\n\n")


        // interaction lors du clic sur un resto en affichant le popup
        holder.itemView.setOnClickListener{
            //afficher le popup
            RestoPopup(this,currentresto).show()
        }
        //utiliser glide pour recuperer une image a partir d'un lien
        Glide.with(context).load(Uri.parse(currentresto.ImageUrl)).into(holder.restoImage)
        //Mettre a jour le nom du reesto
        holder.NomResto?.text = currentresto.Name

        //mettre a jour le detail de chaque resto
        holder.adresseResto?.text = currentresto.Adresse

        //mettre a jour le time dans les barre horizental
        holder.time?.text = currentresto.Time

    }

    override fun getItemCount(): Int {
        return restoList.size
    }
}