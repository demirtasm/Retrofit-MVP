package com.example.vitrinovachallange.adapter

import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.BlurMaskFilter.Blur
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vitrinovachallange.R
import com.example.vitrinovachallange.datas.Category
import com.example.vitrinovachallange.datas.Product
import com.example.vitrinovachallange.datas.Vitrinova
import com.example.vitrinovachallange.view.ProductsFragment
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation
import jp.wasabeef.picasso.transformations.gpu.ToonFilterTransformation
import kotlinx.android.synthetic.main.products_layout.view.*

class ProductsAdapter( allProductList: MutableList<Category>) : RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

    var productList = allProductList


    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var productLayoutView = inflater.inflate(R.layout.products_layout, parent, false)
        return MyViewHolder(productLayoutView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.productTitle?.text = productList[position].name
        Picasso.get()
            .load(productList.get(position).logo.url)
        // .transform(BlurTransformation(holder.productBigImage?.context,2,5))
            .into(holder.productBigImage)
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var itemViewProducts = itemView
        var productTitle = itemViewProducts?.productsTitle
        var productBigImage = itemViewProducts?.productsImage
    }


}
