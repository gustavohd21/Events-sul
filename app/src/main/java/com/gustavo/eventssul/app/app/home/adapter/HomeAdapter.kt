package com.gustavo.eventssul.app.app.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gustavo.eventssul.R
import com.gustavo.eventssul.app.app.model.Events
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_item_events.view.*

class HomeAdapter(private val events: List<Events>, private val listener: EventsListener) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_events, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = events[position].title

        Picasso.get()
            .load(events[position].image)
            .placeholder(R.drawable.image_empty)
            .error(R.drawable.image_empty)
            .into( holder.image)

        holder.itemView.setOnClickListener { listener.onItemClick(events[position]) }
    }

    override fun getItemCount(): Int {
        return events.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.title
        val image = itemView.image
    }

    interface EventsListener {
        fun onItemClick(event: Events)
    }

}