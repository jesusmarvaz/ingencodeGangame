package es.ingencode.gangame.rated

import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import es.ingencode.commons.BaseListFragment
import es.ingencode.commons.DataBindingRecyclerAdapter
import es.ingencode.gangame.BR
import es.ingencode.gangame.R
import es.ingencode.gangame.TopGame
import es.ingencode.gangame.data.GangameDataSource

/**
 * Created by jesusmarvaz on 06/02/2018.
 */
class TopRatedFragment: BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)
    }

    override fun onResume() {
        super.onResume()
        showTopRated()
    }

    private fun showTopRated() {
        GangameDataSource.getTopGames().subscribe({ list ->
            replaceItems(list)
        }, { error ->
            showError(error)
        })
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
        view?.let{
            Snackbar.make(view as View, R.string.error_request, Snackbar.LENGTH_LONG)
                    .setAction(R.string.label_retry, {_: View -> showTopRated()})
                    .show()
        }
    }

    private fun replaceItems(list: List<TopGame>) {
        with(listAdapter as DataBindingRecyclerAdapter<TopGame>) {
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }
}