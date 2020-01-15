package cn.george.mylearn.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import cn.george.mylearn.R
import com.bumptech.glide.Glide

/**
 * Created By George
 * Description:
 */

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl:String?){
    if (!imageUrl.isNullOrEmpty()){
        Glide.with(view.context)
            .asBitmap()
            .load(imageUrl)
            .placeholder(R.drawable.glide_placeholder)
            .centerCrop()
            .centerCrop()
            .into(view)
    }
}