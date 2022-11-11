package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SerialsAdapter(private val serialList:ArrayList<Serials>)
    : RecyclerView.Adapter<SerialsAdapter.SerialsViewHolder>(){

    var onItemClick : ((Serials) -> Unit)? = null

    class SerialsViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val textView : TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerialsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return SerialsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SerialsViewHolder, position: Int) {
        val serials = serialList[position]
        holder.imageView.setImageResource(serials.image)
        holder.textView.text = serials.name

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(serials)
        }
    }

    override fun getItemCount(): Int {
        return serialList.size
    }


}