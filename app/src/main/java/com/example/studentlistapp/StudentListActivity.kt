package com.example.studentlistapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentListActivity : AppCompatActivity() {

    private val names = ArrayList<String>()
    private val rolls = ArrayList<String>()
    private val courses = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        val listView =
            findViewById<ListView>(R.id.studentListView)

        val back =
            findViewById<ImageButton>(R.id.btnBack)

        val clearAll =
            findViewById<Button>(R.id.btnClearAll)

        loadStudents()

        val adapter = StudentAdapter()
        listView.adapter = adapter

        back.setOnClickListener {
            finish()
        }

        clearAll.setOnClickListener {

            getSharedPreferences("StudentData", MODE_PRIVATE)
                .edit()
                .clear()
                .apply()

            names.clear()
            rolls.clear()
            courses.clear()

            adapter.notifyDataSetChanged()
        }
    }

    private fun loadStudents() {

        val preferences =
            getSharedPreferences("StudentData", MODE_PRIVATE)

        val count =
            preferences.getInt("count", 0)

        for (i in 0 until count) {

            val name =
                preferences.getString("name_$i", "")

            val roll =
                preferences.getString("roll_$i", "")

            val course =
                preferences.getString("course_$i", "")

            if (!name.isNullOrEmpty()) {

                names.add(name)
                rolls.add(roll ?: "")
                courses.add(course ?: "")
            }
        }
    }

    inner class StudentAdapter : BaseAdapter() {

        override fun getCount(): Int {
            return names.size
        }

        override fun getItem(position: Int): Any {
            return names[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?
        ): View {

            val view =
                LayoutInflater.from(this@StudentListActivity)
                    .inflate(
                        R.layout.student_item,
                        parent,
                        false
                    )

            val image =
                view.findViewById<ImageView>(
                    R.id.studentImage
                )

            val name =
                view.findViewById<TextView>(
                    R.id.studentName
                )

            val details =
                view.findViewById<TextView>(
                    R.id.studentDetails
                )

            // Repeat the 3 images for all students
            val images = intArrayOf(
                R.drawable.student1,
                R.drawable.student2,
                R.drawable.student3
            )

            image.setImageResource(
                images[position % images.size]
            )

            name.text = names[position]

            details.text =
                "Roll No: ${rolls[position]}   •   ${courses[position]}"

            return view
        }
    }
}