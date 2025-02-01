package com.example.fefu_app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fefu_app.R

class ProfileFragment : Fragment() {
    lateinit var result_view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        result_view = inflater.inflate(R.layout.profile_fragment, container, false)


        return result_view
    }

}