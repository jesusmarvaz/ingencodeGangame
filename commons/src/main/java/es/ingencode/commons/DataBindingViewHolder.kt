package es.ingencode.commons

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by jesusmarvaz on 03/02/2018.
 */
//uso del data-binding, necesario pasarle binding.root
class DataBindingViewHolder<in MODEL>(val itemVariableId: Int, val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindItem(item: MODEL){
        binding.setVariable(itemVariableId, item)
        binding.executePendingBindings() //improves performance
    }
}