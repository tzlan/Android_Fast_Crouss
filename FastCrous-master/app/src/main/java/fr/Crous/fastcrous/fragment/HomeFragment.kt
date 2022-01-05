package fr.Crous.fastcrous.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.Crous.fastcrous.adapter.RestoAdapter
import fr.Crous.fastcrous.decorator.restoDecoration
import fr.Crous.fastcrous.activity.MainActivity
import fr.Crous.fastcrous.R
import fr.Crous.fastcrous.repository.RestoRepository.Singleton.RestoList

class HomeFragment(private val context: MainActivity) : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view=inflater?.inflate(R.layout.fragement_home,container,false)




        //recuperer le recycleview
        val horizental_view=view.findViewById<RecyclerView>(R.id.fragementHome)
        horizental_view.adapter=RestoAdapter(context,RestoList,R.layout.item_resto_horizental)

        //recuperer le second recyclerview
        val verticalRecycleView=view.findViewById<RecyclerView>(R.id.verttical_recycleView)
        verticalRecycleView.adapter= RestoAdapter(context,RestoList,R.layout.item_resto_vertical)
        verticalRecycleView.addItemDecoration(restoDecoration())

        return view
    }

}