package fr.Crous.fastcrous.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.Crous.fastcrous.fragment.HomeFragment
import fr.Crous.fastcrous.fragment.MapsFragment
import fr.Crous.fastcrous.R
import fr.Crous.fastcrous.repository.RestoRepository


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment(this))
        //importer le bottom nav view
        val navigationView =findViewById<BottomNavigationView>(R.id.navigation_view)
        navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.home_page ->{
                    loadFragment(HomeFragment(this))
                    return@setOnNavigationItemSelectedListener true

                }
                R.id.map_page ->{
                    loadFragment(MapsFragment())
                    return@setOnNavigationItemSelectedListener true
                }


                else -> false
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        //charger notre repository
        val repo= RestoRepository()
        //injecter le fragment dans notre boite (dans le composant frame container)
        repo.updateData {
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.addToBackStack(null)
            transaction.commit()}
    }
}