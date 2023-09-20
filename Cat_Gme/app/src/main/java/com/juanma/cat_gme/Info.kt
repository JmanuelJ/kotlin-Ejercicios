package com.juanma.cat_gme

class Info {
    companion object{
        var turn = ""
        var winner = false
        var winnerType = ""

        fun setTurn(){
            turn = when(turn){
                "O" -> "X"
                else -> "O"
            }
        }

        fun initTurn(){
            val num = (1..2).random()

            turn = when(num){
                1 -> "X"
                else -> "O"
            }
        }

        fun cleanInfo(){
            initTurn()
            winner = false
             winnerType = ""
        }

    }
}