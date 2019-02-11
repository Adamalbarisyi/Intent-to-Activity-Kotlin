package com.example.gryus.footballclub

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext

class FootballAdapter(var list : MutableList<ListClub>, var listener : (ListClub) -> Unit) : RecyclerView.Adapter<FootballAdapter.FootballViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballViewHolder {
        return FootballViewHolder(MainActivity.FootballUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: FootballViewHolder, position: Int) {
        holder.bindItem(list[position], listener)

    }

    inner class FootballViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var imageView : ImageView
        var textView : TextView

        init {
            imageView = itemView.findViewById(MainActivity.FootballUI.imageId)
            textView = itemView.findViewById(MainActivity.FootballUI.nameId)
        }

        fun bindItem (items : ListClub, listener : (ListClub) -> Unit){
            textView.text = items.nama
            Glide.with(itemView.context).load(items.image).into(imageView)
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }

}