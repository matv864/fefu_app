package com.example.fefu_app

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Registration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.registration)

        (findViewById<FrameLayout>(R.id.nested_bar)
                    .findViewById<TextView>(R.id.title)
                    .setText(getString(R.string.registration_page))
                )


//        titleInBar = getView

    }
}