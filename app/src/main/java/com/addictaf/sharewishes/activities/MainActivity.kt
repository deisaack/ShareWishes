package com.addictaf.sharewishes.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.addictaf.sharewishes.R
import com.addictaf.sharewishes.fragments.FavoriteFragment
import com.addictaf.sharewishes.fragments.HomeFragment
import com.addictaf.sharewishes.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        addFragmentToUi(HomeFragment::class.java)
        navigation.setOnNavigationItemSelectedListener {
            if (it.itemId==R.id.navigation_home)
            {
                if (frame_container.tag!=null && frame_container.tag != HomeFragment::class.java.simpleName)
                {
                    addFragmentToUi(HomeFragment::class.java)
                }
                return@setOnNavigationItemSelectedListener true
            } else if (it.itemId==R.id.navigation_favorire)
            {
                if (frame_container.tag!=null && frame_container.tag != FavoriteFragment::class.java.simpleName)
                {
                    addFragmentToUi(FavoriteFragment::class.java)
                }
                return@setOnNavigationItemSelectedListener true
            }
            return@setOnNavigationItemSelectedListener false
        }
    }

    private fun addFragmentToUi(className: Class<out Fragment>) {
        Utils.openFragment(supportFragmentManager, className, R.id.frame_container)
        frame_container.setTag(className.simpleName)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
