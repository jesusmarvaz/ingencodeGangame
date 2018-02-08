package es.ingencode.gangame.deals

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import es.ingencode.commons.BaseListFragment
import es.ingencode.commons.DataBindingRecyclerAdapter
import es.ingencode.gangame.BR
import es.ingencode.gangame.Deal
import es.ingencode.gangame.R
import es.ingencode.gangame.data.GangameDataSource
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by jesusmarvaz on 06/02/2018.
 */
class DealsFragment : BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)
    }

    override fun onResume() {
        super.onResume()
        showDeals()
    }

    private fun showDeals() {
        GangameDataSource.getDeals().subscribe({list ->
            replaceItems(list)
        }, { error ->
            showError(error)
        })
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
        view?.let{
            Snackbar.make(view, R.string.error_request, Snackbar.LENGTH_LONG)
                    .setAction(R.string.label_retry, {_: View -> showDeals()})
                    .show()
        }
    }

    private fun replaceItems(list: List<Deal>) {
        with(listAdapter as DataBindingRecyclerAdapter<Deal>) {
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }
}

    /*override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (listAdapter as DataBindingRecyclerAdapter<Deal>).items.addAll(getDummyDeals())
        listAdapter.notifyDataSetChanged()
    }

    fun getDummyDeals(): ArrayList<Deal>{
       return arrayListOf(Deal("Counter Strike",
                0.99F,
                9.99F,
                80,
                80,
                "http://cdn.akamai.steamstatic.com/steam/apps/10/capsule_184x69.jpg"))
    }*/