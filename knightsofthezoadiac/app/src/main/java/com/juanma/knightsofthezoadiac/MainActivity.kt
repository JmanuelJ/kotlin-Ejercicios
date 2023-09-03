package com.juanma.knightsofthezoadiac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.juanma.knightsofthezoadiac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var knight: Knight? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun showInfo(view: View){

        knight?.let {
            binding.tvDetail.setText(knight?.viewInf())
        } ?: binding.tvDetail.setText("Night not Available")
    }

    fun createKnight(view: View){

        when(numberSelection()){
            1 -> {
                binding.ivImage.setImageDrawable(getDrawable(R.drawable.seiya))
                knight = Knight("Seiya",createArmor(), false)
                binding.tvDetail.setText("Seiya Knight Created")
            }
            2 ->  {
                binding.ivImage.setImageDrawable(getDrawable(R.drawable.shiryu))
                knight = Knight("Shiryu",createArmor(), false)
                binding.tvDetail.setText("Shiryu Knight Created")
            }
            3 -> {
                binding.ivImage.setImageDrawable(getDrawable(R.drawable.hyoga))
                knight = Knight("Hyoga",createArmor(), false)
                binding.tvDetail.setText("Shiryu Knight Created")
            }
        }
    }

    fun createArmor(): String{
        var armor = ""

        when(numberSelection()){
            1 -> armor = "Bronze"
            2 -> armor = "Silver"
            3 ->  armor = "Gold"
        }

        return armor
    }

    fun powerUp(view: View){
        knight?.let {
            binding.tvDetail.setText(knight?.initPowerUp())
        } ?: binding.tvDetail.setText("Night not Available")
    }

    fun fightKnight(view: View){
        knight?.let {
            binding.tvDetail.setText(knight?.fight())
        } ?: binding.tvDetail.setText("Night not Available")
    }

    private fun numberSelection(): Int = (1..3).random()
}