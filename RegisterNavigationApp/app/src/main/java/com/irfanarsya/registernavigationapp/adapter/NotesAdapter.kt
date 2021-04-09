package com.irfanarsya.registernavigationapp.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.irfanarsya.registernavigationapp.local.Notes

class NotesAdapter(
    private val data: List<Notes>?
) : RecyclerView.Adapter<NotesAdapter.ViewHolder>(){
    class ViewHolder(val view :View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}