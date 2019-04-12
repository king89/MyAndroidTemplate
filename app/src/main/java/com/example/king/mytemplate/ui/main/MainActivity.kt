package com.example.king.mytemplate.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar.LENGTH_SHORT
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import com.example.king.mytemplate.R
import com.example.king.mytemplate.R.id
import com.example.king.mytemplate.R.string
import com.example.king.mytemplate.base.BaseActivity
import com.example.king.mytemplate.base.ViewModelFactory
import com.example.king.mytemplate.di.annotation.ActivityScopedFactory
import com.example.king.mytemplate.domain.repository.ItemRepository
import com.example.king.mytemplate.ui.main.fragment.MainFragment
import com.example.king.mytemplate.util.Lg
import com.example.king.mytemplate.util.withViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    @field:ActivityScopedFactory
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            string.navigation_drawer_open,
            string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        initViewModel()
    }

    private fun initViewModel() {
        withViewModel<MainActivityViewModel>(viewModelFactory) {
            //TODO do something with activity view model
            this.dataList.observe(this@MainActivity, Observer {
                Snackbar.make(nav_view, "Test Observer: ${it?.size}", LENGTH_SHORT).show()
            })
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            id.nav_camera -> {
                // Handle the camera action
            }
            id.nav_gallery -> {

            }
            id.nav_slideshow -> {

            }
            id.nav_manage -> {

            }
            id.nav_share -> {

            }
            id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
