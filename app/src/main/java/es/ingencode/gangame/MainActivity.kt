package es.ingencode.gangame
import android.app.Activity
import android.app.Fragment
import android.app.FragmentManager
import android.os.Bundle
import es.ingencode.gangame.deals.DealsFragment
import es.ingencode.gangame.owned.MostOwnedFragment
import es.ingencode.gangame.rated.TopRatedFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by jesusmarvaz on 03/02/2018.
 */
class MainActivity : Activity (){
    //companion object: it's a static object (methods and attributes)
    //const val: it's final, a constant in compilation time. You can't assign a function to it, only strings or primitive data.
    //val: es como final, pero en tiempo de ejecución, sí se le pueden asignar funciones
    //val: it's final, but in runtime, you can assign functions to it.
    //var: it's a variable,a class attribute
    //lateinit var: it's an initilization in the future, in case there are null errors when compile
    companion object {
        const val DEFAULT_OPTION = R.id.action_deals
    }
    val fragments: HashMap<Int, Fragment> = linkedMapOf(
            Pair(R.id.action_top_rated, TopRatedFragment()),
            Pair(R.id.action_deals, DealsFragment()),
            Pair(R.id.action_most_owned, MostOwnedFragment()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        //Android extensions (import kotlinx.android.synthetic.main.activity_main.*)
        navigationView.selectedItemId = DEFAULT_OPTION
        //lambda { item -> do something (item)}
        //? it's a safe call, to indicate that variable can be null.
        //!! (not-null assertion) in this way we force the compiler to ignore the null checkup or testing, only in the case we are convinced or secure it's not null.
        navigationView.setOnNavigationItemSelectedListener { item ->
            val fragment : Fragment? = fragments[item.itemId]
            if (fragment != null)
                replaceFragment(fragment)
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        //getter getFragmentManager() of the Activity, it's accessed by naming directly the attribute!!-> fragmentManager
        fragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
    }

    fun initView() {
        val currentFragment = fragmentManager
                .findFragmentById(R.id.fragmentContainer)
        if(currentFragment == null)
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainer, fragments[DEFAULT_OPTION])
                    .commit()
    }
}