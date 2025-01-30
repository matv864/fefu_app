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
                .add(R.id.fragment_container, ActivityFragment(true), "ActivityFragment")
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
        val TopNavigationView = findViewById<BottomNavigationView>(R.id.top_navigation)
        TopNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.personal_activities -> {
                    switchFragment(
                        activities_is_selected = true,
                        personal_activities_is_selected = true
                    )
                    true
                }
                R.id.common_activities -> {
                    switchFragment(
                        activities_is_selected = true,
                        personal_activities_is_selected = false
                    )
                    true
                }
                else -> false
            }
        }

    }

    private fun switchFragment(
        activities_is_selected: Boolean? = null,
        personal_activities_is_selected: Boolean? = null
    ) {
        // I couldn't make overloading
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

        if (personal_activities_is_selected != null) {
            supportFragmentManager.beginTransaction()
                .remove(activities_fragment)
                .add(
                    R.id.fragment_container,
                    ActivityFragment(personal_activities_is_selected),
                    "ActivityFragment"
                )
                .commit()
        }
    }
}