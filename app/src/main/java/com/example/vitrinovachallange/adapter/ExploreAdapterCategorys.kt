package com.example.vitrinovachallange.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vitrinovachallange.R
import com.example.vitrinovachallange.datas.Category
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.category_layout.view.*

class ExploreAdapterCategorys(allCategoryList: MutableList<Category>) :
    RecyclerView.Adapter<ExploreAdapterCategorys.MyViewHolder>() {

    var categoryList = allCategoryList

    override fun getItemCount(): Int =  categoryList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var productLayoutView = inflater.inflate(R.layout.category_layout, parent, false)
       return MyViewHolder(productLayoutView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.categoryTitle.text = categoryList.get(position).name
        Picasso.get().load(categoryList.get(position).logo.url).into(holder.categoryBigImage)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView!!) {
        var itemViewProducts = itemView
        var categoryTitle = itemViewProducts?.tvCategoryName
        var categoryBigImage = itemViewProducts?.imgCategory
    }
}