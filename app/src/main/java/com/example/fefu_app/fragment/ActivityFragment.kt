package com.example.fefu_app.fragment

import ActivityAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fefu_app.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.properties.Delegates

class ActivityFragment: Fragment() {
    var is_personal by Delegates.notNull<Boolean>()

    lateinit var result_view: View
    lateinit var recycler_view: RecyclerView
    private lateinit var adapter: ActivityAdapter
    private var myList: List<ActivityEntity> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        result_view = inflater.inflate(R.layout.activity_fragment, container, false)
        recycler_view = result_view.findViewById(R.id.recycler_view)

        is_personal = true
        setNewAdapter()

        if (this.context != null) {
            // this "if" only for android studio type checker
            recycler_view.layoutManager = LinearLayoutManager(this.context)
        }

        val topNavigationView = result_view.findViewById<BottomNavigationView>(R.id.top_navigation)
        topNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.personal_activities -> {
                    is_personal = true
                    setNewAdapter()
                    true
                }
                R.id.common_activities -> {
                    is_personal = false
                    setNewAdapter()
                    true
                }
                else -> false
            }
        }


        return result_view
    }


    private fun setNewAdapter(){
        myList = listOf(
            ActivityEntity(id = 1, text = System.currentTimeMillis().toString()),
            ActivityEntity(id = 2, text = "fuck"),
            ActivityEntity(id = 3, text = "ok")
        )
        recycler_view.adapter = ActivityAdapter(myList, result_view)


    }


}