package com.juanma.cat_gme

import android.widget.ImageView
import com.juanma.cat_gme.Info.Companion.turn

class GameUI{


    fun paintImage(imageView: ImageView){

        when(turn){
            "X" -> {
                setImageX(imageView)
                blockImview(imageView)
            }
            "O" -> {
                setImageO(imageView)
                blockImview(imageView)
            }
        }
    }

    private fun setImageX(imageView: ImageView){
        imageView.setBackgroundResource(R.drawable.cat_x)
        blockImview(imageView)
    }

    private fun setImageO(imageView: ImageView){
        imageView.setBackgroundResource(R.drawable.mouse_o)
        blockImview(imageView)
    }

    fun setImageReset(imageView: ImageView){
        imageView.setBackgroundResource(R.drawable.nada)
    }

    fun blockImview(imageView: ImageView){
        imageView.isEnabled = false
    }

    fun enableImview(imageView: ImageView){
        imageView.isEnabled = true
    }

    fun setBackground(imageView: ImageView, color: Int){
        imageView.setBackgroundColor(color)
    }

}