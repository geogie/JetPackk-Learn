package cn.george.mylearn.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import cn.george.mylearn.room.data.Shoe

/**
 * Created By George
 * Description:
 */
class ShoeDiffCallback :DiffUtil.ItemCallback<Shoe>(){
    override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
        return oldItem == newItem
    }

}