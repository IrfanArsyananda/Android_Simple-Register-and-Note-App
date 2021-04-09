package com.irfanarsya.registernavigationapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.irfanarsya.registernavigationapp.R
import com.irfanarsya.registernavigationapp.local.Notes
import kotlinx.android.synthetic.main.item_note.view.*

class NotesAdapter(
    private val data: List<Notes>?,
    val itemClick: OnClickListener
) : RecyclerView.Adapter<NotesAdapter.ViewHolder>(){
    class ViewHolder(val view: View, val itemClick: OnClickListener) : RecyclerView.ViewHolder(view){
        fun bind(item: Notes?){
            view.tDate.text = item?.date
            view.tNote.text = item?.note
            view.btnUpdate.setOnClickListener {
                itemClick.update(item)
            }
            view.btnDelete.setOnClickListener {
                itemClick.delete(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data?.size?: 0
    }

    interface OnClickListener{
        fun update(item: Notes?)
        fun delete(item: Notes?)
    }

}