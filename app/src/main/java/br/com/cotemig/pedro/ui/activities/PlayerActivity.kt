package br.com.cotemig.pedro.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cotemig.pedro.R
import br.com.cotemig.pedro.models.Playlist
import coil.load
import coil.transform.RoundedCornersTransformation
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        var playlist = intent.getSerializableExtra("playlist") as Playlist

        showPlayer(playlist)
    }

    fun showPlayer(details: Playlist){
        thumb.load(details.thumb){
            transformations(RoundedCornersTransformation(20f))
        }

        artist.text = details.artist

        musicname.text = details.title
    }
}