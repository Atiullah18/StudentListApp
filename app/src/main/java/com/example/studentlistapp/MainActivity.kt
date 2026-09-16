package com.example.studentlistapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.etName)
        val roll = findViewById<EditText>(R.id.etRoll)
        val course = findViewById<EditText>(R.id.etCourse)

        val save = findViewById<Button>(R.id.btnSave)
        val viewAll = findViewById<Button>(R.id.btnView)
        val clear = findViewById<Button>(R.id.btnClear)

        save.setOnClickListener {

            val studentName = name.text.toString().trim()
            val studentRoll = roll.text.toString().trim()
            val studentCourse = course.text.toString().trim()

            if (studentName.isEmpty() ||
                studentRoll.isEmpty() ||
                studentCourse.isEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Please enter all details",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                val preferences =
                    getSharedPreferences("StudentData", MODE_PRIVATE)

                val count = preferences.getInt("count", 0)

                preferences.edit()
                    .putString("name_$count", studentName)
                    .putString("roll_$count", studentRoll)
                    .putString("course_$count", studentCourse)
                    .putInt("count", count + 1)
                    .apply()

                Toast.makeText(
                    this,
                    "Student Saved Successfully",
                    Toast.LENGTH_SHORT
                ).show()

                name.text.clear()
                roll.text.clear()
                course.text.clear()
            }
        }

        viewAll.setOnClickListener {
            startActivity(
                Intent(this, StudentListActivity::class.java)
            )
        }

        clear.setOnClickListener {
            name.text.clear()
            roll.text.clear()
            course.text.clear()
        }
    }
}