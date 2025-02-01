package com.example.fefu_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fefu_app.fragment.ActivityFragment
import com.example.fefu_app.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class EmptyState : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.emptystate)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ProfileFragment(), "ProfileFragment")
                .add(R.id.fragment_container, ActivityFragment(), "ActivityFragment")
                .commit()
            switchFragment(activities_is_selected = true)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_activity -> {
                    switchFragment(activities_is_selected = true)
                    true
                }
                R.id.navigation_profile -> {
                    switchFragment(activities_is_selected = false)
                    true
                }
                else -> false
            }
        }
    }

    private fun switchFragment(activities_is_selected: Boolean? = null) {
        var activities_fragment: Fragment? = supportFragmentManager.findFragmentByTag("ActivityFragment")
        var profile_fragment: Fragment? = supportFragmentManager.findFragmentByTag("ProfileFragment")

        if (activities_fragment == null || profile_fragment == null) {
            // check only for kotlin type checking
            return
        }

        if (activities_is_selected != null) {
            if (activities_is_selected) {
                supportFragmentManager.beginTransaction()
                    .show(activities_fragment)
                    .hide(profile_fragment)
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .show(profile_fragment)
                    .hide(activities_fragment)
                    .commit()
            }
        }
    }
}