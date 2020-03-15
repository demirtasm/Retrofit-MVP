package com.example.vitrinovachallange.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.vitrinovachallange.R
import com.example.vitrinovachallange.datas.Featured
import com.squareup.picasso.Picasso

class SliderAdapter : PagerAdapter {

    var context: Context
    var images: MutableList<Featured>
    lateinit var inflater: LayoutInflater

    constructor(context: Context, images: MutableList<Featured>) : super() {
        this.context = context
        this.images = images
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as RelativeLayout
    }

    override fun getCount(): Int = 3

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var image: ImageView
        val holder : ExploreAdapterFeatured.MyViewHolder
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view: View = inflater.inflate(R.layout.slider_image_item, container, false)
        image = view.findViewById(R.id.sliderImage) as ImageView
        //image.setBackgroundResource(images[position])
        Picasso.get().load(images[0].cover.url).into(image)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}