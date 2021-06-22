package br.com.cotemig.pedro.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.pedro.R
import br.com.cotemig.pedro.models.ListPlaylist

class PlaylistAdapter(var context: Context, var list: List<ListPlaylist>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_playlist, parent, false)
        return PlaylistHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PlaylistHolder).bind(context, list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class PlaylistHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(context: Context, listPlaylist: ListPlaylist) {
            var name = view.findViewById<TextView>(R.id.name)
            name.text = listPlaylist.name

            var recyclerViewitemPlaylist = view.findViewById<RecyclerView>(R.id.recyclerViewitemPlaylist)
            recyclerViewitemPlaylist.adapter = MusicAdapter(context, listPlaylist.playlist)
            recyclerViewitemPlaylist.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            recyclerViewitemPlaylist.onFlingListener = null

//            var snapHelper = PagerSnapHelper()
//            snapHelper.attachToRecyclerView(recyclerViewitemPlaylist)
        }
    }
}