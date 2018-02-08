package es.ingencode.commons

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by jesusmarvaz on 03/02/2018.
 */

//first abstraction of the fragment (see BaseListFragment)
abstract class BaseFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //haciendo uso de la extensión aplicada a ViewGroup, hemos añadido el método inflate (ver archivo Extension.kt),
        return container?.inflate(getLayoutResId())
    }
    abstract fun getLayoutResId(): Int
}