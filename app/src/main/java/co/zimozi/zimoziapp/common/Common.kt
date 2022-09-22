package co.zimozi.zimoziapp.common

import android.app.Activity
import android.content.Intent
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("imageUrl")
fun setImageUrl(imgView: ImageView, imgUrl: String?) {

    imgUrl?.let {
        Glide.with(imgView.context)
            .load(imgUrl)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .centerCrop()
            .into(imgView)
    }
}

fun Activity.openActivity(activity: Class<*>?) {
    val intent = Intent(this, activity)
    this.startActivity(intent)
}
