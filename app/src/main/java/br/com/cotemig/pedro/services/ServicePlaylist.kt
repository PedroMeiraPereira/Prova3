package br.com.cotemig.pedro.services

import br.com.cotemig.pedro.models.ListPlaylist
import retrofit2.Call
import retrofit2.http.GET

interface ServicePlaylist {

    @GET("playlist/top10")
    fun getPlaylist(): Call<List<ListPlaylist>>

}