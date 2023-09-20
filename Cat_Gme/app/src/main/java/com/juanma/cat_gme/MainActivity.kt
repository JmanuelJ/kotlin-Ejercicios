package com.juanma.cat_gme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.juanma.cat_gme.Info.Companion.initTurn
import com.juanma.cat_gme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var game: Play

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initGame()
        setOnClickGame()
    }

    private fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        game = Play(binding)
    }

    private fun initGame(){
        initTurn()
        game.setBackgroundTurn(this)
    }

    fun setOnClickGame(){
        binding.apply {
            ivN1.setOnClickListener{
                playGame(this.ivN1, 0)
            }
            ivN2.setOnClickListener{
                playGame(this.ivN2, 1)
            }
            ivN3.setOnClickListener{
                playGame(this.ivN3, 2)
            }
            ivN4.setOnClickListener{
                playGame(this.ivN4, 3)
            }
            ivN5.setOnClickListener{
                playGame(this.ivN5, 4)
            }
            ivN6.setOnClickListener{
                playGame(this.ivN6, 5)
            }
            ivN7.setOnClickListener{
                playGame(this.ivN7, 6)
            }
            ivN8.setOnClickListener{
                playGame(this.ivN8, 7)
            }
            ivN9.setOnClickListener{
                playGame(this.ivN9, 8)
            }
            btnReset.setOnClickListener{
                resetGame()
            }
        }
    }

    private fun playGame(imageView: ImageView, index: Int) {
        game.playGame(imageView, this, index)
    }

    private fun resetGame(){
        game.resetGame()
    }
}