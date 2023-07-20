package com.example.day22project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phone")
        val imageId = intent.getIntExtra("imageId",R.drawable.pic0)


        val nameTv = findViewById<TextView>(R.id.tVName)
        val phoneTv = findViewById<TextView>(R.id.tVPhone)
        val image = findViewById<CircleImageView>(R.id.profile_image)
        val btnSend = findViewById<ImageView>(R.id.btnSend)
        val inputLayout = findViewById<TextInputEditText>(R.id.inputLayout)

        nameTv.text = name
        phoneTv.text = phoneNumber
        image.setImageResource(imageId)

        btnSend.setOnClickListener {
            Toast.makeText(this, "Message Send",Toast.LENGTH_SHORT).show()
            inputLayout.text?.clear()
        }


    }
}