package es.ingencode.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by jesusmarvaz on 03/02/2018.
 */

//it's an extension!!, we add inflate method to the ViewGroup class to inflate de view in this smart way
//also, we use de initilize attachToRoot by default with false
fun ViewGroup.inflate(layoutResId: Int, attachToRoot: Boolean = false): View {
    val inflater = LayoutInflater.from(context)
    return inflater.inflate(layoutResId, this, attachToRoot)
}