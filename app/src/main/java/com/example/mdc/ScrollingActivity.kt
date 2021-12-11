package com.example.mdc

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.bottomappbar.BottomAppBar

import com.example.mdc.databinding.ActivityScrollingBinding

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_scrolling)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            if (binding.bottomAppBar.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER){
               binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            }else{
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }

        /*findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            if (findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER){
                findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            }else{
                findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }*/

        binding.bottomAppBar.setNavigationOnClickListener{
            Snackbar.make(binding.root, R.string.message_action_success,Snackbar.LENGTH_LONG)
                .setAnchorView(binding.fab)
                .show()
        }

        binding.content.btnSkip.setOnClickListener { binding.content.cardAdd.visibility = View.GONE }

        binding.content.btnShop.setOnClickListener {
            Snackbar.make(it, R.string.card_buying, Snackbar.LENGTH_LONG)
                .setAnchorView(binding.fab)
                .setAction(R.string.card_to_go,{
                    Toast.makeText(this,R.string.card_history, Toast.LENGTH_LONG).show()
                })
                .show()
        }

        Glide.with(this)
            .load("https://www.hostinger.com.br/tutoriais/wp-content/uploads/sites/12/2019/04/Como-Usar-Um-Git-Branch.png")
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.content.imgCover)


        binding.content.cbEnablePass.setOnClickListener{
            binding.content.tilPassword.isEnabled = !binding.content.tilPassword.isEnabled
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}