package com.example.vitrinovachallange.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.vitrinovachallange.R
import com.example.vitrinovachallange.datas.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.products_image_item.view.*

class ExploreAdapterProducts(allExploreProducts: List<Product>): RecyclerView.Adapter<ExploreAdapterProducts.MyViewHolder>() {

    var exploreProducts = allExploreProducts

    override fun getItemCount(): Int = exploreProducts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var exploreLayoutView = inflater.inflate(R.layout.products_image_item, parent, false)
        return MyViewHolder(exploreLayoutView)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.exploreProductsTitle.text = exploreProducts.get(position).title
        holder.exploreProductsName.text = exploreProducts.get(position).shop.name
        holder.explorePrice.text = exploreProducts.get(position).price.toString()+"TL"
        holder.exploreOldPrice.text = exploreProducts.get(position).oldPrice.toString()+"TL"
        Picasso.get().load(exploreProducts.get(position).images.get(0).url).into(holder.imgExploreProducts)


    }

    class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        var itemViewProducts = itemView
        var exploreProductsTitle = itemViewProducts.tvExploreProductsTitle
        var exploreProductsName = itemViewProducts.tvExploreProductsName
        var explorePrice = itemViewProducts.tvPrice
        var exploreOldPrice = itemViewProducts.tvOldPrice
        var imgExploreProducts = itemViewProducts.imgProductsShop
    }
}