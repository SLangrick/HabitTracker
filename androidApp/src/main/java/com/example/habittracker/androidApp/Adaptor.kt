package com.example.habittracker.androidApp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


class Adaptor(val arrayList: ArrayList<Model>, val context: Context):
    RecyclerView.Adapter<Adaptor.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(model: Model){
            itemView.findViewById<TextView>(R.id.titleText).text = model.Text
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptor.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Adaptor.ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])


        holder.itemView.setOnClickListener {
            val model = arrayList.get(position)
            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnLongClickListener(){
            Toast.makeText(context, "Long click detected", Toast.LENGTH_SHORT).show()
            true
        }





    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

}