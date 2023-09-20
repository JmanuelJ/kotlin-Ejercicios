package com.juanma.cat_gme

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.juanma.cat_gme.Info.Companion.cleanInfo
import com.juanma.cat_gme.Info.Companion.turn
import com.juanma.cat_gme.Info.Companion.winner
import com.juanma.cat_gme.databinding.ActivityMainBinding

class Play(private val binding: ActivityMainBinding) {
    private var gameLogic = GameLogic()
    private var gameUI = GameUI()

    fun playGame( imageView: ImageView, context: Context, index: Int){
        gameLogic.pressBox(index)
        gameUI.paintImage(imageView)
        checkWinner(context)
        Info.setTurn()
        setBackgroundTurn(context)
    }

    fun resetGame(){
        cleanInfo()
        cleanBoard()
    }

     fun setBackgroundTurn( context: Context){
        when(turn){
            "X" -> {
                binding.apply {
                    gameUI.setBackground(ivCat, context.getColor(R.color.blue2))
                    gameUI.setBackground(ivMouse, context.getColor(R.color.white))
                }
            }
            "O"-> {
                binding.apply {
                    gameUI.setBackground(ivCat, context.getColor(R.color.white))
                    gameUI.setBackground(ivMouse, context.getColor(R.color.blue2))
                }
            }
        }
    }

   private fun checkWinner(context: Context){
        gameLogic.valueWinner()
        if(winner){
            blockBoard()
            Toast.makeText(context, "Ganador: $turn", Toast.LENGTH_SHORT).show()
        }
    }

    private fun blockBoard(){
        binding.apply {
            gameUI.apply {
                blockImview(ivN1)
                blockImview(ivN2)
                blockImview(ivN3)
                blockImview(ivN4)
                blockImview(ivN5)
                blockImview(ivN6)
                blockImview(ivN7)
                blockImview(ivN8)
                blockImview(ivN9)
            }
        }
    }

   private  fun cleanBoard(){
        binding.apply {
            gameUI.apply {
                enableImview(ivN1)
                setImageReset(ivN1)
                enableImview(ivN2)
                setImageReset(ivN2)
                enableImview(ivN3)
                setImageReset(ivN3)
                enableImview(ivN4)
                setImageReset(ivN4)
                enableImview(ivN5)
                setImageReset(ivN5)
                enableImview(ivN6)
                setImageReset(ivN6)
                enableImview(ivN7)
                setImageReset(ivN7)
                enableImview(ivN8)
                setImageReset(ivN8)
                enableImview(ivN9)
                setImageReset(ivN9)
            }
        }
    }
}