package com.example.fefu_app

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Registration : AppCompatActivity(), View.OnClickListener {
    lateinit var backButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.registration)

        findViewById<TextView>(R.id.title)
            .setText(getString(R.string.registration_page))

        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener(this)

    }


    override fun onClick(view: View) {
        if (view.id == R.id.back_button) {
            finish()
        }
    }
}