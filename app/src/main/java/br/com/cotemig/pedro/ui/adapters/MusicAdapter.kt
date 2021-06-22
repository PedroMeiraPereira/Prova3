package br.com.cotemig.pedro.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.pedro.R
import br.com.cotemig.pedro.models.Playlist
import br.com.cotemig.pedro.ui.activities.PlayerActivity
import coil.load
import coil.transform.RoundedCornersTransformation

class MusicAdapter(var context: Context, var list: List<Playlist>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_music, parent, false)
        return MusicHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MusicHolder).bind(context, list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MusicHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(context: Context, playlist: Playlist) {
            var thumb = view.findViewById<ImageView>(R.id.thumb)
            thumb.load(playlist.thumb) {
                transformations(RoundedCornersTransformation(20f))
            }

            var album = view.findViewById<TextView>(R.id.album)
            album.text = playlist.album

            var artist = view.findViewById<TextView>(R.id.artist)
            artist.text = playlist.artist

            var itemMusic = view.findViewById<LinearLayout>(R.id.itemMusic)
            itemMusic.setOnClickListener {
                var intent = Intent(context, PlayerActivity::class.java)
                intent.putExtra("playlist", playlist)
                context.startActivity(intent)
            }
        }
    }
}