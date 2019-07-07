package com.yolocc.eyepetizerunofficial

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.yolocc.eyepetizerunofficial.base.BaseActivity
import com.yolocc.eyepetizerunofficial.util.obtainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.toast

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                toolbar.title = getString(R.string.title_home)
                loadFragment(homeFragment)
                hideFragment = homeFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_discover -> {
                toolbar.title = getString(R.string.title_discover)
                loadFragment(discoverFragment)
                hideFragment = discoverFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_ranking -> {
                toolbar.title = getString(R.string.title_ranking)
                loadFragment(rankingFragment)
                hideFragment = rankingFragment
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private lateinit var discoverFragment: DiscoverFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var homeFragment: HomeFragment
    private var hideFragment: Fragment? = null
    private var backTime: Long = 0

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun init() {
        toolbar.title = getString(R.string.title_home)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextAppearance(this, R.style.LobsterFontTextViewStyle)

        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
        homeFragment = HomeFragment.newInstance()
        discoverFragment = DiscoverFragment.newInstance()
        rankingFragment = RankingFragment()
        supportFragmentManager.beginTransaction().add(R.id.frame_container, rankingFragment, "ranking")
            .hide(rankingFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.frame_container, discoverFragment, "discover")
            .hide(discoverFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.frame_container, homeFragment, "home").commit()
        hideFragment = homeFragment
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        if (hideFragment != null) {
            transaction.hide(hideFragment!!)
        }
        transaction.show(fragment).commit()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            if ((System.currentTimeMillis() - backTime) > 2000) {
                toast("再按一次退出")
                backTime = System.currentTimeMillis()
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_like -> {

            }
            R.id.nav_download -> {

            }
            R.id.nav_history -> {

            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return false
    }

    fun obtainViewModel() = obtainViewModel(MainViewModel::class.java)
}
