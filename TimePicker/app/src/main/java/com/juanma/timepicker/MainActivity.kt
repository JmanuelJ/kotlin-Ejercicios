package com.juanma.timepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.juanma.timepicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        setHour()
        changeHour()
    }

    private fun changeHour() {
        binding.tmHora.setOnClickListener{
            setHour()
            binding.tmHora.visibility = View.GONE
        }
    }

    private fun initView(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun pushButton(view: View){
        binding.btnHora.setOnClickListener{
            showClock()
        }
    }

    private fun showClock(){
        binding.tmHora.visibility = View.VISIBLE
    }

    private fun setHour(){
        binding.txtHora.setText(getHourTimePicker())
    }



    private fun getHourTimePicker(): String{
        var hour = binding.tmHora.currentHour.toString().padStart(2,'0')
        var minutes = binding.tmHora.currentMinute.toString().padStart(2,'0')

        return hour + " : " + minutes
    }

}