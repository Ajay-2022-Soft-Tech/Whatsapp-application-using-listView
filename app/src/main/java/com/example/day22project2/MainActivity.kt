package com.example.day22project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var userArrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Preparing Data

        val name = arrayOf("Ajay","Vaidik","Satyam","Sufiyan","Prince","Sahil","Piyush","Indu")
        val lastMsg = arrayOf("Hey Boy?","I am Fine!","What About You?","I'm Cool","How old?","I'm Cool","How's Your Brother?","How's You?")
        val lastMsgTime = arrayOf("9:15 AM","7:30 PM","6:25AM","5:20AM","3:14 PM","4:20 PM","2:10 AM","5:20 PM")
        val phoneNumber = arrayOf("9977252029","7759325253","8899553344","9243643555","9124358437","7745544993","55776633556","8877344344")
        val imageId = intArrayOf(R.drawable.pic0,R.drawable.pic1,R.drawable.pic2,R.drawable.pic5,R.drawable.pic4,R.drawable.pic3,R.drawable.pic6,R.drawable.pic7)

        userArrayList = ArrayList()


//        each user data is been add
        for (eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex] , lastMsgTime[eachIndex], phoneNumber[eachIndex], imageId[eachIndex])
//        adding data to arrayList
            userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = MyAdapter(this, userArrayList)


         // open new activity also

        listView.setOnItemClickListener { parent, view, position, id ->

            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imageId[position]

            val intent = Intent (this, UserActivity :: class.java)
            intent.putExtra("name",userName)
            intent.putExtra("phone",userPhone)
            intent.putExtra("imageId",imageId)
            startActivity(intent)
        }

    }
}