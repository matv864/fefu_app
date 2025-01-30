package com.example.fefu_app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fefu_app.R

class ActivityFragment : Fragment {
    val is_my_activities: Boolean

    constructor(_is_my_activities: Boolean){
        is_my_activities = _is_my_activities
    }


    lateinit var result_view: View
    lateinit var recycler_view: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        result_view = inflater.inflate(R.layout.activity_fragment, container, false)

        recycler_view = result_view.findViewById(R.id.recycler_view)

        return result_view
    }
}