package br.com.cotemig.pedro.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.pedro.R
import br.com.cotemig.pedro.models.ListPlaylist
import br.com.cotemig.pedro.services.RetrofitInitializer
import br.com.cotemig.pedro.ui.adapters.PlaylistAdapter
import retrofit2.Call
import retrofit2.Response

class PlaylistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_playlist, container, false)

        getPlaylist(view)

        return view
    }

    fun getPlaylist(view: View) {
        var s = RetrofitInitializer().servicePlaylist()
        var call = s.getPlaylist()

        call.enqueue(object : retrofit2.Callback<List<ListPlaylist>> {
            override fun onResponse(
                call: Call<List<ListPlaylist>>,
                response: Response<List<ListPlaylist>>
            ) {
                if (response.code() == 200) {
                    response.body()?.let {
                        showPlaylist(view, it)
                    }
                }
            }

            override fun onFailure(call: Call<List<ListPlaylist>>, t: Throwable) {
                Toast.makeText(context, "Ops", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun showPlaylist(view: View, list: List<ListPlaylist>) {
        var recyclerViewPlaylist = view.findViewById<RecyclerView>(R.id.recyclerViewPlaylist)
        recyclerViewPlaylist.adapter = PlaylistAdapter(context!!, list)
        recyclerViewPlaylist.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    companion object {
        fun newInstance(): PlaylistFragment {
            return PlaylistFragment()
        }
    }
}