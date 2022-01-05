package fr.Crous.fastcrous.adapter



import android.app.Activity
import android.content.Context
import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import fr.Crous.fastcrous.R

abstract class CustomInfoWindowGoogleMap (val context: Context) : GoogleMap.InfoWindowAdapter {
    override fun getInfoContents(p0: Marker): View? {
        var mInfoView = (context as Activity).layoutInflater.inflate(R.layout.popup_resto_details, null)
        return mInfoView

    }
    override fun getInfoWindow(p0: Marker): View? {
        return null
    }
}