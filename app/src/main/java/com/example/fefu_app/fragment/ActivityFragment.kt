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

class ActivityFragment(is_my_activities: Boolean) : Fragment() {
    private val is_my_activities: Boolean = is_my_activities

    lateinit var result_view: View
    lateinit var recycler_view: RecyclerView
    private lateinit var adapter: ActivityAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myList = if (is_my_activities) {
                listOf(
                    ActivityEntity(id = 1, text = "hello"),
                    ActivityEntity(id = 2, text = "goodBye")
                )
            } else {
                listOf(
                    ActivityEntity(id = 1, text = "not hello"),
                    ActivityEntity(id = 2, text = "not goodBye")
                )
            }


        result_view = inflater.inflate(R.layout.activity_fragment, container, false)

        recycler_view = result_view.findViewById(R.id.recycler_view)
        adapter = ActivityAdapter(myList)
        recycler_view.adapter = adapter
        if (this.context != null) {
            recycler_view.layoutManager = LinearLayoutManager(this.context)
        }

        return result_view
    }
}