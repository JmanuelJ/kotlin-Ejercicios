package com.juanma.calendario

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var textDate: TextView
    private lateinit var btnDate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()

        val calendarBox = Calendar.getInstance()
        val dateBox = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
            calendarBox.set(Calendar.YEAR, year)
            calendarBox.set(Calendar.MONTH, month)
            calendarBox.set(Calendar.DAY_OF_MONTH, day)
            updateText(calendarBox)
        }
      btnDate.setOnClickListener{
          DatePickerDialog(this,
              dateBox,
              calendarBox.get(Calendar.YEAR),
              calendarBox.get(Calendar.MONTH),
              calendarBox.get(Calendar.DAY_OF_MONTH)
          ).show()
      }
    }

    private fun updateText(calendar: Calendar){
        val dateFormat = "dd-mm-yyyy"
        val simple = SimpleDateFormat(dateFormat, Locale.US)
        textDate.setText(simple.format(calendar.time))
    }

    private fun initView(){
        setContentView(R.layout.activity_main)
        textDate = findViewById(R.id.textDate)
        btnDate = findViewById(R.id.btnDate)
    }

}