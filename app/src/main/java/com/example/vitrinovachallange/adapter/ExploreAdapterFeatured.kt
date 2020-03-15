package com.example.vitrinovachallange.adapter

import android.database.CrossProcessCursor
import android.graphics.ColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.example.vitrinovachallange.R
import com.example.vitrinovachallange.datas.Featured
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation
import jp.wasabeef.picasso.transformations.ColorFilterTransformation
import jp.wasabeef.picasso.transformations.CropSquareTransformation
import jp.wasabeef.picasso.transformations.CropTransformation
import jp.wasabeef.picasso.transformations.gpu.SepiaFilterTransformation
import jp.wasabeef.picasso.transformations.gpu.VignetteFilterTransformation
import kotlinx.android.synthetic.main.fragment_explore.view.*
import kotlinx.android.synthetic.main.slider_image_item.view.*

class ExploreAdapterFeatured(allFeatured: List<Featured>): RecyclerView.Adapter<ExploreAdapterFeatured.MyViewHolder>() {
    var allFeaturedList = allFeatured

    override fun getItemCount(): Int = allFeaturedList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var featuredLayoutView = inflater.inflate(R.layout.slider_image_item, parent, false)
        return MyViewHolder(featuredLayoutView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get()
            .load(allFeaturedList.get(position).cover.url)
          //  .transform(VignetteFilterTransformation(holder.featuredImage?.context))
            .transform(CropTransformation(50,20,1000,500))
            .into(holder.featuredImage)

        holder.featureTitle.text = allFeaturedList.get(position).title
        holder.featureSubTitle.text = allFeaturedList.get(position).subTitle
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemViewProducts = itemView
        var featuredImage = itemViewProducts.sliderImage
        var featureTitle = itemViewProducts.tvExploreTitle
        var featureSubTitle = itemViewProducts.tvExploreSubTitle
        var newProductsTitle = itemViewProducts.tvNewProducts
    }
}