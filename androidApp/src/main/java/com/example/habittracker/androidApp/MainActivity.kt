package com.example.habittracker.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.habittracker.shared.Greeting
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val tv: TextView = findViewById(R.id.text_view)
        //tv.text = greet()

        val db = DataBaseHandler(this)
        val model = Model("Testing")
        db.insertData(model)
        model.Text = "Whoop"
        db.insertData(model)

        val arrayList = ArrayList<Model>()
        var dbList = db.readData()
        dbList.forEach{i -> arrayList.add(i)}

        val myAdaptor = Adaptor(arrayList, this)
        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdaptor
    }
}
