package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Create binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        // Create binding object to connect the layout with the activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Set click listener for the button
        //findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }

        // Access the Done button using the binding object
        binding.doneButton.setOnClickListener { addNickname(it) }
    }

    private fun addNickname(view: View) {

        binding.apply {
            // Access the nickname and button using the binding object
            binding.nicknameText.text = binding.nicknameEdit.text
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
