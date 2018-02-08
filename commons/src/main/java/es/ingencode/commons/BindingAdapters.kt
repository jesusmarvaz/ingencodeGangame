package es.ingencode.commons

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by jesusmarvaz on 03/02/2018.
 */
/*
* <ImageView
                android:id="@+id/imgThumb"
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:layout_marginBottom="8dp"
                android:layout_marginEnd="8dp"
                android:layout_marginStart="8dp"
                android:layout_marginTop="8dp"
                app:imageURL="@{topGame.thumb}"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintDimensionRatio="2:1"
                app:layout_constraintEnd_toStartOf="@+id/guideline"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent" />
* */
@BindingAdapter("imageURL")
fun loadImage(imageView: ImageView, url: String){
    Glide.with(imageView).load(url).into(imageView)
}