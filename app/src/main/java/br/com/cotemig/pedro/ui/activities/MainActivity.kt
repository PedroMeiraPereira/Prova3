package br.com.cotemig.pedro.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.cotemig.pedro.R
import br.com.cotemig.pedro.ui.fragments.PlaylistFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(PlaylistFragment.newInstance())

    }

    fun setFragment(f: Fragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.content, f)
        ft.commit()
    }
}