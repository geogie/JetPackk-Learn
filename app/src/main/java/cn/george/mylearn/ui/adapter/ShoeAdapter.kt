package cn.george.mylearn.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import cn.george.mylearn.databinding.ShoeRecyclerItemBinding
import cn.george.mylearn.room.data.Shoe

/**
 * Created By George
 * Description:
 */
class ShoeAdapter constructor(val context: Context) :
    PagedListAdapter<Shoe, ShoeAdapter.ViewHolder>(ShoeDiffCallback()) {
    companion object{
        private const val TAG="ShoeAdapter-"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ShoeRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context)
                , parent
                , false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoe = getItem(position)
        holder.apply {
            bind(onCreateListener(shoe!!.id), shoe)
            itemView.tag = shoe
        }
    }

    class ViewHolder(private val binding: ShoeRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, item: Shoe) {
            binding.apply {
                this.listener = listener
                this.shoe = item
                executePendingBindings()
            }
        }
    }

    private fun onCreateListener(id:Long):View.OnClickListener{
        return View.OnClickListener {
            Log.d(TAG,"onCreateListener-跳转到详情")
        }
    }
}