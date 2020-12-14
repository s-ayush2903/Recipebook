package com.stvayush.recipebook.framework

import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import com.google.android.material.navigation.NavigationView
import com.stvayush.recipebook.core.BaseActivity
import com.stvayush.recipebook.R
import com.stvayush.recipebook.utils.GenericApiResponse.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_recipe_list.*
import kotlinx.android.synthetic.main.app_bar_main.*

@AndroidEntryPoint
class RecipeListActivity : BaseActivity() {

    lateinit var homeFragment: HomeFragment
    lateinit var zomatoFragment: ZomatoFragment
    lateinit var rapidApiFragment: RapidApiFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        drawerLayout = findViewById(R.id.drawer_layout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.nav_view)

        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title="Recipe Book"

        val drawerToggle = ActionBarDrawerToggle(
            this@RecipeListActivity,
            drawerLayout,
            R.string.open,
            R.string.close
        )
        drawerToggle.isDrawerIndicatorEnabled=true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame,homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame,homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.zomato -> {
                    zomatoFragment = ZomatoFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame,zomatoFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.rapid -> {
                    rapidApiFragment = RapidApiFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame,rapidApiFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.share -> {
                    Toast.makeText(applicationContext,"Share this app!",Toast.LENGTH_SHORT).show()
                }
            }

            drawer_layout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

    }

    override fun onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }

    }
}
