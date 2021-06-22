package br.com.cotemig.pedro.models

import java.io.Serializable

class Playlist (
    var artist : String = "",
    var year : String = "",
    var thumb : String = "",
    var album : String = "",
    var title : String = ""
) : Serializable